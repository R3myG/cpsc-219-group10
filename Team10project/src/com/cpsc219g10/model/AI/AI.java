package com.cpsc219g10.model.AI;
import java.util.Random;

import javax.swing.JOptionPane;

import com.cpsc219g10.model.Player;
import com.cpsc219g10.model.Point;

public class AI {
	//give AI a player
	Player ai = new Player("Computer");
	// give AI an opponent
	Player opponent;
	// start point for boat search(last place searched around)
	Point start;
	//set up a board for ai to use for finding opponents boats
	AIBoard opBoard = new AIBoard("Computer");
	// set up a moves repitour();
	Point[] moves = new Point[100];
	boolean[] hits = new boolean[100];
	int[] moveTypes = new int[100];
	//tells AI if its on to a boat	
	boolean foundBoat = false;
	//tells AI how many boats the opponent has
	int numberOfOpBoats = 5;
	//tells the AI the move its on
	int move = -1;
	int numberOfAttempts=0;
	private Convert con;
	private int hitListCount = 0;

	private final int ATTACKRANDOM = 0;
	private final int ATTACKPOSSIBLES = 1;
	private final int ATTACKAROUND = 2;
	private final int ATTACKINLINE = 3;
	private final int ATTACKFROMSTART = 4;



	//generator for random attack and attack around
	Random gen = new Random();
	/**
	 * basic constructor tells AI who to kill
	 * @param p - oppoent to AI
	 */
	public AI(Player p){
		opponent = p;
		setBoard();
		con = new Convert();
		con.rotate(gen.nextInt(3));
	}
	public AI(Player p,String File){
		opponent = p;
		setBoard();
		con = new Convert(File);
		con.rotate(gen.nextInt(3));
	}
	public Player getAI(){
		return ai;
	}
	private boolean attackFromList(){
		boolean can =false;
		do{
		if(hitListCount>=con.length())
			return false;
		can=attack(con.moves(hitListCount,0),con.moves(hitListCount,1),0);
		hitListCount++;
		}while(!can);
		return true;
	}
	private boolean shoudlAttack(int i,char j){
		if(opBoard.getSquare("Computer",i+1,j)=='E' ||
		   opBoard.getSquare("Computer",i-1,j)=='E' ||
		   opBoard.getSquare("Computer",i,(char)(j+1))=='E' ||
		   opBoard.getSquare("Computer",i,(char)(j-1))=='E'){
		return true;	
		}
		
		return false;
	}
	private void setBoard() {
		for(int i=0;i<5;i++){
			do{
			ai.getBoat(i).setPosition(gen.nextInt(10)+1, (char)(gen.nextInt(10)+1), gen.nextBoolean());
			}while(!ai.getBoard().addBoat(ai.getBoat(i)));
		}
	}
	/**
	 * AI attack comand tells AI to attack oppoenent
	 */
	public void attack(){
		if(foundBoat){
			attackHit();
			}
		else{
			attackPossible();
		}
	}
	/**
	 * finds a space on the opBoard that is marked as hit
	 */
	private void attackPossible() {
		boolean possible = false;
		for(int i = 1; i < 11; i++){
			for(char j = 'a'; j < 'k'; j++){
				if(opBoard.getSquare("Computer", i, j) == 'H'){
					attackaround(new Point(i, (int)j - 97));
					possible = true;
					return;
				}
			}
		}
			attackRandom();
	}
	/**
	 * attacks around a designated point
	 * @param point - point to attack around
	 */
	private void attackaround(Point point) {
		start=point;
		int attack = gen.nextInt(4);
		boolean hit = false;
		do{
			switch(attack){
			case 0:
				if(attack(point.x() + 1, point.y(),ATTACKAROUND)){
					hit = true;
					break;
				}		
			case 1:
				if(attack(point.x() - 1, point.y(),ATTACKAROUND)){
					hit = true;
					break;
				}	
			case 2:
				if(attack(point.x(), point.y() + 1,ATTACKAROUND)){
					hit = true;
					break;
				}	
			case 3:
				if(attack(point.x(), point.y() - 1,ATTACKAROUND)){
					hit = true;
					break;
				}
				else{
					attack = 0;
				}
			}
		}while(!hit);
	}
	/**
	 * attacks the opponents board at random
	 */
	private void attackRandom(){
		numberOfAttempts=0;
		if(!attackFromList()){
			int x;
			char y;
			do{
			x = gen.nextInt(10) + 1;
			y = (char)(gen.nextInt(10) + 97);
			}while(!ai.canAttack(opponent, x, y)&&!shoudlAttack(x, y));
			//JOptionPane.showMessageDialog(null, "the computer attacks square "+x+" , "+y, "AI move",JOptionPane.INFORMATION_MESSAGE);
			move++;	
		
			hits[move] = ai.attack(opponent, x, y,"");
			moves[move] = new Point(x, (int)y - 97);
			moveTypes[move] = 0;
			if(hits[move]){
				opBoard.addSpace(x,(int)y - 96,'H');
				foundBoat = true;
			}
			else{
				opBoard.addSpace(x,(int)y - 96,'M');
			}
		}
	}
	/**
	 * attack opponents board that a boat is being found
	 */
	private void attackHit(){
		if(move<1){
			attackAround();
		}
		else{
		if(moveTypes[move]==ATTACKRANDOM){
			attackAround();
		}
		else if(moveTypes[move]==ATTACKAROUND){
			if(hits[move]){
				attackInLine(start,moves[move]);
			}
			else{
				attackaround(start);
			}
		}
		else if(moveTypes[move]==ATTACKINLINE){
			if(hits[move]){
				attackInLine(start,moves[move]);
			}
			else{
				attackFromStart();
			}
		}
		else if(moveTypes[move]==ATTACKFROMSTART){
			if(hits[move]){
				attackInLine(start,moves[move]);
			}
			else{
				attackaround(start);
			}
		}
		}
		
		
	}
	private void attackInLine(Point point1, Point point2) {
		if(point1.x() < point2.x()){
			if(attack(point2.x() + 1, point2.y(),ATTACKINLINE)){
				return;}
		}
		if(point1.x()>point2.x()){
			if(attack(point2.x()-1,point2.y(),ATTACKINLINE)){
				return;
				}
			
		}
		if(point1.y()<point2.y()){
			if(attack(point2.x(),point2.y()+1,ATTACKINLINE)){
				return;
			}
		}
		if(point1.y()>point2.y()){
			if(attack(point2.x(),point2.y()-1,ATTACKINLINE)){
				return;
			}
		}
		attackFromStart();
	}
	/**
	 * attack backwards from the start point to the most recent attack point
	 */
	private void attackFromStart() {
		if(start.x() < moves[move].x()){
			if(attack(start.x() - 1, start.y(),ATTACKFROMSTART))
				return;
		}
		if(start.x() > moves[move].x()){
			if(attack(start.x() + 1, start.y(),ATTACKFROMSTART))
				return;
			
		}
		if(start.y() < moves[move].y()){
			if(attack(start.x(), start.y() - 1,ATTACKFROMSTART))
				return;
		}
		if(start.y() > moves[move].y()){
			if(attack(start.x(), start.y() + 1,ATTACKFROMSTART))
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
		start = new Point(moves[move].x(), moves[move].y());
		int attack = gen.nextInt(4);
		boolean hit = false;
		do{
			switch(attack){
			case 0:
				if(attack(moves[move].x() + 1, moves[move].y(),ATTACKAROUND)){
					hit = true;
					break;
				}		
			case 1:
				if(attack(moves[move].x()-1,moves[move].y(),ATTACKAROUND)){
					hit = true;

					break;
				}	
			case 2:
				if(attack(moves[move].x(),moves[move].y()+1,ATTACKAROUND)){
					hit = true;
					break;
				}	
			case 3:
				if(attack(moves[move].x(),moves[move].y()-1,ATTACKAROUND)){
					hit = true;
					break;
				}
				else{
					attack = 0;
				}
			}
		}while(!hit);
	}
	/**
	 * attacks in-line with the last 2 attacks
	 */
	private void attackInLine() {
		System.out.println("attackInLine");
		if(moves[move - 1].x() < moves[move].x()){
			if(attack(moves[move].x() + 1, moves[move].y(),ATTACKINLINE))
				{return;}
		}
		if(moves[move-1].x()>moves[move].x()){
			if(attack(moves[move].x()-1,moves[move].y(),ATTACKINLINE)){
				return;
				}
			
		}
		if(moves[move-1].y()<moves[move].y()){
			if(attack(moves[move].x(),moves[move].y()+1,ATTACKINLINE)){
				return;
			}
		}
		if(moves[move-1].y()>moves[move].y()){
			if(attack(moves[move].x(),moves[move].y()-1,ATTACKINLINE)){
				return;
			}
		}
		
	}
	/**
	 * actual AI attack comand checks if the opponent can be attacked if it can then it attacks it at the dictated point
	 * if not it returns false(attack could not completed generaly spot has already been attacked
	 * @param x - x corrdient for attack
	 * @param y - y corrdidnent for attacking
	 * @return whether or not the spot is legal to attack;
	 */
	private boolean attack(int x, int y, int type) {
		numberOfAttempts++;
		if(numberOfAttempts>5){
			attackRandom();
			return true;
		}
		if(x > 0 && y >= 0 && x<11 && y<10){
			if(ai.canAttack(opponent, x, (char)(y + 'a'))){
				//JOptionPane.showMessageDialog(null, "the computer attacks square "+x+" , "+y, "AI move",JOptionPane.INFORMATION_MESSAGE);
				numberOfAttempts=0;
				move++;	
				hits[move] = ai.attack(opponent, x, (char)(y + 97),"");
				moves[move] = new Point(x, y);
				moveTypes[move] = type;
				if(hits[move]){
					opBoard.addSpace(x,y+1,'H');
					foundBoat = true;
				}
				else{
					opBoard.addSpace(x,y+1,'M');
				}
				if(opponent.numberOfBoats() < numberOfOpBoats){
					for(int i = 0; i < 5; i++){
						opBoard.removeIfsunk(opponent.getBoat(i));
					}
					foundBoat = false;
					numberOfOpBoats=opponent.numberOfBoats();
				}
				return true;
			}
		}
		return false;
	}
	public Player getPlayer() {
		return ai;
	}
}
