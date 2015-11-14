# Anarchy Java Client

This is the root of you AI. Stay out of the joueur/ folder, it does most of the heavy lifting to play on our game servers. Your AI, and the game objects it manipulates are all in `games/anarchy/`, with your very own AI living in `games/anarchy/AI.java` for you to make smarter.

## How to Run

This client has been tested and confirmed to work on the Campus rc##xcs213 Linux machines, but it can work on your own Windows/Linux/Mac machines if you desire.

### Linux

```
make
./testRun MyOwnGameSession
```

JRE7 and Maven 3 are the only required packages.

### Windows

On Windows it is probably best to use [Eclipse](http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/mars1) and just create a new project from existing code, pointing to this repo. It should read the .classfile and setup the rest. Note you'll need the Maven plugin too.

Alternatively you can install JRE7 and Maven 3 just like the link bash script does, and run it from the command line using the same commands as in the make file.
