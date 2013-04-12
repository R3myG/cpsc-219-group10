package com.cpsc219g10.model.Test;

import java.util.Random;

import com.cpsc219g10.model.Player;
import com.cpsc219g10.model.AI.AI;

public class AITest {
	static String fileName = "Patern3.txt";
	public static void main(String[] args){
		int count=0;
		int[] counts=new int[200];
		for(int rec=0;rec<10000;rec++){
			Player p= new Player("Gavin");
			AI comp = new AI(p,fileName,false);
			Random gen = new Random();
			for(int i=0;i<5;i++){
				do{
					int x=gen.nextInt(10)+1;
					int y=gen.nextInt(10)+1;
					boolean ori = gen.nextBoolean();
					p.getBoat(i).setPosition(x,y,ori);
				}while(!p.getBoard().addBoat(p.getBoat(i)));
			}
			int each=0;
			do{
			comp.attack();
				count++;
				each++;
			}while(p.hasBoat());
			counts[each]++;
		}
		System.out.println(count/10000.0+"/"+100);
		for(int i=0;i<100;i++){
			System.out.print(counts[i]+"\n");
		}





	}
}
