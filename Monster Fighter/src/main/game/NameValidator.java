package main.game;

/**
 * Contains method that will validate a player's name.
 */
public class NameValidator {
	
	/**
	 * Checks if player's name is valid.
	 * @param name the player's name
	 * @return if player name only contains letters and is a length of between 3 and 15 then returns true, otherwise returns false
	 */
	public static boolean isValidPlayerName(String name) {
		// uses regex ([a-zA-Z\\s]+) to check that name has one or more letters only, spaces between letters accepted.
		if (3 <= name.length() && name.length() <= 15 && name.matches("[a-zA-Z\\s]+") && !name.isBlank()) {
			return true;
		}
		else {
			return false;
		}
	}
}
