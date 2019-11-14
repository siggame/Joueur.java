/**
 * Steal from merchants and become the most infamous pirate.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.pirates;

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
 * Steal from merchants and become the most infamous pirate.
 */
public class Game extends BaseGame {
    /**
     * The rate buried gold increases each turn.
     */
    public double buryInterestRate;

    /**
     * How much gold it costs to construct a single crew.
     */
    public int crewCost;

    /**
     * How much damage crew deal to each other.
     */
    public int crewDamage;

    /**
     * The maximum amount of health a crew member can have.
     */
    public int crewHealth;

    /**
     * The number of moves Units with only crew are given each turn.
     */
    public int crewMoves;

    /**
     * A crew's attack range. Range is circular.
     */
    public double crewRange;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * How much health a Unit recovers when they rest.
     */
    public double healFactor;

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
     * How much gold merchant Ports get each turn.
     */
    public double merchantGoldRate;

    /**
     * When a merchant ship spawns, the amount of additional gold it has relative to the Port's investment.
     */
    public double merchantInterestRate;

    /**
     * The Euclidean distance buried gold must be from the Player's Port to accumulate interest.
     */
    public double minInterestDistance;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * Every Port in the game. Merchant ports have owner set to null.
     */
    public List<Port> ports;

    /**
     * How far a Unit can be from a Port to rest. Range is circular.
     */
    public double restRange;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * How much gold it costs to construct a ship.
     */
    public int shipCost;

    /**
     * How much damage ships deal to ships and ports.
     */
    public int shipDamage;

    /**
     * The maximum amount of health a ship can have.
     */
    public int shipHealth;

    /**
     * The number of moves Units with ships are given each turn.
     */
    public int shipMoves;

    /**
     * A ship's attack range. Range is circular.
     */
    public double shipRange;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * Every Unit in the game. Merchant units have targetPort set to a port.
     */
    public List<Unit> units;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "d51fca49d06cb7164f9dbf9c3515ab0f9b5a17113a5946bddcc75aaba125967f";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Pirates";

        this.players = new ArrayList<Player>();
        this.ports = new ArrayList<Port>();
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
