/**
 * Generated by Creer at 12:46AM on April 16, 2016 UTC, git hash: 'f74143f3f89eebeaa381aba30a8afbda7d0e1d89'
 * A Spider in the game. The most basic unit.
 */
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
// you can add addtional import(s) here
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
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Spider. Used during game initialization, do not call directly.
     */
    public Spider() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
