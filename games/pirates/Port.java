/**
 * A port on a Tile.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.pirates;

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
 * A port on a Tile.
 */
public class Port extends GameObject {
    /**
     * For players, how much more gold this Port can spend this turn. For merchants, how much gold this Port has accumulated (it will spawn a ship when the Port can afford one).
     */
    public int gold;

    /**
     * (Merchants only) How much gold was invested into this Port. Investment determines the strength and value of the next ship.
     */
    public int investment;

    /**
     * The owner of this Port, or null if owned by merchants.
     */
    public Player owner;

    /**
     * The Tile this Port is on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Port. Used during game initialization, do not call directly.
     */
    protected Port() {
        super();
    }

    /**
     * Spawn a Unit on this port.
     *
     * @param   type  What type of Unit to create ('crew' or 'ship').
     * @return True if Unit was created successfully, false otherwise.
     */
    public boolean spawn(String type) {
        JSONObject args = new JSONObject();
        args.put("type", Client.getInstance().gameManager.serializeSafe(type));
        return (boolean)this.runOnServer("spawn", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
