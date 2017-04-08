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





    /**
     * Creates a new instance of a Spawner. Used during game initialization, do not call directly.
     */
    protected Spawner() {
        super();
    }



}
