package com.cpsc219g10.model.Lan;

import javax.swing.JOptionPane;

import com.cpsc219g10.model.*;
public class OnlineTurn extends turn {
	private int server = 0;
	private int local = 1;
	private boolean ServerTurn=true;
	private server comunicate;
	public OnlineTurn(Player[] player, server acomunicate){
		super(player[0],player[1]);
		comunicate=acomunicate;
	}
	public boolean play(int i, int j) {
		/**
		 * Check that x and y are in the play box 
		 * If they are in the play field calculating the box they are in if so
		 */ 
		if(ServerTurn){
			if(i < 1200 && i > 750 && j < 650 && j > 200) {
				int x = ((i - 700) / 45);
					char y = (char)(((j - 200) / 45) + (int)'a');
					//try an attack on the player at the square clicked
					if(JOptionPane.showConfirmDialog(null, "target square "+x+" , "+y, "move check", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
					//check if square is targetable
						if(p[server].canAttack(p[local], x, y)) {
							//attack square
							if(p[server].attack(p[local], x, y)) {
							}
							//check for  victory
							if(!p[local].hasBoat()) {
						    	idraw.won(p[server]);
						    	winner=p[server];
								return true;
							}
							else {
								ServerTurn=false;
								comunicate.waitForAttack(p[server],p[local]);
							}
							if(!p[server].hasBoat()) {
						    	idraw.won(p[local]);
						    	winner=p[local];
								return true;
							}
							idraw.drawplyaterBoard(p[server],true);
							idraw.drawopponentBoard(p[server],p[local]);
						}
					}
					
				else {
					idraw.drawplyaterBoard(p[server],true);
					idraw.drawopponentBoard(p[server],p[local]);
				}
			}
		}
		
		else {
		//refresh board on click outside of box
		idraw.drawplyaterBoard(p[server],true);
		idraw.drawopponentBoard(p[server],p[local]);
		}
		return false;
}
	public boolean place(int x1,int y1, int x2, int y2) {
		if(x1 < 500 && x1 > 50 && y1 < 650 && y1 > 200) {
			int x = ((x1) / 45);
			int y = ((y1 - 155) / 45);
			if(((x2) / 45) == x) {
				p[server].getBoat(bnum).setPosition(x, y, true);
				if(p[server].getBoard().addBoat(p[server].getBoat(bnum))){
					idraw.drawplyaterBoard(p[server],false);
					idraw.drawBoats(p[server], bnum);
					bnum++;
					return true;
				}
				}
			else if(y == (y2 - 155) / 45) {
				p[server].getBoat(bnum).setPosition(x, y, false);
				if(p[server].getBoard().addBoat(p[server].getBoat(bnum))){
					idraw.drawplyaterBoard(p[server],false);
					idraw.drawBoats(p[server],bnum);
					bnum++;
					return true;
				}
			}
			}
		else {
			idraw.drawplyaterBoard(p[server],false);
			if(bnum < 5)
				idraw.drawBoats(p[server],bnum);
		}
		return false;
	}
}
