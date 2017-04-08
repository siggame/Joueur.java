/**
 * This is where you build your AI for the Stumped game.
 */
package games.stumped;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Collections;
import joueur.BaseAI;



/**
 * This is where you build your AI for the Stumped game.
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

    // you can add additional fields here for your AI to use


    /**
     * This returns your AI's name to the game server. Just replace the string.
     * @return string of you AI's name
     */
    public String getName() {
        return "Stumped Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
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
     * @param  name  reason">a string explaining why you won or lost
     */
    public void ended(boolean won, String reason) {
        super.ended(won, reason);
    }


    /**
     * This is called every time it is this AI.player's turn.
     *
     * @return Represents if you want to end your turn. True means end your turn, False means to keep your turn going and re-call this function.
     */
    public boolean runTurn() {
        // This is your Stumped ShellAI
        // ShellAI is intended to be a simple AI that does everything possible in the game, but plays the game very poorly
        // This example code does the following:
        // 1. Grabs a single beaver
        // 2. tries to move the beaver
        // 3. tries to do one of the 5 actions on it
        // 4. Grabs a lodge and tries to recruit a new beaver

        // First let's do a simple print statement telling us what turn we are on
        System.out.println("My Turn " + this.game.currentTurn);

        // used to do random things
        Random random = new Random();

        // 1. get the first beaver to try to do things with
        Beaver beaver = null;

        // If we have any beavers, grab one
        if (this.player.beavers.size() > 0) {
            beaver = this.player.beavers.get(0);
        }

        // if we have a beaver, and it's not distracted, and it is alive (health greater than 0)
        if (beaver != null && beaver.turnsDistracted == 0 && beaver.health > 0) {
            // then let's try to do stuff with it

            // 2. Try to move the beaver
            if (beaver.moves >= 3) {
                // then it has enough moves to move in any direction, so let's move it

                // find a spawner to move to
                Tile target = null;
                for (Tile tile : this.game.tiles) {
                    if (tile.spawner != null && tile.spawner.health > 1) {
                        // then we found a healthy spawner, let's target that tile to move to
                        target = tile;
                        break;
                    }
                }

                // use the pathfinding algorithm below to make a path to the spawner's target tile
                List<Tile> path = this.findPath(beaver.tile, target);

                // if there is a path, move to it
                //      length 0 means no path could be found to the tile
                //      length 1 means the target is adjacent, and we can't move onto the same tile as the spawner
                //      length 2+ means we have to move towards it
                if (path.size() > 1) {
                    System.out.println("Moving Beaver #" + beaver.id + " towards Tile #" + target.id);
                    beaver.move(path.get(0));
                }
            }

            // 3. Try to do an action on the beaver
            if (beaver.actions > 0) {
                // then let's try to do an action!

                // Do a random action!
                final String[] actions = {"buildLodge", "attack", "pickup", "drop", "harvest"};
                String action = actions[random.nextInt(actions.length)];

                // a handy list of our neighbors
                List<Tile> neighbors = beaver.tile.getNeighbors();
                Collections.shuffle(neighbors, random);

                // how much this beaver is carrying, used for calculations
                int load = beaver.branches + beaver.food;

                switch (action) {
                    case "buildLodge":
                        // if the beaver has enough branches to build a lodge
                        //   and the tile does not already have a lodge, then do so
                        if ((beaver.branches + beaver.tile.branches) >= this.player.branchesToBuildLodge && beaver.tile.lodgeOwner == null) {
                            System.out.println("Beaver #" + beaver.id + " building lodge");
                            beaver.buildLodge();
                        }
                        break;
                    case "attack":
                        // look at all our neighbor tiles and if they have a beaver attack it!
                        for (Tile neighbor : neighbors) {
                            if (neighbor.beaver != null) {
                                System.out.println("Beaver #" + beaver.id + " attacking Beaver #" + neighbor.beaver.id);
                                beaver.attack(neighbor.beaver);
                                break;
                            }
                        }
                        break;
                    case "pickup":
                        // make an array of our neighboring tiles + our tile as all can be picked up from
                        List<Tile> pickupTiles = beaver.tile.getNeighbors();
                        pickupTiles.add(beaver.tile);
                        Collections.shuffle(pickupTiles, random);

                        // if the beaver can carry more resources, try to pick something up
                        if (load < beaver.job.carryLimit) {
                            for (Tile tile : pickupTiles) {
                                // try to pickup branches
                                if (tile.branches > 0) {
                                    System.out.println("Beaver #" + beaver.id + " picking up branches");
                                    beaver.pickup(tile, "branches", 1);
                                    break;
                                }
                                // try to pickup food
                                else if (tile.food > 0) {
                                    System.out.println("Beaver #" + beaver.id + " picking up food");
                                    beaver.pickup(tile, "food", 1);
                                    break;
                                }
                            }
                        }
                        break;
                    case "drop":
                        // choose a random tile from our neighbors + out tile to drop stuff on
                        List<Tile> dropTiles = beaver.tile.getNeighbors();
                        dropTiles.add(beaver.tile);
                        Collections.shuffle(dropTiles, random);

                        // find a valid tile to drop resources onto
                        Tile tileToDropOn = null;
                        for (Tile tile : dropTiles) {
                            if (tile.spawner == null) {
                                tileToDropOn = tile;
                                break;
                            }
                        }

                        // if there is a tile that resources can be dropped on
                        if (tileToDropOn != null) {
                            // if we have branches to drop
                            if (beaver.branches > 0) {
                                System.out.println("Beaver #" + beaver.id + " dropping 1 branch");
                                beaver.drop(tileToDropOn, "branches", 1);
                            }
                            // or if we have food to drop
                            else if (beaver.food > 0) {
                                System.out.println("Beaver #" + beaver.id + " dropping 1 food");
                                beaver.drop(tileToDropOn, "food", 1);
                            }
                        }
                        break;
                    case "harvest":
                        // if we can carry more, try to harvest something
                        if (load < beaver.job.carryLimit) {
                            // try to find a neighboring tile with a spawner on it to harvest from
                            for (Tile neighbor : neighbors) {
                                // if it has a spawner on that tile, harvest from it
                                if(neighbor.spawner != null) {
                                    System.out.println("beaver #" + beaver.id + " harvesting Spawner #" + neighbor.spawner.id);
                                    beaver.harvest(neighbor.spawner);
                                    break;
                                }
                            }
                        }
                        break;
                }
            }
        }

        // now try to spawn a beaver if we have lodges

        // 4. Get a lodge to try to spawn something at
        if (this.player.lodges.size() > 0) {
            Tile lodge = this.player.lodges.get(random.nextInt(this.player.lodges.size()));

            // if we found a lodge and it has no beaver blocking it
            if (lodge != null && lodge.beaver == null) {
                // then this lodge can have a new beaver appear here

                // We need to know how many beavers we have to see if they are free to spawn
                int aliveBeavers = 0;
                for (Beaver myBeaver : this.player.beavers) {
                    if (myBeaver.health > 0) {
                        aliveBeavers++;
                    }
                }

                // and we need a Job to spawn
                Job job = this.game.jobs.get(random.nextInt(this.game.jobs.size()));

                // if we have less beavers than the freeBeavers count, it is free to spawn
                //    otherwise if that lodge has enough food on it to cover the job's cost
                if (aliveBeavers < this.game.freeBeaversCount || lodge.food >= job.cost) {
                    // then spawn a new beaver of that job!
                    System.out.println("recruting Job #" + job.id + " to Tile #" + lodge.id);
                    job.recruit(lodge);
                    aliveBeavers++;
                }
            }
        }

        System.out.println("Done with our turn");
        return true; // to signify that we are truly done with this turn
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


}
