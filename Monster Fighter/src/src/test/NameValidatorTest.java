package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import main.game.NameValidator;

/**
 * JUnit tests for NameValidator class.
 */
public class NameValidatorTest {
	
	/**
	 * Tests NameValidator returns expected value.
	 */
	@Test
	public void testIsValidPlayerName() {
		
		assertEquals(false, NameValidator.isValidPlayerName(""));
		assertEquals(false, NameValidator.isValidPlayerName(" "));
		
		assertEquals(false, NameValidator.isValidPlayerName("1"));
		assertEquals(false, NameValidator.isValidPlayerName("!@#"));
		assertEquals(false, NameValidator.isValidPlayerName("pl4y3r"));
		
		assertEquals(true, NameValidator.isValidPlayerName("player"));
		assertEquals(true, NameValidator.isValidPlayerName("best monster"));
		assertEquals(true, NameValidator.isValidPlayerName("name"));
	}

}
