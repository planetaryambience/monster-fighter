package main.inventory;

/**
 * Monster Capacity Reached Exception class.
 * Represents the exception that will be thrown when the player tries to buy a monster when they already have four in their inventory.
 */
public class MonsterCapacityReachedException extends IllegalArgumentException {
	
	/**
	 * Constructor for MonsterCapacityReachedException.
	 * @param message message that will be shown when exception occurs
	 */
	public MonsterCapacityReachedException(String message) {
		super(message);
	}
}
