package com.cpsc219g10.model;

public class Player {
	
	/**
	 * Instance variables
	 */
	private String name;

	/**
	 * Returning the name given to the player
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Converting name to someName
	 * so it can be used outside of this class
	 * @param someName
	 */
	public void setName(String someName) {
		name = someName;
		
	}
	public void attack(Player target, int x, int y){
		// Check board if hit
		// If miss, update board
		// If hit, update board
			// if sunk, display message
				// if gg, display message, quit
	}
}
