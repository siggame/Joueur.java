/**
 * A basic building. It does nothing besides burn down. Other Buildings inherit from this class.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.anarchy;

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
 * A basic building. It does nothing besides burn down. Other Buildings inherit from this class.
 */
public class Building extends GameObject {
    /**
     * When true this building has already been bribed this turn and cannot be bribed again this turn.
     */
    public boolean bribed;

    /**
     * The Building directly to the east of this building, or null if not present.
     */
    public Building buildingEast;

    /**
     * The Building directly to the north of this building, or null if not present.
     */
    public Building buildingNorth;

    /**
     * The Building directly to the south of this building, or null if not present.
     */
    public Building buildingSouth;

    /**
     * The Building directly to the west of this building, or null if not present.
     */
    public Building buildingWest;

    /**
     * How much fire is currently burning the building, and thus how much damage it will take at the end of its owner's turn. 0 means no fire.
     */
    public int fire;

    /**
     * How much health this building currently has. When this reaches 0 the Building has been burned down.
     */
    public int health;

    /**
     * True if this is the Headquarters of the owning player, false otherwise. Burning this down wins the game for the other Player.
     */
    public boolean isHeadquarters;

    /**
     * The player that owns this building. If it burns down (health reaches 0) that player gets an additional bribe(s).
     */
    public Player owner;

    /**
     * The location of the Building along the x-axis.
     */
    public int x;

    /**
     * The location of the Building along the y-axis.
     */
    public int y;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Building. Used during game initialization, do not call directly.
     */
    protected Building() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
