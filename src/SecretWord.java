import java.util.ArrayList;

public class SecretWord {
	
	private String actualWord;
	private String wordState = "";
	private ArrayList<Character> correctGuesses; // TODO: Could be an ArrayList or a String
	
	// Constructor
	
	public SecretWord(String actualWord) {
		this.actualWord = actualWord;
		
		for(int i = 0; i < actualWord.length(); i++) {
			wordState += "_ ";
		}
		wordState = wordState.substring(0, wordState.length() - 1); // removes the last whitespace
		
		this.correctGuesses = new ArrayList<Character>();
	}
	
	// Getters / Setters
	
	public String getActualWord() {
		return actualWord;
	}

	public void setActualWord(String actualWord) {
		this.actualWord = actualWord;
	}

	public String getWordState() {
		return wordState;
	}

	public void setWordState(String wordState) {
		this.wordState = wordState;
	}

	public ArrayList<Character> getCorrectGuesses() {
		return correctGuesses;
	}

	public void setCorrectGuesses(ArrayList<Character> correctGuesses) {
		this.correctGuesses = correctGuesses;
	}

	// Methods
	
	public boolean containsLetter(char letter) {
		return actualWord.toUpperCase().contains(letter + "");
	}
	
	public boolean hasLettersRemaning() {
		return !actualWord.equalsIgnoreCase(wordState.replaceAll("\\s+",""));
	}
	
	public String toString() {
		return wordState;
	}
	
	public void calculateWordState(char correctLetter) {
		int i = 0;
		
		for(char c : actualWord.toCharArray()) {
			if(c == correctLetter) {
				wordState = wordState.substring(0, i) + c + wordState.substring(i + 1);
			}
			i = i + 2;
		}
	}
	
}
