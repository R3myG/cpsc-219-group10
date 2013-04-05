package com.cpsc219g10.model.AI;

import com.cpsc219g10.model.Board;
import com.cpsc219g10.model.Boat;

public class AIBoard extends Board {

	public AIBoard(String name) {
		super(name);
	}
	public void removeIfsunk(Boat boat){
		int vertical = 0, horizontal = 0;
		if(boat.vertical) {
			vertical = 1;
		} else {
			horizontal = 1;
		}
		if(boat.isSunk()){
		for(int i = 0; i < boat.length(); i++) {
			gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)]=missedSpace;

		}
		}
	}
	public void addSpace(int x, int y, char m){
		gameBoard[x-1][y-1]=m;
	}
}
