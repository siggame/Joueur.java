/**
 * A unit in the game.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.catastrophe;

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
 * A unit in the game.
 */
public class Unit extends GameObject {
    /**
     * Whether this unit has performed its action this turn.
     */
    public boolean acted;

    /**
     * The amount of energy this unit has (from 0.0 to 1.0).
     */
    public double energy;

    /**
     * The amount of food this Unit is holding.
     */
    public int food;

    /**
     * The Job this Unit was recruited to do.
     */
    public Job job;

    /**
     * The amount of materials this Unit is holding.
     */
    public int materials;

    /**
     * The tile this Unit is moving to. This only applies to neutral fresh humans spawned on the road.
     */
    public Tile movementTarget;

    /**
     * How many moves this Unit has left this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this Unit, or null if the unit is neutral.
     */
    public Player owner;

    /**
     * The units in the same squad as this unit. Units in the same squad attack and defend together.
     */
    public List<Unit> squad;

    /**
     * Whether this unit is starving. Starving units regenerate energy at half the rate they normally would while resting.
     */
    public boolean starving;

    /**
     * The Tile this Unit is on.
     */
    public Tile tile;

    /**
     * The number of turns before this Unit dies. This only applies to neutral fresh humans created from combat.
     */
    public int turnsToDie;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Unit. Used during game initialization, do not call directly.
     */
    protected Unit() {
        super();
        this.squad = new ArrayList<Unit>();
    }

    /**
     * Attacks an adjacent tile. Costs an action for each unit in this squad. Units in this squad without an action don't participate in combat. Units in the squad cannot move after performing this action.
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
     * Changes this Unit's Job. Must be at max energy (1.0) to change Jobs.
     *
     * @param   job  The Job to change to.
     * @return True if successfully changed Jobs, false otherwise.
     */
    public boolean changeJob(Job job) {
        JSONObject args = new JSONObject();
        args.put("job", Client.getInstance().gameManager.serializeSafe(job));
        return (boolean)this.runOnServer("changeJob", args);
    }

    /**
     * Constructs a structure on an adjacent Tile.
     *
     * @param   tile  The Tile to construct the structure on. It must have enough materials on it for a structure to be constructed.
     * @param   type  The type of structure to construct on that tile.
     * @return True if successfully constructed a structure, false otherwise.
     */
    public boolean construct(Tile tile, String type) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("type", Client.getInstance().gameManager.serializeSafe(type));
        return (boolean)this.runOnServer("construct", args);
    }

    /**
     * Converts an adjacent Unit to your side.
     *
     * @param   tile  The Tile with the Unit to convert.
     * @return True if successfully converted, false otherwise.
     */
    public boolean convert(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("convert", args);
    }

    /**
     * Removes materials from an adjacent Tile's Structure. Soldiers do not gain materials from doing this, but can deconstruct friendly Structures as well.
     *
     * @param   tile  The Tile to deconstruct. It must have a Structure on it.
     * @return True if successfully deconstructed, false otherwise.
     */
    public boolean deconstruct(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("deconstruct", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Unit#drop(Tile, String, int)
     */
    public boolean drop(Tile tile, String resource) {
        return this.drop(tile, resource, 0);
    }

    /**
     * Drops some of the given resource on or adjacent to the unit's Tile. Does not count as an action.
     *
     * @param   tile  The Tile to drop materials/food on.
     * @param   resource  The type of resource to drop ('material' or 'food').
     * @param   amount  The amount of the resource to drop, numbers <= 0 will drop all of the resource.
     * @return True if successfully dropped the resource, false otherwise.
     */
    public boolean drop(Tile tile, String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("drop", args);
    }

    /**
     * Harvests the food on an adjacent Tile.
     *
     * @param   tile  The Tile you want to harvest.
     * @return True if successfully harvested, false otherwise.
     */
    public boolean harvest(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("harvest", args);
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
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Unit#pickup(Tile, String, int)
     */
    public boolean pickup(Tile tile, String resource) {
        return this.pickup(tile, resource, 0);
    }

    /**
     * Picks up some materials or food on or adjacent to the unit's tile. Does not count as an action.
     *
     * @param   tile  The Tile to pickup materials/food from.
     * @param   resource  The type of resource to pickup ('material' or 'food').
     * @param   amount  The amount of the resource to pickup, numbers <= 0 will pickup all of the resource possible.
     * @return True if successfully picked up a resource, false otherwise.
     */
    public boolean pickup(Tile tile, String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("pickup", args);
    }

    /**
     * Regenerates energy. Must be in range of a friendly shelter to rest. Unit cannot move after performing this action.
     *
     * @return True if successfully rested, false otherwise.
     */
    public boolean rest() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("rest", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
