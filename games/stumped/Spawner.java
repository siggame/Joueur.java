/**
 * A resource spawner that generates branches or food.
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
 * A resource spawner that generates branches or food.
 */
public class Spawner extends GameObject {
    /**
     * True if this Spawner has been harvested this turn, and it will not heal at the end of the turn, false otherwise.
     */
    public boolean hasBeenHarvested;

    /**
     * How much health this Spawner has, which is used to calculate how much of its resource can be harvested.
     */
    public int health;

    /**
     * The Tile this Spawner is on.
     */
    public Tile tile;

    /**
     * What type of resource this is ('food' or 'branches').
     */
    public String type;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Spawner. Used during game initialization, do not call directly.
     */
    protected Spawner() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
