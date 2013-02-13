/**
 * Creating the instance variables
 * and methods for the 
 * boat class
 */
public class Boat {
	
	/**
	 * Setting up the instance variables
	 */
	public String owner;
	private String type;
	private final String[] types = {"aircraft carrier" , "battleship" , 
			"submarine" , "destroyer" , "patrol boat"};
	private final int[] lengths = {5, 4, 3, 3, 2};
	public boolean vertical;
	public int x;
	public int y;
	private int length;
	private int health;
	
	/**
	 * returns the length of the boat
	 * @return
	 */
	public int length() {
		return length;
	};
	
	/**
	 * generates a new boat object with a specific type and length
	 * @param type_num - the kind of boat(0 = aircraft carrier, 1 = battleship,
			2 = submarine, 3 = destroyer, 4 = patrol boat
	 */
	public Boat(int type_num, String pname) {
		type = types[type_num];
		length = lengths[type_num];
		owner = pname;
		health = length;
	}
	public void setPosition(int xCoordinate, int yCoordinate, boolean orientation) {
		x = xCoordinate - 1;
		y = yCoordinate - 1;
		vertical = orientation;
	}
	public void isMe(int x,int y){
		boolean me = false;
		int vertical = 0, horizontal = 0;
		
		// Set the orientation of the boat
		if(this.vertical) {
			vertical = 1;
		} else {
			horizontal = 1;
		}
		
		// Check if the boat will fit
		for(int i = 0; i < length; i++) {
			if(this.x + (i * horizontal) == x || this.y + (i * vertical) == y){
				health--;
			}
		}
	}
	/**
	 * If the health of the boat reaches zero, 
	 * the boat will be considered sunk
	 * @return
	 */
	public boolean isSunk(){
		if(health == 0)
			return true;
		else
			return false;
		
	}
	public String toString(){
		return owner + " " + type + " " + length + " " + x + " " + y + " " + vertical;
	}
}
