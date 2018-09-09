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
     * Whether this Unit has performed its action this turn.
     */
    public boolean acted;

    /**
     * The amount of blueium carried by this unit.
     */
    public int blueium;

    /**
     * The amount of blueium ore carried by this unit.
     */
    public int blueiumOre;

    /**
     * If a ship is on this Tile, how much health it has remaining.
     */
    public int health;

    /**
     * The Job this Unit does.
     */
    public Job job;

    /**
     * How many more times this Unit may move this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this Unit.
     */
    public Player owner;

    /**
     * The amount of redium carried by this unit.
     */
    public int redium;

    /**
     * The amount of redium ore carried by this unit.
     */
    public int rediumOre;

    /**
     * Duration of stun immunity.
     */
    public int stunImmune;

    /**
     * Duration the unit is stunned.
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
     * Makes the unit do something to a machine on its tile. Interns sabotage, physicists run, and managers protect.
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
     * Attacks a unit on a ajacent tile.
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
     * Drops material at the units feat
     *
     * @param   tile  The tile the materials will be dropped on.
     * @param   amount  The amount of materials to dropped. Amounts <= 0 will drop all the materials on the Unit.
     * @param   material  The material the unit will drop.
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
     * Picks up material at the units feat
     *
     * @param   tile  The tile the materials will be dropped on.
     * @param   amount  The amount of materials to pick up. Amounts <= 0 will pick up all the materials on the Unit.
     * @param   material  The material the unit will pick up.
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
