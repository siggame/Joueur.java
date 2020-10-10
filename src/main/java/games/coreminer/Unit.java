/**
 * A unit in the game.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.coreminer;

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
     * The number of bombs being carried by this Unit. (0 to job cargo capacity - other carried materials).
     */
    public int bombs;

    /**
     * The number of building materials carried by this Unit. (0 to job cargo capacity - other carried materials).
     */
    public int buildingMaterials;

    /**
     * The amount of dirt carried by this Unit. (0 to job cargo capacity - other carried materials).
     */
    public int dirt;

    /**
     * The remaining health of a Unit.
     */
    public int health;

    /**
     * The Job this Unit has.
     */
    public Job job;

    /**
     * The maximum amount of cargo this Unit can carry.
     */
    public int maxCargoCapacity;

    /**
     * The maximum health of this Unit.
     */
    public int maxHealth;

    /**
     * The maximum mining power of this Unit.
     */
    public int maxMiningPower;

    /**
     * The maximum moves this Unit can have.
     */
    public int maxMoves;

    /**
     * The remaining mining power this Unit has this turn.
     */
    public int miningPower;

    /**
     * The number of moves this Unit has left this turn.
     */
    public int moves;

    /**
     * The amount of ore carried by this Unit. (0 to job capacity - other carried materials).
     */
    public int ore;

    /**
     * The Player that owns and can control this Unit.
     */
    public Player owner;

    /**
     * The Tile this Unit is on.
     */
    public Tile tile;

    /**
     * The upgrade level of this unit. Starts at 0.
     */
    public int upgradeLevel;


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
     * Builds a support, shield, or ladder on Unit's tile, or an adjacent Tile.
     *
     * @param   tile  The Tile to build on.
     * @param   type  The structure to build (support, ladder, or shield).
     * @return True if successfully built, False otherwise.
     */
    public boolean build(Tile tile, String type) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("type", Client.getInstance().gameManager.serializeSafe(type));
        return (boolean)this.runOnServer("build", args);
    }

    /**
     * Purchase a resource from the player's base or hopper.
     *
     * @param   resource  The type of resource to buy.
     * @param   amount  The amount of resource to buy.
     * @return True if successfully purchased, false otherwise.
     */
    public boolean buy(String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("buy", args);
    }

    /**
     * Dumps materials from cargo to an adjacent tile. If the tile is a base or hopper tile, materials are sold instead of placed.
     *
     * @param   tile  The tile the materials will be dumped on.
     * @param   material  The material the Unit will drop. 'dirt', 'ore', or 'bomb'.
     * @param   amount  The number of materials to drop. Amounts <= 0 will drop all the materials.
     * @return True if successfully dumped materials, false otherwise.
     */
    public boolean dump(Tile tile, String material, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("material", Client.getInstance().gameManager.serializeSafe(material));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("dump", args);
    }

    /**
     * Mines the Tile the Unit is on or an adjacent tile.
     *
     * @param   tile  The Tile the materials will be mined from.
     * @param   amount  The amount of material to mine up. Amounts <= 0 will mine all the materials that the Unit can.
     * @return True if successfully mined, false otherwise.
     */
    public boolean mine(Tile tile, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("mine", args);
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
     * Transfers a resource from the one Unit to another.
     *
     * @param   unit  The Unit to transfer materials to.
     * @param   resource  The type of resource to transfer.
     * @param   amount  The amount of resource to transfer.
     * @return True if successfully transfered, false otherwise.
     */
    public boolean transfer(Unit unit, String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("unit", Client.getInstance().gameManager.serializeSafe(unit));
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("transfer", args);
    }

    /**
     * Upgrade this Unit.
     *
     * @return True if successfully upgraded, False otherwise.
     */
    public boolean upgrade() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("upgrade", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
