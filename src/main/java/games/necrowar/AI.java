/**
 * This is where you build your AI for the Necrowar game.
 */
package games.necrowar;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import joueur.BaseAI;

// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add additional import(s) here
import java.util.ListIterator;
// <<-- /Creer-Merge: imports -->>

/**
 * This is where you build your AI for the Necrowar game.
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

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional fields here for your AI to use
    public Tile spawnUnitTile = null;
    public Tile spawnWorkerTile = null;
    public List<Tile> goldMines = new ArrayList<Tile>();
    public List<Unit> miners = new ArrayList<Unit>();
    public List<Unit> builders = new ArrayList<Unit>();
    public List<Unit> units = new ArrayList<Unit>();
    public List<Tile> grassByPath = new ArrayList<Tile>();
    public Tower enemyCastle = null;
    public Tower myCastle = null;

    // <<-- /Creer-Merge: fields -->>


    /**
     * This returns your AI's name to the game server. Just replace the string.
     * @return string of you AI's name
     */
    public String getName() {
        // <<-- Creer-Merge: get-name -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        return "Necrowar Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
        // <<-- /Creer-Merge: get-name -->>
    }

    /**
     * This is automatically called when the game first starts, once the Game object and all GameObjects have been initialized, but before any players do anything.
     * This is a good place to initialize any variables you add to your AI, or start tracking game objects.
     */
    public void start() {
        // <<-- Creer-Merge: start -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        super.start();
        // replace with your own start logic

        // Print our starting stats
        System.out.println("Gold: " + this.player.gold);
        System.out.println("Mana: " + this.player.mana);
        System.out.print("Units: ");
        for (Unit unit : this.player.units) {
            System.out.print(unit.job.title);
        }
        System.out.println("\nTowers: ");
        for (Tower t : this.player.towers) {
            System.out.print(t.job.title);
        }
        System.out.println("\nCastle Health: " + this.player.towers.get(0).health);

        // Set up variables to track stuff
        this.enemyCastle = this.player.opponent.towers.get(0);
        this.myCastle = this.player.towers.get(0);

        for (Tile tile : this.player.side) {
            if (tile.isUnitSpawn)
                this.spawnUnitTile = tile;
            else if (tile.isWorkerSpawn)
                this.spawnWorkerTile = tile;
            else if (tile.isGoldMine)
                this.goldMines.add(tile);
            else if (tile.isGrass) {
                for (Tile neighbor : tile.getNeighbors()) {
                    if (neighbor.isPath)
                        this.grassByPath.add(tile);
                }
            }
        }
        // Now we should have our spawn tiles, mines, and tower building locations!

        // <<-- /Creer-Merge: start -->>
    }

    /**
     * This is automatically called every time the game (or anything in it) updates.
     * If a function you call triggers an update this will be called before that function returns.
     */
    public void gameUpdated() {
        // <<-- Creer-Merge: game-updated -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        super.gameUpdated();
        // <<-- /Creer-Merge: game-updated -->>
    }

    /**
     * This is automatically called when the game ends.
     * You can do any cleanup of you AI here, or do custom logging. After this function returns the application will close.
     * @param  won  true if your player won, false otherwise
     * @param  reason  a string explaining why you won or lost
     */
    public void ended(boolean won, String reason) {
        // <<-- Creer-Merge: ended -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        super.ended(won, reason);
        // replace with your own end logic

        // Print our final stats
        System.out.println("Gold: " + this.player.gold);
        System.out.println("Mana: " + this.player.mana);
        System.out.print("Units: ");
        for (Unit unit : this.player.units) {
            System.out.print(unit.job.title);
        }
        System.out.println("\nTowers: ");
        for (Tower t : this.player.towers) {
            System.out.print(t.job.title);
        }
        if (this.player.towers.get(0).job.title == "castle")
            System.out.println("\nCastle Health: " + this.player.towers.get(0).health);
        else
            System.out.println("No castle left :(");
        // <<-- /Creer-Merge: ended -->>
    }


    /**
     * This is called every time it is this AI.player's turn.
     *
     * @return Represents if you want to end your turn. True means end your turn, False means to keep your turn going and re-call this function.
     */
    public boolean runTurn() {
        // <<-- Creer-Merge: runTurn -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        // Put your game logic here for runTurn

        List<Tile> path;
        // Remove any dead units from our personal tracking lists
        for (ListIterator<Unit> it = this.miners.listIterator(); it.hasNext();) {
            if (it.next().health <= 0)
                it.remove();
        }
        for (ListIterator<Unit> it = this.builders.listIterator(); it.hasNext();) {
            if (it.next().health <= 0)
                it.remove();
        }
        for (ListIterator<Unit> it = this.units.listIterator(); it.hasNext();) {
            if (it.next().health <= 0)
                it.remove();
        }

        // Spawn all three of our chosen unit types if necessary
        if (this.miners.size() == 0)
            if (this.spawnWorkerTile.spawnWorker())
                this.miners.add(this.player.units.get(this.player.units.size()-1));

        if (this.builders.size() == 0)
            if (this.spawnWorkerTile.spawnWorker())
                this.builders.add(this.player.units.get(this.player.units.size()-1));

        if (this.units.size() == 0)
            if (this.spawnUnitTile.spawnUnit("ghoul"))
                this.units.add(this.player.units.get(this.player.units.size()-1));

        // Activate all the different units in our lists
        for (Unit miner : this.miners) {
            if (miner.tile.isGoldMine)
                miner.mine(miner.tile);
            else {
                path = this.findPathWorker(miner.tile, this.goldMines.get(0));
                for (Tile tile : path) {
                    if (miner.moves <= 0)
                        break;
                    miner.move(tile);
                }

            }

        }

        for (Unit builder : this.builders) {
            path = this.findPathWorker(builder.tile, this.grassByPath.get(0));
            for (Tile tile : path) {
                if (builder.moves <= 0)
                    break;
                builder.move(tile);
            }
            if (path.size() == 0 && builder.moves > 0)
                builder.build("arrow");
        }


        for (Unit unit : this.units) {
            path = this.findPath(unit.tile, this.enemyCastle.tile.tileSouth);
            for (Tile tile : path) {
                if (unit.moves <= 0)
                    break;
                unit.move(tile);
            }
            if (path.size() == 0 && unit.moves > 0)
                unit.attack(this.enemyCastle.tile);
        }


        // Make towers attack anything adjacent to them
        // Note that they are not using their full range
        List<Tile> adjacent;
        for (Tower tower : this.player.towers) {
            adjacent = tower.tile.getNeighbors();
            for (Tile tile : adjacent)
                if (tile.unit != null && tile.unit.owner == this.player.opponent)
                    tower.attack(tile);
        }


        return true;
        // <<-- /Creer-Merge: runTurn -->>
    }


    /**
     * A very basic path finding algorithm (Breadth First Search) that when given a starting Tile, will return a valid path to the goal Tile.
     * @param  start  the starting Tile
     * @param  goal  the goal Tile
     * @return A List of Tiles representing the path, the the first element being a valid adjacent Tile to the start, and the last element being the goal. Or an empty list if no path found.
     */
    List<Tile> findPath(Tile start, Tile goal) {
        // no need to make a path to here...
        if (start == goal) {
            return new ArrayList<Tile>();
        }

        // the tiles that will have their neighbors searched for 'goal'
        Queue<Tile> fringe = new LinkedList<Tile>();

        // How we got to each tile that went into the fringe.
        HashMap<Tile, Tile> cameFrom = new HashMap<Tile, Tile>();

        // Enqueue start as the first tile to have its neighbors searched.
        fringe.add(start);

        // keep exploring neighbors of neighbors... until there are no more.
        while (!fringe.isEmpty()) {
            // the tile we are currently exploring.
            Tile inspect = fringe.remove();

            // cycle through the tile's neighbors.
            List<Tile> neighbors = inspect.getNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                Tile neighbor = neighbors.get(i);

                // If we found the goal we've found the path!
                if (neighbor == goal) {
                    // Follow the path backward starting at the goal and return it.
                    List<Tile> path = new ArrayList<Tile>();
                    path.add(goal);

                    // Starting at the tile we are currently at, insert them retracing our steps till we get to the starting tile
                    for (Tile step = inspect; step != start; step = cameFrom.get(step)) {
                        path.add(0, step);
                    }

                    return path;
                }

                // if the tile exists, has not been explored or added to the fringe yet, and it is pathable
                if (neighbor != null && !cameFrom.containsKey(neighbor) && neighbor.isPathable()) {
                    // add it to the tiles to be explored and add where it came from.
                    fringe.add(neighbor);
                    cameFrom.put(neighbor, inspect);
                }

            } // for each neighbor

        } // while fringe not empty

        // if you're here, that means that there was not a path to get to where you want to go.
        //   in that case, we'll just return an empty path.
        return new ArrayList<Tile>();
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add additional methods here for your AI to call
    List<Tile> findPathWorker(Tile start, Tile goal) {
        // no need to make a path to here...
        if (start == goal) {
            return new ArrayList<Tile>();
        }

        // the tiles that will have their neighbors searched for 'goal'
        Queue<Tile> fringe = new LinkedList<Tile>();

        // How we got to each tile that went into the fringe.
        HashMap<Tile, Tile> cameFrom = new HashMap<Tile, Tile>();

        // Enqueue start as the first tile to have its neighbors searched.
        fringe.add(start);

        // keep exploring neighbors of neighbors... until there are no more.
        while (!fringe.isEmpty()) {
            // the tile we are currently exploring.
            Tile inspect = fringe.remove();

            // cycle through the tile's neighbors.
            List<Tile> neighbors = inspect.getNeighbors();
            for (int i = 0; i < neighbors.size(); i++) {
                Tile neighbor = neighbors.get(i);

                // If we found the goal we've found the path!
                if (neighbor == goal) {
                    // Follow the path backward starting at the goal and return it.
                    List<Tile> path = new ArrayList<Tile>();
                    path.add(goal);

                    // Starting at the tile we are currently at, insert them retracing our steps till we get to the starting tile
                    for (Tile step = inspect; step != start; step = cameFrom.get(step)) {
                        path.add(0, step);
                    }

                    return path;
                }

                // if the tile exists, has not been explored or added to the fringe yet, and it is pathable
                if (neighbor != null && !cameFrom.containsKey(neighbor) && neighbor.isPathableWorker()) {
                    // add it to the tiles to be explored and add where it came from.
                    fringe.add(neighbor);
                    cameFrom.put(neighbor, inspect);
                }

            } // for each neighbor

        } // while fringe not empty

        // if you're here, that means that there was not a path to get to where you want to go.
        //   in that case, we'll just return an empty path.
        return new ArrayList<Tile>();
    }
    // <<-- /Creer-Merge: methods -->>
}
