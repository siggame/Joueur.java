package joueur;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.json.JSONArray;

public abstract class BaseAI {
    public BaseAI() {}

    public String getName() {
        return "Java Player";
    }

    public void start() {
     // the inheriting AI can add code to this inherited function
    }

    public void ended(boolean won, String reason) {
     // the inheriting AI can add code to this inherited function
    }

    public void invalid(String message) {
        // the inheriting AI can add code to this inherited function
        System.err.println("INVALID: " + message);
    }

    public void gameUpdated() {
     // the inheriting AI can add code to this inherited function
    }

    public Object doOrder(String order, JSONArray jsonArray) {
        GameManager gameManager = Client.getInstance().gameManager;
        try {
            Method[] methods = this.getClass().getDeclaredMethods();
            Method method = null;
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().equals(order)) {
                    method = methods[i];
                    break;
                }
            }

            int len = jsonArray.length();
            Object[] unserializedArgs = new Object[len];
            for (int i = 0; i < len; i++) {
                unserializedArgs[i] = gameManager.unserialize(jsonArray.get(i));
            }

            Object returned = method.invoke(this, unserializedArgs);
            return returned;

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | SecurityException e) {
            Client.getInstance().handleError(e, ErrorCode.REFLECTION_FAILED, "Could not find method '" + order + "' in AI to do order.");
        }

        return null;
    }
}
