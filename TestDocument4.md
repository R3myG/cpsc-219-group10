# Test Documentation for the Third Deliverable #


## Interface ##
For the second deliverable this is for the interface part:

Using the Main class runs the interface part. This part was coded with eclipse in the package com.cpsc219g10.view. So the easiest way is to use eclipse.
You can test this interface by using quit, rules of the game and the credits with “?”.

"New" and "Score" have to be implemented.

Working classes are:
  * HomePanel = done
  * RulesPanel = done
  * Window = done
  * ZContainer = done

In progress:
  * GamePanel = need to be done
  * PlaceBoatPanel = need to be done

## Boats ##


Working methods are:
  * setPostion = done
  * Boat = done
In progress:
  * isMe = done
BoatTest
Boat test is a simple test that ensures a boat object can be created, and that the position of the boat can be set and altered.
The output should be simply a print out of the boat's stats, followed by a length print out, matching the length of the boat.
The BoatTest class need only be run along with the boat class.

## Player ##


Working methods are:
  * getNam) = done
  * setName = done
In progress:
  * attack = done

PlayerTest Class
the player test class is a very involved test that checks all of the methods in the class
it generates 2 players and places a few boats around.

at this point player 1 attacks and hits player 2's battle ship. a message box should open saying you hit my battle ship.

after this it ensures that player 2 is still alive and playing.

after this player 2 sends a barrage of 25 attacks levelling all of player 1's boats. and checks to make sure that player 1 is completely wiped out. in the attack it will list all missed attacks.

it then prints out each player displaying all of there vital information

lastly assuming all previous test have passed it out putts a successes message(this is the most important message to see). if it does not display this then every specific fail is tagged with a number
## Board ##


Working methods are:
  * setOwner = done
  * Board = done
  * getSquare = done
  * addBoat = true
  * targetSquare = true
In progress:
  * Everything should be set for the Board Class
BoardTest:
> The BoardTest is a little more involved. It generates a board and all 5 boat objects, then adds the boats to the board. It will then print out the board as a text.

> After this it goes through and attacks every other space on the board. Printing out the board afterwards as well.
> You should be able to view the position of each boat on the grid and compare it to the two different boards. The positions and orientations should match up.

> The BoardTest class has to run along with the Board class as well, however it must also have the the BoatClass present as well.

## OnePlayerTest ##
this is the first Playable game test it uses a mouse listener on a JPannel to track where the players click the board and enables each player to place boats and target boats.

the game is a one computer PVP that involves switching computer users

_Instructions:_
View:
  * the left board is the player board and is clicked on only during the placing phase in order to place boats
  * the right board is the opponent board and is clicked during the playing phase in order to target an opponent square
Play:
  * the game is played between 2 players Gavin and Claire by default  the game has 4 states the placing state the playing state the turn switch state and the winning state.
  * the game begins on gavins turn on the placing phase the boat being placed is shown on the top corner of the board. you click the board where you want the top left corner of the boat to go then select a vertical or horizontal orientation by clicking either beside or bellow the last box(which will be painted red)
  * the screen then turns to the switching state. simply click any where in the white box to switch players.
  * for the remainder of the placing turn the turns progress the same(note: if you try and place a boat illegally it will not place and the switching phase will not be entered.)
  * after claire places her last boat the game mode will switch to the playing mode
  * gavin starts and this time by click the square on the opponents board where he would like to attack
  * if the attack hits it will inform the user though a message box that they hit and then go to the switch state, if it does not no message is displayed and switch state is entered immediately(note: once a boat has been sunk the message will switch to "you sunk my 'boat type' "
  * play continues till one player looses all there boats at which point the game enters the winning phase simply displaying the name of the winner"

_Known Bugs_

Graphics:
  * During he playing phase boats do not always draw to the board = fixed.
  * Text not centred in all boxes
  * Back ground image has some errors = fixed
Logic:
  * Winning state not entered when a player wins = fixed
  * When you open a new game on top of an existing game, there will be a second instance of the game playing. The boards will randomly switch between the two instances of the game.