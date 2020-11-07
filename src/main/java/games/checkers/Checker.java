/**
 * A checker on the game board.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.checkers;

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
 * A checker on the game board.
 */
public class Checker extends GameObject {
    /**
     * If the checker has been kinged and can move backwards.
     */
    public boolean kinged;

    /**
     * The player that controls this Checker.
     */
    public Player owner;

    /**
     * The x coordinate of the checker.
     */
    public int x;

    /**
     * The y coordinate of the checker.
     */
    public int y;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Checker. Used during game initialization, do not call directly.
     */
    protected Checker() {
        super();
    }

    /**
     * Returns if the checker is owned by your player or not.
     *
     * @return True if it is yours, false if it is not yours.
     */
    public boolean isMine() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("isMine", args);
    }

    /**
     * Moves the checker from its current location to the given (x, y).
     *
     * @param   x  The x coordinate to move to.
     * @param   y  The y coordinate to move to.
     * @return Returns the same checker that moved if the move was successful. Otherwise null.
     */
    public Checker move(int x, int y) {
        JSONObject args = new JSONObject();
        args.put("x", Client.getInstance().gameManager.serializeSafe(x));
        args.put("y", Client.getInstance().gameManager.serializeSafe(y));
        return (Checker)this.runOnServer("move", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
