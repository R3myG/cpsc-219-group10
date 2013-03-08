package com.cpsc219g10.model;

import java.util.Random;

public class AI {
	//give AI a player
	Player ai = new Player("comp");
	// give AI an opponent
	Player opponent;
	// start point for boat search(last place searched around)
	Point start;
	//set up a board for ai to use for finding opponents boats
	AIBoard opBoard = new AIBoard("comp");
	// set up a moves repitour();
	Point[] moves = new Point[100];
	boolean[] hits = new boolean[100];
	//tells AI if its on to a boat	
	boolean foundBoat = false;
	//tells AI how many boats the opponent has
	int numberOfOpBoats = 5;
	//tells the AI the move its on
	int move = -1;
	//generator for random attack and attack around
	Random gen = new Random();
	/**
	 * basic constructor tells AI who to kill
	 * @param p - oppoent to AI
	 */
	public AI(Player p){
		opponent=p;
	}
	/**
	 * AI attack comand tells AI to attack oppoenent
	 */
	public void attack(){
			if(foundBoat)
				attackHit();
			else
				attackPossible();

	}
	/**
	 * finds a space on the opBoard that is marked as hit
	 */
	private void attackPossible() {
		boolean possible=false;
		for(int i=1;i<11;i++){
			for(char j='a';j<'k';j++){
				if(opBoard.getSquare("comp",i,j)=='H'){
					attackaround(new Point(i,(int)j-97));
					possible=true;
				}
			}
		}
		if(!possible){
			attackRandom();
		}
	}
	/**
	 * attacks around a designated point
	 * @param point - point to attack around
	 */
	private void attackaround(Point point) {
		int attack=gen.nextInt(4);
		boolean hit=false;
		do{
			switch(attack){
			case 0:
				if(attack(point.x()+1,point.y())){
					hit=true;
					break;
				}		
			case 1:
				if(attack(point.x()-1,point.y())){
					hit=true;
					break;
				}	
			case 2:
				if(attack(point.x(),point.y()+1)){
					hit=true;
					break;
				}	
			case 3:
				if(attack(point.x(),point.y()-1)){
					hit=true;
					break;
				}
				else{
					attack=0;
				}
			}
		}while(!hit);
	}
	/**
	 * attacks the opponents board at random
	 */
	private void attackRandom(){
		int x;
		char y;
		do{
		x=gen.nextInt(10)+1;
		y=(char)(gen.nextInt(10)+97);
		}while(ai.canAttack(opponent,x,y));
		
		move++;	
	
		hits[move]=ai.attack(opponent,x,y);
		moves[move]=new Point(x,(int)y-97);
	}
	/**
	 * attack opponents board that a boat is being found
	 */
	private void attackHit(){
		if(hits[move-1]&&hits[move]){
			attackInLine();
		}
		else if(hits[move-1]&&!hits[move]){
			attackFromStart();
		}
		else{
			attackAround();
		}
		
		
	}
	/**
	 * attack backwards from the start point to the most recent attack point
	 */
	private void attackFromStart() {
		if(start.x()<moves[move].x()){
			if(attack(start.x()+1,start.y()))
				return;
		}
		if(start.x()>moves[move].x()){
			if(attack(start.x()-1,start.y()))
				return;
			
		}
		if(start.y()<moves[move].y()){
			if(attack(start.x(),start.y()+1))
				return;
		}
		if(start.y()>moves[move].y()){
			if(attack(start.x(),start.y()-1))
				return;
		}
		else{
			attackPossible();
		}
	}
	/**
	 * attacks around the current hit point
	 */
	private void attackAround() {
		start=new Point(moves[move].x(),moves[move].y());
		int attack=gen.nextInt(4);
		boolean hit=false;
		do{
			switch(attack){
			case 0:
				if(attack(moves[move].x()+1,moves[move].y())){
					hit=true;
					break;
				}		
			case 1:
				if(attack(moves[move].x()-1,moves[move].y())){
					hit=true;
					break;
				}	
			case 2:
				if(attack(moves[move].x(),moves[move].y()+1)){
					hit=true;
					break;
				}	
			case 3:
				if(attack(moves[move].x(),moves[move].y()-1)){
					hit=true;
					break;
				}
				else{
					attack=0;
				}
			}
		}while(!hit);
	}
	/**
	 * attacks in-line with the last 2 attacks
	 */
	private void attackInLine() {
		if(moves[move-1].x()<moves[move].x()){
			if(attack(moves[move].x()+1,moves[move].y()))
				return;
		}
		if(moves[move-1].x()>moves[move].x()){
			if(attack(moves[move].x()-1,moves[move].y()))
				return;
			
		}
		if(moves[move-1].y()<moves[move].y()){
			if(attack(moves[move].x(),moves[move].y()+1))
				return;
		}
		if(moves[move-1].y()>moves[move].y()){
			if(attack(moves[move].x(),moves[move].y()-1))
				return;
		}
		
	}
	/**
	 * actual AI attack comand checks if the opponent can be attacked if it can then it attacks it at the dictated point
	 * if not it returns false(attack could not be completed generaly spot has already been attacked
	 * @param x - x corrdient for attack
	 * @param y - y corrdidnent for attacking
	 * @return whether or not the spot is legal to attack;
	 */
	private boolean attack(int x, int y) {
		if(ai.canAttack(opponent,x,(char)(y+97))){
			move++;	
			hits[move]=ai.attack(opponent,x,(char)(y+97));
			moves[move]=new Point(x,(int)y-97);
			if(hits[move]){
				foundBoat=true;
			}
			if(opponent.numberOfBoats()<numberOfOpBoats){
				for(int i=0;i<5;i++){
					opBoard.removeIfsunk(opponent.getBoat(i));
				}
				foundBoat=false;
				numberOfOpBoats=opponent.numberOfBoats();
			}
			return true;
		}
		return false;
	}
}
