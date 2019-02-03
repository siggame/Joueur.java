/**
 * This is where you build your AI for the Chess game.
 */
package games.chess;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import joueur.BaseAI;

/**
 * This is where you build your AI for the Chess game.
 */
public class AI extends BaseAI {
    /**
     * This is the Game object itself, it contains all the information about the current game
     */
    public Game game;

    /**
     * This is your AI's player. This AI class is not a player, but it should command this Player.
     */
    public Player player;

    /**
     * This returns your AI's name to the game server. Just replace the string.
     * @return string of you AI's name
     */
    public String getName() {
        return "Chess Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
    }

    /**
     * This is automatically called when the game first starts, once the Game object and all GameObjects have been initialized, but before any players do anything.
     * This is a good place to initialize any variables you add to your AI, or start tracking game objects.
     */
    public void start() {
        super.start();
    }

    /**
     * This is automatically called every time the game (or anything in it) updates.
     * If a function you call triggers an update this will be called before that function returns.
     */
    public void gameUpdated() {
        super.gameUpdated();
    }

    /**
     * This is automatically called when the game ends.
     * You can do any cleanup of you AI here, or do custom logging. After this function returns the application will close.
     * @param  won  true if your player won, false otherwise
     * @param  reason  a string explaining why you won or lost
     */
    public void ended(boolean won, String reason) {
        super.ended(won, reason);
    }


    /**
     * This is called every time it is this AI.player's turn to make a move.
     *
     * @return A string in Standard Algebriac Notation (SAN) for the move you want to make. If the move is invalid or not properly formatted you will lose the game.
     */
    public String makeMove() {
        System.out.println(this.prettyFEN(this.game.fen, this.player.color));

        // This will only work if we are black move the pawn at b2 to b3.
        // Otherwise we will lose.
        // Your job is to code SOMETHING to parse the FEN string in some way to determine a valid move, in SAN format.
        return "b3";
    }

    /**
     * Pretty formats an FEN string to a human readable string.
     *
     * For more information on FEN (Forsyth-Edwards Notation) strings see:
     * https://wikipedia.org/wiki/Forsyth%E2%80%93Edwards_Notation 
     */
    private String prettyFEN(String fen, String us) {
        // split the FEN string up to help parse it
        String[] split = fen.split(" ");
        String first = split[0]; // the first part is always the board locations

        char sideToMove = split[1].charAt(0); // always the second part for side to move
        String usOrThem = sideToMove == us.charAt(0) ? "us"  : "them";

        String fullmove = split[5]; // always the sixth part for the full move

        String[] lines = first.split("/");
        StringBuilder strings = new StringBuilder();

        strings.append(String.format(
            "Move: %s\nSide to move: %s (%s)\n   +-----------------+",
            fullmove,
            sideToMove,
            usOrThem
        ));

        int i = -1;
        for (String line : lines) {
            i++;
            strings.append(String.format("\n %s |", 8 - i));
            for (char character : line.toCharArray()) {
                int asInt = Character.getNumericValue(character);
                if (asInt < 9) {
                    // blank tiles n times, so repeat the . that many times
                    strings.append(new String(new char[asInt]).replace("\0", " ."));
                }
                else {
                    // it was a regular character for a piece
                    strings.append(" " + character);
                }
            }
            strings.append(" |");
        }
        strings.append("\n   +-----------------+\n     a b c d e f g h\n");

        return strings.toString();
    }
}
