package com.cpsc219g10.model.Test;

import com.cpsc219g10.model.*;

public class TestAll {
	public static void main(String[] args){
		boolean passed = true;
		// Boats
		Boat[] boats= new Boat[5];
		try{
			for(int i=0;i<5;i++){
				boats[i] =  new Boat(i,"owner");
				boats[i].setPosition(i,i,true);
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
	}
}
