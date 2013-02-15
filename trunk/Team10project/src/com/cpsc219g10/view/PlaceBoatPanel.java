package com.cpsc219g10.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import drawwindow.drawOnWindow;

public class PlaceBoatPanel extends ZContainer{
	
	private double middleX;
	private double middleY;
	
	public PlaceBoatPanel(Dimension dim){
		super(dim);
		initPanel();
		middleX = dim.getWidth()/2;
		middleY = dim.getHeight()/2;
				
	}

	public void initPanel(){
		JLabel titre = new JLabel("Place your Boats\n");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(comics30);
		this.panel.add(titre, BorderLayout.NORTH);
		
		JPanel frame = new JPanel();
		drawOnWindow drawOnWindow = new drawOnWindow();
		frame.setContentPane(drawOnWindow);
		this.panel.add(new JPanel(frame, BorderLayout.CENTER);
		
		JTextArea texte = new JTextArea("Board\n");
		texte.setFont(arial);
		texte.setEditable(false);
		texte.setBackground(Color.blue);
		
		this.panel.add(texte, BorderLayout.SOUTH);
	}
	public void paintComponent(){
		Math.round(middleX);
		Math.round(middleY);
		
		int X_UP = (int)middleX -300;
		int Y_UP = (int)middleY -250;
		
		
		int X_DOWN = (int)middleX + 250;
		int Y_DOWN = (int)middleY + 250;
			//System.out.println("That's an awesome test ! ! !");
			for (int i=0; i<11 ; i++) {
				g.drawLine(X_UP, Y_UP+i*50, X_DOWN, Y_UP+i*50);
			}
			for (int i=0; i<11 ; i++) {
				g.drawLine(X_UP+i*50, Y_UP, X_UP+i*50, Y_DOWN);
			}
			
			
	}
}
