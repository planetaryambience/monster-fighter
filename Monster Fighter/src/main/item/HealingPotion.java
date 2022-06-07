package main.item;

import main.monster.Monster;

/**
 * Healing Potion class.
 * Represents a Healing potion.
 * Extends {@link Potion}.
 */

public class HealingPotion extends Potion {
	
	/**
	 * The constructor for HealingPotion
	 */
	public HealingPotion() {
		setItemName("Healing Potion");
		setItemDescription("Heals 40HP of a monster.");
		setBuyAndSellPrices(60);
	}

	/**
	 * Heals the monster by 40HP.
	 */
	@Override
	public void useItem(Monster monster) {
		monster.heal(40);
	}
}
