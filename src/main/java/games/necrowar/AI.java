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
        // Go through all the units that you own.

        List<Tile> spawnWorkerTiles = new ArrayList<Tile>();
        List<Tile> spawnUnitTiles = new ArrayList<Tile>();
        for (Tile tile : this.player.side)
        {
            if (tile.owner == this.player)
            {
                if (tile.isWorkerSpawn)
                    spawnWorkerTiles.add(tile);
                else if (tile.isUnitSpawn)
                    spawnUnitTiles.add(tile);
            }
        }

        int gold = this.player.gold;
        int mana = this.player.mana;
        int numWorkers = 0;
        int numUnits = 0;
        for (Unit unit : this.player.units)
            if (unit.title.equals("worker"))
                numWorkers++;
            else
                numUnits++;

        if (numWorkers < 5)
            spawnWorkerTiles[0].spawnWorker();

        if (numUnits < 3)
            spawnUnitTiles[0].spawnUnit("ghoul");

        for (Unit unit : this.player.units)
        {
            // Only tries to do something if the unit actually exists.
            // if a unit does not have a tile, then they are dead.
            if (unit != null && unit.tile != null)
            {
                if (unit.job.title.equals("worker"))
                {
                    //If the unit is a worker, go to mine and collect gold
                    Tile target = null;

                    // Goes through all tiles in the game and finds a mine.
                    // Should only have four workers over at the mine.
                    for (Tile tile : this.game.tiles)
                    {
                        // If that mine is on my side, is a gold mine, and have no units on it
                        if (tile.isGoldMine && this.player.side.contains(tile) && tile.unit == null)
                        {
                            // Send it to that tile
                            target = tile;
                        }
                        // If the tile is a tower and on my side, and has no other units on it.
                        else if (tile.isTower && player.side.contains(tile) && tile.unit == null)
                        {
                            // Send it to that tile
                            target = tile;
                        }
                    }
                    // Else, try fishing
                    if (target == null)
                    {
                        // All river spots
                        List<Tile> riverSpots = new ArrayList<Tile>();
                        for (Tile tile : game.tiles)
                        {
                            // Gathers all river spots
                            if (tile.isRiver && player.side.contains(tile))
                            {
                                riverSpots.add(tile);
                            }
                        }
                        // Go through all game titles and find all adjacent spots to the river
                        for (Tile tile : game.tiles)
                        {
                            boolean foundRiverSpot = False;
                            for (Tile spot : riverSpots)
                            {
                                foundRiverSpot = tile.getNeighbors().contains(spot);
                            }
                            // Only does anything if tile is adjacent to river
                            if (foundRiverSpot && player.side.contains(tile))
                            {

                                while (unit.moves > 0 && !findPath(unit.tile, tile).isEmpty())
                                {
                                    // Moves unit until there are no moves left for the worker or at the tile
                                    if (!unit.move(findPath(unit.tile, tile).get(0)))
                                    {
                                        unit.move(target);
                                    }
                                }
                                // Fish
                                if (!unit.acted)
                                {
                                    unit.fish(tile);
                                }


                                break;
                            }
                        }
                    }
                    else
                    {
                        // Move to the target, whether that be mine or tower
                        while (unit.moves > 0 && !findPath(unit.tile, target).isEmpty())
                        {
                            if (!unit.move(findPath(unit.tile, target).get(0)))
                            {
                                unit.move(target);
                            }
                        }
                        // Checks whether the target is a mine or tower. Acts accordingly
                        if (!unit.acted)
                        {
                            if (target.isMine) {
                                unit.acted = True;
                                unit.mine(tile);
                            }
                            else if (target.isTower) {
                                unit.acted = True;
                                unit.build(tile);
                            }
                        }
                    }
                }
                else if (unit.UnitJob.title.equals("ghoul"))
                {
                    // Finds enemy towers
                    Tile target = null;

                    for (Tile tile : game.tiles)
                    {
                        if (tile.isTower && enemy.side.contains(tile) && tile.unit != null)
                        {
                            target = tile;
                            // Moves towards our target until at the target or out of moves.
                            while (unit.moves > 0 && findPath(unit.tile, target).size() > 1)
                            {
                                if (!unit.move(findPath(unit.tile, target).get(0)))
                                {
                                    unit.move(target);
                                }
                                if (!unit.acted)
                                {
                                       unit.attack(target);
                                       unit.acted = True;
                                }
                            }
                        }
                        else if (target != null)
                        {
                            Tile target = null;
                            for (Tile tile : game.tiles)
                            {
                                if (tile.isCastle && enemy.side.contains(tile) && tile.unit != null)
                                {
                                    target = tile;
                                    // Moves towards our target until at the target or out of moves.
                                    while (unit.moves > 0 && findPath(unit.tile, target).size() > 1)
                                    {
                                        if (!unit.move(findPath(unit.tile, target).get(0)))
                                        {
                                            unit.move(target);
                                        }
                                        if (!unit.acted)
                                        {
                                                unit.attack(target);
                                                unit.acted = True;
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
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
    // <<-- /Creer-Merge: methods -->>
}
