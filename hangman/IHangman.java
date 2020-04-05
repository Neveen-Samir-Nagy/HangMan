package eg.edu.alexu.csd.datastructure.hangman;

import java.io.IOException;

public interface IHangman {
	/**
	 * Set the dictionary Note: You should implement another function which will
	 * read a file into array then call this function to set the dictionary.
	 * 
	 * @param words:
	 *            an array of words
	 */
	void setDictionary(String[] words);

	/**
	 * Pick a random secret word from the dictionary and returns it
	 * 
	 * @return secret word or null
	 */
	String selectRandomSecretWord();

	/**
	 * Receive a new user guess, and verify it against the secret word.
	 * 
	 * @param c
	 *            case insensitive user guess. If c is NULL then ignore it and do no
	 *            change
	 * @return secret word with the remaining hidden characters (use '-' instead of
	 *         unsolved characters), or return NULL if user reached max wrong
	 *         guesses.
	 */
	String guess(Character c) throws Exception;

	/**
	 * Set the maximum number of wrong guesses
	 * 
	 * @param max
	 *            maximum number of wrong guesses, If it is NULL, then assume it 1
	 */
	void setMaxWrongGuesses(Integer max);
}