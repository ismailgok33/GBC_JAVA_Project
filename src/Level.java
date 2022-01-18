import java.util.ArrayList;

public class Level {

	// Properties
	
	private int levelNumber;
	private int chancesRemaining;
	private SecretWord secretWord;
	private boolean debugOn;
	
	// Constructor
	
	public Level(int levelNumber, int chancesRemaining, SecretWord secretWord, boolean debugOn) {
		this.levelNumber = levelNumber;
		this.chancesRemaining = chancesRemaining;
		this.secretWord = secretWord;
		this.debugOn = debugOn;
	}
	
	
	
	// Getters / Setters
	
	public int getLevelNumber() {
		return levelNumber;
	}



	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}



	public int getChancesRemaining() {
		return chancesRemaining;
	}



	public void setChancesRemaining(int chancesRemaining) {
		this.chancesRemaining = chancesRemaining;
	}



	public SecretWord getSecretWord() {
		return secretWord;
	}



	public void setSecretWord(SecretWord secretWord) {
		this.secretWord = secretWord;
	}



	public boolean isDebugOn() {
		return debugOn;
	}



	public void setDebugOn(boolean debugOn) {
		this.debugOn = debugOn;
	}


	// Methods

	public String toString() {
		
		if(debugOn) {
			return "Level: " + levelNumber + ", Chances Remaining: " 
			+ chancesRemaining + ", Secret Word: " + secretWord.getWordState() 
			+ ", Actual Word: " + secretWord.getActualWord();
		}
		
		return "Level: " + levelNumber + ", Chances Remaining: " 
				+ chancesRemaining + ", Secret Word: " + secretWord.getWordState();
	}
	
	public boolean checkGuesses(char guessedLetter) {
		
		if(secretWord.containsLetter(guessedLetter)) {
			
			// TODO: update the state of the secretWord accordingly
			ArrayList<Character> correctGuesses = secretWord.getCorrectGuesses();
			if(!correctGuesses.contains(guessedLetter)) {
				correctGuesses.add(guessedLetter);
				secretWord.setCorrectGuesses(correctGuesses);
				secretWord.calculateWordState(guessedLetter);
			}
			else {
				System.out.println("You already guessed " + guessedLetter + " before");
			}
			
			return true;
		}
		else {
			chancesRemaining--;
			return false;
		}
		
	}
	
	public boolean isWordGuessed() {
		return !secretWord.hasLettersRemaning();
	}
	
}
