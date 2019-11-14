/**
 * Gather branches and build up your lodge as beavers fight to survive.
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
 * Gather branches and build up your lodge as beavers fight to survive.
 */
public class Game extends BaseGame {
    /**
     * Every Beaver in the game.
     */
    public List<Beaver> beavers;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * When a Player has less Beavers than this number, then recruiting other Beavers is free.
     */
    public int freeBeaversCount;

    /**
     * All the Jobs that Beavers can have in the game.
     */
    public List<Job> jobs;

    /**
     * Constant number used to calculate what it costs to spawn a new lodge.
     */
    public double lodgeCostConstant;

    /**
     * How many lodges must be owned by a Player at once to win the game.
     */
    public int lodgesToWin;

    /**
     * The number of Tiles in the map along the y (vertical) axis.
     */
    public int mapHeight;

    /**
     * The number of Tiles in the map along the x (horizontal) axis.
     */
    public int mapWidth;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * Every Spawner in the game.
     */
    public List<Spawner> spawner;

    /**
     * Constant number used to calculate how many branches/food Beavers harvest from Spawners.
     */
    public double spawnerHarvestConstant;

    /**
     * All the types of Spawners in the game.
     */
    public List<String> spawnerTypes;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "7de307cae4a9a163a9b3600cb20c4b376b9f9cc42f1b990852878fea0127eed3";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Stumped";

        this.beavers = new ArrayList<Beaver>();
        this.jobs = new ArrayList<Job>();
        this.players = new ArrayList<Player>();
        this.spawner = new ArrayList<Spawner>();
        this.spawnerTypes = new ArrayList<String>();
        this.tiles = new ArrayList<Tile>();
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
