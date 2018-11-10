/**
 * A unit in the game. May be a manager, intern, or physicist.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.newtonian;

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
 * A unit in the game. May be a manager, intern, or physicist.
 */
public class Unit extends GameObject {
    /**
     * Whether or not this Unit has performed its action this turn.
     */
    public boolean acted;

    /**
     * The amount of blueium carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int blueium;

    /**
     * The amount of blueium ore carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int blueiumOre;

    /**
     * The remaining health of a unit.
     */
    public int health;

    /**
     * The Job this Unit has.
     */
    public Job job;

    /**
     * The number of moves this unit has left this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this Unit.
     */
    public Player owner;

    /**
     * The amount of redium carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int redium;

    /**
     * The amount of redium ore carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int rediumOre;

    /**
     * Duration of stun immunity. (0 to timeImmune).
     */
    public int stunImmune;

    /**
     * Duration the unit is stunned. (0 to the game constant stunTime).
     */
    public int stunTime;

    /**
     * The Tile this Unit is on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Unit. Used during game initialization, do not call directly.
     */
    protected Unit() {
        super();
    }

    /**
     * Makes the unit do something to a machine or unit adjacent to its tile. Interns sabotage, physicists work. Interns stun physicist, physicist stuns manager, manager stuns intern.
     *
     * @param   tile  The tile the unit acts on.
     * @return True if successfully acted, false otherwise.
     */
    public boolean act(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("act", args);
    }

    /**
     * Attacks a unit on an adjacent tile.
     *
     * @param   tile  The Tile to attack.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Drops materials at the units feet or adjacent tile.
     *
     * @param   tile  The tile the materials will be dropped on.
     * @param   amount  The number of materials to dropped. Amounts <= 0 will drop all the materials.
     * @param   material  The material the unit will drop. 'redium', 'blueium', 'redium ore', or 'blueium ore'.
     * @return True if successfully deposited, false otherwise.
     */
    public boolean drop(Tile tile, int amount, String material) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        args.put("material", Client.getInstance().gameManager.serializeSafe(material));
        return (boolean)this.runOnServer("drop", args);
    }

    /**
     * Moves this Unit from its current Tile to an adjacent Tile.
     *
     * @param   tile  The Tile this Unit should move to.
     * @return True if it moved, false otherwise.
     */
    public boolean move(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Picks up material at the units feet or adjacent tile.
     *
     * @param   tile  The tile the materials will be picked up from.
     * @param   amount  The amount of materials to pick up. Amounts <= 0 will pick up all the materials that the unit can.
     * @param   material  The material the unit will pick up. 'redium', 'blueium', 'redium ore', or 'blueium ore'.
     * @return True if successfully deposited, false otherwise.
     */
    public boolean pickup(Tile tile, int amount, String material) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        args.put("material", Client.getInstance().gameManager.serializeSafe(material));
        return (boolean)this.runOnServer("pickup", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
