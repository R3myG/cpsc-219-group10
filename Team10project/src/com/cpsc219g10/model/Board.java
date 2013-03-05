package com.cpsc219g10.model;

public class Board {
	/**
	 * The actual game board storage consists of a grid of characters
	 * It will update the board as spaces are filled with boats, and after spaces are attacked
	 * 
	 * Legend:
	 * O-unoccupied space
	 * B-square contains a vessel
	 * M-space has been hit though did not containing a boat
	 * X-boat struck at this point
	 */
	private int board_size=10;
	private char[][] gameBoard= new char[10][10];

	private final char emptySpace = 'O';
	private final char boatSpace = 'B';
	private final char missedSpace = 'M';
	private final char HitSpace = 'X';

	private String owner = "";

	// Define the owner of the board
	public void setOwner(String name){
		if(owner == "")
			owner = name;
	}
	public Board(String name){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				gameBoard[i][j] = emptySpace;
			}
		}
		owner = name;
	}

	/**
	 * Convert the y coordinate from a letter coordinate to a number coordinate and vice versa
	 */
	private int yConv(char y) {
		int yint = (int)y - (int)'a';
		return yint;
	}
	/*private char yConv(int y){
		char ychar = (char)(y + 97);
		return ychar;
	}
	*/
	
	/**
	 * This method will check a block on either a player's own board or the opponent's board.
	 * It will return the value of the square at the coordinates given.
	 * 
	 * If you are checking your own board, it will return whatever value is there.
	 * If you are checking the opponent's board, it will return whether or not there is a boat there
	 * 
	 * @param player - checks that the player name is the same as the owner or the board
	 * @param x - x coordinate 
	 * @param ychar - y coordinate as a character 
	 * @return value of the board at that space x,y if your not the board owner 
	 */
	public char getSquare(String player, int x, char ychar){
		int y = yConv(ychar);
		
		if(player == owner) {
			return gameBoard[x][y];
		} else {
			if(gameBoard[x][y] != boatSpace) {
				return gameBoard[x][y];
			} else {
				return emptySpace;
			}
		}
			
	}
	
	/**
	 * Adds a boat object onto the board. 
	 * 
	 * @param boat - The type of boat that's being added
	 * @return whether or not the boat can be added at the requested coordinates
	 */
	public boolean addBoat(Boat boat){
		boolean legal = true;
		int vertical = 0, horizontal = 0;
		
		// Set the orientation of the boat
		if(boat.vertical) {
			vertical = 1;
		} else {
			horizontal = 1;
		}
		
		// Check if the boat will fit
		for(int i = 0; i < boat.length() && legal; i++) {
			if(boat.x + (i * horizontal) < 10 && boat.y + (i * vertical) < 10) {
				if(gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)] != emptySpace) {
					legal = false;
				}
			}
			else {
				legal = false;
			}
		}

		// If it does fit, update the game board with the newly added boat
		if(legal) {
			for(int i = 0; i < boat.length(); i++) {
				gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)] = boatSpace;
			}
		}

		return legal;
	}
	
	/**
	 * Attack a particular square on the board.
	 * If the attack hits a boat, it sinks that section and returns a success.
	 * Otherwise it misses the boat and returns a failure.
	 * 
	 * @param x - The x coordinate of the attack
	 * @param ychar - The y coordinate of the attack as a character
	 * @return whether or not the boat was hit
	 */
	public boolean targetSquare(int x, char ychar){
		boolean hit = false;
		int y = yConv(ychar);
		
		if(gameBoard[x][y] == boatSpace){
			gameBoard[x][y] = HitSpace;
			hit = true;
		} else {
			gameBoard[x][y] = missedSpace;
		}
		return hit;
	}
	public String toString(){
		String out = "";
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				out += gameBoard[j][i]+"\t";
			}
			out += "\n";
		}
		return out;	
	}	
}