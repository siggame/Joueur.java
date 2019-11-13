/**
 * A Tile in the game that makes up the 2D map grid.
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
 * A Tile in the game that makes up the 2D map grid.
 */
public class Tile extends GameObject {
    /**
     * The amount of corpses on this tile.
     */
    public int corpses;

    /**
     * Whether or not the tile is a castle tile.
     */
    public boolean isCastle;

    /**
     * Whether or not the tile is considered to be a gold mine or not.
     */
    public boolean isGoldMine;

    /**
     * Whether or not the tile is considered grass or not (Workers can walk on grass).
     */
    public boolean isGrass;

    /**
     * Whether or not the tile is considered to be the island gold mine or not.
     */
    public boolean isIslandGoldMine;

    /**
     * Whether or not the tile is considered a path or not (Units can walk on paths).
     */
    public boolean isPath;

    /**
     * Whether or not the tile is considered a river or not.
     */
    public boolean isRiver;

    /**
     * Whether or not the tile is considered a tower or not.
     */
    public boolean isTower;

    /**
     * Whether or not the tile is the unit spawn.
     */
    public boolean isUnitSpawn;

    /**
     * Whether or not the tile can be moved on by workers.
     */
    public boolean isWall;

    /**
     * Whether or not the tile is the worker spawn.
     */
    public boolean isWorkerSpawn;

    /**
     * The amount of Ghouls on this tile.
     */
    public int numGhouls;

    /**
     * The amount of Hounds on this tile.
     */
    public int numHounds;

    /**
     * The amount of Zombies on this tile.
     */
    public int numZombies;

    /**
     * Which player owns this tile, only applies to grass tiles for workers, NULL otherwise.
     */
    public Player owner;

    /**
     * The Tile to the 'East' of this one (x+1, y). Null if out of bounds of the map.
     */
    public Tile tileEast;

    /**
     * The Tile to the 'North' of this one (x, y-1). Null if out of bounds of the map.
     */
    public Tile tileNorth;

    /**
     * The Tile to the 'South' of this one (x, y+1). Null if out of bounds of the map.
     */
    public Tile tileSouth;

    /**
     * The Tile to the 'West' of this one (x-1, y). Null if out of bounds of the map.
     */
    public Tile tileWest;

    /**
     * The Tower on this Tile if present, otherwise null.
     */
    public Tower tower;

    /**
     * The Unit on this Tile if present, otherwise null.
     */
    public Unit unit;

    /**
     * The x (horizontal) position of this Tile.
     */
    public int x;

    /**
     * The y (vertical) position of this Tile.
     */
    public int y;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Tile. Used during game initialization, do not call directly.
     */
    protected Tile() {
        super();
    }

    /**
     * Resurrect the corpses on this tile into Zombies.
     *
     * @param   num  Number of zombies to resurrect.
     * @return True if successful res, false otherwise.
     */
    public boolean res(int num) {
        JSONObject args = new JSONObject();
        args.put("num", Client.getInstance().gameManager.serializeSafe(num));
        return (boolean)this.runOnServer("res", args);
    }

    /**
     * Spawns a fighting unit on the correct tile.
     *
     * @param   title  The title of the desired unit type.
     * @return True if successfully spawned, false otherwise.
     */
    public boolean spawnUnit(String title) {
        JSONObject args = new JSONObject();
        args.put("title", Client.getInstance().gameManager.serializeSafe(title));
        return (boolean)this.runOnServer("spawnUnit", args);
    }

    /**
     * Spawns a worker on the correct tile.
     *
     * @return True if successfully spawned, false otherwise.
     */
    public boolean spawnWorker() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("spawnWorker", args);
    }

    /**
     * Gets the neighbors of this Tile
     * @return The neighboring (adjacent) Tiles to this tile
     */
    public List<Tile> getNeighbors() {
        List<Tile> list = new ArrayList<Tile>();

        if (this.tileNorth != null) {
            list.add(this.tileNorth);
        }

        if (this.tileEast != null) {
            list.add(this.tileEast);
        }

        if (this.tileSouth != null) {
            list.add(this.tileSouth);
        }

        if (this.tileWest != null) {
            list.add(this.tileWest);
        }

        return list;
    }

    /**
     * Checks if a Tile is pathable to units
     * @return True if pathable, false otherwise
     */
    public boolean isPathable() {
        // <<-- Creer-Merge: is_pathable_builtin -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        return false; // DEVELOPER ADD LOGIC HERE
        // <<-- /Creer-Merge: is_pathable_builtin -->>
    }

    /**
     * Checks if this Tile has a specific neighboring Tile
     * @param  tile  Tile to check against
     * @return true if the tile is a neighbor of this Tile, false otherwise
     */
    public boolean hasNeighbor(Tile tile) {
        if (tile == null) {
            return false;
        }

        return (this.tileNorth == tile || this.tileEast == tile || this.tileSouth == tile || this.tileEast == tile);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
