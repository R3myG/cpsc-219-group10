package com.cpsc219g10.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cpsc219g10.model.*;

public class GraphicsContoler extends MouseAdapter{
	protected turn game;
	protected draw idraw;
	protected boolean playing = true;
	

	protected boolean placing = true;
	protected boolean oneclick = false;
	private boolean blank = false;
	protected int lastclickX, lastclickY;
    public GraphicsContoler(draw aidraw, turn agame) {
    	idraw=aidraw;
    	game=agame;
	}
	public void mouseClicked(MouseEvent e) {
		if(playing){
	    	
	    	//play a round of the game
	    	if(e.getX() > 500 && e.getX() < 750 && e.getY() > 300 && e.getY() < 420) {
	    		game.refresh(placing);
	    		blank = false;
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
		if(e.getX() < 500 && e.getX() > 50 && e.getY() < 650 && e.getY() > 200 && !blank) {
    		if(oneclick) {
	    		game.refresh(placing);
	    		if(game.place(lastclickX, lastclickY, e.getX(), e.getY())) {
	    			blank = true;
	    			}
	    		oneclick = false;
	    		if(!game.allready()) {
	    			//initiate game count down
	    			idraw.black("BEGIN!");
	    			for(int i=3;i>=0;i--){
		    			try{Thread.sleep(1000); 
		    			} 
		    			catch(InterruptedException j) {
		    			}
		    			idraw.black(i+"");
	    			}

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
