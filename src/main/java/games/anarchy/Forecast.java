/**
 * The weather effect that will be applied at the end of a turn, which causes fires to spread.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.anarchy;

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
 * The weather effect that will be applied at the end of a turn, which causes fires to spread.
 */
public class Forecast extends GameObject {
    /**
     * The Player that can use WeatherStations to control this Forecast when its the nextForecast.
     */
    public Player controllingPlayer;

    /**
     * The direction the wind will blow fires in. Can be 'north', 'east', 'south', or 'west'.
     */
    public String direction;

    /**
     * How much of a Building's fire that can be blown in the direction of this Forecast. Fire is duplicated (copied), not moved (transferred).
     */
    public int intensity;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Forecast. Used during game initialization, do not call directly.
     */
    protected Forecast() {
        super();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
