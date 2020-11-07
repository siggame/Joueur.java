/**
 * A Tile in the game that makes up the 2D map grid.
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
 * A Tile in the game that makes up the 2D map grid.
 */
public class Tile extends GameObject {
    /**
     * An array of Bombs on this Tile.
     */
    public List<Bomb> bombs;

    /**
     * The amount of dirt on this Tile.
     */
    public int dirt;

    /**
     * Whether or not the Tile is a base Tile.
     */
    public boolean isBase;

    /**
     * Whether or not this Tile is about to fall after this turn.
     */
    public boolean isFalling;

    /**
     * Whether or not a hopper is on this Tile.
     */
    public boolean isHopper;

    /**
     * Whether or not a ladder is built on this Tile.
     */
    public boolean isLadder;

    /**
     * Whether or not a support is built on this Tile.
     */
    public boolean isSupport;

    /**
     * An array of the Miners on this Tile.
     */
    public List<Miner> miners;

    /**
     * The amount of ore on this Tile.
     */
    public int ore;

    /**
     * The owner of this Tile, or undefined if owned by no-one.
     */
    public Player owner;

    /**
     * The amount of shielding on this Tile.
     */
    public int shielding;

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
        this.bombs = new ArrayList<Bomb>();
        this.miners = new ArrayList<Miner>();
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
