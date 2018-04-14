/**
 * A structure on a Tile.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.catastrophe;

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
 * A structure on a Tile.
 */
public class Structure extends GameObject {
    /**
     * The range of this Structure's effect. For example, a radius of 1 means this Structure affects a 3x3 square centered on this Structure.
     */
    public int effectRadius;

    /**
     * The number of materials in this Structure. Once this number reaches 0, this Structure is destroyed.
     */
    public int materials;

    /**
     * The owner of this Structure if any, otherwise null.
     */
    public Player owner;

    /**
     * The Tile this Structure is on.
     */
    public Tile tile;

    /**
     * The type of Structure this is ('shelter', 'monument', 'wall', 'road', 'neutral').
     */
    public String type;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Structure. Used during game initialization, do not call directly.
     */
    protected Structure() {
        super();
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
