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
     * The number of actions remaining for the beaver this turn.
     */
    public int actions;

    /**
     * The number of branches this beaver is holding.
     */
    public int branches;

    /**
     * The number of fish this beaver is holding.
     */
    public int fish;

    /**
     * How much health this beaver has left.
     */
    public int health;

    /**
     * The Job this beaver was recruited to do.
     */
    public Job job;

    /**
     * How many moves this beaver has left this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this beaver.
     */
    public Player owner;

    /**
     * True if the Beaver has finished being recruited and can do things, False otherwise.
     */
    public boolean recruited;

    /**
     * The tile this beaver is on.
     */
    public Tile tile;

    /**
     * Number of turns this beaver is distracted for (0 means not distracted).
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
     * @param   beaver  The beaver to attack. Must be on an adjacent tile.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Beaver beaver) {
        JSONObject args = new JSONObject();
        args.put("beaver", Client.getInstance().gameManager.serializeSafe(beaver));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Builds a lodge on the Beavers current tile.
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
     * Drops some of the given resource on the beaver's tile. Fish dropped in water disappear instantly, and fish dropped on land die one per tile per turn.
     *
     * @param   tile  The Tile to drop branches/fish on. Must be the same Tile that the Beaver is on, or an adjacent one.
     * @param   resource  The type of resource to drop ('branch' or 'fish').
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
     * Harvests the branches or fish from a Spawner on an adjacent tile.
     *
     * @param   spawner  The Spawner you want to harvest. Must be on an adjacent tile.
     * @return True if successfully harvested, false otherwise.
     */
    public boolean harvest(Spawner spawner) {
        JSONObject args = new JSONObject();
        args.put("spawner", Client.getInstance().gameManager.serializeSafe(spawner));
        return (boolean)this.runOnServer("harvest", args);
    }

    /**
     * Moves this beaver from its current tile to an adjacent tile.
     *
     * @param   tile  The tile this beaver should move to.
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
     * Picks up some branches or fish on the beaver's tile.
     *
     * @param   tile  The Tile to pickup branches/fish from. Must be the same Tile that the Beaver is on, or an adjacent one.
     * @param   resource  The type of resource to pickup ('branch' or 'fish').
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
