package joueur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Stack;

import org.json.*;

public class Client {
    // region Singletion pattern setup
    private static Client instance = null;

    protected Client() {
        // Exists only to defeat instantiation.
    }

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }

        return instance;
    }

    // endregion

    public final static int ERROR_CODE_SOCKET_READ = 18;
    public final static int ERROR_CODE_DELTA_MERGE = 19;
    
    private String server = null;
    private int port = 0;
    private boolean printIO = false;
    private final String EOT_CHAR = "" + (char) 4;
    private final int BUFFER_SIZE = 1024;
    private BaseAI ai = null;
    private BaseGameObject aisPlayer = null;
    public GameManager gameManager;
    private Socket socket;
    private PrintWriter socketOut;
    private BufferedReader socketIn;
    private Stack<ServerEvent> eventsStack;
    private String receivedBuffer = "";

    public void connectTo(BaseGame game, BaseAI ai, String server, int port, boolean printIO) {
        if (server.isEmpty()) {
            server = "localhost";
        }

        if (port <= 0) {
            port = 3000;
        }
        
        this.server = server;
        this.port = port;
        this.printIO = printIO;
        this.ai = ai;
        this.gameManager = new GameManager(game);
        this.eventsStack = new Stack<ServerEvent>();

        System.out.println("Attemping to connect to host " + server + ":" + port);

        this.socket = null;
        this.socketIn = null;
        this.socketOut = null;

        try {
            this.socket = new Socket(this.server, this.port);
            this.socket.setSoTimeout(1000); // 1 sec timeout
            this.socketOut = new PrintWriter(this.socket.getOutputStream(), true);
            this.socketIn = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + server + ":" + port);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for " + "the connection to: " + server + ":" + port);
            System.exit(1);
        }
    }

    public String lowercaseFirst(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public void send(String eventName, Object data) {
        JSONObject send = new JSONObject(data);
        send.put("event", eventName);
        if (data != null) {
            send.put("data", data);
        }

        send.put("sentTime", System.currentTimeMillis());
        
        String str = send.toString() + this.EOT_CHAR;
        
        if (this.printIO) {
            System.out.println("TO SERVER <-- " + str);
        }
        
        this.socketOut.println(str);
        //this.socketOut.flush();
    }

    public void disconnect(int errorCode, String errorMessage) {
        if (errorMessage != null) {
            System.err.println(errorMessage);
        }
        
        try {
            this.socketOut.close();
            this.socketIn.close();
            this.socket.close();
        } catch (IOException ioexception) {
            // whatever, we are disconnecting anyways
        }

        System.exit(errorCode);
    }

    public Object waitForEvent(String eventName) {
        while (true) {
            this.waitForEvents();

            while (!this.eventsStack.isEmpty()) {
                ServerEvent serverEvent = this.eventsStack.pop();
                if (serverEvent.event.equals(eventName)) {
                    return serverEvent.data;
                } else {
                    this.autoHandle(serverEvent.event, serverEvent.data);
                }
            }
        }
    }

    private void waitForEvents() {
        if (!this.eventsStack.isEmpty()) {
            return; // as we already have events to handle, no need to wait for more
        }

        while (true) {
            char[] chars = null;
            int charsRead = -2;
            try {
                chars = new char[this.BUFFER_SIZE];
                charsRead = this.socketIn.read(chars);
            } catch (SocketTimeoutException e) {
                continue;
            } catch (IOException e) {
                e.printStackTrace();
                this.disconnect(Client.ERROR_CODE_SOCKET_READ, "Error with reading socket: " + e.getMessage());
            }
            
            String responseData = null;
            if(charsRead != -2) {
                if (charsRead == -1) { // then there was still more to read, so it filled the whole buffer
                    charsRead = this.BUFFER_SIZE;
                }
                
                if (chars != null) {
                    responseData = new String(chars, 0, charsRead);
                }
            }
            if (responseData == null || responseData.isEmpty()) {
                continue;
            }

            if (this.printIO) {
                System.out.println("FROM SERVER -->" + responseData);
            }
            
            String total = this.receivedBuffer + responseData;
            String[] split = total.split("[" + this.EOT_CHAR + "]", -1);

            this.receivedBuffer = split[split.length - 1]; // this is either an empty string because of the EOT_CHAR split, or an incomplete json string so store it in the buffer

            for (int i = split.length - 2; i >= 0; i--) { // iterate through in reverse, skipping the over the very last item because we stored it in the receivedBuffer
                String str = split[i];
                JSONObject deserialized = new JSONObject(str);
                ServerEvent serverEvent = new ServerEvent(deserialized.getString("event"), deserialized.opt("data"));
                this.eventsStack.push(serverEvent);
            }

            if (!this.eventsStack.isEmpty()) {
                return;
            }
        }
    }

    private void autoHandle(String eventName, Object data) {
        try {
            Method method = this.getClass().getDeclaredMethod("autoHandle" + eventName.substring(0, 1).toUpperCase() + eventName.substring(1), Object.class);
            method.setAccessible(true);

            try {
                method.invoke(this, data);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unused") // because it can be invoked via reflection
    private void autoHandleDelta(Object data) {
        this.gameManager.deltaUpdate((JSONObject) data);

        if (this.aisPlayer == null) {
            try {
                this.aisPlayer = (BaseGameObject) this.ai.getClass().getField("player").get(this.ai);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (this.aisPlayer != null) {
            this.ai.gameUpdated();
        }
    }

    @SuppressWarnings("unused") // because it can be invoked via reflection
    private void autoHandleInvalid(Object data) throws Exception {
        throw new Exception("Sent invalid command data!");
    }

    @SuppressWarnings("unused") // because it can be invoked via reflection
    private void autoHandleOver(Object data) {
        this.ai.ended(true, "");
        this.disconnect(0, null);
    }

    public Object runOnServer(BaseGameObject caller, String functionName, JSONObject args) {
        JSONObject data = new JSONObject();
        data.put("caller", this.gameManager.serializeGameObject(caller));
        data.put("functionName", functionName);
        if (args != null) {
            data.put("args", args);
        }

        this.send("run", data);

        Object runData = this.waitForEvent("ran");

        return runData;
    }
}
