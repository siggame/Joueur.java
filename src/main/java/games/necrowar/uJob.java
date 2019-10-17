/**
 * Information about a unit's job/type.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.necrowar;

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
 * Information about a unit's job/type.
 */
public class uJob extends GameObject {
    /**
     * The amount of damage this type does per attack.
     */
    public int damage;

    /**
     * How much does this type cost in gold.
     */
    public int goldCost;

    /**
     * The amount of starting health this type has.
     */
    public int health;

    /**
     * How much does this type cost in mana.
     */
    public int manaCost;

    /**
     * The number of moves this type can make per turn.
     */
    public int moves;

    /**
     * How many of this type of unit can take up one tile.
     */
    public int perTile;

    /**
     * Amount of tiles away this type has to be in order to be effective.
     */
    public int range;

    /**
     * The type title. 'worker', 'zombie', 'ghoul', 'hound', 'abomination', 'wraith' or 'horseman'.
     */
    public String title;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a uJob. Used during game initialization, do not call directly.
     */
    protected uJob() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
