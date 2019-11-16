/**
 * A beaver in the game.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.stumped;

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
 * A beaver in the game.
 */
public class Beaver extends GameObject {
    /**
     * The number of actions remaining for the Beaver this turn.
     */
    public int actions;

    /**
     * The amount of branches this Beaver is holding.
     */
    public int branches;

    /**
     * The amount of food this Beaver is holding.
     */
    public int food;

    /**
     * How much health this Beaver has left.
     */
    public int health;

    /**
     * The Job this Beaver was recruited to do.
     */
    public Job job;

    /**
     * How many moves this Beaver has left this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this Beaver.
     */
    public Player owner;

    /**
     * True if the Beaver has finished being recruited and can do things, False otherwise.
     */
    public boolean recruited;

    /**
     * The Tile this Beaver is on.
     */
    public Tile tile;

    /**
     * Number of turns this Beaver is distracted for (0 means not distracted).
     */
    public int turnsDistracted;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Beaver. Used during game initialization, do not call directly.
     */
    protected Beaver() {
        super();
    }

    /**
     * Attacks another adjacent beaver.
     *
     * @param   beaver  The Beaver to attack. Must be on an adjacent Tile.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Beaver beaver) {
        JSONObject args = new JSONObject();
        args.put("beaver", Client.getInstance().gameManager.serializeSafe(beaver));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Builds a lodge on the Beavers current Tile.
     *
     * @return True if successfully built a lodge, false otherwise.
     */
    public boolean buildLodge() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("buildLodge", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Beaver#drop(Tile, String, int)
     */
    public boolean drop(Tile tile, String resource) {
        return this.drop(tile, resource, 0);
    }

    /**
     * Drops some of the given resource on the beaver's Tile.
     *
     * @param   tile  The Tile to drop branches/food on. Must be the same Tile that the Beaver is on, or an adjacent one.
     * @param   resource  The type of resource to drop ('branches' or 'food').
     * @param   amount  The amount of the resource to drop, numbers <= 0 will drop all the resource type.
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
     * Harvests the branches or food from a Spawner on an adjacent Tile.
     *
     * @param   spawner  The Spawner you want to harvest. Must be on an adjacent Tile.
     * @return True if successfully harvested, false otherwise.
     */
    public boolean harvest(Spawner spawner) {
        JSONObject args = new JSONObject();
        args.put("spawner", Client.getInstance().gameManager.serializeSafe(spawner));
        return (boolean)this.runOnServer("harvest", args);
    }

    /**
     * Moves this Beaver from its current Tile to an adjacent Tile.
     *
     * @param   tile  The Tile this Beaver should move to.
     * @return True if the move worked, false otherwise.
     */
    public boolean move(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Beaver#pickup(Tile, String, int)
     */
    public boolean pickup(Tile tile, String resource) {
        return this.pickup(tile, resource, 0);
    }

    /**
     * Picks up some branches or food on the beaver's tile.
     *
     * @param   tile  The Tile to pickup branches/food from. Must be the same Tile that the Beaver is on, or an adjacent one.
     * @param   resource  The type of resource to pickup ('branches' or 'food').
     * @param   amount  The amount of the resource to drop, numbers <= 0 will pickup all of the resource type.
     * @return True if successfully picked up a resource, false otherwise.
     */
    public boolean pickup(Tile tile, String resource, int amount) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("resource", Client.getInstance().gameManager.serializeSafe(resource));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("pickup", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
