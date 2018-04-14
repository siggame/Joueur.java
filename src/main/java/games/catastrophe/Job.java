/**
 * Information about a Unit's job.
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
 * Information about a Unit's job.
 */
public class Job extends GameObject {
    /**
     * The amount of energy this Job normally uses to perform its actions.
     */
    public double actionCost;

    /**
     * How many combined resources a Unit with this Job can hold at once.
     */
    public int carryLimit;

    /**
     * The number of moves this Job can make per turn.
     */
    public int moves;

    /**
     * The amount of energy normally regenerated when resting at a shelter.
     */
    public double regenRate;

    /**
     * The Job title.
     */
    public String title;

    /**
     * The amount of food per turn this Unit consumes. If there isn't enough food for every Unit, all Units become starved and do not consume food.
     */
    public int upkeep;


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
