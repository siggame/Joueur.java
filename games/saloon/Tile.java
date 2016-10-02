/**
 * A Tile in the game that makes up the 2D map grid.
 */
package games.saloon;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;

// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add addtional import(s) here
// <<-- /Creer-Merge: imports -->>

/**
 * A Tile in the game that makes up the 2D map grid.
 */
public class Tile extends GameObject {
    /**
     * The beer Bottle currently flying over this Tile.
     */
    public Bottle bottle;

    /**
     * The Cowboy that is on this Tile, or null if empty.
     */
    public Cowboy cowboy;

    /**
     * The furnishing that is on this Tile, or null if empty.
     */
    public Furnishing furnishing;

    /**
     * If this Tile is pathable, but has a hazard that damages Cowboys that path through it.
     */
    public boolean hasHazard;

    /**
     * If this Tile is a wall of the Saloon, and can never be pathed through.
     */
    public boolean isWall;

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
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Tile. Used during game initialization, do not call directly.
     */
    public Tile() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
