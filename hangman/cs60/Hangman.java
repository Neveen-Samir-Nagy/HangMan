package eg.edu.alexu.csd.datastructure.hangman.cs60;

import java.util.Random;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * .
 *
 * @author EL-hamd
 *
 */
public class Hangman implements IHangman {

	/**
	 * .
	 *
	 * Array
	 */
	private String randomword = "", secretword = "";

	/**
	 * .
	 *
	 * Integers
	 */
	private int max1, count = 0, i = 0, size = -1, flag3 = 0, flag = 0;

	/**
	 * .
	 *
	 * String
	 */
	private String[] words2, words1;

	/**
	 * .
	 *
	 * File
	 */
	private File file = new File("c://temp//testFile1.txt");

	/**
	 * . func
	 *
	 * @param s
	 *            first
	 * @param pos
	 *            second
	 * @param c
	 *            third
	 * @return the string
	 */
	public static
	String replaceCharAt(final String s,
			final int pos,
			final char c) {
		return s.substring(0, pos) + c + s.substring(pos + 1);
	}

	/**
	 * . read
	 *
	 * @return file
	 */
	public String[] readfile() {
		try {
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append(":");
			}
			br.close();
			fr.close();
			String f = stringBuffer.toString();
			words1 = f.split(":");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return words1;
	}

	@Override
	public final void setDictionary(final String[] words) {
		// TODO Auto-generated method stub
		words2 = words;
	}

	@Override
	public final String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (words2 == null || words2.length == 0) {
			return null;
		}
		final Random x = new Random();
		int number = x.nextInt(words2.length);
		flag3 = 1;
		randomword = words2[number];
		return randomword;
	}

	@Override
	public final String guess(final Character c) throws Exception {
		// TODO Auto-generated method stub
		if (flag3 == 0) {
			throw new RuntimeException();
		}
		if (randomword.charAt(0) == ' ' || randomword.length() == 0) {
			throw new RuntimeException();
		}
		if (count == 0 && max1 == 0) {
			throw new RuntimeException();
		} else if (max1 == 0) {
			return null;
		}
		if (count == 0) {
			for (i = 0; i < randomword.length(); i++) {
				secretword = secretword + "-";
				count = 1;
			}
			size = randomword.length();
		}
		if (c == null) {
			return secretword;
		}
		if (Character.isLetter(c)) {
			char f = Character.toLowerCase(c);
			String checkword = randomword;
			String word2 = secretword.toLowerCase();
			checkword = checkword.toLowerCase();
			flag = 0;
			for (i = 0; i < randomword.length(); i++) {
				if (f == word2.charAt(i)) {
					return secretword;
				}
			}
			for (i = 0; i < randomword.length(); i++) {
				if ((f == checkword.charAt(i))) {
					flag = 1;
					size--;
					char e = randomword.charAt(i);
					secretword =
							replaceCharAt(
									secretword,
									i,
									randomword.
									charAt(i));
				}
			}
			if (flag == 0) {
				max1--;
			}
			if (max1 == 0) {
				return null;
			} else if (flag == 1 && size == 0) {
				return secretword;
			} else if (flag == 0 && size == 0) {
				return null;
			}
		}
		if (c == null) {
			return secretword;
		} else {
			return secretword;
		}
	}

	@Override
	public final void setMaxWrongGuesses(final Integer max) {
		if (max == null) {
			max1 = 1;
		} else {
			max1 = max;
		}
	}
}
