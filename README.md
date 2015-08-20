# Joueur.java
The Java game client for the Cadre framework to connect to [Cerveau](https://github.com/JacobFischer/Cerveau) servers.

![{Cadre}](http://i.imgur.com/17wwI3f.png)

All inspiration taken from [MST's SIG-GAME framework](https://github.com/siggame), and most of the terminology is assuming some familiarity with it as this is a spiritual successor to it.

## Features

* Multi-Game:
  * One client can have multiple AIs to play different games.
* Easy generation of new game AIs using the [Creer](https://github.com/JacobFischer/Creer) codegen.
* No game specific logic. All logic is done server side. Here on clients we just merge deltas into the game state, and expose the changes in handle Game and GameObject classes.
* Uses Maven for dependencies.
* Networking via TCP
  * Communication via json strings with support for cycles within game references
  * Only deltas in states are send over the network

## How to Run

```
javac JoueurJava GAME_NAME -s SERVER -p PORT -n PLAYER_NAME
```

Only `GAME_NAME` is required to run this client.


## Other notes

The game classes made publicly expose their attributes. **Do not** change them, or merge errors may happen. Java does not support any type of property pattern to hide setters behind.

### Missing features

This client does not support multi-dimensional objects (e.g. an array of arrays). And no dictionaries outside the special GameObjects dictionary will merge correctly for similar reasons. The main issue is because we want to keep the delta-merging code as DRY as possible.
