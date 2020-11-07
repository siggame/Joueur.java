/**
 * A Miner in the game.
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
 * A Miner in the game.
 */
public class Miner extends GameObject {
    /**
     * The number of bombs being carried by this Miner.
     */
    public int bombs;

    /**
     * The number of building materials carried by this Miner.
     */
    public int buildingMaterials;

    /**
     * The Upgrade this Miner is on.
     */
    public Upgrade currentUpgrade;

    /**
     * The amount of dirt carried by this Miner.
     */
    public int dirt;

    /**
     * The remaining health of this Miner.
     */
    public int health;

    /**
     * The remaining mining power this Miner has this turn.
     */
    public int miningPower;

    /**
     * The number of moves this Miner has left this turn.
     */
    public int moves;

    /**
     * The amount of ore carried by this Miner.
     */
    public int ore;

    /**
     * The Player that owns and can control this Miner.
     */
    public Player owner;

    /**
     * The Tile this Miner is on.
     */
    public Tile tile;

    /**
     * The upgrade level of this Miner. Starts at 0.
     */
    public int upgradeLevel;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Miner. Used during game initialization, do not call directly.
     */
    protected Miner() {
        super();
    }

    /**
     * Builds a support, shield, or ladder on Miner's Tile, or an adjacent Tile.
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
     * Purchase a resource from the Player's base or hopper.
     *
     * @param   resource  The type of resource to buy.
     * @param   amount  The amount of resource to buy. Amounts <= 0 will buy all of that material Player can.
     * @return True if successfully purchased, false otherwise.
     */
    public boolean buy(String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("buy", args);
    }

    /**
     * Dumps materials from cargo to an adjacent Tile. If the Tile is a base or a hopper Tile, materials are sold instead of placed.
     *
     * @param   tile  The Tile the materials will be dumped on.
     * @param   material  The material the Miner will drop. 'dirt', 'ore', or 'bomb'.
     * @param   amount  The number of materials to drop. Amounts <= 0 will drop all of the material.
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
     * Mines the Tile the Miner is on or an adjacent Tile.
     *
     * @param   tile  The Tile the materials will be mined from.
     * @param   amount  The amount of material to mine up. Amounts <= 0 will mine all the materials that the Miner can.
     * @return True if successfully mined, false otherwise.
     */
    public boolean mine(Tile tile, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("mine", args);
    }

    /**
     * Moves this Miner from its current Tile to an adjacent Tile.
     *
     * @param   tile  The Tile this Miner should move to.
     * @return True if it moved, false otherwise.
     */
    public boolean move(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Transfers a resource from the one Miner to another.
     *
     * @param   miner  The Miner to transfer materials to.
     * @param   resource  The type of resource to transfer.
     * @param   amount  The amount of resource to transfer. Amounts <= 0 will transfer all the of the material.
     * @return True if successfully transferred, false otherwise.
     */
    public boolean transfer(Miner miner, String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("miner", Client.getInstance().gameManager.serializeSafe(miner));
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("transfer", args);
    }

    /**
     * Upgrade this Miner by installing an upgrade module.
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
