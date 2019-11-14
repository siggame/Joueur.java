/**
 * Two player grid based game where each player tries to burn down the other player's buildings. Let it burn.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.anarchy;

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
 * Two player grid based game where each player tries to burn down the other player's buildings. Let it burn.
 */
public class Game extends BaseGame {
    /**
     * How many bribes players get at the beginning of their turn, not counting their burned down Buildings.
     */
    public int baseBribesPerTurn;

    /**
     * All the buildings in the game.
     */
    public List<Building> buildings;

    /**
     * The current Forecast, which will be applied at the end of the turn.
     */
    public Forecast currentForecast;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * All the forecasts in the game, indexed by turn number.
     */
    public List<Forecast> forecasts;

    /**
     * The width of the entire map along the vertical (y) axis.
     */
    public int mapHeight;

    /**
     * The width of the entire map along the horizontal (x) axis.
     */
    public int mapWidth;

    /**
     * The maximum amount of fire value for any Building.
     */
    public int maxFire;

    /**
     * The maximum amount of intensity value for any Forecast.
     */
    public int maxForecastIntensity;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The next Forecast, which will be applied at the end of your opponent's turn. This is also the Forecast WeatherStations can control this turn.
     */
    public Forecast nextForecast;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

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
    public final static String gameVersion = "2bc66f9a5d7babd553079e149c7466feb6f553935b608ff722872e195fbadab8";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Anarchy";

        this.buildings = new ArrayList<Building>();
        this.forecasts = new ArrayList<Forecast>();
        this.players = new ArrayList<Player>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
