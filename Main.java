import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;

import joueur.BaseAI;
import joueur.BaseGame;
import joueur.Client;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

class JoueurJava {
    public static void main(String[] args) throws IOException {
        ArgumentParser parser = ArgumentParsers.newArgumentParser("Joueur.Java")
            .description("Runs the Java client with options. Must a provide a game name to play on the server.");
        parser.addArgument("gameName")
            .dest("gameName")
            .required(true)
            .help("the name of the game you want to play on the server");
        parser.addArgument("-s", "--server")
            .dest("server")
            .setDefault("localhost")
            .help("the url to the server you want to connect to e.g. locahost:3000");
        parser.addArgument("-p", "--port")
            .dest("port")
            .type(Integer.class)
            .setDefault(3000)
            .help("the port to connect to on the server. Can be defined on the server arg via server:port");
        parser.addArgument("-n", "--name")
            .dest("playerName")
            .help("the name you want to use as your AI\'s player name. This over-rides the name you set in your code");
        parser.addArgument("-r", "--session")
            .dest("session")
            .setDefault("*")
            .help("the requested game session you want to play on the server");
        parser.addArgument("--printIO")
            .dest("printIO")
            .action(Arguments.storeTrue())
            .help("(debugging) print IO through the TCP socket to the terminal");
        
        String gameName = "", server = "localhost", requestedSession = "*", playerName = "Java Player";
        int port = 3000;
        boolean printIO = false;
        
        try {
            Namespace parsedArgs = parser.parseArgs(args);
            gameName = parsedArgs.getString("gameName");
            server = parsedArgs.getString("server");
            requestedSession = parsedArgs.getString("session");
            playerName = parsedArgs.getString("name");
            port = parsedArgs.getInt("port");
            printIO = parsedArgs.getBoolean("printIO");
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(21);
        }
        
        if (server.contains(":")) {
            String[] split = server.split(":");
            server = split[0];
            port = Integer.parseInt(split[1]);
        }
        
        BaseGame game = null;
        BaseAI ai = null;
        Client client = Client.getInstance();
        
        try {
            Class<?> gameClass = Class.forName("games." + client.lowercaseFirst(gameName) + ".Game");
            Constructor<?> gameConstructor = gameClass.getConstructor(new Class[0]);
            game = (BaseGame)gameConstructor.newInstance(new Object[0]);
            
            Class<?> aiClass = Class.forName("games." + client.lowercaseFirst(gameName) + ".AI");
            Constructor<?> aiConstructor = aiClass.getConstructor(new Class[0]);
            ai = (BaseAI)aiConstructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            System.err.println("Error: could not create game or ai via reflection for game '" + gameName + "'");
            e.printStackTrace();
            System.exit(17);
        }
        
        client.connectTo(game, ai, server, port, printIO);
        
        if (playerName == null || playerName.isEmpty()) {
            playerName = ai.getName();
            if (playerName == null || playerName.isEmpty()) {
                playerName = "Java Player"; // to make sure they have a name
            }
        }
        
        JSONObject playData = new JSONObject();
        playData.put("gameName", gameName);
        playData.put("playerName", playerName);
        playData.put("requestedSession", requestedSession);
        playData.put("clientType", "Java");
        client.send("play", playData);
        
        JSONObject lobbiedData = (JSONObject)client.waitForEvent("lobbied");
        
        gameName = lobbiedData.getString("gameName");
        String gameSession = lobbiedData.getString("gameSession");
        
        System.out.println("In Lobby for game '" + gameName + "' in session '" + gameSession + "'.");
        
        JSONObject constants = lobbiedData.getJSONObject("constants");
        
        client.gameManager.setConstants(constants);
        JSONObject startData = (JSONObject)client.waitForEvent("start");
        
        // set the AI's game and player via reflection
        try {
            ai.getClass().getField("game").set(ai, game);
            ai.getClass().getField("player").set(ai, game.gameObjects.get(startData.getString("playerID")));
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
            System.err.println("Error: could not set reflected game and player for ai.");
            e.printStackTrace();
            System.exit(17);
        }
        
        ai.start();
        ai.gameUpdated();
        
        while (true) {
            JSONObject orderData = (JSONObject)client.waitForEvent("order");
            
            String order = orderData.getString("order");
            Object returned = ai.doOrder(order, orderData.optJSONArray("args"));
            
            JSONObject finishedData = new JSONObject();
            finishedData.put("finished", order);
            finishedData.put("returned", returned);
            client.send("finished", finishedData);
        }
    }
}
