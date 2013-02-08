package com.cpsc219g10.view;
/**
 * This class set the home page of the program
 * 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HomePanel extends ZContainer {

	public HomePanel(Dimension dim){
		super(dim);
		initPanel();
	}

	public void initPanel(){
		JLabel titre = new JLabel("Welcome in this BattleShip Game !\n");
		titre.setHorizontalAlignment(JLabel.CENTER);
		titre.setFont(comics30);
		this.panel.add(titre, BorderLayout.NORTH);
		
		this.panel.add(new JLabel(new ImageIcon("pictures/home.jpg")), BorderLayout.CENTER);
		
		JTextArea texte = new JTextArea("Welcome message\n");
		texte.setFont(arial);
		texte.setEditable(false);
		texte.setBackground(Color.blue);
		
		this.panel.add(texte, BorderLayout.SOUTH);
	}
}
