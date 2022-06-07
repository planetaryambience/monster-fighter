package main.item;

import main.monster.Monster;

/**
 * Chicken Breast class.
 * Represents Chicken Breast food item.
 * Extends {@link Food}.
 */

public class ChickenBreast extends Food {
	
	/**
	 * The constructor for ChickenBreast.
	 */
	public ChickenBreast() {
		setItemName("Chicken Breast");
		setItemDescription("Great bulk food that makes\nyour monster STRONGER!\n"
				+ "Effect: Boosts your monster's damage by 10P.");
		setBuyAndSellPrices(68);
	}

	/**
	 * Using the item will increase the monster's damage amount by 10 points.
	 */
	@Override
	public void useItem(Monster monster) {
		monster.damageBoost(10);
	}

}
