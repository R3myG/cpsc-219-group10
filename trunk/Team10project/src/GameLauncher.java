import java.util.Scanner;
/**
 * This will be the main launcher for the logic portion of the game
 */

public class GameLauncher{
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){		
		Player Winner = new Player();
		
		//Asks user for the number of players, and converts it to an integer
		System.out.println("Please enter the number of players: ");
		String numberOfPlayersStr = keyboard.nextLine();
		int numberOfPlayers = Integer.parseInt(numberOfPlayersStr);
		
		Player[] Player;
		Player = new Player[numberOfPlayers];
		
		
		
		//Sets a name for each number entered
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Please enter player " + (i + 1) + "'s name: ");
			String someName = keyboard.nextLine();
			Player[i] = new Player();
			Player[i].setName(someName);
		}
		int target;
		int x;
		int y;
		
		while (Winner.getName() == null) {
			for (int i = 0; i < numberOfPlayers-1; i++) {
			System.out.println("It is " + Player[i].getName() + "'s turn!");
			
			System.out.println("Enter the player number you want to attack:");
			target = keyboard.nextInt();
			
			System.out.println("Enter the x-coordinate you want to attack:");
			x = keyboard.nextInt();
			
			System.out.println("Enter the y-coordinate you want to attack:");
			y = keyboard.nextInt();
			
			
			Player[i].attack(Player[target], x, y);
			System.out.println("There is no winner!");			
			
			}
		}
		System.out.println("The winner is: " + Winner.getName());
		
		
		
		
	}
}