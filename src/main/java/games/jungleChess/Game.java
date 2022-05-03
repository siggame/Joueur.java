/**
 * A 7x9 board game with pieces, to win the game the players must make successful captures of the enemy and reach the opponents den.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.jungleChess;

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
 * A 7x9 board game with pieces, to win the game the players must make successful captures of the enemy and reach the opponents den.
 */
public class Game extends BaseGame {
    /**
     * The list of [known] moves that have occurred in the game, in a format. The first element is the first move, with the last element being the most recent.
     */
    public List<String> history;

    /**
     * The jungleFen is similar to the chess FEN, the order looks like this, board (split into rows by '/'), whose turn it is, half move, and full move.
     */
    public String jungleFen;

    /**
     * List of all the players in the game.
     */
    public List<Player> players;

    /**
     * A unique identifier for the game instance that is being played.
     */
    public String session;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>

    /**
     * The hash of the game version we have locally. Used to compare to the game server's game version.
     */
    public final static String gameVersion = "0f0b85b33f03a669a391b36c90daa195d028dd1f21f8d4b601adfcf39b23eee2";


    /**
     * Creates a new instance of a Game. Used during game initialization, do not call directly.
     */
    protected Game() {
        super();
        this.name = "JungleChess";

        this.history = new ArrayList<String>();
        this.players = new ArrayList<Player>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
