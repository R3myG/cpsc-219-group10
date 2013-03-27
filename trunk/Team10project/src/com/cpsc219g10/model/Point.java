package com.cpsc219g10.model;
/**
 * The point class takes and stores the x and y corrodenants of a particular point on a plane. 
 * once created the point can not be altered and can onyl be accsessd. 
 * the point class has methods that alow you to add 2 points together or multiply the point by a 
 * scalling factor
 */
public class Point {
	private int x;
	private int y;
	
	/**
	 * Constructor takes the x and y cordenents of a location and turns them in to a point object
	 * @param ax  x-corrdinent
	 * @param ay  y-corrdinant
	 */
	public Point(int ax, int ay) {
		x = ax;
		y = ay;
		}
	
	/**
	 * Gets the x coordinate of the point
	 * Accessor
	 * Pre-condition: 
	 * Post-condition:  
	 * @return x coordinate
	 */
	public int x() {
		return x;
	}
	
	/**
	 * Accessor
	 * @return
	 */
	public int y() {
		return y;
	}
	
	/**
	 * Adds the values of this point to those of a different point and returns the values as a new point
	 * Accessor
	 * Pre-condition: 
	 * Post-condition: 
	 * @param apoint
	 * @return
	 */
	public Point add(Point apoint) {
		return new Point(x + apoint.x, y + apoint.y);
	}
	
	/**
	 * Multiplies the x and y coordinates of the point by a scaler and passes them back to the user.
	 * Accessor
	 * Pre-condition: 
	 * Post-condition: 
	 * @param multiplier
	 * @return
	 */
	public Point mult(double multiplier){
		return new Point((int)(x * multiplier), (int)(y * multiplier));
	}
	
	/**
	 * Accsessor
	 */
	public String toString(){
		return "("+ x +", "+ y +")";
	}
	
	/**
	 * Accessor
	 * @param p
	 * @return
	 */
	public boolean equals(Point p){
		if(x == p.x && y == p.y)
			return true;
		else
			return false;
	}
}

