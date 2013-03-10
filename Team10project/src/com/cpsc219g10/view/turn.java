/**
 * Class Description: 
 */
package com.cpsc219g10.view;
import javax.swing.JOptionPane;

import com.cpsc219g10.model.Player;

public class turn {
	//graphics from canvas and players
	
	private Player[] p = new Player[2];
	//current value's of player turns
	
	int pnum = 0;
	int opnum = 1;
	int bnum = 0;
	draw idraw;
	/**
	 * Sets up all of the variables for the game
	 * @param player
	 * @param opponent
	 * @param canvas
	 */
	public void set(Player player, Player opponent, draw adraw) {
		p[0] = player;
		p[1] = opponent;
		idraw = adraw;
	}
	/**
	 * plays a round if click was in playable area 
	 * @param i - x coordinates of click
	 * @param j - y coordinates of click
	 */
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
						System.out.println(p[pnum].getName() + "is targeting" + y + " " + x);
						if(p[pnum].attack(p[opnum], x, y)) {
							System.out.println("hit!!");
						}
						
						//check for  victory
						if(!p[opnum].hasBoat()) {
					    	idraw.won(p[pnum]);
							return true;
						}
						
						//switch players
						int hold = pnum;
						pnum = opnum;
						opnum = hold;
						
						//black out for turn change
						idraw.black();
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
	/**
	 * Method Description: Attempts to place the boats vertical and horizontal
	 * and will not allow the continuation of the game until
	 * each boat has been placed in a spot that is acceptable
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public boolean place(int x1,int y1, int x2, int y2) {
		if(x1 < 500 && x1 > 50 && y1 < 650 && y1 > 200) {
			int x = ((x1) / 45);
			int y = ((y1 - 155) / 45);
			System.out.println("position " + x + " " + y + " placing attempt");
			if(((x2) / 45) == x) {
				System.out.println("position " + x + " " + y + " placing vertical");

				p[pnum].getBoat(bnum).setPosition(x, y, true);
				if(p[pnum].getBoard().addBoat(p[pnum].getBoat(bnum))){
					idraw.drawplyaterBoard(p[pnum],false);
					idraw.drawBoats(p[pnum], bnum);
					try{Thread.sleep(1000);
					}
					catch(InterruptedException e) { 
					}
					int hold = pnum;
					pnum = opnum;
					opnum=hold;
					if(opnum == 1) {
						bnum++;
					}
					idraw.black();
					return true;
				}
				else{System.out.println("position " + x + " " + y + " placing failed");
				}
			}
			else if(y == (y2 - 155) / 45) {
				System.out.println("position " + x + " " + y + " placing horizontal");
				p[pnum].getBoat(bnum).setPosition(x, y, false);
				System.out.println(p[pnum].getBoat(bnum));

				if(p[pnum].getBoard().addBoat(p[pnum].getBoat(bnum))){
					idraw.drawplyaterBoard(p[pnum],false);
					idraw.drawBoats(p[pnum],bnum);
					try{Thread.sleep(1000);
					}
					catch(InterruptedException e) {
					}
					int hold = pnum;
					pnum = opnum;
					opnum = hold;
					if(opnum == 1) {
						bnum++;
					}
					idraw.black();
					return true;
				}
				else{System.out.println("position " + x + " " + y + " placing failed");
				}
			}
			else {
				System.out.println("position " + x + " " + y + " placing failed");
				}
			}
		else {
			idraw.drawplyaterBoard(p[pnum],false);
			if(bnum < 5)
				idraw.drawBoats(p[pnum],bnum);
		}
		return false;
	}
	public boolean allready() {
		if(bnum == 5)
			return false;
		else
			return true;
	}
	public void draw() {
		idraw.drawplyaterBoard(p[pnum],true);
		idraw.drawopponentBoard(p[pnum], p[opnum]);
	}
	public void refresh(boolean placing) {
		if(placing) {
			idraw.drawplyaterBoard(p[pnum],false);
			if(bnum < 5)
				idraw.drawBoats(p[pnum], bnum);
		}
		else{
			draw();
		}
	}
}