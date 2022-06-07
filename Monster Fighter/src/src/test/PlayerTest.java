package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.actor.Player;

/**
 * JUnit tests for Player class.
 */
public class PlayerTest {

	/**
	 * Tests a Player is instantiated with expected values.
	 */
	@Test
	public void testPlayer() {
		Player testPlayer1 = new Player("player One", "normal", 5);
		assertEquals("player One", testPlayer1.getPlayerName());
		assertEquals("normal", testPlayer1.getGameDifficulty());
		assertEquals(5, testPlayer1.getNumOfDays());
		
		testPlayer1.addScore(10);
		assertEquals(10, testPlayer1.getGameScore());
		
		testPlayer1.addDay();
		assertEquals(2, testPlayer1.getCurrentDay());
	}
}
