package main.monster;

/**
 * Light Tank class. Represents a monster of Light Tank type.
 * Extends {@link Monster}.
 */
public class LightTank extends Monster {
	
	/**
	 * The constructor for LightTank.
	 */
	public LightTank() {
		super("Eligor", "Light Tank", 150, 25, 6);
		setDescription("\"Woof.\"");
		setBuyAndSellPrices(76);
	}
	
}
