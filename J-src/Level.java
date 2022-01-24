
import java.util.ArrayList;

public class Level implements Cloneable {

	// Properties
	
	private int levelNumber;
	private int chancesRemaining;
	private SecretWord secretWord;
	private boolean debugOn = false;
	
	// Constructor
	
	public Level(int levelNumber, int chancesRemaining, SecretWord secretWord) {
		this.levelNumber = levelNumber;
		this.chancesRemaining = chancesRemaining;
		this.secretWord = secretWord;
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
		
		char capitalGuessedLetter = Character.toUpperCase(guessedLetter);

		if(secretWord.containsLetter(capitalGuessedLetter)) {
			// TODO: update the state of the secretWord accordingly
			ArrayList<Character> correctGuesses = secretWord.getCorrectGuesses();
			if(!correctGuesses.contains(capitalGuessedLetter)) {
				correctGuesses.add(capitalGuessedLetter);
				secretWord.setCorrectGuesses(correctGuesses);
				secretWord.calculateWordState(capitalGuessedLetter);
			}
			else {
				System.out.println("You already guessed " + capitalGuessedLetter + " before");
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
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
