package com.cpsc219g10.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import com.cpsc219g10.model.*;
import javax.imageio.ImageIO;


public class draw {
	private final char emptySpace = 'O';
	private final char boatSpace = 'B';
	private final char missedSpace = 'M';
	private final char HitSpace = 'X';
	private final Color black=new Color(0,0,0,255);
	private final Color red=new Color(255,0,0,255);
	private final Color green=new Color(0,255,0,255);
	private final Color blue=new Color(0,0,255,255);
	private final Color white=new Color(255,255,255,255);
	private final Color clear=new Color(0,0,0,0);
	
	
	private final int YSHIFT=200;
	private final int GRIDSIZE=45;
	private final int XSHIFT=50;
	private final int XSHIFT2=GRIDSIZE*10+XSHIFT+200;
	
	private Graphics canvas;
	private Image hit = null;
	private Image vert =null;
	private Image hor = null;
	private Image back =null;
	/**
	 * draws to canvas the board the current player can veiw(his or her own board)
	 * @param canvas- canvas to be painted on
	 * @param p - player whose turn it is
	 */
	public draw(Graphics acanvas){
		try 
		{
		hit = ImageIO.read(new File("pictures/HIT!.png"));
		vert = ImageIO.read(new File("pictures/VERTBOATS.png"));
		hor = ImageIO.read(new File("pictures/ORBOATS.png"));
		back = ImageIO.read(new File("pictures/back.png"));

		} 
		catch (IOException e) 
		{
			System.out.println("Failed");
		}
		canvas=acanvas;
	}
		public void drawplyaterBoard(Player p){
		canvas.clearRect(0,0,10000,10000);
		canvas.setColor(black);
		canvas.setFont(new Font("sansserif", Font.BOLD, 32));
		canvas.drawString(p.getName(),100,100);
		for(int i=0;i<GRIDSIZE*11;i+=GRIDSIZE){
			canvas.drawLine(XSHIFT,i+YSHIFT,GRIDSIZE*10+XSHIFT,i+YSHIFT);
			canvas.drawLine(i+XSHIFT,YSHIFT,i+XSHIFT,GRIDSIZE*10+YSHIFT);

		}
		int point=1;
		for(int i=0;i<GRIDSIZE*10;i+=GRIDSIZE){
			canvas.setFont(new Font("sansserif", Font.BOLD, 32));
			canvas.drawString(Integer.toString(point), i+XSHIFT,YSHIFT-10);
			canvas.drawString(Character.toString((char)(point+64)), 20,i+YSHIFT+30);
			point++;
		}
		drawBoats(p);
		for(int i=0;i<10;i++){
			for(char j='a';j<'k';j++){
				int x=XSHIFT+i*GRIDSIZE+2;
				int y=YSHIFT+((int)j-97)*GRIDSIZE+2;
				
				switch(p.getBoard().getSquare(p.getName(),i,j)){
				case emptySpace:
					canvas.setColor(blue);
					break;
				case boatSpace:
					canvas.setColor(clear);
					break;
				case missedSpace:
					canvas.setColor(green);
					break;
				case HitSpace:
	
					canvas.setColor(clear);
					canvas.drawImage(hit, x-2, y-2, x+45,y+45 , 0, 0, 45, 45, null );

					break;
				}
				canvas.fillRect(x,y,GRIDSIZE-4,GRIDSIZE-4);

				
			}
		}
		canvas.drawImage(back, 0, 0, 1440,781, 0, 0, 1440,781, null );

	}
	/**
	 * draws to the canvas the view the player can see of his opponents board.(includes:un hit spaces, missed spaces and empty spaces)
	 * @param canvas - canvas that is to be painted on
	 * @param p - player whos turn it is
	 * @param op - opponent of curent player
	 */
	public void drawopponentBoard(Player p,Player op){
		canvas.setColor(black);
		for(int i=0;i<GRIDSIZE*11;i+=GRIDSIZE){
			canvas.drawLine(50+XSHIFT2,i+YSHIFT,GRIDSIZE*10+50+XSHIFT2,i+YSHIFT);
			canvas.drawLine(i+50+XSHIFT2,YSHIFT,i+50+XSHIFT2,GRIDSIZE*10+YSHIFT);

		}
		int point=1;
		for(int i=0;i<GRIDSIZE*10;i+=GRIDSIZE){
			canvas.drawString(Integer.toString(point), i+50+XSHIFT2,YSHIFT-10);
			canvas.drawString(Character.toString((char)(point+64)), 20+XSHIFT2,i+YSHIFT+30);
			point++;
		}
		for(int i=0;i<10;i++){
			for(char j='a';j<'k';j++){
				int x=50+i*GRIDSIZE+2+XSHIFT2;
				int y=YSHIFT+((int)j-97)*GRIDSIZE+2;
				
				switch(op.getBoard().getSquare(p.getName(),i,j)){
				case emptySpace:
					canvas.setColor(blue);
					break;
				case boatSpace:
					canvas.setColor(green);
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
	 * blanks out screen for next players turn
	 * @param canvas
	 */
	public void drawBoats(Player p){
		for(int i=0;i<5;i++){	
			if(p.getBoat(i).x==-1&&p.getBoat(i).y==-1){
			}
			else{
				int x=p.getBoat(i).x*45+50;
				int y = p.getBoat(i).y*45+200;
				int l = p.getBoat(i).length()*45;
				if(p.getBoat(i).vertical){
					canvas.drawImage(vert, x, y, x+45,y+l , 45*i, 0, 45*(i+1), l, null );
				}
				else{
					canvas.drawImage(hor, x, y, x+l,y+45 , 0, 45*i, l, 45*(i+1), null );
				}
			}
			
		}
	}
	public void drawBoats(Player p,int num){
		for(int i=0;i<num+1;i++){	
			int l = p.getBoat(i).length()*45;
			System.out.println(p.getBoat(i));
			if(p.getBoat(i).x==-1&&p.getBoat(i).y==-1){
				canvas.drawImage(hor, 50, 150, 50+l,195 , 0, 45*i, l, 45*(i+1), null );
			}
			else{
				int x=p.getBoat(i).x*45+50;
				int y = p.getBoat(i).y*45+200;
				if(p.getBoat(i).vertical){
					canvas.drawImage(vert, x, y, x+45,y+l , 45*i, 0, 45*(i+1), l, null );
				}
				else{
					canvas.drawImage(hor, x, y, x+l,y+45 , 0, 45*i, l, 45*(i+1), null );
				}
			}
			
		}
	}
	public void black() {
		canvas.setColor(black);		
		canvas.fillRect(0,0,10000,10000);
		canvas.setColor(white);	
		canvas.setFont(new Font("sansserif", Font.BOLD, 32));
		canvas.drawString("NEXT PLAYER",600,300);
	}
	/**
	 * displays the winner on a green canvas
	 * @param winner - the person who has won
	 * @param canvas
	 */
	public void won(Player winner) {
		canvas.setColor(green);
		canvas.fillRect(0,0,10000,10000);
		canvas.setColor(red);		
		canvas.setFont(new Font("sansserif", Font.BOLD, 32));
		canvas.drawString(winner.getName()+" wins!!",600,300);
		
	}
}
