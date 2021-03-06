/**
 * Information about a tower's job/type.
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
 * Information about a tower's job/type.
 */
public class tJob extends GameObject {
    /**
     * Whether this tower type hits all of the units on a tile (true) or one at a time (false).
     */
    public boolean allUnits;

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
     * The number of tiles this type can attack from.
     */
    public int range;

    /**
     * The type title. 'arrow', 'aoe', 'ballista', or 'cleansing'.
     */
    public String title;

    /**
     * How many turns have to take place between this type's attacks.
     */
    public int turnsBetweenAttacks;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a tJob. Used during game initialization, do not call directly.
     */
    protected tJob() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
