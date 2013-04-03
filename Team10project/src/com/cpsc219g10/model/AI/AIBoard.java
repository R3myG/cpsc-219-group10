package com.cpsc219g10.model.AI;

import com.cpsc219g10.model.Board;
import com.cpsc219g10.model.Boat;

public class AIBoard extends Board {

	public AIBoard(String name) {
		super(name);
	}
	public void removeIfsunk(Boat boat){
		System.out.println("called");
		int vertical = 0, horizontal = 0;
		if(boat.vertical) {
			vertical = 1;
		} else {
			horizontal = 1;
		}
		if(boat.isSunk()){
		for(int i = 0; i < boat.length(); i++) {
			System.out.println(boat);
			gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)]=emptySpace;
			System.out.println((boat.x + (i * horizontal))+" "+(boat.y + (i * vertical)));

		}
		}
	}
	public void addSpace(int x, int y, char m){
		gameBoard[x-1][y-1]=m;
	}
}
