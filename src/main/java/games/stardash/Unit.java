/**
 * A unit in the game. May be a corvette, missleboat, martyr, transport, miner.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.stardash;

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
 * A unit in the game. May be a corvette, missleboat, martyr, transport, miner.
 */
public class Unit extends GameObject {
    /**
     * Whether or not this Unit has performed its action this turn.
     */
    public boolean acted;

    /**
     * The x value this unit is dashing to.
     */
    public double dashX;

    /**
     * The y value this unit is dashing to.
     */
    public double dashY;

    /**
     * The remaining health of the unit.
     */
    public int energy;

    /**
     * The amount of Genarium ore carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int genarium;

    /**
     * Tracks whether or not the ship is dashing or Mining. If true, it cannot do anything else.
     */
    public boolean isBusy;

    /**
     * The Job this Unit has.
     */
    public Job job;

    /**
     * The amount of Legendarium ore carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int legendarium;

    /**
     * The distance this unit can still move.
     */
    public double moves;

    /**
     * The amount of Mythicite carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int mythicite;

    /**
     * The Player that owns and can control this Unit.
     */
    public Player owner;

    /**
     * The martyr ship that is currently shielding this ship if any.
     */
    public Unit protector;

    /**
     * The amount of Rarium carried by this unit. (0 to job carry capacity - other carried items).
     */
    public int rarium;

    /**
     * The shield that a martyr ship has.
     */
    public int shield;

    /**
     * The x value this unit is on.
     */
    public double x;

    /**
     * The y value this unit is on.
     */
    public double y;


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
     * Attacks the specified unit.
     *
     * @param   enemy  The Unit being attacked.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Unit enemy) {
        JSONObject args = new JSONObject();
        args.put("enemy", Client.getInstance().gameManager.serializeSafe(enemy));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Causes the unit to dash towards the designated destination.
     *
     * @param   x  The x value of the destination's coordinates.
     * @param   y  The y value of the destination's coordinates.
     * @return True if it moved, false otherwise.
     */
    public boolean dash(double x, double y) {
        JSONObject args = new JSONObject();
        args.put("x", Client.getInstance().gameManager.serializeSafe(x));
        args.put("y", Client.getInstance().gameManager.serializeSafe(y));
        return (boolean)this.runOnServer("dash", args);
    }

    /**
     * Allows a miner to mine a asteroid.
     *
     * @param   body  The object to be mined.
     * @return True if successfully acted, false otherwise.
     */
    public boolean mine(Body body) {
        JSONObject args = new JSONObject();
        args.put("body", Client.getInstance().gameManager.serializeSafe(body));
        return (boolean)this.runOnServer("mine", args);
    }

    /**
     * Moves this Unit from its current location to the new location specified.
     *
     * @param   x  The x value of the destination's coordinates.
     * @param   y  The y value of the destination's coordinates.
     * @return True if it moved, false otherwise.
     */
    public boolean move(double x, double y) {
        JSONObject args = new JSONObject();
        args.put("x", Client.getInstance().gameManager.serializeSafe(x));
        args.put("y", Client.getInstance().gameManager.serializeSafe(y));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Tells you if your ship can move to that location from were it is without clipping the sun.
     *
     * @param   x  The x position of the location you wish to arrive.
     * @param   y  The y position of the location you wish to arrive.
     * @return True if pathable by this unit, false otherwise.
     */
    public boolean safe(double x, double y) {
        JSONObject args = new JSONObject();
        args.put("x", Client.getInstance().gameManager.serializeSafe(x));
        args.put("y", Client.getInstance().gameManager.serializeSafe(y));
        return (boolean)this.runOnServer("safe", args);
    }

    /**
     * Attacks the specified projectile.
     *
     * @param   missile  The projectile being shot down.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean shootdown(Projectile missile) {
        JSONObject args = new JSONObject();
        args.put("missile", Client.getInstance().gameManager.serializeSafe(missile));
        return (boolean)this.runOnServer("shootdown", args);
    }

    /**
     * Grab materials from a friendly unit. Doesn't use a action.
     *
     * @param   unit  The unit you are grabbing the resources from.
     * @param   amount  The amount of materials to you with to grab. Amounts <= 0 will pick up all the materials that the unit can.
     * @param   material  The material the unit will pick up. 'genarium', 'rarium', 'legendarium', or 'mythicite'.
     * @return True if successfully taken, false otherwise.
     */
    public boolean transfer(Unit unit, int amount, String material) {
        JSONObject args = new JSONObject();
        args.put("unit", Client.getInstance().gameManager.serializeSafe(unit));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        args.put("material", Client.getInstance().gameManager.serializeSafe(material));
        return (boolean)this.runOnServer("transfer", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
