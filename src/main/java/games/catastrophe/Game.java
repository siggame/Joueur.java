/**
 * Convert as many humans to as you can to survive in this post-apocalyptic wasteland.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.catastrophe;

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
 * Convert as many humans to as you can to survive in this post-apocalyptic wasteland.
 */
public class Game extends BaseGame {
    /**
     * The multiplier for the amount of energy regenerated when resting in a shelter with the cat overlord.
     */
    public double catEnergyMult;

    /**
     * The player whose turn it is currently. That player can send commands. Other players cannot.
     */
    public Player currentPlayer;

    /**
     * The current turn number, starting at 0 for the first player's turn.
     */
    public int currentTurn;

    /**
     * The amount of turns it takes for a Tile that was just harvested to grow food again.
     */
    public int harvestCooldown;

    /**
     * All the Jobs that Units can have in the game.
     */
    public List<Job> jobs;

    /**
     * The amount that the harvest rate is lowered each season.
     */
    public int lowerHarvestAmount;

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
     * The multiplier for the cost of actions when performing them in range of a monument. Does not effect pickup cost.
     */
    public double monumentCostMult;

    /**
     * The number of materials in a monument.
     */
    public int monumentMaterials;

    /**
     * The number of materials in a neutral Structure.
     */
    public int neutralMaterials;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;

    /**
     * The number of materials in a shelter.
     */
    public int shelterMaterials;

    /**
     * The amount of food Players start with.
     */
    public int startingFood;

    /**
     * The multiplier for the amount of energy regenerated when resting while starving.
     */
    public double starvingEnergyMult;

    /**
     * Every Structure in the game.
     */
    public List<Structure> structures;

    /**
     * All the tiles in the map, stored in Row-major order. Use `x + y * mapWidth` to access the correct index.
     */
    public List<Tile> tiles;

    /**
     * The amount of time (in nano-seconds) added after each player performs a turn.
     */
    public int timeAddedPerTurn;

    /**
     * After a food tile is harvested, the number of turns before it can be harvested again.
     */
    public int turnsBetweenHarvests;

    /**
     * The number of turns between fresh humans being spawned on the road.
     */
    public int turnsToCreateHuman;

    /**
     * The number of turns before the harvest rate is lowered (length of each season basically).
     */
    public int turnsToLowerHarvest;

    /**
     * Every Unit in the game.
     */
    public List<Unit> units;

    /**
     * The number of materials in a wall.
     */
    public int wallMaterials;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "ede84ab86376b00287c09558f05e8f2a61b92109d93aad9ebd3379ff4215fb53";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Catastrophe";

        this.jobs = new ArrayList<Job>();
        this.players = new ArrayList<Player>();
        this.structures = new ArrayList<Structure>();
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
