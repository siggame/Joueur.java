/**
 * Can be bribed to change the next Forecast in some way.
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
 * Can be bribed to change the next Forecast in some way.
 */
public class WeatherStation extends Building {

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a WeatherStation. Used during game initialization, do not call directly.
     */
    protected WeatherStation() {
        super();
    }

    /**
     * Defaults the value for the optional arg 'negative' to 'false'
     *
     * @see WeatherStation#intensify(boolean)
     */
    public boolean intensify() {
        return this.intensify(false);
    }

    /**
     * Bribe the weathermen to intensity the next Forecast by 1 or -1.
     *
     * @param   negative  By default the intensity will be increased by 1, setting this to true decreases the intensity by 1.
     * @return True if the intensity was changed, false otherwise.
     */
    public boolean intensify(boolean negative) {
        JSONObject args = new JSONObject();
        args.put("negative", Client.getInstance().gameManager.serializeSafe(negative));
        return (boolean)this.runOnServer("intensify", args);
    }

    /**
     * Defaults the value for the optional arg 'counterclockwise' to 'false'
     *
     * @see WeatherStation#rotate(boolean)
     */
    public boolean rotate() {
        return this.rotate(false);
    }

    /**
     * Bribe the weathermen to change the direction of the next Forecast by rotating it clockwise or counterclockwise.
     *
     * @param   counterclockwise  By default the direction will be rotated clockwise. If you set this to true we will rotate the forecast counterclockwise instead.
     * @return True if the rotation worked, false otherwise.
     */
    public boolean rotate(boolean counterclockwise) {
        JSONObject args = new JSONObject();
        args.put("counterclockwise", Client.getInstance().gameManager.serializeSafe(counterclockwise));
        return (boolean)this.runOnServer("rotate", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
