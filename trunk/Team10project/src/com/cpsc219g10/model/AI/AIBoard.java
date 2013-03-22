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
		for(int i = 0; i < boat.length(); i++) {
			if(gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)] == HitSpace){
				gameBoard[boat.x + (i * horizontal)][boat.y + (i * vertical)]=emptySpace;
			}
			
		}
	}
	public void addSpace(int x, int y, char m){
		gameBoard[x-1][y-1]=m;
	}
}
