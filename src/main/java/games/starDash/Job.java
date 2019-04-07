/**
 * Information about a unit's job.
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
 * Information about a unit's job.
 */
public class Job extends GameObject {
    /**
     * How many combined resources a unit with this Job can hold at once.
     */
    public int carryLimit;

    /**
     * The amount of damage this Job does per attack.
     */
    public int damage;

    /**
     * The amount of starting health this Job has.
     */
    public int energy;

    /**
     * The distance this job can move per turn.
     */
    public int moves;

    /**
     * The distance at which this job can effect things.
     */
    public int range;

    /**
     * The reserve the martyr use to protect allies.
     */
    public int shield;

    /**
     * The Job title. 'corvette', 'missileboat', 'martyr', 'transport', or 'miner'. (in this order from 0-4).
     */
    public String title;

    /**
     * How much money it costs to spawn a unit.
     */
    public int unitCost;


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
