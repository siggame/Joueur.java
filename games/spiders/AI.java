/**
 * This is where you build your AI for the Spiders game.
 */
package games.spiders;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import joueur.BaseAI;


/**
 * This is where you build your AI for the Spiders game.
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

    private Random this.rng;

    /**
     * This returns your AI's name to the game server. Just replace the string.
     * @return string of you AI's name
     */
    public String getName() {
        return "Spiders Java Player"; // REPLACE THIS WITH YOUR TEAM NAME!
    }

    /**
     * This is automatically called when the game first starts, once the Game object and all GameObjects have been initialized, but before any players do anything.
     * This is a good place to initialize any variables you add to your AI, or start tracking game objects.
     */
    public void start() {
        super.start();
        this.rng = new Random();
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
     * @param  reason a string explaining why you won or lost
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
        // This is ShellAI, it is very simple, and demonstrates how to use all the game objects in Spiders
        int index = this.rng.nextInt(player.spiders.size());

        // Try to do something with a random spider
        Spider spider = player.spiders.get(index);

        if(spider.gameObjectName.equals("BroodMother")) {
            BroodMother broodMother = (BroodMother)spider;

            int choice = this.rng.nextInt(10);
            if(choice == 0) { // 10% of the time try to consume a Spiderling
                if(broodMother.nest.spiders.size() > 1) { // let's eat a baby

                    // pick a random spiderling
                    index = this.rng.nextInt(broodMother.nest.spiders.size());
                    Spider otherSpider = broodMother.nest.spiders.get(index);

                    if(otherSpider != broodMother) { // can't eat yourself
                        System.out.println("Broodmother #" + broodMother.id +
                                           " consuming " + otherSpider.gameObjectName + " #" + otherSpider.id);
                        broodMother.consume((Spiderling)otherSpider);
                    }
                }
            }
            else {
                if(broodMother.eggs > 0) { // try to spawn a baby Spiderling

                    // pick a random spiderling type
                    List<String> spiderlingTypes = Arrays.asList("Cutter", "Weaver", "Spitter");
                    index = this.rng.nextInt(spiderlingTypes.size());
                    String randomSpiderlingType = spiderlingTypes.get(index);

                    System.out.println("Broodmother #" + broodMother.id +
                                       " spawning " + randomSpiderlingType);
                    broodMother.spawn(randomSpiderlingType);
                }
            }
        }
        else {
            Spiderling spiderling = (Spiderling)spider;
            // spiderlings all have two common behaviors: move, attack,
            // plus one behavior specific to their exact type

            // some actions take time. if a spiderling is still doing a thing
            // then they can't do another thing. much like undergrads, they
            // might think they can multitask, but really they can't.
            if(spiderling.busy.equals("")) { // then they are NOT busy

                int choice = this.rng.nextInt(3);
                if(choice == 0) { // move
                    if(spiderling.nest.webs.size() > 0 ) {

                        // pick a random web to move to
                        index = this.rng.nextInt(spiderling.nest.webs.size());
                        Web web = spiderling.nest.webs.get(index);

                        System.out.println(spiderling.gameObjectName +" #" + spiderling.id +
                                           " moving on Web #" + web.id);
                        spiderling.move(web);
                    }
                }
                else if(choice == 1) { // attack
                    if(spiderling.nest.spiders.size() > 1) {

                        // pick a random spiderling to attack
                        index = this.rng.nextInt(spiderling.nest.spiders.size());
                        Spider otherSpider = spiderling.nest.spiders.get(index);

                        // no friendly fire, please
                        if(!(otherSpider.owner.equals(spiderling.owner))) {
                            System.out.println(spiderling.gameObjectName + " #" + spiderling.id + " attacking " +
                                               otherSpider.gameObjectName + " #" + otherSpider.id);
                            spiderling.attack((Spiderling)otherSpider);
                        }
                    }
                }
                else { // do the unique behavior
                    if(spiderling.gameObjectName.equals("Spitter")) {
                        Spitter spitter = (Spitter)spiderling;
                        Nest enemyNest = player.otherPlayer.broodMother.nest;

                        // ensure that the Web from here to there doesn't already exist
                        Web existingWeb = null;
                        for (int i = 0; i < enemyNest.webs.size() ; ++i) {
                            if(enemyNest.webs.get(i).nestA == spitter.nest ||
                                    enemyNest.webs.get(i).nestB == spitter.nest) {
                                existingWeb = enemyNest.webs.get(i);
                                break;
                            }
                        }

                        if(existingWeb == null) { // then there is no Web already!
                            System.out.println("Spitter #" + spitter.id +
                                               " spitting to Nest #" + enemyNest.id);
                            spitter.spit(enemyNest);
                        }
                    }
                    else if(spiderling.gameObjectName.equals("Cutter")) {
                        Cutter cutter = (Cutter)spiderling;

                        if(cutter.nest.webs.size() > 0) {

                            // pick a random Web
                            index = this.rng.nextInt(cutter.nest.webs.size());
                            Web web = cutter.nest.webs.get(index);

                            System.out.println("Cutter #" + cutter.id +
                                               " cutting Web #" + web.id);
                            cutter.cut(web);
                        }
                    }
                    else if(spiderling.gameObjectName.equals("Weaver")) {
                        Weaver weaver = (Weaver)spiderling;

                        if(weaver.nest.webs.size() > 0) {

                            // pick a random Web
                            index = this.rng.nextInt(weaver.nest.webs.size());
                            Web web = weaver.nest.webs.get(index);

                            // randomly decide to strengthen or weaken
                            choice = this.rng.nextInt(2);
                            if(choice == 0) { // strengthen
                                System.out.println("Weaver #" + weaver.id +
                                                   " strengthening Web #" + web.id);
                                weaver.strengthen(web);
                            }
                            else { // weaken
                                System.out.println("Weaver #" + weaver.id +
                                                   " weakening Web #" + web.id);
                                weaver.weaken(web);
                            }
                        }
                    }
                }
            }
        }

        return true; // to signify you are done with your turn
    }
}
