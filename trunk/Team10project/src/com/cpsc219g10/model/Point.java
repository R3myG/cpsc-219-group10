package com.cpsc219g10.model;
/**
 * the point class takes and stores the x and y corrodenants of a particular point on a plane. 
 * once created the point can not be altered and can onyl be accsessd. 
 * the point class has methods that alow you to add 2 points together or multiply the point by a 
 * scalling factor
 */
public class Point {
	private int x;
	private int y;
	/**
	 * constructor takes the x and y cordenents of a location and turns them in to a point object
	 * @param ax  x-corrdinent
	 * @param ay  y-corrdinant
	 */
	public Point(int ax,int ay){
		x=ax;
		y=ay;
		}
	/**
	 * gets the x corrdinnt of the point
	 * 
	 * accsessor
	 * 
	 * @return x corrdindant
	 */
	public int x(){
		return x;
	}
	/**
	 * accsessor
	 * @return
	 */
	public int y(){
		return y;
	}
	/**
	 * adds the values of this point to those of a different point and returns the values as a new point
	 * 
	 * accsessor
	 * 
	 * @param apoint
	 * @return
	 */
	public Point add(Point apoint){
		return new Point(x+apoint.x,y+apoint.y);
	}
	/**
	 * mulitplies the x and y corrdennnts of the point by a scalor and passes them back to the user.
	 * accsessor
	 * @param multiplier
	 * @return
	 */
	public Point mult(double multiplier){
		return new Point((int)(x*multiplier),(int)(y*multiplier));
	}
	/**
	 * accsessor
	 */
	public String toString(){
		return "("+x+","+y+")";
	}
	/**
	 * accsessor
	 * @param p
	 * @return
	 */
	public boolean equals(Point p){
		if(x==p.x&&y==p.y)
			return true;
		else
			return false;
	}
}

