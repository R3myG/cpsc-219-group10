package com.cpsc219g10.view;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GraphicGenerator {		
	//generate an instance of the turns
	public turn game = new turn();
	public Player winner=null;		
	boolean placing=true, oneclick=false;
	int lastclickX, lastclickY;
	draw idraw;

/**
 * 	this runs the game generating players 
 */
	public void start(JPanel pan1){
		Player[] p=new Player[2];
		p[0]=new Player("Gavin");
		p[1]=new Player("Claire");
		Random gen = new Random();
		//set boat positoins randomly.
		/*
		  for(int pn=0;pn<2;pn++){
			for(int i=0;i<5;i++){
				do{
					p[pn].b[i].setPosition(gen.nextInt(10)+1,gen.nextInt(10)+1,gen.nextBoolean());
					System.out.println(p[pn].b[i]);
				}while(!p[pn].gb.addBoat(p[pn].b[i]));
			}
			System.out.println(p[pn].gb);
		}*/
		//set up the playing surface on a jframe
		//set up the playing surface to be a jpanel on top of the jframe

		//set all basic variables



		try{Thread.sleep(1000);}catch(InterruptedException e){}
		Graphics canvas = pan1.getGraphics();
		System.out.println(pan1.getHeight()+" "+pan1.getWidth());
		idraw=new draw(canvas);
		//set game to have the aproptiate players and canvas
		game.set(p[0],p[1],idraw);
		//initiate the board
		idraw.drawplyaterBoard(p[0]);
		idraw.drawBoats(p[0],0);
		//add mouse listener. to get x and y coordenants of mosue position.
		pan1.addKeyListener( new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
						game.refresh(placing);
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		pan1.addMouseListener(new MouseAdapter(){  
		    public void mouseClicked(MouseEvent e){
		    	//output attack coordednets for debug
		    	System.out.println("click!@"+e.getX()+" "+e.getY());
		    	//play a round of the game
		    	if(placing){
		    		if(oneclick){
			    		game.place(lastclickX,lastclickY,e.getX(),e.getY());
			    		oneclick=false;
			    		if(!game.allready()){
			    			placing=false;
			    			game.draw();
			    		}
		    		}
		    		else{
		    			lastclickX=e.getX();
		    			lastclickY=e.getY();
		    			oneclick=true;
		    		}
		    	}
		    	else
		    		game.play(e.getX(),e.getY());
		    	}
			}
		 );
    }
}

