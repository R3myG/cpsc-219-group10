# Second Deliverable #


## Group 10 ##

## Description of Application ##

The application in progress of creation is a Battleship game. The game as of right now will be run person vs. person on the same computer. It has a click based interface, so you can click a target on a grid, and the game will read that as an attack. If the attack hits a boat, it will mark said boat as hit until it is dead.

Since it is two people playing on one computer, when one person is taking a turn the opponent must be looking away or facing across from the first player. Once the first players turn is over, there will be a slight delay, where a black screen will appear to allow the players to swap spots, or rotate the laptop.

There has been a graphical interface added to give the players a visual interpretation of the game. This allows the players to place their boats on a grid, as well as see the game progress as they attempt to hit their opponents boats.

There was some bugs with the "Next Player" button that have been resolved, which will allow you to correctly place boats where you want, as opposed to where you may have clicked on the screen during the "Player Swap" phase.

In the last deliverable we described a possibility of adding an AI to the game. This will allow a single player to face off against an AI of various difficulty. The logic for the code involving the AI has been started, even though it is currently at the very basic levels of production.

## UML Diagrams ##
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

| **Turn** |
|:---------|
|  |
|-pnum: int|
|-opnum: int|
|-bnum: int|
|  |
|+set(player: Player, opponent: Player, adraw: draw)|
|+play(i: int, j: int)|
|+place(x1: int, y1: int, x2: int, y2: int): boolean|
|+refresh(placing: boolean)|

| **Draw** |
|:---------|
|  |
|-emptySpace: char|
|-boatSpace: char|
|-missedSpace: char|
|-hitSpace: char|
|-black: Color|
|-red: Color|
|-green: Color|
|-white: Color|
|-clear: Color|
|-YSHIFT: int|
|-GRIDSIZE: int|
|-XSHIFT: int|
|-XSHIFT2: int|
|-canvas: Graphics|
|-hit: Image|
|-vert: Image|
|-hor: Image|
|-bacl: Image|
|  |
|+draw(acanvas: Graphics)|
|+drawplyaterBoard(p: Player)|
|+drawopponentBoard(p: Player, op: Player)|
|+drawBoats(p: Player)|
|+drawBoats(p: Player, num: int)|
|+won(winner: Player)|
|+paintSquare(ax: int, ay: int)|

## Classes still needed to be created ##
As of right now, the only classes that we are working on creating are the classes involving the production of the AI.