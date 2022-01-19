import java.util.Scanner;
public class Main {

	
	/*
	 * Prompts the user to enter a menu option.
	 */
	public static char menu() {
		
		Scanner input = new Scanner(System.in);
		
		char option;
		
		System.out.println("Welcome to the Word Guessing Game!");
		System.out.println("Enter the letter of the corresponding option");
		System.out.println("A. Start Game");
		System.out.println("B. Result of Previous Games");
		System.out.println("C. Exit");
		
		option = input.next().charAt(0);
		option = Character.toLowerCase(option);
		
		
		return option;
		
	}
	
	public static void gameStart() {
		char guess;
		
		System.out.println("Enter")
	}
	
	
	public static void main(String[] args) {
		Level[] level = new Level[3]; //array containing 3 levels
		PreviousGameResult[] history = new PreviousGameResult[5];
		
		char option = menu();
		// System.out.println(option); // to preview if it is taking the right input.
		
		do {
			switch(option) {
				case 'a':
					System.out.println("Starting the game");
					//do something there
					option = menu();
					break;	
				case 'b':
					System.out.println("Showing Previous Games");
					//do something here
					option = menu();
					break;
				case 'c':
					System.out.println("Exiting Game");
					break;
				default:
					System.out.println("\nYou have entered an invalid option, please enter it again.\n");
					option = menu();
			}
		}while(option != 'c');
		
		
	}

}
