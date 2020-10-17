/**
 * A Spider spawned by the BroodMother.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.spiders;

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
 * A Spider spawned by the BroodMother.
 */
public class Spiderling extends Spider {
    /**
     * When empty string this Spiderling is not busy, and can act. Otherwise a string representing what it is busy with, e.g. 'Moving', 'Attacking'.
     */
    public String busy;

    /**
     * The Web this Spiderling is using to move. Null if it is not moving.
     */
    public Web movingOnWeb;

    /**
     * The Nest this Spiderling is moving to. Null if it is not moving.
     */
    public Nest movingToNest;

    /**
     * The number of Spiderlings busy with the same work this Spiderling is doing, speeding up the task.
     */
    public int numberOfCoworkers;

    /**
     * How much work needs to be done for this Spiderling to finish being busy. See docs for the Work formula.
     */
    public double workRemaining;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Spiderling. Used during game initialization, do not call directly.
     */
    protected Spiderling() {
        super();
    }

    /**
     * Attacks another Spiderling.
     *
     * @param   spiderling  The Spiderling to attack.
     * @return True if the attack was successful, false otherwise.
     */
    public boolean attack(Spiderling spiderling) {
        JSONObject args = new JSONObject();
        args.put("spiderling", Client.getInstance().gameManager.serializeSafe(spiderling));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Starts moving the Spiderling across a Web to another Nest.
     *
     * @param   web  The Web you want to move across to the other Nest.
     * @return True if the move was successful, false otherwise.
     */
    public boolean move(Web web) {
        JSONObject args = new JSONObject();
        args.put("web", Client.getInstance().gameManager.serializeSafe(web));
        return (boolean)this.runOnServer("move", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
