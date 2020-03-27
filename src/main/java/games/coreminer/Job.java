/**
 * Information about a Unit's job.
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
 * Information about a Unit's job.
 */
public class Job extends GameObject {
    /**
     * The amount of cargo capacity this Unit starts with per level.
     */
    public List<int> cargoCapacity;

    /**
     * The cost of spawning a Unit with this Job.
     */
    public int cost;

    /**
     * The amount of starting health this Job has per level.
     */
    public List<int> health;

    /**
     * The amount of mining power this Unit has per turn per level.
     */
    public List<int> miningPower;

    /**
     * The number of moves this Job can make per turn per level.
     */
    public List<int> moves;

    /**
     * The Job title. 'miner' or 'bomb'.
     */
    public String title;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Job. Used during game initialization, do not call directly.
     */
    protected Job() {
        super();
        this.cargoCapacity = new ArrayList<int>();
        this.health = new ArrayList<int>();
        this.miningPower = new ArrayList<int>();
        this.moves = new ArrayList<int>();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
