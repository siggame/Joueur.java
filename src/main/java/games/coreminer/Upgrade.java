/**
 * Information about a Miner's Upgrade module.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.coreminer;

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
 * Information about a Miner's Upgrade module.
 */
public class Upgrade extends GameObject {
    /**
     * The amount of cargo capacity this Upgrade has.
     */
    public int cargoCapacity;

    /**
     * The maximum amount of health this Upgrade has.
     */
    public int health;

    /**
     * The amount of mining power this Upgrade has per turn.
     */
    public int miningPower;

    /**
     * The number of moves this Upgrade can make per turn.
     */
    public int moves;

    /**
     * The Upgrade title.
     */
    public String title;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Upgrade. Used during game initialization, do not call directly.
     */
    protected Upgrade() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
