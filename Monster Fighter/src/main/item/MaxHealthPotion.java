package main.item;

import main.monster.Monster;

/**
 * Max Health class.
 * Represents a Max Health potion.
 * Extends {@link Potion}.
 */
public class MaxHealthPotion extends Potion {
	
	/**
	 * The constructor for MaxHealthPotion
	 */
	public MaxHealthPotion() {
		setItemName("Max Health Potion");
		setItemDescription("A magical potion that restores a\nmonster's health to its maximum.");
		setBuyAndSellPrices(80);
	}

	/**
	 * Heals the monster to its full health.
	 */
	@Override
	public void useItem(Monster monster) {
		monster.heal(monster.getMonsterMaxHealth());
	}
}
