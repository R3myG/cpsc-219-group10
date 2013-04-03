package com.cpsc219g10.model.AI;

import javax.swing.JOptionPane;

import com.cpsc219g10.model.*;

public class AITurn extends turn {
	private AI comp;
	private int pnum = 0;
	private int opnum = 1;
	public AITurn(Player player){
		super(player,null);
		comp = new AI(player);
		p[1]=comp.getPlayer();
	}
	public Player getAI(){
		return p[1];
	}
	public boolean play(int i, int j) {
		/**
		 * Check that x and y are in the play box 
		 * If they are in the play field calculating the box they are in if so
		 */ 
		if(i < 1200 && i > 750 && j < 650 && j > 200) {
			int x = ((i - 700) / 45);
				char y = (char)(((j - 200) / 45) + (int)'a');
				//try an attack on the player at the square clicked
				if(JOptionPane.showConfirmDialog(null, "target square "+x+" , "+y, "move check", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
				//check if square is targetable
					if(p[pnum].canAttack(p[opnum], x, y)) {
						//attack square
						if(p[pnum].attack(p[opnum], x, y)) {
						}
						
						//check for  victory
						if(!p[opnum].hasBoat()) {
					    	idraw.won(p[pnum]);
					    	winner=p[pnum];
							return true;
						}
						comp.attack();
						if(!p[pnum].hasBoat()) {
					    	idraw.won(p[opnum]);
					    	winner=p[opnum];
							return true;
						}
						
						idraw.drawplyaterBoard(p[pnum],true);
						idraw.drawopponentBoard(p[pnum],p[opnum]);
					}
				}
				
			else {
				idraw.drawplyaterBoard(p[pnum],true);
				idraw.drawopponentBoard(p[pnum],p[opnum]);
			}
		}
		
		else {
		//refresh board on click outside of box
		idraw.drawplyaterBoard(p[pnum],true);
		idraw.drawopponentBoard(p[pnum],p[opnum]);
		}
		return false;
}
	public boolean place(int x1,int y1, int x2, int y2) {
		if(x1 < 500 && x1 > 50 && y1 < 650 && y1 > 200) {
			int x = ((x1) / 45);
			int y = ((y1 - 155) / 45);
			if(((x2) / 45) == x) {
				p[pnum].getBoat(bnum).setPosition(x, y, true);
				if(p[pnum].getBoard().addBoat(p[pnum].getBoat(bnum))){
					idraw.drawplyaterBoard(p[pnum],false);
					idraw.drawBoats(p[pnum], bnum);
					bnum++;
					return true;
				}
				}
			else if(y == (y2 - 155) / 45) {
				p[pnum].getBoat(bnum).setPosition(x, y, false);
				if(p[pnum].getBoard().addBoat(p[pnum].getBoat(bnum))){
					idraw.drawplyaterBoard(p[pnum],false);
					idraw.drawBoats(p[pnum],bnum);
					bnum++;
					return true;
				}
			}
			}
		else {
			idraw.drawplyaterBoard(p[pnum],false);
			if(bnum < 5)
				idraw.drawBoats(p[pnum],bnum);
		}
		return false;
	}
}
