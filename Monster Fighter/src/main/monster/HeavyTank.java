package main.monster;

/**
 * Heavy Tank class.
 * Represents a monster of Heavy Tank type.
 * Extends {@link Monster}.
 */

public class HeavyTank extends Monster {
	
	/**
	 * The constructor for HeavyTank
	 */
	public HeavyTank() {
		super("Cerberus", "Heavy Tank", 200, 20, 6);
		setDescription("\"Woof woof woof.\"");
		setBuyAndSellPrices(108);
	}

}
