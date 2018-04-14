/**
 * A connection (edge) to a Nest (node) in the game that Spiders can converge on (regardless of owner). Spiders can travel in either direction on Webs.
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
 * A connection (edge) to a Nest (node) in the game that Spiders can converge on (regardless of owner). Spiders can travel in either direction on Webs.
 */
public class Web extends GameObject {
    /**
     * How long this Web is, i.e., the distance between its nestA and nestB.
     */
    public double length;

    /**
     * How much weight this Web currently has on it, which is the sum of all its Spiderlings weight.
     */
    public int load;

    /**
     * The first Nest this Web is connected to.
     */
    public Nest nestA;

    /**
     * The second Nest this Web is connected to.
     */
    public Nest nestB;

    /**
     * All the Spiderlings currently moving along this Web.
     */
    public List<Spiderling> spiderlings;

    /**
     * How much weight this Web can take before snapping and destroying itself and all the Spiders on it.
     */
    public int strength;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Web. Used during game initialization, do not call directly.
     */
    protected Web() {
        super();
        this.spiderlings = new ArrayList<Spiderling>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
