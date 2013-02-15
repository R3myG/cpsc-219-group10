package com.cpsc219g10.model;

public class BoatTest {
	public static void main(String[] args){
		Boat b1= new Boat(0,"Gavin");
		b1.setPosition(2,5,true);
		System.out.print(b1+"\n"+"length:"+b1.length());
	}
}
