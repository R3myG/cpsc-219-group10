package com.cpsc219g10.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class OnePlayerTest {
	public static void main(String[] args){
		JFrame myframe = new JFrame("BATTLE SHIP");
		myframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myframe.setSize(1440,781);
		myframe.setLocation(30,30);
		JPanel pan = new JPanel();
		
		try{Thread.sleep(1000);}catch(InterruptedException e){}
		myframe.add(pan);
		pan.setLocation(0,0);
		pan.setSize(1440,781);
		
		try{Thread.sleep(1000);}catch(InterruptedException e){}
		myframe.setVisible(true);
		
		GraphicGenerator game = new GraphicGenerator();
		game.start(pan);
	}
}
