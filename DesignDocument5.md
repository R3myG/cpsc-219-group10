# Fifth Deliverable #


## Group 10 ##

## Description of Application ##

The application in progress of creation is a Battleship game. The game as of right now will be run person vs. person on the same computer. It has a click based interface, so you can click a target on a grid, and the game will read that as an attack. If the attack hits a boat, it will mark said boat as hit until it is dead.

Since it is two people playing on one computer, when one person is taking a turn the opponent must be looking away or facing across from the first player. Once the first players turn is over, there will be a slight delay, where a black screen will appear to allow the players to swap spots, or rotate the laptop.

As the game progresses, a player will eventually sink all of their opponents boats. When this event occurs, the screen will change and a message will pop up saying the winner of the game.

There has been a graphical interface added to give the players a visual interpretation of the game. This allows the players to place their boats on a grid, as well as see the game progress as they attempt to hit their opponents boats.

There was some bugs with the "Next Player" button that have been resolved, which will allow you to correctly place boats where you want, as opposed to where you may have clicked on the screen during the "Player Swap" phase.

In deliverable three we described a possibility of adding an AI to the game. This will allow a single player to face off against an AI of various difficulty. The logic for the code involving the AI has been started, even though it is currently at the very basic levels of production. Now for deliverable four we have made quite strides with the AI, but still have yet to implement it into the actual game files. It is still undetermined if it will be ready in time for the final deliverable, but it will be an ongoing task to attempt to complete.

There has now been a set of rules added to the interface that you can view before the game starts. These rules briefly explain how to play the game. They include: how do place your boats, how to attack, how to switch turns and most importantly, how to win!

The AI that was mentioned previously has now been completed. It follows an algorithm that will be randomized, to prevent the players from memorizing the pattern of the AI and placing their boats strategically to counter it. There are also graphs that can be produced to see how many turns the AI takes to win on average at different difficulty levels.

The AI was the last section of the project to be complete, thus finishing the project.

## UML Diagram for the Final Product ##
![http://cpsc-219-group10.googlecode.com/svn/trunk/Team10project/ClassDiagram.png](http://cpsc-219-group10.googlecode.com/svn/trunk/Team10project/ClassDiagram.png)

## Other UML Diagrams ##
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

## AI Strategy algorithm ##

The AI was designed so that it could be implemented through the simple command attack(), that would travers the entire aspect of attacking a player. the basic break down of the AI logic is as follows.

_BoatNotFound_

when the AI has not found a Boat(it either has yet to find a ship or has not found another ship since the last one was sank) the AI has 3 possibilites

  * Attack Possibles - the AI has its own version of a board where it keeps data on the player its mostly a copy of the AI's game board though when ever it sinks a ship it removes it from the board. the first thing the AI will do is look threw this board for any "Hit Space" and attacks around the space. this is because any space that is a Hit space contained a boat though that boat has yet to be sank so at least one adjacent square will also be a hit"
  * Strategic attack - the AI has a repository of attack patterns stored in a folder. the files are simply text files containing 2 columns of  numbers, the X and Y coordinates in order that the strategy calles to attack in the specific file it will be drawing from is selected randomly from all lists present and then the reference frame of the board is rotated 90 180 270 or 360 degrees to add another level of complication
  * Random Attack - random attack the the most default of attacks the AI simply generates 2 random numbers and attacks that square. if the square is not attackable it regenerates numbers and tries again.

_BoatFound_

once the AI has hit an enemy boat it flips a boolean to true telling itself that there is a boat there. from this point it follows a simple progression of patterns till the boat is sunk.

  * Attack Around - the AI begins by attacking squares adjacent to the Hit Space. picking a random direction each turn to attack
  * Attack In Line -  once the AI has landed its second hit if the boat is not yet sunk it begins to attack along the axis of the two hits. working along the row or column till the boat is sunk or it stops hitting boats.
  * Attack From Start - if the AI is attacking in a line and it comes to the end of the boat and has not yet sunk the target the at draws a line back to the first Hit Space. and then attacks on the opposite side till it sinks the boat or hits nothing
  * Attack Possibles - this point is why attack Possibles was created. if the AI has attacked up and down the row or column and come to two dead ends then obviously there are multiple boats in this position. attack possibles allows the AI to identify a new Start Point to begin this algorithm from.