/**
 * Mine resources to obtain more wealth than your opponent.
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
 * Mine resources to obtain more wealth than your opponent.
 */
public class Game extends BaseGame {
    /**
     * The price of buying a bomb.
     */
    public int bombCost;

    /**
     * The amount of cargo space taken up by a bomb.
     */
    public int bombSize;

    /**
     * The price of buying building materials.
     */
    public int buildingMaterialCost;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * The amount of turns it takes to gain a free Bomb.
     */
    public int freeBombInterval;

    /**
     * A list of all jobs.
     */
    public List<Job> jobs;

    /**
     * The amount of building material required to build a ladder.
     */
    public int ladderCost;

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
     * The amount of victory points awarded when ore is deposited in the base.
     */
    public int oreValue;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The amount of building material required to shield a Tile.
     */
    public int shieldCost;

    /**
     * The amount of building material required to build a support.
     */
    public int supportCost;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * Every Unit in the game.
     */
    public List<Unit> units;

    /**
     * The cost to upgrade a Unit's cargo capacity.
     */
    public int upgradeCargoCapacityCost;

    /**
     * The cost to upgrade a Unit's health.
     */
    public int upgradeHealthCost;

    /**
     * The cost to upgrade a Unit's mining power.
     */
    public int upgradeMiningPowerCost;

    /**
     * The cost to upgrade a Unit's movement speed.
     */
    public int upgradeMovesCost;

    /**
     * The amount of victory points required to win.
     */
    public int victoryAmount;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "46abaae0c6f41ba8536de3714cb964013777223bc6d6753f838182f9673db93e";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Coreminer";

        this.jobs = new ArrayList<Job>();
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
