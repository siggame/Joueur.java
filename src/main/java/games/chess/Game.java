/**
 * The traditional 8x8 chess board with pieces.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.chess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;
import joueur.Client;
import joueur.BaseGame;
import joueur.BaseGameObject;



/**
 * The traditional 8x8 chess board with pieces.
 */
public class Game extends BaseGame {
    /**
     * Forsyth-Edwards Notation (fen), a notation that describes the game board state.
     */
    public String fen;

    /**
     * The list of [known] moves that have occured in the game, in Standard Algebriac Notation (SAN) format. The first element is the first move, with the last being the most recent.
     */
    public List<String> history;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;





    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "Chess";

        this.history = new ArrayList<String>();
        this.players = new ArrayList<Player>();
    }


}
