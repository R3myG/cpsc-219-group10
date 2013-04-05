package com.cpsc219g10.model.AI;

import java.util.Random;

import com.cpsc219g10.model.Player;

public class AITest {
	public static void main(String[] args){
		int count=0;
		for(int rec=0;rec<1000;rec++){
			Player p= new Player("Gavin");
			AI comp = new AI(p);
			Random gen = new Random();
			for(int i=0;i<5;i++){
				do{
					int x=gen.nextInt(10)+1;
					int y=gen.nextInt(10)+1;
					boolean ori = gen.nextBoolean();
					p.getBoat(i).setPosition(x,y,ori);
				}while(!p.getBoard().addBoat(p.getBoat(i)));
			}
			do{
			comp.attack();
				count++;
			}while(p.hasBoat());
		}
		System.out.println(count/1000.0+"/"+100);

	}
}
