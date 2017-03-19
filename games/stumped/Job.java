/**
 * Information about a beaver's job.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.stumped;

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
 * Information about a beaver's job.
 */
public class Job extends GameObject {
    /**
     * The number of actions this job can make per turn.
     */
    public int actions;

    /**
     * How many resources a beaver with this job can hold at once.
     */
    public int carryLimit;

    /**
     * Scalar for how many branches this job harvests at once.
     */
    public int chopping;

    /**
     * How many fish this Job costs to recruit.
     */
    public int cost;

    /**
     * The amount of damage this job does per attack.
     */
    public int damage;

    /**
     * How many turns a beaver attacked by this job is distracted by.
     */
    public int distractionPower;

    /**
     * Scalar for how many fish this job harvests at once.
     */
    public int fishing;

    /**
     * The amount of starting health this job has.
     */
    public int health;

    /**
     * The number of moves this job can make per turn.
     */
    public int moves;

    /**
     * The job title ('builder', 'fisher', etc).
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

    /**
     * Recruits a Beaver of this Job to a lodge
     *
     * @param   tile  The Tile that is a lodge owned by you that you wish to spawn the Beaver of this Job on.
     * @return The recruited Beaver if successful, null otherwise.
     */
    public Beaver recruit(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (Beaver)this.runOnServer("recruit", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
