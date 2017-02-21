/**
 * Can put out fires completely.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.anarchy;

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
 * Can put out fires completely.
 */
public class FireDepartment extends Building {
    /**
     * The amount of fire removed from a building when bribed to extinguish a building.
     */
    public int fireExtinguished;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a FireDepartment. Used during game initialization, do not call directly.
     */
    protected FireDepartment() {
        super();
    }

    /**
     * Bribes this FireDepartment to extinguish the some of the fire in a building.
     *
     * @param   building  The Building you want to extinguish.
     * @return True if the bribe worked, false otherwise.
     */
    public boolean extinguish(Building building) {
        JSONObject args = new JSONObject();
        args.put("building", Client.getInstance().gameManager.serializeSafe(building));
        return (boolean)this.runOnServer("extinguish", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
