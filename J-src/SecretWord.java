/*
 * Date Created: 18/01/22
 * File Owner: Julian Sanchez
 * Date Last Updated:
 * Description:
 */
public class SecretWord {
	
	//Properties
	String actualWord;
	
	//construct
	public SecretWord(String word) {
		actualWord = word;
	}
	
	//Methods
	public boolean containsLetter(String letter) {
		
		boolean valid;
		
		valid = actualWord.contains(letter);
		
		return valid;
	}
	
	public boolean hasLettersRemaining() {
		
		boolean remain;
		
		
		
		
		return remain;
	}
}
