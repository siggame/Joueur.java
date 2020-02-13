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
     * Builds a support, shield, ladder, or bomb on Unit's tile, or an adjacent Tile.
     *
     * @param   tile  The Tile to build on.
     * @param   type  The structure to build (support, ladder, shield, or bomb).
     * @return True if successfully built, False otherwise.
     */
    public boolean build(Tile tile, String type) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("type", Client.getInstance().gameManager.serializeSafe(type));
        return (boolean)this.runOnServer("build", args);
    }

    /**
     * Dumps materials from cargo to an adjacent tile.
     *
     * @param   tile  The tile the materials will be dumped on.
     * @param   material  The material the Unit will drop. 'dirt' or 'ore'.
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
     * Upgrade an attribute of this Unit. "health", "miningPower", "moves", or "capacity".
     *
     * @param   attribute  The attribute of the Unit to be upgraded.
     * @return True if successfully upgraded, False otherwise.
     */
    public boolean upgrade(String attribute) {
        JSONObject args = new JSONObject();
        args.put("attribute", Client.getInstance().gameManager.serializeSafe(attribute));
        return (boolean)this.runOnServer("upgrade", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
