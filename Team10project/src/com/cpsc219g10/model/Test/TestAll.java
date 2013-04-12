package com.cpsc219g10.model.Test;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.cpsc219g10.model.*;
import com.cpsc219g10.model.AI.AI;
import com.cpsc219g10.model.AI.Convert;
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
			System.out.println("\nBoats index out of bounds");
		}
		try{
			new Boat(5,"owner");
			passed=false;
			System.out.println("\nBoats index out of bounds");
		}catch(ArrayIndexOutOfBoundsException aob){
		}
		if(!boats[0].isMe(1,'a',true,false) || boats[0].isMe(2,'a',true,false)){
			passed=false;
			System.out.println("\nBoats isMe Failed.");
		}
		if(boats[0].isSunk()){
			passed=false;
			System.out.println("\nBoats isSunk Failed.");
		}
		//Board
		Board gb = new Board("owner");
		try{
		for(int i=0;i<5;i++){
			gb.addBoat(boats[i]);
		}
		}catch(ArrayIndexOutOfBoundsException aob){
			passed=false;
			System.out.println("\nFailed to place Boats");
		}
		if(gb.getSquare("owner",0,'a')!='O' ||
		   gb.getSquare("owner",1,'a')!='B' ||
		   gb.getSquare("owner",1,'b')!='B' ||
		   gb.getSquare("owner",3,'e')!='B' ||
		   gb.getSquare("owner",9,'a')!='O'){
			passed=false;
			System.out.println("\nboat Placements do not match");
		}
		for(int i=0;i<9;i++){
			gb.targetSquare(i,(char)(i+'a'));
		}
		if(gb.getSquare("owner",1,'a')!='X' ||
		   gb.getSquare("owner",2,'b')!='X' ||
		   gb.getSquare("owner",3,'c')!='X' ||
		   gb.getSquare("owner",6,'f')!='M' ||
		   gb.getSquare("owner",7,'g')!='M'){
				passed=false;
				System.out.println("\nboard targeting do not match");
		}
		//player
		if(!PlayerTest.main()){
			passed=false;
			System.out.println("\nPlayer Failed");	
		}
		//turn draw
		Player p1,p2, winner=null;
		p1= new Player("P1");
		p2= new Player("P2");
		JFrame frame= new JFrame();
		JPanel pan = new JPanel();
		frame.setSize(new Dimension(1400,800));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(pan);
		frame.setVisible(true);
		try{
		draw draw = new draw(pan.getGraphics());
		turn turn = new turn(p1,p2);
		turn.set(draw,winner);
		turn.place(1,1,2,1);
		turn.place(1,1,2,1);
		turn.place(2,2,3,2);
		turn.place(2,2,3,2);
		turn.place(3,3,4,3);
		turn.place(3,3,4,3);
		turn.place(4,4,5,4);
		turn.place(4,4,5,4);
		turn.place(5,5,6,5);
		turn.place(5,5,6,5);
		turn.play(1,1);
		turn.refresh(true);
		frame.dispose();
		}catch(Exception e){
			passed=false;
			System.out.println("turn and draw error");	
		}
		//Convert
		Convert file = new Convert("Test.txt");
		if(file.moves(0,0)!=0 || file.moves(1,1)!=1){
			passed=false;
			System.out.println("convert Test Failed");	
		}
		file.rotate(0);
		if(file.moves(0,0)!=0 || file.moves(1,1)!=8){
			passed=false;
			System.out.println("convert rotation Test Failed");	
		}
		//AI
		try{
		Player jim =  new Player("harry");
		AI bob = new AI(jim);
		}catch(Exception e){
			passed=false;
			System.out.println("AI Failed to construct");	
		}
		if (passed = false) {
			System.out.println("\nTests Failed");
		} else {
			System.out.println("\nTests passed");
		}
	}
}
