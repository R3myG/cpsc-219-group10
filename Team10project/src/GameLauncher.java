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
		
		
		// Initialize an array of Players, Boards, and Boats(for each player)
		Player[] Player;
		Board[] Board;
		Boat[][] Boat;
		Player = new Player[numberOfPlayers];
		Board = new Board[numberOfPlayers];
		Boat = new Boat[numberOfPlayers][5];
		
		
		
		//Sets a name for each number entered and initializes their game board.
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("Please enter player " + (i + 1) + "'s name: ");
			String someName = keyboard.nextLine();
			Player[i] = new Player();
			Player[i].setName(someName);
			Board[i] = new Board(Player[i].getName());

		}
		
		System.out.println("Create your boards!\n");
		
		
		// Get each player to add boats to their board
		// MAY GET MOVED TO BOAT CLASS!!!
		for (int i = 0; i < numberOfPlayers; i++) {
			System.out.println("It is " + Player[i].getName() +"'s turn to set their board!\n");
			for(int j = 0; j < 5; j++) {
				Boat[i][j] = new Boat(j, Player[i].getName());
				
				// Print out what type of boat is being added
				// OR let the user choose which type (and length)
				// Use some method of setting the position
				do{
				System.out.print("Enter the x coordinate: ");
				int xCoordinate = keyboard.nextInt();
				System.out.print("Enter the y coordinate: ");
				int yCoordinate = keyboard.nextInt();
				System.out.print("Is the boat vertical? True of False: ");
				boolean orientation = keyboard.nextBoolean();
				
				Boat[i][j].setPosition(xCoordinate, yCoordinate, orientation);
				
				// Keep asking for an input until a valid input is correct
				} while(!Board[i].addBoat(Boat[i][j]));
				
				System.out.print(Boat[i][j] + "\n");
			}
		}
		System.out.println("Finished placing boats, begin attacking!");
		
		// Start the game
		int target;
		int x;
		String y;
		char ychar;
		int i = 0;
		do {
			System.out.println("It is " + Player[i].getName() + "'s turn!");
			
			// Change this to either a string or a select method.
			System.out.println("Enter the player number you want to attack:");
			target = keyboard.nextInt();
			
			System.out.println("Enter the x-coordinate you want to attack:");
			x = keyboard.nextInt();
			
			System.out.println("Enter the y-coordinate you want to attack:");
			y = keyboard.next();
			
			ychar = y.charAt(0);
			
			if (Board[target].targetSquare(x, ychar)) {
				System.out.println("You have hit the opponent!");
				/* Display on both boards
				 * if sunk, print out which boat is sunk
				 * if game is over, Winner.setName(Player[i].getName());
				 * 
				 */
			} else {
				System.out.println("You missed!");
			}
			
			
			if (i == numberOfPlayers - 1) {
				i = 0;
			} else {
				i++;
			}
			
		}	while (Winner.getName() == null);
		
		System.out.println("The winner is: " + Winner.getName());
		
		
		
		
	}
}