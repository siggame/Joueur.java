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
     * The amount of cargo capacity this Unit starts with.
     */
    public int cargoCapacity;

    /**
     * The amount of starting health this Job has.
     */
    public int health;

    /**
     * The maximum amount of cargo capacity this Unit can have.
     */
    public int maxCargoCapacity;

    /**
     * The maximum amount of health this Job can have.
     */
    public int maxHealth;

    /**
     * The maximum amount of mining power this Unit can have.
     */
    public int maxMiningPower;

    /**
     * The maximum number of moves this Job can have.
     */
    public int maxMoves;

    /**
     * The amount of mining power this Unit has per turn.
     */
    public int miningPower;

    /**
     * The number of moves this Job can make per turn.
     */
    public int moves;

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
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
