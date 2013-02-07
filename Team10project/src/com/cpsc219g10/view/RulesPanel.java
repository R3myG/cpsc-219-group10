package com.cpsc219g10.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RulesPanel extends ZContainer{

	public RulesPanel(Dimension dim){
		super(dim);
		initPanel();
	}

	public void initPanel(){
		JLabel titre = new JLabel();
		titre.setFont(comics30);
		titre.setText("The Battleship Game");
		titre.setHorizontalAlignment(JLabel.CENTER);
		
		this.panel.add(titre, BorderLayout.CENTER);
		
		this.panel.add(new JLabel(new ImageIcon("home.jpg")), BorderLayout.CENTER);
		
		JTextArea accueil = new JTextArea();
		accueil.setBackground(Color.white);
		accueil.setText(" Rules Rules Rules Rules Rules Rules Rules Rules Rules Rules" + 
						"\nRules Rules Rules Rules Rules Rules Rules Rules Rules Rules");
		accueil.setFont(arial);
		accueil.setEditable(false);
		this.panel.add(accueil, BorderLayout.SOUTH);
	}
	
}