package com.cpsc219g10.model.AI;

import java.awt.event.MouseEvent;

import com.cpsc219g10.model.turn;
import com.cpsc219g10.view.*;

public class AIGraphicsControler extends GraphicsContoler {

	public AIGraphicsControler(draw aidraw, turn agame) {
		super(aidraw, agame);
	}
	public void mouseClicked(MouseEvent e) {
		if(playing){
	    	//output attack coordednets for debug	    	
	    	//play a round of the game
	    	if(e.getX() > 500 && e.getX() < 750 && e.getY() > 300 && e.getY() < 420) {
	    		game.refresh(placing);
	    	}
	    	else if(placing) {
	    		 placing(e);
	    	}
	    	else
	    		if(game.play(e.getX(), e.getY())){
	    			playing = false;
	    			try{Thread.sleep(5000); 
	    			} 
	    			catch(InterruptedException j) {
	    			}
	    			/*
	    			 * LAUNCH MAIN PANNEL
	    			 */
	    		}
		}
	}
	public void placing(MouseEvent e) {
		if(e.getX() < 500 && e.getX() > 50 && e.getY() < 650 && e.getY() > 200 ) {
    		if(oneclick) {
	    		game.refresh(placing);
	    		if(game.place(lastclickX, lastclickY, e.getX(), e.getY())) {
	    			}
	    		oneclick = false;
	    		if(!game.allready()) {
	    			//initiate game count down
	    			placing = false;
	    			game.draw();
	    		}
    		}
    		else{
    			lastclickX = e.getX();
    			lastclickY = e.getY();
    			oneclick = true;
    			idraw.paintSquare(e.getX(), e.getY());
    		}
		}
	}
}
