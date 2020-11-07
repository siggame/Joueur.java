/**
 * There's an infestation of enemy spiders challenging your queen BroodMother spider! Protect her and attack the other BroodMother in this turn based, node based, game.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.spiders;

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
 * There's an infestation of enemy spiders challenging your queen BroodMother spider! Protect her and attack the other BroodMother in this turn based, node based, game.
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
     * The speed at which Cutters work to do cut Webs.
     */
    public int cutSpeed;

    /**
     * Constant used to calculate how many eggs BroodMothers get on their owner's turns.
     */
    public double eggsScalar;

    /**
     * The starting strength for Webs.
     */
    public int initialWebStrength;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The maximum strength a web can be strengthened to.
     */
    public int maxWebStrength;

    /**
     * The speed at which Spiderlings move on Webs.
     */
    public int movementSpeed;

    /**
     * Every Nest in the game.
     */
    public List<Nest> nests;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The speed at which Spitters work to spit new Webs.
     */
    public int spitSpeed;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * How much web strength is added or removed from Webs when they are weaved.
     */
    public int weavePower;

    /**
     * The speed at which Weavers work to do strengthens and weakens on Webs.
     */
    public int weaveSpeed;

    /**
     * Every Web in the game.
     */
    public List<Web> webs;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "a8df6038306b6855bb35959d7698f8dcbf98f48e7e148de59fef940ccb241bdf";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Spiders";

        this.nests = new ArrayList<Nest>();
        this.players = new ArrayList<Player>();
        this.webs = new ArrayList<Web>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
