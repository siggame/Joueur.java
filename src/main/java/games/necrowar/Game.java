/**
 * Send hordes of the undead at your opponent while defending yourself against theirs to win.
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
 * Send hordes of the undead at your opponent while defending yourself against theirs to win.
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
     * The amount of gold income per turn per unit in a mine.
     */
    public int goldIncomePerUnit;

    /**
     * The amount of gold income per turn per unit in the island mine.
     */
    public int islandIncomePerUnit;

    /**
     * The Amount of gold income per turn per unit fishing on the river side.
     */
    public int manaIncomePerUnit;

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
     * The amount of turns it takes between the river changing phases.
     */
    public int riverPhase;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * A list of every tower type / job.
     */
    public List<TowerJob> towerJobs;

    /**
     * Every Tower in the game.
     */
    public List<Tower> towers;

    /**
     * A list of every unit type / job.
     */
    public List<UnitJob> unitJobs;

    /**
     * Every Unit in the game.
     */
    public List<Unit> units;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "935f0e64ba290cdce31688a40bd90d1eb5375f36aeebd67482238fc0da25ef86";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Necrowar";

        this.players = new ArrayList<Player>();
        this.tiles = new ArrayList<Tile>();
        this.towerJobs = new ArrayList<TowerJob>();
        this.towers = new ArrayList<Tower>();
        this.unitJobs = new ArrayList<UnitJob>();
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
