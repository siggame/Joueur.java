package joueur;
import java.util.HashMap;

public class BaseGame {
    public HashMap<String, BaseGameObject> gameObjects;
    public String name;

    public final static String gameVersion = "base version";

    protected BaseGame() {
        this.name = "NO_NAME";
        this.gameObjects = new HashMap<String, BaseGameObject>();
    }
}
