/**
 * Collect of the most of the rarest mineral orbiting around the sun and out-compete your competitor.
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
 * Collect of the most of the rarest mineral orbiting around the sun and out-compete your competitor.
 */
public class Game extends BaseGame {
    /**
     * All the celestial bodies in the game. The first two are planets and the third is the sun. The fourth is the VP asteroid. Everything else is normal asteroids.
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
     * The cost of dashing.
     */
    public int dashCost;

    /**
     * The distance traveled each turn by dashing.
     */
    public int dashDistance;

    /**
     * The value of every unit of genarium.
     */
    public double genariumValue;

    /**
     * A list of all jobs. The first element is corvette, second is missileboat, third is martyr, fourth is transport, and fifth is miner.
     */
    public List<Job> jobs;

    /**
     * The value of every unit of legendarium.
     */
    public double legendariumValue;

    /**
     * The highest amount of material, that can be in a asteroid.
     */
    public int maxAsteroid;

    /**
     * The maximum number of turns before the game will automatically end.
     */
    public int maxTurns;

    /**
     * The smallest amount of material, that can be in a asteroid.
     */
    public int minAsteroid;

    /**
     * The rate at which miners grab minerals from asteroids.
     */
    public int miningSpeed;

    /**
     * The amount of mythicite that spawns at the start of the game.
     */
    public double mythiciteAmount;

    /**
     * The number of orbit updates you cannot mine the mithicite asteroid.
     */
    public int orbitsProtected;

    /**
     * The rarity modifier of the most common ore. This controls how much spawns.
     */
    public double oreRarityGenarium;

    /**
     * The rarity modifier of the rarest ore. This controls how much spawns.
     */
    public double oreRarityLegendarium;

    /**
     * The rarity modifier of the second rarest ore. This controls how much spawns.
     */
    public double oreRarityRarium;

    /**
     * The amount of energy a planet can hold at once.
     */
    public int planetEnergyCap;

    /**
     * The amount of energy the planets restore each round.
     */
    public int planetRechargeRate;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * The standard size of ships.
     */
    public int projectileRadius;

    /**
     * The amount of distance missiles travel through space.
     */
    public int projectileSpeed;

    /**
     * Every projectile in the game.
     */
    public List<Projectile> projectiles;

    /**
     * The value of every unit of rarium.
     */
    public double rariumValue;

    /**
     * The regeneration rate of asteroids.
     */
    public double regenerateRate;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The standard size of ships.
     */
    public int shipRadius;

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
     * The number of turns it takes for a asteroid to orbit the sun. (Asteroids move after each players turn).
     */
    public int turnsToOrbit;

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
    public final static String gameVersion = "0fa378e83ac567ebdf3e9805d3f130023f936e2740acda173d238b37f2b5d541";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Stardash";

        this.bodies = new ArrayList<Body>();
        this.jobs = new ArrayList<Job>();
        this.players = new ArrayList<Player>();
        this.projectiles = new ArrayList<Projectile>();
        this.units = new ArrayList<Unit>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
