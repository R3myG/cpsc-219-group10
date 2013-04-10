package com.cpsc219g10.model.Test;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cpsc219g10.model.*;
import com.cpsc219g10.view.*;

public class TestAll {
	public static void main(String[] args){
		boolean passed = true;
		// Boats
		Boat[] boats= new Boat[5];
		try{
			for(int i=0;i<5;i++){
				boats[i] =  new Boat(i,"owner");
				boats[i].setPosition(i+1,i+1,true);
			}
		}catch(ArrayIndexOutOfBoundsException aob){
			passed=false;
			System.out.println("Boats index out of bounds");
		}
		try{
			new Boat(5,"owner");
			passed=false;
			System.out.println("Boats index out of bounds");
		}catch(ArrayIndexOutOfBoundsException aob){
		}
		if(!boats[0].isMe(0,'a',true) || boats[0].isMe(0,'b',true)){
			passed=false;
			System.out.println("Boats isMe Failed.");
		}
		if(boats[0].isSunk()){
			passed=false;
			System.out.println("Boats isSunk Failed.");
		}
		//Board
		Board gb = new Board("owner");
		try{
		for(int i=0;i<5;i++){
			gb.addBoat(boats[i]);
		}
		}catch(ArrayIndexOutOfBoundsException aob){
			passed=false;
			System.out.println("Failed to place Boats");
		}
		if(gb.getSquare("owner",0,'a')!='B' ||
		   gb.getSquare("owner",1,'a')!='E' ||
		   gb.getSquare("owner",1,'b')!='B' ||
		   gb.getSquare("owner",3,'e')!='B' ||
		   gb.getSquare("owner",9,'a')!='E'){
			passed=false;
			System.out.println("boat Placements do not match");
		}
		for(int i=0;i<9;i++){
			gb.targetSquare(i,(char)(i+'a'));
		}
		if(gb.getSquare("owner",0,'a')!='H' ||
		   gb.getSquare("owner",1,'b')!='H' ||
		   gb.getSquare("owner",2,'c')!='H' ||
		   gb.getSquare("owner",5,'g')!='M' ||
		   gb.getSquare("owner",6,'h')!='M'){
				passed=false;
				System.out.println("board targeting do not match");
		}
		//player
		if(!PlayerTest.main()){
			passed=false;
			System.out.println("Player Failed");	
		}
		//turn draw
		Player p1,p2, winner=null;
		p1= new Player("P1");
		p2= new Player("P2");
		JFrame frame= new JFrame();
		JPanel pan = new JPanel();
		frame.setSize(new Dimension(1400,800));
		frame.add(pan);
		frame.setVisible(true);
		draw draw = new draw(pan.getGraphics());
		turn turn = new turn(p1,p2);
		turn.set(draw,winner);
		turn.place(1,1,2,1);
		turn.place(2,2,3,2);
		turn.place(3,3,4,3);
		turn.place(4,4,5,4);
		turn.place(5,5,6,5);
		turn.play(1,1);


		
	}
}
