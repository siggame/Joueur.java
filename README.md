# GAME_NAME Java Client

This is the root of you AI. Stay out of the `joueur/` folder, it does most of the heavy lifting to play on our game servers. Your AI, and the game objects it manipulates are all in `games/game_name/`, with your very own AI living in `games/game_name/AI.java` for you to make smarter.

## How to Run

This client has been tested and confirmed to work on the Campus rc##xcs213 Linux machines, but it can work on your own Windows/Linux/Mac machines if you desire.

### Linux

```
make
./testRun MyOwnGameSession
```

JRE7 and Maven 3 are the only required packages, and can be found in `java-common` and `mvn` respectively.

In addition, after you `make` once, you can do `make core` instead to just rebuild, and not fetch the dependencies again.

### Windows

On Windows it is probably best to use [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars1) and just create a new project from existing code, pointing to this repo. It should read the `.classfile` and setup the rest. Note you'll need the Maven plugin too.

Alternatively you can install JRE7 and Maven 3 just like the link bash script does, and run it from the command line using the same commands as in the `Makefile`.

## Other Notes

It is possible that on your Missouri S&T S-Drive this client will not run properly. This is not a fault with the client, but rather the school's S-Drive implimentation changing some file permissions during run time. We cannot control this. Instead, we recommend cloning your repo outside the S-Drive and use an SCP program like [WinSCP](https://winscp.net/eng/download.php) to edit the files in Windows using whatever IDE you want if you want to code in Windows, but compile in Linux.

The only file you should ever modify to create your AI is the `AI.java` file. All the other files are needed for the game to work. In addition, you should never be creating your own instances of the Game's classes, nor should you ever try to modify their variables. Instead, treat the Game and its members as a read only structure that represents the game state on the game server. You interact with it by calling the game functions.
