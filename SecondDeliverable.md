# Second Deliverable #


## Group 10 ##

## Description of Application ##

The application in progress of creation is a Battleship game. The game as of right now will be run person vs. person on the same computer. It has a click based interface, so you can click a target on a grid, and the game will read that as an attack. If the attack hits a boat, it will mark said boat as hit until it is dead.

Since it is two people playing on one computer, when one person is taking a turn the opponent must be looking away or facing across from the first player. Once the first players turn is over, there will be a slight delay, where a black screen will appear to allow the players to swap spots, or rotate the laptop.

In the future, there may be an AI aspect of the game developed, where a player can challenge an AI of various skill levels (easy, medium, hard). As well as AI, if the group deems it possible, we will attempt to try to make the game accessible from two different computers via a LAN or wireless connection.

## UML Diagrams of 4 Classes ##
![http://cpsc-219-group10.googlecode.com/svn/trunk/Team10project/ClassDiagram.png](http://cpsc-219-group10.googlecode.com/svn/trunk/Team10project/ClassDiagram.png)
| **Boat** |
|:---------|
|  |
|+owner: String|
|+vertical: boolean|
|+x: int|
|+y: int|
|-type: String|
|-types: String|
|-length: int|
|-health: int|
|  |
|+Boat(type\_num: int, pname: int)|
|+setPosition(xCoordinate: int, yCoordinate: int, orientation: boolean)|
|+isMe(x: int, y:int)|
|+isSunk(): boolean|



| **Player** |
|:-----------|
|  |
|-name: String|
|  |
|+setName(someName: String)|
|+attack(target: Player, x: int, y:int)|



| **Board** |
|:----------|
|  |
|-board\_size: int|
|-gameBoard: char|
|emptySpace: char|
|boatSpace: char|
|missedSpace: char|
|HitSpace: char|
|-owner: String|
|  |
|+setOwner(name: String)|
|+Board(name: String)|
|+getSquare(player: String, x: int, ychar: char)|
|+addBoat(boat: Boat): boolean|
|targetSquare(x: int, ychar: char): boolean|



| **Window** |
|:-----------|
||
|-menu: JMenuBar|
|-file: JMenu|
|-newgame: JMenuItem|
|-score: JMenuItem|
|-quit: JMenuItem|
|-about: JMenu|
|-about2: JMenu|
|-rules: JMenuItem|
|-conteneur: JPanel|
|-size: Dimension|
|  |
|+Window()|