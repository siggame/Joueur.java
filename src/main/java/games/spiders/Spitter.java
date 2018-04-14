/**
 * A Spiderling that creates and spits new Webs from the Nest it is on to another Nest, connecting them.
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
 * A Spiderling that creates and spits new Webs from the Nest it is on to another Nest, connecting them.
 */
public class Spitter extends Spiderling {
    /**
     * The Nest that this Spitter is creating a Web to spit at, thus connecting them. Null if not spitting.
     */
    public Nest spittingWebToNest;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Spitter. Used during game initialization, do not call directly.
     */
    protected Spitter() {
        super();
    }

    /**
     * Creates and spits a new Web from the Nest the Spitter is on to another Nest, connecting them.
     *
     * @param   nest  The Nest you want to spit a Web to, thus connecting that Nest and the one the Spitter is on.
     * @return True if the spit was successful, false otherwise.
     */
    public boolean spit(Nest nest) {
        JSONObject args = new JSONObject();
        args.put("nest", Client.getInstance().gameManager.serializeSafe(nest));
        return (boolean)this.runOnServer("spit", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
