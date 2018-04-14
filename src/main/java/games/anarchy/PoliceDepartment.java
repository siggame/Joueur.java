/**
 * Used to keep cities under control and raid Warehouses.
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
 * Used to keep cities under control and raid Warehouses.
 */
public class PoliceDepartment extends Building {

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a PoliceDepartment. Used during game initialization, do not call directly.
     */
    protected PoliceDepartment() {
        super();
    }

    /**
     * Bribe the police to raid a Warehouse, dealing damage equal based on the Warehouse's current exposure, and then resetting it to 0.
     *
     * @param   warehouse  The warehouse you want to raid.
     * @return The amount of damage dealt to the warehouse, or -1 if there was an error.
     */
    public int raid(Warehouse warehouse) {
        JSONObject args = new JSONObject();
        args.put("warehouse", Client.getInstance().gameManager.serializeSafe(warehouse));
        return (int)this.runOnServer("raid", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
