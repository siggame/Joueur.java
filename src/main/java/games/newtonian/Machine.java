/**
 * A machine in the game. Used to refine ore.
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
 * A machine in the game. Used to refine ore.
 */
public class Machine extends GameObject {
    /**
     * What type of ore the machine takes it. Also determines the type of material it outputs. (redium or blueium).
     */
    public String oreType;

    /**
     * The amount of ore that needs to be inputted into the machine for it to be worked.
     */
    public int refineInput;

    /**
     * The amount of refined ore that is returned after the machine has been fully worked.
     */
    public int refineOutput;

    /**
     * The number of times this machine needs to be worked to refine ore.
     */
    public int refineTime;

    /**
     * The Tile this Machine is on.
     */
    public Tile tile;

    /**
     * Tracks how many times this machine has been worked. (0 to refineTime).
     */
    public int worked;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Machine. Used during game initialization, do not call directly.
     */
    protected Machine() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
