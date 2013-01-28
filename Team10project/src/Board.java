
public class Board {
	/*the actual gem board storage consists of a grid of characters
	 * legend:
	 * O-unoccupied space
	 * B-square contains a vessal
	 * M-space has been hit though did not conatian a boat
	 * X-boat struck at this point
	 */
	private char[][] gameBoard;

	private final char emptySpace='O';
	private final char boatSpace='B';
	private final char missedSpace='M';
	private final char HitSpace='X';

	private String owner="";

	void setOwner(String name){
		if(owner=="")
			owner=name;
	}
	/**
	 * returns the value of the sqare at the corrdenants given.
	 * uses a true or false to determin if the person calling is the owner of the board
	 * @param player - checks that the player name is the same as the owner or the board
	 * @param x - x coordinant 
	 * @param ychar - y cordinant
	 * @return value of the board at that space x,y if your not the board owner 
	 */
	char getSquare(String player,int x, char ychar){
		int y=yConv(ychar);
		if(player==owner)
			return gameBoard[x][y];
		else{
			if(gameBoard[x][y]!=boatSpace){
				return gameBoard[x][y];
			}
			else
			return emptySpace;
		}
			
	}
	/**
	 * adds a boat object to the board. 
	 * @param boat - boat thats being added
	 * @return weather or not the boat coudl be added at the requested corrdinants
	 */
	public boolean addBoat(Boat boat){
		boolean legal=true;
		int vertical=0, horizontal=0;
		if(boat.vertical)
			vertical=1;
		else
			horizontal=1;
		
		for(int i=0;i<boat.length();i++){
			if(gameBoard[boat.x+(i*horizontal)][yConv(boat.y)+(i*vertical)]!=emptySpace)
				legal=false;
		}
		if(legal){
			for(int i=0;i<boat.length();i++){
				gameBoard[boat.x+(i*horizontal)][yConv(boat.y)+(i*vertical)]=boatSpace;
			}
		}
		return legal;
	}
	/**
	 * attack a particualr square on the board. if the attack hits a boat it sinks that sectoin
	 * and returns a sucsess. if not it returns a failure.
	 * @param x
	 * @param ychar
	 * @return wheather or not the boat was hit
	 */
	public boolean targetSquare(int x, char ychar){
		boolean hit=false;
		int y=yConv(ychar);
		if(gameBoard[x][y]==boatSpace){
			gameBoard[x][y]=HitSpace;
			hit=true;
		}
		else
			gameBoard[x][y]=missedSpace;
		return hit;
	}
	

	// converters for input and output of y values(imput and outputs as a character but is used as an int)
	private int yConv(char y) {
		int yint=(int)y-97;
		return yint;
	}
	private char yConv(int y){
		char ychar=(char)(y+97);
		return ychar;
	}
	
}
