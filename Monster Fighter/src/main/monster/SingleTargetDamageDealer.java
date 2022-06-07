package main.monster;

/**
 * Single Target Damage Dealer class.
 * Represents a monster of Single Target Damage Dealer type.
 * Extends {@link Monster}.
 */

public class SingleTargetDamageDealer extends Monster {
	
	/**
	 * The constructor for Single Target Damage Dealer.
	 */
	public SingleTargetDamageDealer() {
		super("Labolas", "Single Target Damage Dealer", 100, 50, 10);
		setDescription("\"Have you seen my puppy?\n"
				+ "I think he's got three heads.\"");
		setBuyAndSellPrices(88);
	}
}
