package com.cpsc219g10.model;

public class Player {
	
	/**
	 * Instance variables
	 */
	private String name;
	public Boat[] boats = new Boat[5];
	public Board gameBoard;
	public int hp = 17;
	public Player(String Pname){
		for(int i = 0; i < 5; i++){
			boats[i] = new Boat(i,Pname);
		}
		gameBoard = new Board(Pname);
		name = Pname;
	}
	
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
	 * Determines whether or not the player you are attacking is able to be attacked
	 * Mutator
	 * Pre-condition: a player is created
	 * Post-condition: the player is attacked if it was a valid opponent
	 * @param someName
	 */
	public Boolean canAttack(Player opponent, int x, char y){
		if(opponent.gameBoard.getSquare(name, x, y) == 'O')
			return true;
		else
			return false;
	}
	
	/**
	 * Allows you to attack a player
	 * Accessor
	 * Pre-condition: an opponent has been declared
	 * Post-condition: an attack is initiated
	 * @param opponent
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean attack(Player opponent, int x, char y){
		if(opponent.gameBoard.targetSquare(x - 1, y)){
			for(int i = 0; i < 5; i++){
				opponent.getBoat(i).isMe(x, y,false);
			}
			return true;
		}
		return false;
	}
	/**
	 * Allows you to attack a player
	 * Accessor
	 * Pre-condition: an opponent has been declared
	 * Post-condition: an attack is initiated
	 * @param opponent
	 * @param x
	 * @param y
	 * @param string
	 * @return
	 */
	public boolean attack(Player opponent, int x, char y, String s){
		if(opponent.gameBoard.targetSquare(x - 1, y)){
			for(int i = 0; i < 5; i++){
				opponent.getBoat(i).isMe(x, y,true);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Determines if the player has a boat
	 * Accessor
	 * Pre-condition: boats were created
	 * Post-condition: determines if the player actually has boats remaining
	 * @return
	 */
	public boolean hasBoat(){
		boolean has = false;
		for(int i = 0; i < 5; i++){
			if(!boats[i].isSunk()){
				has = true;
			}
		}
		return has;
	}
	
	/**
	 * Allows 5 boats to be made
	 * Accessor
	 * Pre-condition: nothing
	 * Post-condition: 5 boats are made
	 * @return
	 */
	public int numberOfBoats() {
		int number = 0;
		for(int i = 0; i < 5; i++){
			if(!boats[i].isSunk()){
				number++;
			}
		}
		return number;
	}
	
	/**
	 * Returns to a string
	 */
	public String toString(){
		String msg = name + "\n\n";
		for(int i = 0; i < 5; i++){
			msg += boats[i] + "\n";
		}
		msg += gameBoard;
		return msg;
	}
}
