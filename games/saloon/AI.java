/**
 * This is where you build your AI for the Saloon game.
 */
package games.saloon;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Random;
import joueur.BaseAI;

/**
 * This is where you build your AI for the Saloon game.
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
        return "Saloon Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
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
        // This is "ShellAI", some basic code we've provided that does
        // everything in the game for demo purposed, but poorly so you
        // can get to optimizing or overwriting it ASAP
        //
        // ShellAI does a few things:
        // 1. Tries to spawn a new Cowboy
        // 2. Tries to move to a Piano
        // 3. Tries to play a Piano
        // 4. Tries to act

        System.out.println("Start of my turn: " + this.game.currentTurn);

        // Find the active cowboy to try to do things with
        Cowboy activeCowboy = null;
        for (int i = 0; i < this.player.cowboys.size(); i++) {
            Cowboy cowboy = this.player.cowboys.get(i);

            // if this cowboy is not dead then make him our active cowboy we will try to control
            if(!cowboy.isDead) {
                activeCowboy = cowboy;
                break;
            }
        }

        // A random generator we use to do random silly things
        Random random = new Random();

        // 1. Try to spawn a cowboy.

        // Randomly select a job.
        String newJob = this.game.jobs.get(random.nextInt(this.game.jobs.size()));

        // Count cowboys with selected job
        int jobCount = 0;
        for (int i = 0; i < this.player.cowboys.size(); i++) {
            Cowboy cowboy = this.player.cowboys.get(i);

            if(!cowboy.isDead && cowboy.job.equals(newJob)) {
                jobCount++;
            }
        }

        // Call in the new cowboy with that job if there aren't too many
        //   cowboys with that job already.
        if (this.player.youngGun.canCallIn && jobCount < this.game.maxCowboysPerJob) {
            System.out.println("1. Calling in: " + newJob);
            this.player.youngGun.callIn(newJob);
        }

        // Now lets use him
        if (activeCowboy != null) {
            // 2. Try to move to a piano.

            // Find a piano.
            Furnishing piano = null;
            for (int i = 0; i < this.game.furnishings.size(); i++) {
                Furnishing furnishing = this.game.furnishings.get(i);

                if (furnishing.isPiano && !furnishing.isDestroyed) {
                    piano = furnishing;
                    break;
                }
            }

            // There will always be pianos or the game will end. No need to check for existence.
            // Attempt to move toward the piano by finding a path.
            if (activeCowboy.canMove && !activeCowboy.isDead) {
                System.out.println("Trying to use Cowboy #" + activeCowboy.id);

                // Path can be empty if no piano to find, or the target piano is our neighbor.
                List<Tile> path = this.findPath(activeCowboy.tile, piano.tile);

                // if there is a path, move along it
                //      length 0 means no path could be found to the tile
                //      length 1 means the piano is adjacent, and we can't move onto the same tile as the piano
                if (path.size() > 1) {
                    System.out.println("2. Moving to Tile #" + path.get(0).id);
                    activeCowboy.move(path.get(0));
                }
            }

            // 3. Try to play a nearby piano.
            if (!activeCowboy.isDead && activeCowboy.turnsBusy == 0) {
                List<Tile> neighbors = activeCowboy.tile.getNeighbors();

                for (int i = 0; i < neighbors.size(); i++) {
                    Tile neighbor = neighbors.get(i);

                    if (neighbor.furnishing != null && neighbor.furnishing.isPiano) {
                        System.out.println("3. Playing piano (Furnishing) #" + neighbor.furnishing.id);
                        activeCowboy.play(neighbor.furnishing);
                        break;
                    }
                }
            }

            // 4. Try to act with active cowboy
            if (!activeCowboy.isDead && activeCowboy.turnsBusy == 0) {
                // Get a random neighboring tile.
                List<Tile> neighbors = activeCowboy.tile.getNeighbors();
                Tile neighbor = neighbors.get(random.nextInt(neighbors.size()));

                // Based on job, act accordingly.
                if (activeCowboy.job.equals("Bartender")) {
                    // Bartenders dispense brews freely, but they still manage to get their due.
                    String direction = Tile.DIRECTIONS[random.nextInt(Tile.DIRECTIONS.length)];
                    System.out.println("4. Bartender acting on Tile #" + neighbor.id + " with drunkDirection: " + direction);
                    activeCowboy.act(neighbor, direction);
                }
                else if (activeCowboy.job.equals("Brawler")) {
                    // Brawlers' brains are so pickled, they hardly know friend from foe.
                    // Probably don't ask them act on your behalf.
                    System.out.println("4. Brawlers cannot act");
                }
                else if (activeCowboy.job.equals("Sharpshooter")) {
                    // Sharpshooters aren't as quick as they used to be, and all that ruckus around them
                    // requires them to focus when taking aim.
                    if (activeCowboy.focus > 0) {
                        System.out.println("4. Sharpshooter acting on Tile #" + neighbor.id);
                        activeCowboy.act(neighbor);
                    }
                    else {
                        System.out.println("4. Sharpshooter doesn't have enough focus. (focus == " + activeCowboy.focus + ")");
                    }
                }
            }
        }

        System.out.println("Ending my turn.");

        return true;
    }

    /**
     * A very basic path finding algorithm (Breadth First Search) that when given a starting Tile, will return a valid path to the goal Tile.
     * @param  start  the starting Tile
     * @param  goal  the goal Tile
     * @return A List of Tiles representing the path, the the first element being a valid adjacent Tile to the start, and the last element being the goal.
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
