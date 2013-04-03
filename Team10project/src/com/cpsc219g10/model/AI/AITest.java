package com.cpsc219g10.model.AI;

import com.cpsc219g10.model.Player;

public class AITest {
	public static void main(String[] args){
		Player p= new Player("Gavin");
		AI comp = new AI(p);
		for(int i=0;i<5;i++){
			p.getBoat(i).setPosition((i+1)*2,i+1,true);
			if(!p.getBoard().addBoat(p.getBoat(i))){
				System.out.println("fail 6 @"+i);
			}
		}
		int count=0;
		do{
			System.out.println("\n turn \n"+comp.opBoard);
		comp.attack();
			System.out.println("\n turn \n"+comp.opBoard);
			count++;
		}while(p.hasBoat());
		System.out.println(count+"/"+100);
	}
}
