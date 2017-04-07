/**
 * A Tile in the game that makes up the 2D map grid.
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
 * A Tile in the game that makes up the 2D map grid.
 */
public class Tile extends GameObject {
    /**
     * The Beaver on this Tile if present, otherwise null.
     */
    public Beaver beaver;

    /**
     * The number of branches dropped on this Tile.
     */
    public int branches;

    /**
     * The cardinal direction water is flowing on this Tile ('North', 'East', 'South', 'West').
     */
    public String flowDirection;

    /**
     * The number of food dropped on this Tile.
     */
    public int food;

    /**
     * The owner of the Beaver lodge on this Tile, if present, otherwise null.
     */
    public Player lodgeOwner;

    /**
     * The resource Spawner on this Tile if present, otherwise null.
     */
    public Spawner spawner;

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
     * What type of Tile this is, either 'Water' or 'Land'.
     */
    public String type;

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

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
