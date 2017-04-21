/**
 * An furnishing in the Saloon that must be pathed around, or destroyed.
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

// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add additional import(s) here
// <<-- /Creer-Merge: imports -->>

/**
 * An furnishing in the Saloon that must be pathed around, or destroyed.
 */
public class Furnishing extends GameObject {
    /**
     * How much health this Furnishing currently has.
     */
    public int health;

    /**
     * If this Furnishing has been destroyed, and has been removed from the game.
     */
    public boolean isDestroyed;

    /**
     * True if this Furnishing is a piano and can be played, False otherwise.
     */
    public boolean isPiano;

    /**
     * If this is a piano and a Cowboy is playing it this turn.
     */
    public boolean isPlaying;

    /**
     * The Tile that this Furnishing is located on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Furnishing. Used during game initialization, do not call directly.
     */
    protected Furnishing() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
