package joueur;

import org.json.JSONObject;

public class BaseGameObject {
    public String id;

    protected Object runOnServer(String functionName, JSONObject args) {
        return Client.getInstance().runOnServer(this, functionName, args);
    }
}
