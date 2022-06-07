package main.inventory;

/**
 * Insufficient Gold Exception class.
 * Represents the exception that will be thrown if player doesn't have enough gold for a purchase.
 */
public class InsufficientGoldException extends IllegalArgumentException {
	
	/**
	 * Constructor for InsufficientGoldException.
	 * @param message message that will be shown when exception occurs
	 */
	public InsufficientGoldException(String message) {
		super(message);
	}
}
