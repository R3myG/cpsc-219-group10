
public class Boat {
	public String owner;
	private String type;
	private final String[] types = {"aircraft carrier" , "battleship" , 
			"submarine" , "destroyer" , "patrol boat"};
	private final int[] lengths = {5, 4, 3, 3, 2};
	public boolean vertical;
	public int x;
	public int y;
	private int length;
	
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
	public Boat(int type_num,String pname) {
		type = types[type_num];
		length = lengths[type_num];
		owner=pname;
	}
	public void setPosition(int xCoordinate, int yCoordinate, boolean orientation) {
		x = xCoordinate-1;
		y = yCoordinate-1;
		vertical = orientation;
	}
	public String toString(){
		return owner+" "+type+" "+length+" "+x+" "+y+" "+vertical;
	}
}
