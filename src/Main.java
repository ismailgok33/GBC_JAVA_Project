import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	private static int score = 0;
	private static Level[] levels = null;
	private static ArrayList<PreviousGameResult> previousResults = new ArrayList<PreviousGameResult>();
	
	public static void main(String[] args) {
		
		welcomeMessage();
		
	}
	
	private static int startTheGame(Level level, int score) {
		Scanner s = new Scanner(System.in);
		
		char guessedLetter;
		boolean isGuessCorrect = false;
		
		while(!level.isWordGuessed()) {
			gameDisplayInfo(level);
			System.out.print("Guess a letter  ");
			guessedLetter = s.next().charAt(0);
			System.out.println("");
			isGuessCorrect = level.checkGuesses(guessedLetter);
			
			if(level.getChancesRemaining() <= 0) {
				System.out.println("");
				gameOver(false); // The game is lost	
			}
		}
		
		System.out.println("");
		System.out.println("CONGRATULATIONS. You guessed the secret word!");
		return level.getChancesRemaining();
	}
	
	private static void gameDisplayInfo(Level level) {
		System.out.println("--------------------------------------------------");
		System.out.println("Your current score is " + score);
		System.out.println(level.toString());
		System.out.println("");
	}
	
	private static void gameOver(boolean win) {
		System.out.println("****************************************************");
		if(win) {
			System.out.println("CONGRATULATIONS. You have won the game! Hurraayyyy");
		}
		else {
			System.out.println("LOSE. You are out of guesses. You couldn't guess the word!");
		}
		
		System.out.println("Your SCORE is " + score);
		
		PreviousGameResult gameResult = new PreviousGameResult(score);
		previousResults.add(gameResult);
		
		score = 0;

		welcomeMessage();
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
			Level level = allLevels[list.get(i)];
			System.out.println("DEBUG: secret word of the level is " + level.getSecretWord().getActualWord());
			level.setLevelNumber(i + 1);
			try {
				selectedLevels[i] = (Level)level.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		
		return selectedLevels;
	}
	
	private static Level[] createLevels() {
		
		Level[] allLevels = new Level[10];
		
		// Level 1
		SecretWord firstSW = new SecretWord("LONDON");
		Level firstLevel = new Level(0, 5, firstSW, false);
		allLevels[0] = firstLevel;
		
		// Level 2
		SecretWord secondSW = new SecretWord("TORONTO");
		Level secondLevel = new Level(0, 5, secondSW, false);
		allLevels[1] = secondLevel;
		
		// Level 3
		SecretWord thirdSW = new SecretWord("PARIS");
		Level thirdLevel = new Level(0, 5, thirdSW, false);
		allLevels[2] = thirdLevel;
		
		// Level 4
		SecretWord forthSW = new SecretWord("OTTOWA");
		Level forthLevel = new Level(0, 5, forthSW, false);
		allLevels[3] = forthLevel;
		
		// Level 5
		SecretWord fifthSW = new SecretWord("CHICAGO");
		Level fifthLevel = new Level(0, 5, fifthSW, false);
		allLevels[4] = fifthLevel;
		
		// Level 6
		SecretWord sixthSW = new SecretWord("HAWAII");
		Level sixthLevel = new Level(0, 5, sixthSW, false);
		allLevels[5] = sixthLevel;
		
		// Level 6
		SecretWord seventhSW = new SecretWord("BUDAPEST");
		Level seventhLevel = new Level(0, 5, seventhSW, false);
		allLevels[6] = seventhLevel;
		
		// Level 6
		SecretWord eighthSW = new SecretWord("BRASIL");
		Level eighthLevel = new Level(0, 5, eighthSW, false);
		allLevels[7] = eighthLevel;
		
		// Level 6
		SecretWord ninthSW = new SecretWord("BARCELONA");
		Level ninthLevel = new Level(3, 5, ninthSW, false);
		allLevels[8] = ninthLevel;
		
		// Level 6
		SecretWord tenthSW = new SecretWord("TOKYO");
		Level tenthLevel = new Level(0, 5, tenthSW, false);
		allLevels[9] = tenthLevel;
		
		return allLevels;
	}
	
	private static boolean askMenuInput() {
		
		// TODO : make sure the program does not crush when input a letter
		
		Scanner sc = new Scanner(System.in);
		int selectedMenuItem = 0;
		boolean menuSelected = false;
		
		System.out.println("Press '1' for Start Game. \nPress '2' for Results of Previous Games. \nPress '3' for Exit");
		System.out.println("");
		
		selectedMenuItem = sc.nextInt();
		
		if(selectedMenuItem == 1) { // Start the game
			menuSelected = true;
			levels = chooseLevelsRandomly();
			
			for(int i = 0; i < levels.length; i++) {
				System.out.println("");
				System.out.println("Welcome to Level " + (i + 1));
				System.out.println("Current score is " + score + " point");
				System.out.println("");
				score += startTheGame(levels[i], score);
			}
			
			gameOver(true); // The game has been won
		}
		else if(selectedMenuItem == 2) { // Show previous scores
			menuSelected = true;
			
			if(previousResults.size() > 0) {
				for(PreviousGameResult game : previousResults) {
					System.out.println(game.toString());
				}
			}
			else {
				System.out.println("You don't have any previous games to show.");
			}
			
			welcomeMessage();
		}
		else if(selectedMenuItem == 3) { // Exit
			menuSelected = true;
			System.out.println("Good bye.");
			System.exit(0);
		}
		else {
			menuSelected = false;
		}
		
		return menuSelected;
	}
	
	private static void welcomeMessage() {
		
		boolean menuSelected = false;
		System.out.println("\n");
		System.out.println("Welcome to the word guessing game. Please select one item from the menu...");
		
		while(!menuSelected) {
			
			menuSelected = askMenuInput();
			
			if(!menuSelected) {
				System.out.println("Wrong input! Please type a correct number from the menu.");

			}
		}
	}
	
}
