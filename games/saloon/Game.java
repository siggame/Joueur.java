/**
 * Use cowboys to have a good time and play some music on a Piano, while brawling with enemy Coyboys.
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
 * Use cowboys to have a good time and play some music on a Piano, while brawling with enemy Coyboys.
 */
public class Game extends BaseGame {
    /**
     * All the beer Bottles currently flying across the saloon in the game.
     */
    public List<Bottle> bottles;

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
     * All the jobs that Cowboys can be assigned within the saloon.
     */
    public List<String> jobs;

    /**
     * The maximum number of Cowboys a Player can bring into the saloon.
     */
    public int maxCowboys;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * When a player's rowdyness reaches or exceeds this number their Cowboys take a collective siesta.
     */
    public int rowdynessToSiesta;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


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
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
