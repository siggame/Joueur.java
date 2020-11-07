/**
 * Combine elements and be the first scientists to create fusion.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.newtonian;

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
 * Combine elements and be the first scientists to create fusion.
 */
public class Game extends BaseGame {
    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * The maximum number of interns a player can have.
     */
    public int internCap;

    /**
     * A list of all jobs. The first element is intern, second is physicists, and third is manager.
     */
    public List<Job> jobs;

    /**
     * Every Machine in the game.
     */
    public List<Machine> machines;

    /**
     * The maximum number of managers a player can have.
     */
    public int managerCap;

    /**
     * The number of Tiles in the map along the y (vertical) axis.
     */
    public int mapHeight;

    /**
     * The number of Tiles in the map along the x (horizontal) axis.
     */
    public int mapWidth;

    /**
     * The number of materials that spawn per spawn cycle.
     */
    public int materialSpawn;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The maximum number of physicists a player can have.
     */
    public int physicistCap;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * The amount of victory points added when a refined ore is consumed by the generator.
     */
    public int refinedValue;

    /**
     * The percent of max HP regained when a unit end their turn on a tile owned by their player.
     */
    public double regenerateRate;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The amount of turns it takes a unit to spawn.
     */
    public int spawnTime;

    /**
     * The amount of turns a unit cannot do anything when stunned.
     */
    public int stunTime;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * The number turns a unit is immune to being stunned.
     */
    public int timeImmune;

    /**
     * Every Unit in the game.
     */
    public List<Unit> units;

    /**
     * The amount of combined heat and pressure that you need to win.
     */
    public int victoryAmount;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "7c19f909ee5faa0ac3faf4e989032b5a37ba94aeb5d6ae7654a15a2bb1401bbe";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Newtonian";

        this.jobs = new ArrayList<Job>();
        this.machines = new ArrayList<Machine>();
        this.players = new ArrayList<Player>();
        this.tiles = new ArrayList<Tile>();
        this.units = new ArrayList<Unit>();
    }

    /**
     * Gets the Tile at a specified (x, y) position
     * @param  x  integer between 0 and the mapWidth
     * @param  y  integer between 0 and the mapHeight
     * @return the Tile at (x, y) or null if out of bounds
     */
    public Tile getTileAt(int x, int y)
    {
        if (x < 0 || y < 0 || x >= this.mapWidth || y >= this.mapHeight) {
            // out of bounds
            return null;
        }

        return this.tiles.get(x + y * this.mapWidth);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
