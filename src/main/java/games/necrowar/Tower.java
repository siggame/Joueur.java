/**
 * A tower in the game. Used to combat enemy waves.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.necrowar;

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
 * A tower in the game. Used to combat enemy waves.
 */
public class Tower extends GameObject {
    /**
     * Whether this tower has attacked this turn or not.
     */
    public boolean attacked;

    /**
     * How many turns are left before it can fire again.
     */
    public int cooldown;

    /**
     * How much remaining health this tower has.
     */
    public int health;

    /**
     * What type of tower this is (it's job).
     */
    public TowerJob job;

    /**
     * The player that built / owns this tower.
     */
    public Player owner;

    /**
     * The Tile this Tower is on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Tower. Used during game initialization, do not call directly.
     */
    protected Tower() {
        super();
    }

    /**
     * Attacks an enemy unit on an tile within it's range.
     *
     * @param   tile  The Tile to attack.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("attack", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
