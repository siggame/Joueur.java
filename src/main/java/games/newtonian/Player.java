/**
 * A player in this game. Every AI controls one player.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.newtonian;

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
 * A player in this game. Every AI controls one player.
 */
public class Player extends GameObject {
    /**
     * What type of client this is, e.g. 'Python', 'JavaScript', or some other language. For potential data mining purposes.
     */
    public String clientType;

    /**
     * Every generator Tile owned by this Player. (listed from the outer edges inward, from top to bottom).
     */
    public List<Tile> generatorTiles;

    /**
     * The amount of heat this Player has.
     */
    public int heat;

    /**
     * The time left till a intern spawns. (0 to spawnTime).
     */
    public int internSpawn;

    /**
     * If the player lost the game or not.
     */
    public boolean lost;

    /**
     * The time left till a manager spawns. (0 to spawnTime).
     */
    public int managerSpawn;

    /**
     * The name of the player.
     */
    public String name;

    /**
     * This player's opponent in the game.
     */
    public Player opponent;

    /**
     * The time left till a physicist spawns. (0 to spawnTime).
     */
    public int physicistSpawn;

    /**
     * The amount of pressure this Player has.
     */
    public int pressure;

    /**
     * The reason why the player lost the game.
     */
    public String reasonLost;

    /**
     * The reason why the player won the game.
     */
    public String reasonWon;

    /**
     * All the tiles this Player's units can spawn on. (listed from the outer edges inward, from top to bottom).
     */
    public List<Tile> spawnTiles;

    /**
     * The amount of time (in ns) remaining for this AI to send commands.
     */
    public double timeRemaining;

    /**
     * Every Unit owned by this Player.
     */
    public List<Unit> units;

    /**
     * If the player won the game or not.
     */
    public boolean won;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Player. Used during game initialization, do not call directly.
     */
    protected Player() {
        super();
        this.generatorTiles = new ArrayList<Tile>();
        this.spawnTiles = new ArrayList<Tile>();
        this.units = new ArrayList<Unit>();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
