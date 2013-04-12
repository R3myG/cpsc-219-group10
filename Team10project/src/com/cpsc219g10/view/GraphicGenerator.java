/**
 * Class Description: 
 */
package com.cpsc219g10.view;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.cpsc219g10.model.*;
import com.cpsc219g10.model.AI.AIGraphicsControler;
import com.cpsc219g10.model.AI.AITurn;

public class GraphicGenerator {		
	
	//generate an instance of the turns
	public turn game;
	Player[] p = new Player[2];
	public Player winner = null;		
	draw idraw;

/**
 * 	This runs the game generating players 
 */
	public void start(JPanel pan) {
		Object[] options = { "One Player", "Two Player" };
		int gameType=JOptionPane.showOptionDialog(null, "Please choose a Game Type", "Game Type",
				JOptionPane.DEFAULT_OPTION, 1,
				null, options, options[0]);
		Graphics canvas = pan.getGraphics();
		idraw = new draw(canvas);
		if(gameType==0){
			String name = JOptionPane.showInputDialog("Please enter your name: ");
			p[0]=new Player(name);
			game = new AITurn(p[0]);
			p[1]=game.getAI();
		}
		else{
		String namePlayerOne = JOptionPane.showInputDialog("Player one, please enter your name: ");
		String namePlayerTwo = JOptionPane.showInputDialog("Player two, please enter your name: ");
		p[0]=new Player(namePlayerOne);
		p[1]=new Player(namePlayerTwo);
		game = new turn(p[0], p[1]);
		//set all basic variables
		}
		game.set(idraw,winner);

		//set game to have the appropriate players and canvas

		//initiate the board
		idraw.drawplyaterBoard(p[0],false);
		idraw.drawBoats(p[0], 0);
		//add mouse listener. to get x and y coordinates of mouse position.
		if(gameType==0){
			pan.addMouseListener(new AIGraphicsControler(idraw,game));
		}
		else
			pan.addMouseListener(new GraphicsContoler(idraw,game));
	}
}