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
	 * Converting name to someName so it can be used outside of this class
	 * Accessor or Mutator
	 * Pre-condition: 
	 * Post-condition: 
	 * @param someName
	 */
	public Boolean canAttack(Player opponent,int x,char y){
		if(opponent.gameBoard.getSquare(name, x, y) == 'O')
			return true;
		else
			return false;
	}
	
	/**
	 * Allows you to attack a player
	 * Accessor or Mutator
	 * Pre-condition: 
	 * Post-condition: 
	 * @param opponent
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean attack(Player opponent, int x, char y){
		if(opponent.gameBoard.targetSquare(x - 1, y)){
			for(int i = 0; i < 5; i++){
				opponent.getBoat(i).isMe(x, y);
			}
			return true;
		}
		return false;
	}
	
	/**
	 *
	 * Accessor or Mutator
	 * Pre-condition: 
	 * Post-condition: 
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
	 * 
	 * Accessor or Mutator
	 * Pre-condition: 
	 * Post-condition: 
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
	
	public String toString(){
		String msg = name + "\n\n";
		for(int i = 0; i < 5; i++){
			msg += boats[i] + "\n";
		}
		msg += gameBoard;
		return msg;
	}

	public boolean attack(Player opponent, int x, char y, String string) {
		if(opponent.gameBoard.targetSquare(x - 1, y)){
			for(int i = 0; i < 5; i++){
				opponent.getBoat(i).isMe(x, y,string);
			}
			return true;
		}
		return false;
	}
}
