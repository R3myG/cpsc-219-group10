package com.cpsc219g10.model;


public class Player {
	
	/**
	 * Instance variables
	 */
	private String name;
	public Boat[] boats= new Boat[5];
	public Board gameBoard;
	public Player(String Pname){
		for(int i=0;i<5;i++){
			boats[i]=new Boat(i,Pname);
		}
		gameBoard=new Board(Pname);
		name=Pname;
	}
	/**
	 * Returning the name given to the player
	 * @return
	 */
	public String getName() {
		return name;
	}
	public Boat getBoat(int i) {
		return boats[i];
	}
	public Board getBoard() {
		return gameBoard;
	}
	/**
	 * Converting name to someName
	 * so it can be used outside of this class
	 * @param someName
	 */
	public void setName(String someName) {
		name = someName;
		
	}
	public boolean attack(Player target, int x, int y){
		// Check board if hit
		// If miss, update board
		// If hit, update board
			// if sunk, display message
				// if gg, display message, quit
		return false;
	}
	public boolean canAttack(Player player, int x, char y) {
		// TODO Auto-generated method stub
		return false;
	}
}
