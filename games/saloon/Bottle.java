/**
 * A bottle thrown by a bartender at a Tile.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.saloon;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;

// you can add addtional import(s) here

/**
 * A bottle thrown by a bartender at a Tile.
 */
public class Bottle extends GameObject {
    /**
     * The Direction this Bottle is flying and will move to between turns, can be 'North', 'East', 'South', or 'West'.
     */
    public String direction;

    /**
     * The direction any Cowboys hit by this will move, can be 'North', 'East', 'South', or 'West'.
     */
    public String drunkDirection;

    /**
     * True if this Bottle has impacted and has been destroyed (removed from the Game). False if still in the game flying through the saloon.
     */
    public boolean isDestroyed;

    /**
     * The Tile this bottle is currently flying over.
     */
    public Tile tile;


    // you can add addtional field(s) here. None of them will be tracked or updated by the server.


    /**
     * Creates a new instance of a Bottle. Used during game initialization, do not call directly.
     */
    public Bottle() {
        super();
    }

    // you can add addtional method(s) here.
}
