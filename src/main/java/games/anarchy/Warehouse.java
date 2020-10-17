/**
 * A typical abandoned warehouse that anarchists hang out in and can be bribed to burn down Buildings.
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
 * A typical abandoned warehouse that anarchists hang out in and can be bribed to burn down Buildings.
 */
public class Warehouse extends Building {
    /**
     * How exposed the anarchists in this warehouse are to PoliceDepartments. Raises when bribed to ignite buildings, and drops each turn if not bribed.
     */
    public int exposure;

    /**
     * The amount of fire added to buildings when bribed to ignite a building. Headquarters add more fire than normal Warehouses.
     */
    public int fireAdded;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Warehouse. Used during game initialization, do not call directly.
     */
    protected Warehouse() {
        super();
    }

    /**
     * Bribes the Warehouse to light a Building on fire. This adds this building's fireAdded to their fire, and then this building's exposure is increased based on the Manhattan distance between the two buildings.
     *
     * @param   building  The Building you want to light on fire.
     * @return The exposure added to this Building's exposure. -1 is returned if there was an error.
     */
    public int ignite(Building building) {
        JSONObject args = new JSONObject();
        args.put("building", Client.getInstance().gameManager.serializeSafe(building));
        return (int)this.runOnServer("ignite", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
