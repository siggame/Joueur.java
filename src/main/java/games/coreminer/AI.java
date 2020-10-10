/**
 * This is where you build your AI for the Coreminer game.
 */
package games.coreminer;

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
 * This is where you build your AI for the Coreminer game.
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
    public List<Tile> mineTiles = new ArrayList<Tile>();
    public List<Tile> supportTiles = new ArrayList<Tile>();
    public Tile lastMined = null;
    public Tile tunnelX = null;
    // <<-- /Creer-Merge: fields -->>


    /**
     * This returns your AI's name to the game server. Just replace the string.
     * @return string of you AI's name
     */
    public String getName() {
        // <<-- Creer-Merge: get-name -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
        return "Coreminer Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
        // <<-- /Creer-Merge: get-name -->>
    }

    /**
     * This is automatically called when the game first starts, once the Game object and all GameObjects have been initialized, but before any players do anything.
     * This is a good place to initialize any variables you add to your AI, or start tracking game objects.
     */
    public void start() {
        // <<-- Creer-Merge: start -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.

        super.start();
        this.tunnelX = this.player.side[this.game.map_height + 1].x;

        //create hard coded tunnels
        for (Tile tile : this.player.side) {
            //get tiles next to base on players side of the map
            if (tile.x == this.tunnelX)
                this.mineTiles.add(tile);
            else if ((tile.y != 0) && (tile.y % 3 == 0))
                this.mineTiles.add(tile);
                if (tile.x % 2 == 0)
                    this.supportTiles.add(tile);
        }
        //sort by y value 
        Comparator<Tile> compareByY = (Tile o1, Tile o2) -> o1.y.compareTo(o2.y);
        Collections.sort(mineTiles, compareByY);
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
        // if player has no units, spawn miner at base 
        if (this.player.units.size() == 0)
            this.player.base_tile.spawn_miner();

        //control each miner
        for (Unit miner : this.player.units)
        {
            //only control miners
            if (miner.job.title == "miner")
            {
                //if miner is stuck in a cave-in, mine itself out 
                if (miner.tile.dirt + miner.tile.ore > 0)
                    miner.mine(miner.tile, -1);
                //if lacking building materials, go to base 
                if (miner.tile.is_base == false && ((miner.dirt + miner,ore >= 0.5 * miner.max_cargo_capacity) || miner.building_materials <= 0))
                {
                    //move to single ladder tunnel 
                    for (Tile tile : this.find_path(miner.tile, this.game.tiles[this.tunnelX + (miner.tile.y * this.game.map_width)]))
                    {
                        if (miner.moves == 0)
                            break;
                        miner.move(tile);
                    }
                    for (Tile tile : this.find_path(miner.tile, this.player.base_tile)
                    {
                        //if you need a ladder, build one
                        if (miner.tile.tile_north == tile && miner.tile.is_ladder == false)
                        {
                            //only build ladder in single column upward
                            if (miner.tile.x == self.tunnelX)
                                miner.build(miner.tile, "ladder");
                        }
                        if (miner.moves == 0)
                            break;
                        miner.move(tile);
                    }
                }
                //if miner is at base, drop off/buy materials if needed
                if (miner.tile == this.player.base_tile)
                {
                    if (miner.dirt > 0)
                        miner.dump(miner.tile, "dirt", 0);
                    if (miner.ore > 0)
                        miner.dump(miner.tile, "ore", 0);

                    //if you need building materials for ladders
                    if (miner.building_materials < self.game.ladder_cost * 3)
                        //if you have enough money to buy three ladders worth of material
                        if (this.player.money >= this.game.building_material_cost * this.game.ladder_cost * 3)
                        {
                            this.player.buy("buildingMaterials", this.game.ladder_cost * 3);
                            this.player.transfer(miner, "buildingMaterials", this.game.ladder_cost * 3)
                        }
                    //if you need building materials for supports
                    if (miner.building_materials < self.game.support_cost * 3)
                        //if you have enough money to buy three supports worth of material
                        if (this.player.money >= this.game.building_material_cost * this.game.support_cost * 3)
                        {
                            this.player.buy("buildingMaterials", this.game.support_cost * 3);
                            this.player.transfer(miner, "buildingMaterials", this.game.support_cost * 3)
                        }
                }

                //mine tunnels
                List<Tile> path = new ArrayList<Tile>();
                //if no path, find another 
                for (Tile tile : this.mineTiles)
                {
                    if (tile.ore + tile.dirt > 0)
                        path = this.find_path(miner.tile, tile);
                    if (path.size() > 0)
                        break;
                }
                for (Tile tile : path)
                {
                    if (miner.moves == 0)
                        break;
                    //mine anything in the way, build ladders down 
                    if (tile.ore + tile.dirt > 0)
                    {
                        boolean buildLadder = false;
                        if (tile == miner.tile.tile_south)
                            buildLadder = true;
                        miner.mine(tile, -1);
                        if (buildLadder)
                            miner.build(tile, "ladder");
                    }
                    //if space is open, move 
                    if (tile.ore + tile.dirt <= 0)
                    {
                        miner.move(tile);
                        //if tile is in supportTiles, build a suppot on it 
                        if (this.supportTiles.contains(tile) && tile.is_support == false)
                            //only build if you have enough materal for 2 more ladders 
                            if (miner.building_materials >= ((this.game.ladder_cost * 2) + this.game.support_cost))
                                miner.build(tile, "support");
                    }
                }
            }      
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
    // <<-- /Creer-Merge: methods -->>
}
