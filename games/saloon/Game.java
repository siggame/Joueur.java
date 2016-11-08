/**
 * Use cowboys to have a good time and play some music on a Piano, while brawling with enemy Cowboys.
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

// you can add addtional import(s) here

/**
 * Use cowboys to have a good time and play some music on a Piano, while brawling with enemy Cowboys.
 */
public class Game extends BaseGame {
    /**
     * How many turns a Bartender will be busy for after throwing a Bottle.
     */
    public int bartenderCooldown;

    /**
     * All the beer Bottles currently flying across the saloon in the game.
     */
    public List<Bottle> bottles;

    /**
     * How much damage is applied to neighboring things bit by the Sharpshooter between turns.
     */
    public int brawlerDamage;

    /**
     * Every Cowboy in the game.
     */
    public List<Cowboy> cowboys;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * Every furnishing in the game.
     */
    public List<Furnishing> furnishings;

    /**
     * All the jobs that Cowboys can be called in with.
     */
    public List<String> jobs;

    /**
     * The number of Tiles in the map along the y (vertical) axis.
     */
    public int mapHeight;

    /**
     * The number of Tiles in the map along the x (horizontal) axis.
     */
    public int mapWidth;

    /**
     * The maximum number of Cowboys a Player can bring into the saloon of each specific job.
     */
    public int maxCowboysPerJob;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * When a player's rowdiness reaches or exceeds this number their Cowboys take a collective siesta.
     */
    public int rowdinessToSiesta;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * How much damage is applied to things hit by Sharpshooters when they act.
     */
    public int sharpshooterDamage;

    /**
     * How long siestas are for a player's team.
     */
    public int siestaLength;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * How many turns a Cowboy will be drunk for if a bottle breaks on it.
     */
    public int turnsDrunk;


    // you can add addtional field(s) here. None of them will be tracked or updated by the server.


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    public Game() {
        super();
        this.name = "Saloon";

        this.bottles = new ArrayList<Bottle>();
        this.cowboys = new ArrayList<Cowboy>();
        this.furnishings = new ArrayList<Furnishing>();
        this.jobs = new ArrayList<String>();
        this.players = new ArrayList<Player>();
        this.tiles = new ArrayList<Tile>();
    }

    // you can add addtional method(s) here.
}
