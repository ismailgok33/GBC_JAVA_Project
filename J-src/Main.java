import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	private static int score = 0;

	private static ArrayList<PreviousGameResult> GameHistory = new ArrayList<PreviousGameResult>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Level[] levels = null;
		Level level = null;
		int option;
		boolean won;
		
		do {
			option = menu();
			switch(option) {
				case 1:
					levels = chooseLevelsRandomly();
					int gameState = 0; //1 = false, 2 = true
					
					for(int i = 0; i < levels.length; i++) { 
						score += startTheGame(levels[i],score);
						System.out.println("DEBUG: The Score for level " + i + " is " + score);
						System.out.println("score in loop " + score);
						if(levels[i].getChancesRemaining() <= 0) {
							gameState = 1;
							break; //SHOULD GO OUT OF THE LOOP
						}
						
						gameState = 2; //IN THE CASE THE GAME HAS BEEN WON

						System.out.println("CONGRATULATIONS. You guessed the secret word!");g
						
					}
					//GOES OUT AFTER ALL 3 LEVELS
					if(gameState == 2) {
						gameOver(true); // The game has been won
					}
					else if(gameState == 1){
						gameOver(false);
					}
					PreviousGameResult previousGame = new PreviousGameResult(score);
					
					GameHistory.add(previousGame);

					score = 0;
					break;
				case 2:
					if(GameHistory.size() > 0) {
						for(PreviousGameResult game : GameHistory) {
							System.out.println(game.toString());
						}
					}
					else {
						System.out.println("You don't have any previous games to show.");
					}
					break;
					
				case 3:
					System.out.println("Exiting the game. Thank you for playing.");
					break;
				default:
					System.out.println("You have entered an invalid option. Please enter a valid option \n");
					option = menu();
					
			}
		}while(option != 3);

		
	}
	
	private static int menu() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to the word guessing game. Please select one item from the menu...");
		System.out.println("Press '1' for Start Game. \nPress '2' for Results of Previous Games. \nPress '3' for Exit");
		System.out.println("");
		int option = input.nextInt();
	//	input.close();
		
		return option;
	}
	
	
	private static int startTheGame(Level level, int score) {
		Scanner s = new Scanner(System.in);
		
		char guessedLetter;
		boolean isGuessCorrect = false;
		
		while(!level.isWordGuessed() && (level.getChancesRemaining() >0)) {
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
		}
		return score + level.getChancesRemaining();
	}
	
	private static void gameDisplayInfo(Level level) {
		System.out.println("--------------------------------------------------");
		System.out.println("Level is " + level.getLevelNumber());
		System.out.println(level.toString());
	}
	
	private static void gameOver(boolean win) {
		System.out.println("****************************************************");

		if(win == true) {
			System.out.println("CONGRATULATIONS. You have won the game! Hurraayyyy");
		}
		else {
			System.out.println("LOSE. You are out of guesses. You couldn't guess the word!");
		}
		
		System.out.println("Your SCORE is " + score);
		
	}
	
	private static Level[] chooseLevelsRandomly() {
		
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
		Level firstLevel = new Level(0, 5, firstSW);
		allLevels[0] = firstLevel;
		
		// Level 2
		SecretWord secondSW = new SecretWord("TORONTO");
		Level secondLevel = new Level(0, 5, secondSW);
		allLevels[1] = secondLevel;
		
		// Level 3
		SecretWord thirdSW = new SecretWord("PARIS");
		Level thirdLevel = new Level(0, 5, thirdSW);
		allLevels[2] = thirdLevel;
		
		// Level 4
		SecretWord forthSW = new SecretWord("OTTOWA");
		Level forthLevel = new Level(0, 5, forthSW);
		allLevels[3] = forthLevel;
		
		// Level 5
		SecretWord fifthSW = new SecretWord("CHICAGO");
		Level fifthLevel = new Level(0, 5, fifthSW);
		allLevels[4] = fifthLevel;
		
		// Level 6
		SecretWord sixthSW = new SecretWord("HAWAII");
		Level sixthLevel = new Level(0, 5, sixthSW);
		allLevels[5] = sixthLevel;
		
		// Level 6
		SecretWord seventhSW = new SecretWord("BUDAPEST");
		Level seventhLevel = new Level(0, 5, seventhSW);
		allLevels[6] = seventhLevel;
		
		// Level 6
		SecretWord eighthSW = new SecretWord("BRASIL");
		Level eighthLevel = new Level(0, 5, eighthSW);
		allLevels[7] = eighthLevel;
		
		// Level 6
		SecretWord ninthSW = new SecretWord("BARCELONA");
		Level ninthLevel = new Level(3, 5, ninthSW);
		allLevels[8] = ninthLevel;
		
		// Level 6
		SecretWord tenthSW = new SecretWord("TOKYO");
		Level tenthLevel = new Level(0, 5, tenthSW);
		allLevels[9] = tenthLevel;
		
		return allLevels;
	}
	
}
	
