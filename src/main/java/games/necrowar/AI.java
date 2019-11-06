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
        for (Unit unit : player.units)
        {

            // Only tries to do something if the unit actually exists.
            // if a unit does not have a tile, then they are dead.
            if (unit != null && unit.tile != null)
            {
                if (unit.uJob.title.equals("worker"))
                {
                    //If the unit is a worker, go to mine and collect gold
                    Tile target = null;

                    // Goes through all tiles in the game and finds a mine.
                    // Should only have four workers over at the mine.
                    for (Tile tile : game.tiles)
                    {
                        // If that mine is on my side, is a gold mine, and have no units on it
                        if (tile.isGoldMine && player.side.contains(tile) && tile.unit == null)
                        {
                            // Send it to that tile
                            target = tile;
                        }
                    }
                    // Else, try fishing
                    if (target == null)
                    {   
                        // All river spots
                        List<Tile> riverSpots = new ArrayList<Title>();
                        for (Tile tile : game.tiles)
                        {
                            // Gathers all river spots
                            if (tile.isRiver && player.side.contains(tile))
                            {
                                riverSpots.add(tile)
                            }
                        // Go through all game titles and find all adjacent spots to the river
                        for (Tile tile : game.tiles)
                        {
                            boolean foundRiverSpot = False
                            for (Tile spot : riverSpots)
                            {
                                foundRiverSpot = tile.getNeighbors().contains(spot)
                            }
                            // Only does anything if tile is adjacent to river
                            if (foundRiverSpot && player.side.contains(tile)
                            {
                                
                                while (unit.moves > 0 && !findPath(unit.tile, tile).isEmpty())
                                {
                                    // Moves unit there are no moves left for the physicist.
                                    if (!unit.move(findPath(unit.tile, tile).get(0)))
                                    {
                                        break;
                                    }
                                }
                                // Fish
                                if (!unit.acted)
                                {
                                    unit.fish(tile)
                                }
                                

                                break;
                            }
                        }
                    }
                    else
                    {
                        // Gets the tile of the targeted machine if adjacent to it.
                        boolean adjacent = false;

                        for (Tile tile : target.getNeighbors())
                        {
                            if (tile == unit.tile)
                            {
                                adjacent = true;
                            }
                        }

                        // If there is a machine that is waiting to be worked on, go to it.
                        while ( unit.moves > 0 && !findPath(unit.tile, target).isEmpty() && !adjacent)
                        {
                            if (!unit.move(findPath(unit.tile, target).get(0)))
                            {
                                break;
                            }
                        }

                        // Acts on the target machine to run it if the physicist is adjacent.
                        if (adjacent && !unit.acted)
                        {
                            unit.act(target);
                        }
                    }
                }
                else if (unit.job.title.equals("intern"))
                {
                    // If the unit is an intern, collects blueium ore.
                    // Note: You also need to collect redium ore.

                    // Goes to gather resources if currently carrying less than the carry limit.
                    if (unit.blueiumOre < unit.job.carryLimit)
                    {
                        // Your intern's current target.
                        Tile target = null;

                        // Goes to collect blueium ore that isn't on a machine.
                        for (Tile tile : game.tiles)
                        {
                            if (tile.blueiumOre > 0 && tile.machine == null)
                            {
                                target = tile;
                                break;
                            }
                        }

                        // Moves towards our target until at the target or out of moves.
                        if (!findPath(unit.tile, target).isEmpty())
                        {
                            while (unit.moves > 0 && !findPath(unit.tile, target).isEmpty())
                            {
                                if (!unit.move(findPath(unit.tile, target).get(0)))
                                    break;
                            }
                        }

                        // Picks up the appropriate resource once we reach our target's tile.
                        if (unit.tile == target && target.blueiumOre > 0)
                        {
                            unit.pickup(target, 0, "blueium ore");
                        }


                    }
                    else
                    {
                        // Deposits blueium ore in a machine for it if we have any.

                        // Finds a machine in the game's tiles that takes blueium ore.
                        for (Tile tile : game.tiles)
                        {
                            if (tile.machine != null && tile.machine.oreType.equals("blueium"))
                            {
                                // Moves towards the found machine until we reach it or are out of moves.
                                while (unit.moves > 0 && !findPath(unit.tile, tile).isEmpty())
                                {
                                    if (!unit.move(findPath(unit.tile, tile).get(0)))
                                    {
                                        break;
                                    }
                                }

                                // Deposits blueium ore on the machine if we have reached it.
                                if (findPath(unit.tile, tile).size() <= 1)
                                {
                                    unit.drop(tile, 0, "blueium ore");
                                }
                            }
                        }
                    }
                }
                else if (unit.job.title.equals("manager"))
                {
                    // Finds enemy interns, stuns, && attacks them if there is no blueium to take to the generator.
                    Tile target = null;

                    for (Tile tile : game.tiles)
                    {
                        if (tile.blueium > 1 && unit.blueium < unit.job.carryLimit)
                            target = tile;
                    }

                    if (target  == null && unit.blueium == 0)
                    {
                        for (Unit enemy : game.units)
                        {
                            // Only does anything for an intern that is owned by your opponent.
                            if (enemy.tile != null && enemy.owner == player.opponent && enemy.job.title.equals("intern"))
                            {
                                // Moves towards the intern until reached or out of moves.
                                while (unit.moves > 0 && !findPath(unit.tile, enemy.tile).isEmpty())
                                    if (!unit.move(findPath(unit.tile, enemy.tile).get(0)))
                                        break;

                                // Either stuns or attacks the intern if we are within range.
                                if (enemy.tile.hasNeighbor(unit.tile))
                                {
                                    if (enemy.stunTime == 0 && enemy.stunImmune == 0)
                                    {
                                        // Stuns the enemy intern if they are !stunned && !immune.
                                        unit.act(enemy.tile);
                                    }
                                    else
                                    {
                                        // Attacks the intern otherwise.
                                        unit.attack(enemy.tile);
                                    }

                                    break;
                                }
                            }
                        }
                    }
                    else if (target != null)
                    {
                        // Moves towards our target until at the target or out of moves.
                        while (unit.moves > 0 && findPath(unit.tile, target).size() > 1)
                        {
                            if (!unit.move(findPath(unit.tile, target).get(0)))
                            {
                                break;
                            }
                        }

                        // Picks up blueium once we reach our target's tile.
                        if (findPath(unit.tile, target).size() <= 1 && target.blueium > 0)
                        {
                            unit.pickup(target, 0, "blueium");
                        }
                    }
                    else if (target == null && unit.blueium > 0)
                    {
                        // Stores a tile that is part of your generator.
                        Tile gen_tile = player.generatorTiles.get(0);

                        // Goes to your generator && drops blueium in.
                        while (unit.moves > 0 && !findPath(unit.tile, gen_tile).isEmpty())
                        {
                            if (!unit.move(findPath(unit.tile, gen_tile).get(0)))
                            {
                                break;
                            }
                        }

                        // Deposits blueium in our generator if we have reached it.
                        if (findPath(unit.tile, gen_tile).isEmpty())
                        {
                            unit.drop(gen_tile, 0, "blueium");
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
