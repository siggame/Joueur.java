/**
 * A Spider in the game. The most basic unit.
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
 * A Spider in the game. The most basic unit.
 */
public class Spider extends GameObject {
    /**
     * If this Spider is dead and has been removed from the game.
     */
    public boolean isDead;

    /**
     * The Nest that this Spider is currently on. Null when moving on a Web.
     */
    public Nest nest;

    /**
     * The Player that owns this Spider, and can command it.
     */
    public Player owner;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Spider. Used during game initialization, do not call directly.
     */
    protected Spider() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
