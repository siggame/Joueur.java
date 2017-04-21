/**
 * An eager young person that wants to join your gang, and will call in the veteran Cowboys you need to win the brawl in the saloon.
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
 * An eager young person that wants to join your gang, and will call in the veteran Cowboys you need to win the brawl in the saloon.
 */
public class YoungGun extends GameObject {
    /**
     * The Tile that a Cowboy will be called in on if this YoungGun calls in a Cowboy.
     */
    public Tile callInTile;

    /**
     * True if the YoungGun can call in a Cowboy, false otherwise.
     */
    public boolean canCallIn;

    /**
     * The Player that owns and can control this YoungGun.
     */
    public Player owner;

    /**
     * The Tile this YoungGun is currently on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a YoungGun. Used during game initialization, do not call directly.
     */
    protected YoungGun() {
        super();
    }

    /**
     * Tells the YoungGun to call in a new Cowboy of the given job to the open Tile nearest to them.
     *
     * @param   job  The job you want the Cowboy being brought to have.
     * @return The new Cowboy that was called in if valid. They will not be added to any `cowboys` lists until the turn ends. Null otherwise.
     */
    public Cowboy callIn(String job) {
        JSONObject args = new JSONObject();
        args.put("job", Client.getInstance().gameManager.serializeSafe(job));
        return (Cowboy)this.runOnServer("callIn", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
