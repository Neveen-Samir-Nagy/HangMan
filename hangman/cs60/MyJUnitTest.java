package eg.edu.alexu.csd.datastructure.hangman.cs60;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
import eg.edu.alexu.csd.datastructure.iceHockey.cs60.IceHockey;

/**.
 * test
 * @author EL-hamd
 *
 */

public class MyJUnitTest {

	/**.
	 * test
	 */

    @Test
    public void iceHockeyTest() {
        IPlayersFinder playersFinder = new IceHockey();
        final String[] photo = {
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"};
		final int team = 4;
		final int threshold = 16;
		Point[] returnedPoints;
		returnedPoints = playersFinder.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(3, 8),
				new Point(4, 16),
				new Point(5, 4),
				new Point(16, 3),
				new Point(16, 17),
				new Point(17, 9)};
		Assert.assertArrayEquals(
		ans, returnedPoints);
    }

    /**.
     * test1
     */
    @Test
    public void hangmanTest() {
        try {
            IHangman hangman = new Hangman();
            String[] dictionary = new String[] {"EGYPT"};
            hangman.setDictionary(dictionary);
            hangman.selectRandomSecretWord();
            hangman.setMaxWrongGuesses(2);
            Assert.assertEquals("--Y--", hangman.guess('Y'));
        } catch (Exception e) {
            System.err.println("Failed to complete the test");
            e.printStackTrace();
        }
    }
}
