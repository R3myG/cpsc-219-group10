/**
 * Class Description: Creates the boards and places the boats
 * for each player
 */
package com.cpsc219g10.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.cpsc219g10.model.Player;

/**
 * Creating instance variables
 */
public class draw {
	private final char emptySpace = 'O';
	private final char boatSpace = 'B';
	private final char missedSpace = 'M';
	private final char HitSpace = 'X';
	private final Color black = new Color(0, 0, 0, 255);
	private final Color red = new Color(255, 0, 0, 255);
	private final Color green = new Color(0, 255, 0, 255);
	//private final Color blue = new Color(0, 0, 255, 255);
	private final Color white = new Color(255, 255, 255, 255);
	private final Color clear = new Color(0, 0, 0, 0);
	
	private final int YSHIFT = 200;
	private final int GRIDSIZE = 45;
	private final int XSHIFT = 50;
	private final int XSHIFT2 = GRIDSIZE * 10 + XSHIFT + 200;
	
	private Graphics canvas;
	private Image hit = null;
	private Image vert = null;
	private Image hor = null;
	private Image back = null;
	/**
	 * Draws the board to the canvas that the current player can view (his or her own board)
	 * @param canvas: canvas to be painted on
	 */
	public draw(Graphics acanvas){
		try 
		{
		hit = ImageIO.read(new File("pictures/HIT!.png"));
		vert = ImageIO.read(new File("pictures/VERTBOATS.png"));
		hor = ImageIO.read(new File("pictures/HORBOATS.png"));
		back = ImageIO.read(new File("pictures/back.png"));

		} 
		catch (IOException e) 
		{
			System.out.println("Failed");
		}
		canvas = acanvas;
	}
	
	/**
	 * Draws the board onto the canvas for a given player
	 * @param p: player whose turn it is
	 */
		public void drawplyaterBoard(Player p,boolean playing){
		canvas.clearRect(0, 0, 10000, 10000);
		canvas.setColor(black);
		canvas.setFont(new Font("sansserif", Font.BOLD, 32));
		canvas.drawString(p.getName(), 100, 100);
		canvas.drawImage(back, 0, 0, 1440,781, 0, 0, 1440,781, null );
		if(playing)
			drawBoats(p);
		for(int i = 1; i < 11; i++){
			for(char j = 'a'; j < 'k'; j++){
				int x = XSHIFT + (i-1) * GRIDSIZE + 2;
				int y = YSHIFT + ((int)j - 97) * GRIDSIZE + 2;
				switch(p.getBoard().getSquare(p.getName(), i, j)){
				case emptySpace:
					canvas.setColor(clear);
					break;
				case boatSpace:
					canvas.setColor(clear);
					break;
				case missedSpace:
					canvas.setColor(green);
					break;
				case HitSpace:
	
					canvas.setColor(clear);
					canvas.drawImage(hit, x - 2, y - 2, x + 45,y + 45 , 0, 0, 45, 45, null );
					break;
				}
				canvas.fillRect(x, y, GRIDSIZE - 4, GRIDSIZE - 4);
			}
		}
		//canvas.drawImage(back, 0, 0, 1440,781, 0, 0, 1440,781, null )
	}
		
	/**
	 * Draws the opponents canvas to the board (from the perspective of the enemy)
	 * (Includes: spaces not hit, missed spaces and empty spaces)
	 * @param p: player whos turn it is
	 * @param op: opponent of curent player
	 */
	public void drawopponentBoard(Player p, Player op){
		canvas.setColor(black);
		for(int i = 1;i < 11; i++){
			for(char j = 'a'; j < 'k'; j++){
				int x = 50 + (i-1) * GRIDSIZE + 2 + XSHIFT2;
				int y = YSHIFT + ((int)j - 97) * GRIDSIZE + 2;
				
				switch(op.getBoard().getSquare(p.getName(), i, j)){
				case emptySpace:
					canvas.setColor(clear);
					break;
				case missedSpace:
					canvas.setColor(white);
					break;
				case HitSpace:
					canvas.setColor(red);
					break;
				}
				canvas.fillRect(x,y,GRIDSIZE-4,GRIDSIZE-4);		
			}
		}		
	}
	
	/**
	 * Places the boats on the board for each player
	 * Blanks out screen for next players turn
	 * @param canvas
	 */
	public void drawBoats(Player p) {
		System.out.println("Drawboats!!!");
		for(int i = 0; i < 5; i++){	
			if(p.getBoat(i).x == -1 && p.getBoat(i).y == -1){
			}
			else{
				int x = p.getBoat(i).x * 45 + 50;
				int y = p.getBoat(i).y * 45 + 200;
				int l = p.getBoat(i).length() * 45;
				if(p.getBoat(i).vertical){
					canvas.drawImage(vert, x, y, x + 45, y + l, 45 * i, 0, 45 * (i + 1), l, null);
				}
				else{
					canvas.drawImage(hor, x, y, x + l, y + 45, 0, 45 * i, l, 45 * (i + 1), null);
				}
			}
		}
	}
	
	/**
	 * Draws the boars for each player
	 * @param p: player who's turn it is
	 * @param num
	 */
	public void drawBoats(Player p, int num) {
		System.out.println("drawboats to " + num);
		for(int i = 0; i < num + 1; i++) {	
			int l = p.getBoat(i).length() * 45;
			System.out.println(p.getBoat(i));
			if(p.getBoat(i).x == -1 && p.getBoat(i).y == -1) {
				canvas.drawImage(hor, 50, 150, 50 + l, 195, 0, 45 * i, l, 45 * (i + 1), null);
			}
			else {
				int x = p.getBoat(i).x * 45 + 50;
				int y = p.getBoat(i).y * 45 + 200;
				if(p.getBoat(i).vertical){
					canvas.drawImage(vert, x, y, x + 45, y + l, 45 * i, 0, 45 * (i + 1), l, null);
				}
				else{
					canvas.drawImage(hor, x, y, x + l, y + 45, 0, 45 * i, l, 45 * (i + 1), null);
				}
			}
		}
	}
	
	/**
	 * The screen for when the turns switch between players
	 */
	public void black() {
		canvas.setColor(black);		
		canvas.fillRect(0, 0, 10000, 10000);
		canvas.setColor(white);	
		canvas.fillRect(500, 250, 250, 120);
		canvas.setColor(black);		
		canvas.setFont(new Font("sansserif", Font.BOLD, 28));
		canvas.drawString("NEXT", 550, 300);
		canvas.drawString("PLAYER", 540, 340);

		
}
	/**
	 * Displays the winner on a green canvas
	 * @param winner: the person who has won
	 * @param canvas
	 */
	public void won(Player winner) {
		canvas.setColor(green);
		canvas.fillRect(0, 0, 10000, 10000);
		canvas.setColor(red);		
		canvas.setFont(new Font("sansserif", Font.BOLD, 32));
		canvas.drawString(winner.getName()+" wins!!",600,300);
		
	}
	/**
	 * Paints a square on the player board red for marking purposes.
	 * @param ax
	 * @param ay
	 */
	public void paintSquare(int ax, int ay) {
		if(ax < 500 && ax > 50 && ay < 650 && ay > 200) {
			int x = ((ax) / 45) - 1;
			int y = ((ay - 155) / 45) - 1;
			System.out.println(y + " " + x);
			x = x * GRIDSIZE + 2 + XSHIFT;
			y = YSHIFT + y * GRIDSIZE + 2;
			canvas.setColor(red);
			canvas.fillRect(x, y, GRIDSIZE - 4, GRIDSIZE - 4);
		}		
	}
}
