/**
 * A unit group in the game. This may consist of a ship and any number of crew.
 */

// DO NOT MODIFY THIS FILE
// Never try to directly create an instance of this class, or modify its member variables.
// Instead, you should only be reading its variables and calling its functions.

package games.pirates;

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
 * A unit group in the game. This may consist of a ship and any number of crew.
 */
public class Unit extends GameObject {
    /**
     * Whether this Unit has performed its action this turn.
     */
    public boolean acted;

    /**
     * How many crew are on this Tile. This number will always be <= crewHealth.
     */
    public int crew;

    /**
     * How much total health the crew on this Tile have.
     */
    public int crewHealth;

    /**
     * How much gold this Unit is carrying.
     */
    public int gold;

    /**
     * How many more times this Unit may move this turn.
     */
    public int moves;

    /**
     * The Player that owns and can control this Unit, or null if the Unit is neutral.
     */
    public Player owner;

    /**
     * (Merchants only) The path this Unit will follow. The first element is the Tile this Unit will move to next.
     */
    public List<Tile> path;

    /**
     * If a ship is on this Tile, how much health it has remaining. 0 for no ship.
     */
    public int shipHealth;

    /**
     * (Merchants only) The number of turns this merchant ship won't be able to move. They will still attack. Merchant ships are stunned when they're attacked.
     */
    public int stunTurns;

    /**
     * (Merchants only) The Port this Unit is moving to.
     */
    public Port targetPort;

    /**
     * The Tile this Unit is on.
     */
    public Tile tile;


    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of a Unit. Used during game initialization, do not call directly.
     */
    protected Unit() {
        super();
        this.path = new ArrayList<Tile>();
    }

    /**
     * Attacks either the 'crew' or 'ship' on a Tile in range.
     *
     * @param   tile  The Tile to attack.
     * @param   target  Whether to attack 'crew' or 'ship'. Crew deal damage to crew and ships deal damage to ships. Consumes any remaining moves.
     * @return True if successfully attacked, false otherwise.
     */
    public boolean attack(Tile tile, String target) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("target", Client.getInstance().gameManager.serializeSafe(target));
        return (boolean)this.runOnServer("attack", args);
    }

    /**
     * Buries gold on this Unit's Tile. Gold must be a certain distance away for it to get interest (Game.minInterestDistance).
     *
     * @param   amount  How much gold this Unit should bury. Amounts <= 0 will bury as much as possible.
     * @return True if successfully buried, false otherwise.
     */
    public boolean bury(int amount) {
        JSONObject args = new JSONObject();
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("bury", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Unit#deposit(int)
     */
    public boolean deposit() {
        return this.deposit(0);
    }

    /**
     * Puts gold into an adjacent Port. If that Port is the Player's port, the gold is added to that Player. If that Port is owned by merchants, it adds to that Port's investment.
     *
     * @param   amount  The amount of gold to deposit. Amounts <= 0 will deposit all the gold on this Unit.
     * @return True if successfully deposited, false otherwise.
     */
    public boolean deposit(int amount) {
        JSONObject args = new JSONObject();
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("deposit", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Unit#dig(int)
     */
    public boolean dig() {
        return this.dig(0);
    }

    /**
     * Digs up gold on this Unit's Tile.
     *
     * @param   amount  How much gold this Unit should take. Amounts <= 0 will dig up as much as possible.
     * @return True if successfully dug up, false otherwise.
     */
    public boolean dig(int amount) {
        JSONObject args = new JSONObject();
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("dig", args);
    }

    /**
     * Moves this Unit from its current Tile to an adjacent Tile. If this Unit merges with another one, the other Unit will be destroyed and its tile will be set to null. Make sure to check that your Unit's tile is not null before doing things with it.
     *
     * @param   tile  The Tile this Unit should move to.
     * @return True if it moved, false otherwise.
     */
    public boolean move(Tile tile) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        return (boolean)this.runOnServer("move", args);
    }

    /**
     * Regenerates this Unit's health. Must be used in range of a port.
     *
     * @return True if successfully rested, false otherwise.
     */
    public boolean rest() {
        JSONObject args = new JSONObject();
        return (boolean)this.runOnServer("rest", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '1'
     *
     * @see Unit#split(Tile, int, int)
     */
    public boolean split(Tile tile) {
        return this.split(tile, 1);
    }

    /**
     * Defaults the value for the optional arg 'gold' to '0'
     *
     * @see Unit#split(Tile, int, int)
     */
    public boolean split(Tile tile, int amount) {
        return this.split(tile, amount, 0);
    }

    /**
     * Moves a number of crew from this Unit to the given Tile. This will consume a move from those crew.
     *
     * @param   tile  The Tile to move the crew to.
     * @param   amount  The number of crew to move onto that Tile. Amount <= 0 will move all the crew to that Tile.
     * @param   gold  The amount of gold the crew should take with them. Gold < 0 will move all the gold to that Tile.
     * @return True if successfully split, false otherwise.
     */
    public boolean split(Tile tile, int amount, int gold) {
        JSONObject args = new JSONObject();
        args.put("tile", Client.getInstance().gameManager.serializeSafe(tile));
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        args.put("gold", Client.getInstance().gameManager.serializeSafe(gold));
        return (boolean)this.runOnServer("split", args);
    }

    /**
     * Defaults the value for the optional arg 'amount' to '0'
     *
     * @see Unit#withdraw(int)
     */
    public boolean withdraw() {
        return this.withdraw(0);
    }

    /**
     * Takes gold from the Player. You can only withdraw from your own Port.
     *
     * @param   amount  The amount of gold to withdraw. Amounts <= 0 will withdraw everything.
     * @return True if successfully withdrawn, false otherwise.
     */
    public boolean withdraw(int amount) {
        JSONObject args = new JSONObject();
        args.put("amount", Client.getInstance().gameManager.serializeSafe(amount));
        return (boolean)this.runOnServer("withdraw", args);
    }


    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
