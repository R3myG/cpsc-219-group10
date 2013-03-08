package com.cpsc219g10.model;

public class PlayerTest {
	public static void main(String[] args){
		Player pt1 = new Player("test1");
		Player pt2 = new Player("test2");
		pt2.getBoat(0).setPosition(4,4,true);
		pt2.getBoard().addBoat(pt2.getBoat(0));
		
		boolean pass=true;
		
		if(!pt1.canAttack(pt2,4,'d')){
			pass=false;
			System.out.println("fail 1");
		}
		if(!pt1.attack(pt2,4,'d')){
			pass=false;
			System.out.println("fail 2");
		}
		if(pt2.getBoard().getSquare(pt2.getName(),4,'d')!='X'){
			pass=false;
			System.out.println("fail 3");
		}
		if(!pt2.hasBoat()){
			pass=false;
			System.out.println("fail 4");
			}
		if(pt2.numberOfBoats()!=5){
			pass=false;
			System.out.println("fail 5");
		}
		for(int i=0;i<5;i++){
			pt1.getBoat(i).setPosition(i+1,1,true);
			if(!pt1.getBoard().addBoat(pt1.getBoat(i))){
				pass=false;
				System.out.println("fail 6 @"+i);
			}
		}
		System.out.print("miss @");
		for(int i=1;i<6;i++){
			for(char j='a';j<'f';j++){
				if(!pt2.canAttack(pt1,i,j)){
					pass=false;
					System.out.println("fail 7 @("+i+","+j+")");
				}
				if(!pt2.attack(pt1,i,j)){
					System.out.print("("+i+","+j+")");
				}
			}
		}
		if(pt1.hasBoat()){
			pass=false;
			System.out.println("fail 9");
			}
		if(pt1.numberOfBoats()!=0){
			pass=false;
			System.out.println("fail 10");
		}
		System.out.println(pt1+"\n\n"+pt2);
		
		if(pass)
			System.out.println("All Tests Passed");


	}
}
