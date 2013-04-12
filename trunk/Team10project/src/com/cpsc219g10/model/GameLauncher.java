package com.cpsc219g10.model;
import java.util.Scanner;
/**
 * This will be the main launcher for the logic portion of the game
 */

public class GameLauncher{
	static Scanner keyboard = new Scanner(System.in);
	public static void main(String[] args){		
		//Player Winner = new Player();
		
		//Asks user for the number of players, and converts it to an int
		System.out.println("Please enter the number of players: ");
		String numberOfPlayersStr = keyboard.nextLine();
		int numberOfPlayers = Integer.parseInt(numberOfPlayersStr);
		
		//Sets a name for each number entered
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Please enter player " + (i + 1) + "'s name: ");
			String someName = keyboard.nextLine();
			Player player = new Player(someName);
			//player.setName(someName + i);
		}
	}
}