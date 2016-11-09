/**
 * A Tile in the game that makes up the 2D map grid.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.saloon;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;

/**
 * A Tile in the game that makes up the 2D map grid.
 */
public class Tile extends GameObject {
    /**
     * The beer Bottle currently flying over this Tile.
     */
    public Bottle bottle;

    /**
     * The Cowboy that is on this Tile, null otherwise.
     */
    public Cowboy cowboy;

    /**
     * The furnishing that is on this Tile, null otherwise.
     */
    public Furnishing furnishing;

    /**
     * If this Tile is pathable, but has a hazard that damages Cowboys that path through it.
     */
    public boolean hasHazard;

    /**
     * If this Tile is a balcony of the Saloon that YoungGuns walk around on, and can never be pathed through by Cowboys.
     */
    public boolean isBalcony;

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

    /**
     * The YoungGun on this tile, null otherwise.
     */
    public YoungGun youngGun;

    /**
     * The list of all valid directions Tiles can be in
     */
    public static final String[] DIRECTIONS = { "North", "East", "South", "West" };



    /**
     * Creates a new instance of a Tile. Used during game initialization, do not call directly.
     */
    public Tile() {
        super();
    }

    /**
     * Gets the neighbors of this Tile
     * @return The neighboring (adjacent) Tiles to this tile
     */
    public List<Tile> getNeighbors() {
        List list = new ArrayList<Tile>();

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

    /// <summary>
    /// Checks if a Tile is pathable to units
    /// </summary>
    /// <returns>True if pathable, false otherwise</returns>
    public boolean isPathable() {
        return !this.isBalcony && this.cowboy == null && this.furnishing == null;
    }

    /// <summary>
    /// Checks if this Tile has a specific neighboring Tile
    /// </summary>
    /// <param name="tile">Tile to check against</param>
    /// <returns>true if the tile is a neighbor of this Tile, false otherwise</returns>
    public boolean hasNeighbor(Tile tile) {
        if (tile == null) {
            return false;
        }

        return (this.tileNorth == tile || this.tileEast == tile || this.tileSouth == tile || this.tileEast == tile);
    }
}
