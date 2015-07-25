package joueur;
import java.util.Map;

import org.json.JSONObject;

public class BaseGameObject {
    public String id;
    
    protected Object runOnServer(String functionName, JSONObject args) {
        return Client.getInstance().runOnServer(this, functionName, args);
    }
}
