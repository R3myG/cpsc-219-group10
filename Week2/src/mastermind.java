import java.util.Random;
import java.util.Scanner;

/**
 * A class that allows the user to play the game mastermind.
 * This is the first iteration, which allows the user a fixed
 * number of guesses without feedback.  The length of the 
 * randomly chosen string is 4 and the characters chosen are
 * A,B,C or D.  No feedback is provided to user about the quality
 * of their guess.
 */
public class mastermind {
   public static final int MAX_GUESSES  = 5;
   public static final int NUM_POSSIBLE_VALUES = 4;
   public static final int CHOICE_LENGTH = 4;
   
   public static void main(String[] args) {
      // Generate a random string.
      Random generator = new Random();
      String choice = "";
      while (choice.length() < CHOICE_LENGTH) {
         // Each choice uses a random number and converts this alpha character.
         choice += (char)(generator.nextInt(NUM_POSSIBLE_VALUES) + (int)'A');
      }
      
      // Get user to enter a choice until either running out of guesses
      // or the string was guessed
      Scanner keyboard = new Scanner(System.in);
      boolean choiceGuessed = false;
      for (int numOfGuesses = 0; !choiceGuessed && numOfGuesses < MAX_GUESSES; numOfGuesses++) {
         System.out.print("Enter a guess: ");
         String guess = keyboard.nextLine();
         choiceGuessed = guess.equals(choice);
      }
      
      // Let the user know they guessed the string or what the chosen string was.
      if (choiceGuessed) {
         System.out.println("Nice Work!");
      } else {
         System.out.printf("The string I had chosen was: %s\n",choice);
      }
   }
}