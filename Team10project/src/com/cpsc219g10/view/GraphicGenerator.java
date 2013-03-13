/**
 * Class Description: 
 */
package com.cpsc219g10.view;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.cpsc219g10.model.Player;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicGenerator {		
	
	//generate an instance of the turns
	public turn game = new turn();
	public Player winner = null;		
	boolean placing = true, oneclick = false, blank = false;
	int lastclickX, lastclickY;
	draw idraw;

/**
 * 	This runs the game generating players 
 */
	public void start(JPanel pan) {
		String namePlayerOne = JOptionPane.showInputDialog("Player one, please enter your name: ");
		String namePlayerTwo = JOptionPane.showInputDialog("Player two, please enter your name: ");
		Player[] p = {new Player(namePlayerOne), new Player(namePlayerTwo)};

		//set all basic variables
		try{Thread.sleep(1000); 
		} 
		catch(InterruptedException e) {
		}
		
		Graphics canvas = pan.getGraphics();
		
		idraw = new draw(canvas);
		
		//set game to have the aproptiate players and canvas
		game.set(p[0], p[1], idraw);
		
		//initiate the board
		idraw.drawplyaterBoard(p[0],false);
		idraw.drawBoats(p[0], 0);
		
		//add mouse listener. to get x and y coordenants of mosue position.
		pan.addMouseListener(new MouseAdapter() {  
		    public void mouseClicked(MouseEvent e) {
		    	if(winner==null){
			    	//output attack coordednets for debug
			    	System.out.println("click!@" + e.getX() + " " + e.getY());
			    	
			    	//play a round of the game
			    	if(e.getX() > 500 && e.getX() < 750 && e.getY() > 300 && e.getY() < 420) {
			    		game.refresh(placing);
			    		blank = false;
			    	}
			    	else if(placing) {
			    		 placing(e);
			    	}
			    	else
			    		game.play(e.getX(), e.getY());
		    	}
			}
		});
	}
	/**
	 * Method Description: 
	 * @param e:
	 */
	public void placing(MouseEvent e) {
		if(e.getX() < 500 && e.getX() > 50 && e.getY() < 650 && e.getY() > 200 && !blank) {
    		if(oneclick) {
	    		game.refresh(placing);
	    		if(game.place(lastclickX, lastclickY, e.getX(), e.getY())) {
	    			blank = true; System.out.println("blank is true");
	    			}
	    		oneclick = false;
	    		if(!game.allready()) {
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