package com.cpsc219g10.model.Test;
import java.util.Random;

import com.cpsc219g10.model.*;

public class BoardTest {
	public static void main(String[] args){
		Random gen = new Random();
		Boat boats[]={new Boat(0,"Gavin"),new Boat(1,"Gavin"),new Boat(2,"Gavin"),new Boat(3,"Gavin"),new Boat(4,"Gavin")};
		Board gb = new Board("Gavin");
		for(int i=0;i<5;i++){
			do{
				boats[i].setPosition(gen.nextInt(10)+1,gen.nextInt(10)+1,gen.nextBoolean());
			}while(!gb.addBoat(boats[i]));
			System.out.println(boats[i]);
		}
		System.out.print(gb);
		for(int i=0;i<10;i+=2){
			for(char j='a';j<'k';j+=2){
				gb.targetSquare(i,j);
			}
		}
		System.out.println("\n"+gb);
	}
}
