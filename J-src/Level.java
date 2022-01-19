/*
 * Date Created: 18/01/22
 * File Owner: Julian Sanchez
 * Date Last Updated:
 * Description:
 */
public class Level {

	//Properties
	int level;
	int chancesRemaining;
	SecretWord hiddenWord;
	boolean debugOn;
	
	//Construct
	public Level(int lvl, int chances, SecretWord sWord, boolean debug) {
		level = lvl;
		chancesRemaining = chances;
		hiddenWord = sWord;
		debugOn = debug;
	}
	
	//methods
	public String toString() {
		
		String hideWord = hiddenWord;
		hideWord - hideWord.replaceAll(hideWord, hideWord)
		
		System.out.println("Level " + level);
		System.out.println("Remaining number of guesses: " + chancesRemaining);
		//print out the new 
		
	}
	
	public void checkGuess(char guessedLetter) {
		
	}
	
	public boolean isWordGuessed() {
		
		boolean answered;
		
		hiddenWord == //variable with the user's answer
		
		return answered;
	}
}
