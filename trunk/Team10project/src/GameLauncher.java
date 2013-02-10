import java.util.Scanner;

public class GameLauncher{
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args){		
		Player Winner = new Player();
		System.out.println("Please enter the number of players: ");
		String numberOfPlayersStr = keyboard.nextLine();
		int numberOfPlayers = Integer.parseInt(numberOfPlayersStr);
		
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Please enter player " + (i+1) + "'s name: ");
			String someName = keyboard.nextLine();
			Player player = new Player();
			player.setName(someName + i);
			
		}
		/*while (Winner.getName() == null) {
			
			// Play the game!
			System.out.println("There is no winner!");
		}
		System.out.println("The winner is: " + Winner.getName());
		*/
		
		
		
	}
}