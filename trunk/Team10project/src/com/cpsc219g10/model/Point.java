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
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	/**
	 * Adds the values of this point to those of a different point and returns the values as a new point
	 * Accessor
	 * Pre-condition: two points are given
	 * Post-condition: a single new point is returned
	 * @param apoint
	 * @return
	 */
	public Point add(Point apoint) {
		return new Point(x + apoint.x, y + apoint.y);
	}
	
	/**
	 * Multiplies the x and y coordinates of the point by a scaler and passes them back to the user.
	 * Accessor
	 * Pre-condition: two points are given
	 * Post-condition: a single new point is returned
	 * @param multiplier
	 * @return
	 */
	public Point mult(double multiplier){
		return new Point((int)(x * multiplier), (int)(y * multiplier));
	}
	
	/**
	 * Returns as a string
	 */
	public String toString(){
		return "("+ x +", "+ y +")";
	}
	
	/**
	 * Determines if the point has the same x and y coordinate
	 * Accessor
	 * Pre-condition: nothing
	 * Post-condition: returns true if the x and y are equal and false otherwise
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

