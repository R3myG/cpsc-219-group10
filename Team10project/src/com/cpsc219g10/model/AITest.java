package com.cpsc219g10.model;

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
		System.out.println(p);
		do{
		comp.attack();
		System.out.println(p);
		try{Thread.sleep(1000); } 
		catch(InterruptedException e) {}
		}while(p.hasBoat());
	}
}
