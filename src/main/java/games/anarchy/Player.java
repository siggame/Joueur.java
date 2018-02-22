/**
 * A player in this game. Every AI controls one player.
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
 * A player in this game. Every AI controls one player.
 */
public class Player extends GameObject {
    /**
     * How many bribes this player has remaining to use during their turn. Each action a Building does costs 1 bribe. Any unused bribes are lost at the end of the player's turn.
     */
    public int bribesRemaining;

    /**
     * All the buildings owned by this player.
     */
    public List<Building> buildings;

    /**
     * What type of client this is, e.g. 'Python', 'JavaScript', or some other language. For potential data mining purposes.
     */
    public String clientType;

    /**
     * All the FireDepartments owned by this player.
     */
    public List<FireDepartment> fireDepartments;

    /**
     * The Warehouse that serves as this player's headquarters and has extra health. If this gets destroyed they lose.
     */
    public Warehouse headquarters;

    /**
     * If the player lost the game or not.
     */
    public boolean lost;

    /**
     * The name of the player.
     */
    public String name;

    /**
     * This player's opponent in the game.
     */
    public Player opponent;

    /**
     * All the PoliceDepartments owned by this player.
     */
    public List<PoliceDepartment> policeDepartments;

    /**
     * The reason why the player lost the game.
     */
    public String reasonLost;

    /**
     * The reason why the player won the game.
     */
    public String reasonWon;

    /**
     * The amount of time (in ns) remaining for this AI to send commands.
     */
    public double timeRemaining;

    /**
     * All the warehouses owned by this player. Includes the Headquarters.
     */
    public List<Warehouse> warehouses;

    /**
     * All the WeatherStations owned by this player.
     */
    public List<WeatherStation> weatherStations;

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
        this.buildings = new ArrayList<Building>();
        this.fireDepartments = new ArrayList<FireDepartment>();
        this.policeDepartments = new ArrayList<PoliceDepartment>();
        this.warehouses = new ArrayList<Warehouse>();
        this.weatherStations = new ArrayList<WeatherStation>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
