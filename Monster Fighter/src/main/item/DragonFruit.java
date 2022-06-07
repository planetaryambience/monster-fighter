package main.item;

import main.monster.Monster;

/**
 * Dragon Fruit class.
 * Represents Dragon Fruit food item.
 * Extends {@link Food}.
 */

public class DragonFruit extends Food {
	
	/**
	 * The constructor for DragonFruit.
	 */
	public DragonFruit() {
		setItemName("Dragon Fruit");
		setItemDescription("It does look like a dragon.\n"
				+ "Effect: Boosts your monster's max health by 20HP.");
		setBuyAndSellPrices(56);
	}

	/**
	 * Using the item will increase the monster's max health.
	 */
	@Override
	public void useItem(Monster monster) {
		monster.maxHealthBoost(20);
	}

}
