/**
 * Tracks any projectiles moving through space.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.stardash;

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
 * Tracks any projectiles moving through space.
 */
public class Projectile extends GameObject {
    /**
     * The remaining health of the projectile.
     */
    public int energy;

    /**
     * The amount of remaining distance the projectile can move.
     */
    public int fuel;

    /**
     * The Player that owns and can control this Projectile.
     */
    public Player owner;

    /**
     * The unit that is being attacked by this projectile.
     */
    public Unit target;

    /**
     * The x value this projectile is on.
     */
    public double x;

    /**
     * The y value this projectile is on.
     */
    public double y;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Projectile. Used during game initialization, do not call directly.
     */
    protected Projectile() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
