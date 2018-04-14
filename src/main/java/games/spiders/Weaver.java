/**
 * A Spiderling that can alter existing Webs by weaving to add or remove silk from the Webs, thus altering its strength.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.spiders;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;

// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add additional import(s) here
// <<-- /Creer-Merge: imports -->>

/**
 * A Spiderling that can alter existing Webs by weaving to add or remove silk from the Webs, thus altering its strength.
 */
public class Weaver extends Spiderling {
    /**
     * The Web that this Weaver is strengthening. Null if not strengthening.
     */
    public Web strengtheningWeb;

    /**
     * The Web that this Weaver is weakening. Null if not weakening.
     */
    public Web weakeningWeb;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Weaver. Used during game initialization, do not call directly.
     */
    protected Weaver() {
        super();
    }

    /**
     * Weaves more silk into an existing Web to strengthen it.
     *
     * @param   web  The web you want to strengthen. Must be connected to the Nest this Weaver is currently on.
     * @return True if the strengthen was successfully started, false otherwise.
     */
    public boolean strengthen(Web web) {
        JSONObject args = new JSONObject();
        args.put("web", Client.getInstance().gameManager.serializeSafe(web));
        return (boolean)this.runOnServer("strengthen", args);
    }

    /**
     * Weaves more silk into an existing Web to strengthen it.
     *
     * @param   web  The web you want to weaken. Must be connected to the Nest this Weaver is currently on.
     * @return True if the weaken was successfully started, false otherwise.
     */
    public boolean weaken(Web web) {
        JSONObject args = new JSONObject();
        args.put("web", Client.getInstance().gameManager.serializeSafe(web));
        return (boolean)this.runOnServer("weaken", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
