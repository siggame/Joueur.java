/**
 * A person on the map that can move around and interact within the saloon.
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
 * A person on the map that can move around and interact within the saloon.
 */
public class Cowboy extends GameObject {
    /**
     * If the Cowboy can be moved this turn via its owner.
     */
    public boolean canMove;

    /**
     * The direction this Cowboy is moving while drunk. Will be 'North', 'East', 'South', or 'West' when drunk; or '' (empty string) when not drunk.
     */
    public String drunkDirection;

    /**
     * How much focus this Cowboy has. Different Jobs do different things with their Cowboy's focus.
     */
    public int focus;

    /**
     * How much health this Cowboy currently has.
     */
    public int health;

    /**
     * If this Cowboy is dead and has been removed from the game.
     */
    public boolean isDead;

    /**
     * If this Cowboy is drunk, and will automatically walk.
     */
    public boolean isDrunk;

    /**
     * The job that this Cowboy does, and dictates how they fight and interact within the Saloon.
     */
    public String job;

    /**
     * The Player that owns and can control this Cowboy.
     */
    public Player owner;

    /**
     * The Tile that this Cowboy is located on.
     */
    public Tile tile;

    /**
     * How many times this unit has been drunk before taking their siesta and resetting this to 0.
     */
    public int tolerance;

    /**
     * How many turns this unit has remaining before it is no longer busy and can `act()` or `play()` again.
     */
    public int turnsBusy;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Cowboy. Used during game initialization, do not call directly.
     */
    protected Cowboy() {
        super();
    }

    /**
     * Defaults the value for the optional arg 'drunkDirection' to '""'
     *
     * @see Cowboy#act(Tile, String)
     */
    public boolean act(Tile tile) {
        return this.act(tile, "");
    }

    /**
     * Does their job's action on a Tile.
     *
     * @param   tile  The Tile you want this Cowboy to act on.
     * @param   drunkDirection  The direction the bottle will cause drunk cowboys to be in, can be 'North', 'East', 'South', or 'West'.
     * @return True if the act worked, false otherwise.
     */
    public boolean act(Tile tile, String drunkDirection) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("drunkDirection", Client.getInstance().gameManager.serializeSafe(drunkDirection));
        return (boolean)this.runOnServer("act", args);
    }

    /**
     * Moves this Cowboy from its current Tile to an adjacent Tile.
     *
     * @param   tile  The Tile you want to move this Cowboy to.
     * @return True if the move worked, false otherwise.
     */
    public boolean move(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Sits down and plays a piano.
     *
     * @param   piano  The Furnishing that is a piano you want to play.
     * @return True if the play worked, false otherwise.
     */
    public boolean play(Furnishing piano) {
        JSONObject args = new JSONObject();
        args.put("piano", Client.getInstance().gameManager.serializeSafe(piano));
        return (boolean)this.runOnServer("play", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
