package main.monster;

/**
 * Single Target Healer class
 * Represents a monster of Single Target Healer type.
 * Extends {@link Monster}.
 */

public class SingleTargetHealer extends Monster {
	
	/**
	 * The constructor of Single Target Healer.
	 */
	public SingleTargetHealer() {
		super("Vapula", "Single Target Healer", 80, 10, 40);
		setDescription("\"Dude where is this place?\n"
				+ "Was I iseikai'd?\"");
		setBuyAndSellPrices(92);
	}

}
