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
		accueil.setBackground(Color.blue);
		accueil.setText("How to play Battleship" +
				"\n\nBattle ship is a 2 player game where the players create a 10 by 10 game boad containing 5 boats." +
				"\nThe first player to find and shoot down all 5 boats wins." +
				"\n\nTo start the game, click on \"File -> New Game\"" +
				"\n\nPhase 1: Setting up game board\nThe boat that will be placed next will appear on the upper left (note the length of the boat)" +
				"\nClick on any block on the grid to position the uppermost/leftmost part of the boat." +
				"\nClick on any block directly right of the first to place horizontaly, or directly below to place vertically." +
				"\nHint: A double click on any block will set the boat vertically on that position" +
				"\n\nPhase 2: Attacking" +
				"\nAfter the board has been set, we enter the attacking phase." +
				"\nYour gameboard will be shown to you on the left and your opponent's board on the right" +
				"\nTo attack, click on a spot on your opponent's board. A confirmation will appear to check that the spot is correct." +
				"\nIf you hit an opponent's boat, a message will appear, else your turn will end." +
				"\nIf you hit a boat and the boat is sunk, a message will apear telling you which boat has been sunk." +
				"\nOnce all 5 boats are sunk a winner is determined.");
		accueil.setFont(arial);
		accueil.setEditable(false);
		this.panel.add(accueil, BorderLayout.SOUTH);
	}
	
}