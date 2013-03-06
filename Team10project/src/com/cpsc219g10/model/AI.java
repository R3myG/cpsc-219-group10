package com.cpsc219g10.model;

import java.util.Random;

public class AI {
	Player ai = new Player("comp");
	Player opponent;
	Point[] moves = new Point[100];
	boolean[] hits = new boolean[100];
	boolean first = true;
	int move = -1;
	Random gen = new Random();
	public AI(Player p){
		opponent=p;
	}
	public void attack(){
		if(!first){
			if(hits[move])
				attackHit();
			else
				attackRandom();
		}
		else
			attackRandom();
	}
	private void attackRandom(){
		int x;
		char y;
		do{
		x=gen.nextInt(10);
		y=(char)(gen.nextInt(10)+97);
		}while(ai.canAttack(opponent,x,y));
		
		move++;	
	
		hits[move]=ai.attack(opponent,x,y);
		moves[move]=new Point(x,(int)y-97);
	}
	private void attackHit(){
		if(hits[move-1]){
			attackInLine();
		}
		else
			attackAround();
	}
	private void attackAround() {
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
	private boolean attack(int x, int y) {
		if(ai.canAttack(opponent,x,(char)(y+97))){
			move++;	
			hits[move]=ai.attack(opponent,x,(char)(y+97));
			moves[move]=new Point(x,(int)y-97);
			
			return true;
		}
		return false;
	}
}
