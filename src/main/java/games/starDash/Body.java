/**
 * A celestial body located within the game.
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
 * A celestial body located within the game.
 */
public class Body extends GameObject {
    /**
     * The amount of material the object has.
     */
    public int amount;

    /**
     * The type of celestial body it is.
     */
    public String bodyType;

    /**
     * The type of material the celestial body has.
     */
    public String materialType;

    /**
     * The radius of the circle that this body takes up.
     */
    public double radius;

    /**
     * The x value this celestial body is on.
     */
    public double x;

    /**
     * The y value this celestial body is on.
     */
    public double y;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Body. Used during game initialization, do not call directly.
     */
    protected Body() {
        super();
    }

    /**
     * Spawn a unit on some value of this celestial body.
     *
     * @param   x  The x value of the spawned unit.
     * @param   y  The y value of the spawned unit.
     * @param   title  The job title of the unit being spawned.
     * @return True if successfully taken, false otherwise.
     */
    public boolean spawn(double x, double y, String title) {
        JSONObject args = new JSONObject();
        args.put("x", Client.getInstance().gameManager.serializeSafe(x));
        args.put("y", Client.getInstance().gameManager.serializeSafe(y));
        args.put("title", Client.getInstance().gameManager.serializeSafe(title));
        return (boolean)this.runOnServer("spawn", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}