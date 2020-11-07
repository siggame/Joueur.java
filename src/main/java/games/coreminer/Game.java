/**
 * Mine resources to obtain more value than your opponent.
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
 * Mine resources to obtain more value than your opponent.
 */
public class Game extends BaseGame {
    /**
     * The monetary price of a bomb when bought or sold.
     */
    public int bombPrice;

    /**
     * The amount of cargo space taken up by a Bomb.
     */
    public int bombSize;

    /**
     * Every Bomb in the game.
     */
    public List<Bomb> bombs;

    /**
     * The monetary price of building materials when bought.
     */
    public int buildingMaterialPrice;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * The monetary price of dirt when bought or sold.
     */
    public int dirtPrice;

    /**
     * The amount of damage taken per Tile fallen.
     */
    public int fallDamage;

    /**
     * The amount of extra damage taken for falling while carrying a large amount of cargo.
     */
    public int fallWeightDamage;

    /**
     * The amount of building material required to build a ladder.
     */
    public int ladderCost;

    /**
     * The amount of mining power needed to remove a ladder from a Tile.
     */
    public int ladderHealth;

    /**
     * The amount deemed as a large amount of cargo.
     */
    public int largeCargoSize;

    /**
     * The amount deemed as a large amount of material.
     */
    public int largeMaterialSize;

    /**
     * The number of Tiles in the map along the y (vertical) axis.
     */
    public int mapHeight;

    /**
     * The number of Tiles in the map along the x (horizontal) axis.
     */
    public int mapWidth;

    /**
     * The maximum amount of shielding possible on a Tile.
     */
    public int maxShielding;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The highest upgrade level allowed on a Miner.
     */
    public int maxUpgradeLevel;

    /**
     * Every Miner in the game.
     */
    public List<Miner> miners;

    /**
     * The amount of money awarded when ore is dumped in the base and sold.
     */
    public int orePrice;

    /**
     * The amount of value awarded when ore is dumped in the base and sold.
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
     * The amount of mining power needed to remove one unit of shielding off a Tile.
     */
    public int shieldHealth;

    /**
     * The monetary price of spawning a Miner.
     */
    public int spawnPrice;

    /**
     * The amount of damage taken when suffocating inside a filled Tile.
     */
    public int suffocationDamage;

    /**
     * The amount of extra damage taken for suffocating under a large amount of material.
     */
    public int suffocationWeightDamage;

    /**
     * The amount of building material required to build a support.
     */
    public int supportCost;

    /**
     * The amount of mining power needed to remove a support from a Tile.
     */
    public int supportHealth;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public double timeAddedPerTurn;

    /**
     * The cost to upgrade a Miner.
     */
    public int upgradePrice;

    /**
     * Every Upgrade for a Miner in the game.
     */
    public List<Upgrade> upgrades;

    /**
     * The amount of victory points (value) required to win.
     */
    public int victoryAmount;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "b559778acd8e4c689b8d028ca6cc154714ce79c39b09cd6d171b50faf88ef747";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Coreminer";

        this.bombs = new ArrayList<Bomb>();
        this.miners = new ArrayList<Miner>();
        this.players = new ArrayList<Player>();
        this.tiles = new ArrayList<Tile>();
        this.upgrades = new ArrayList<Upgrade>();
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
