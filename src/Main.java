import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Level[] levels = null;
		int score = 0;
		boolean menuSelected = false;
		int selectedMenuItem = 0;
		
		System.out.println("Welcome to the word guessing game. Please select one item from the menu...");
		System.out.println("Press '1' for Start Game. \n Press '2' for Results of Previous Games. \n Press '3' for Exit");
		System.out.println("");
		
		// TODO: make this selection a method or a nicer way. No copies !!
		selectedMenuItem = sc.nextInt();
		
		
		if(selectedMenuItem == 1) { // Start the game
			menuSelected = true;
			levels = chooseLevelsRandomly();
			
			for(int i = 0; i < levels.length; i++) {
				startTheGame(levels[i]);
			}
			
		}
		else if(selectedMenuItem == 2) { // Show previous scores
			menuSelected = true;
			// TODO : Previous games
		}
		else if(selectedMenuItem == 3) { // Exit
			menuSelected = true;
			System.out.println("Good bye.");
			System.exit(0);
		}
		else {
			menuSelected = false;
		}
		
		while(!menuSelected) {
			System.out.println("Wrong input! Please type a correct number from the menu.");
			System.out.println("Press '1' for Start Game. \n Press '2' for Results of Previous Games. \n Press '3' for Exit");
			System.out.println("");
			
			selectedMenuItem = sc.nextInt();
			
			if(selectedMenuItem == 1) { // Start the game
				menuSelected = true;
				levels = chooseLevelsRandomly();
			}
			else if(selectedMenuItem == 2) { // Show previous scores
				menuSelected = true;
				// TODO : Previous games
			}
			else if(selectedMenuItem == 3) { // Exit
				menuSelected = true;
				System.out.println("Good bye.");
				System.exit(0);
			}
			else {
				menuSelected = false;
			}
			
		}
		
	}
	
	private static void startTheGame(Level level) {
		Scanner s = new Scanner(System.in);
		
		char guessedLetter;
		boolean isGuessCorrect = false;
		
		while(!level.isWordGuessed()) {
			gameDisplayInfo(level);
			System.out.print("Guess a letter  ");
			guessedLetter = s.next().charAt(0);
			System.out.println("");
			isGuessCorrect = level.checkGuesses(guessedLetter);
			System.out.println("You guessed " + guessedLetter);
			
			if(isGuessCorrect) {
				System.out.println("The letter " + guessedLetter + " is in the secret word");
			}
			else {
				System.out.println("The letter " + guessedLetter + " is NOT in the secret word");
			}
			
			if(level.getChancesRemaining() >= 0) {
				System.out.println("LOSE. You are out of guesses. You couldn't guess the word!");
				return;
			}
		}
		
		System.out.println("CONGRATULATIONS. You guessed the secret word!");
		
	}
	
	private static void gameDisplayInfo(Level level) {
		System.out.println("--------------------------------------------------");
		System.out.println("Welcome to the level " + level.getLevelNumber());
		System.out.println("Your current score is XXXX"); // TODO : get the score either a global var or pass as parameter
		System.out.println(level.toString());
	}
	
	private static Level[] chooseLevelsRandomly() {
		
		// TODO: get the number of levels as a parameter
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Level[]	allLevels = createLevels();	
		Level[] selectedLevels = new Level[3];

		for(int i = 0; i < allLevels.length; i++) {
			list.add(i);
		}
		
		Collections.shuffle(list);
		
		for(int i = 0; i < selectedLevels.length; i++) {
			selectedLevels[i] = allLevels[list.get(i)];
		}
		
		return selectedLevels;
	}
	
	private static Level[] createLevels() {
		
		Level[] allLevels = new Level[10];
		
		// Level 1
		SecretWord firstSW = new SecretWord("LONDON");
		Level firstLevel = new Level(1, 5, firstSW, false);
		allLevels[0] = firstLevel;
		
		// Level 2
		SecretWord secondSW = new SecretWord("TORONTO");
		Level secondLevel = new Level(2, 5, secondSW, false);
		allLevels[1] = firstLevel;
		
		// Level 3
		SecretWord thirdSW = new SecretWord("PARIS");
		Level thirdLevel = new Level(3, 5, thirdSW, false);
		allLevels[2] = firstLevel;
		
		// Level 4
		SecretWord forthSW = new SecretWord("OTTOWA");
		Level forthLevel = new Level(3, 5, forthSW, false);
		allLevels[3] = firstLevel;
		
		// Level 5
		SecretWord fifthSW = new SecretWord("CHICAGO");
		Level fifthLevel = new Level(3, 5, fifthSW, false);
		allLevels[4] = firstLevel;
		
		// Level 6
		SecretWord sixthSW = new SecretWord("HAWAII");
		Level sixthLevel = new Level(3, 5, sixthSW, false);
		allLevels[5] = firstLevel;
		
		// Level 6
		SecretWord seventhSW = new SecretWord("BUDAPEST");
		Level seventhLevel = new Level(3, 5, seventhSW, false);
		allLevels[6] = firstLevel;
		
		// Level 6
		SecretWord eighthSW = new SecretWord("BRASIL");
		Level eighthLevel = new Level(3, 5, eighthSW, false);
		allLevels[7] = firstLevel;
		
		// Level 6
		SecretWord ninthSW = new SecretWord("RIO DE JENERIO");
		Level ninthLevel = new Level(3, 5, ninthSW, false);
		allLevels[8] = firstLevel;
		
		// Level 6
		SecretWord tenthSW = new SecretWord("NEW YORK");
		Level tenthLevel = new Level(3, 5, tenthSW, false);
		allLevels[9] = firstLevel;
		
		return allLevels;
	}
	
}
