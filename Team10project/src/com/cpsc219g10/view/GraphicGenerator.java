/**
 * Class Description: 
 */
package com.cpsc219g10.view;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.cpsc219g10.model.Player;

public class GraphicGenerator {		
	
	//generate an instance of the turns
	public turn game = new turn();
	public Player winner = null;		
	draw idraw;

/**
 * 	This runs the game generating players 
 */
	public void start(JPanel pan) {
		String namePlayerOne = JOptionPane.showInputDialog("Player one, please enter your name: ");
		String namePlayerTwo = JOptionPane.showInputDialog("Player two, please enter your name: ");
		Player[] p = {new Player(namePlayerOne), new Player(namePlayerTwo)};
		//set all basic variables
		/*
		try{Thread.sleep(1000); 
		} 
		catch(InterruptedException e) {
		}
		*/
		
		Graphics canvas = pan.getGraphics();
		idraw = new draw(canvas);
		//set game to have the aproptiate players and canvas
		game.set(p[0], p[1], idraw,winner);
		
		//initiate the board
		idraw.drawplyaterBoard(p[0],false);
		idraw.drawBoats(p[0], 0);
		
		//add mouse listener. to get x and y coordenants of mosue position.
		pan.addMouseListener(new GraphicsContoler(idraw,game));
	}
}