/**
 * Collect of the most of the rarest mineral orbiting aroung the sun and outcompete your competetor.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.stardash;

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
 * Collect of the most of the rarest mineral orbiting aroung the sun and outcompete your competetor.
 */
public class Game extends BaseGame {
    /**
     * All the celestial bodies in the game.
     */
    public List<Body> bodies;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * The distance traveled each turn by dashing.
     */
    public int dashDistance;

    /**
     * A list of all jobs. first item is corvette, second is missleboat, third is martyr, fourth is transport, and fifth is miner.
     */
    public List<Job> jobs;

    /**
     * The highest amount of material, barring rarity, that can be in a asteroid.
     */
    public int maxAsteroid;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The smallest amount of material, barring rarity, that can be in a asteroid.
     */
    public int minAsteroid;

    /**
     * The rarity modifier of the most common ore. This controls how much spawns.
     */
    public double oreRarity1;

    /**
     * The rarity modifier of the second rarest ore. This controls how much spawns.
     */
    public double oreRarity2;

    /**
     * The rarity modifier of the rarest ore. This controls how much spawns.
     */
    public double oreRarity3;

    /**
     * The amount of energy the planets restore each round.
     */
    public int planetRechargeRate;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * The regeneration rate of asteroids.
     */
    public double regenerateRate;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The size of the map in the X direction.
     */
    public int sizeX;

    /**
     * The size of the map in the Y direction.
     */
    public int sizeY;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * Every Unit in the game.
     */
    public List<Unit> units;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Stardash";

        this.bodies = new ArrayList<Body>();
        this.jobs = new ArrayList<Job>();
        this.players = new ArrayList<Player>();
        this.units = new ArrayList<Unit>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
