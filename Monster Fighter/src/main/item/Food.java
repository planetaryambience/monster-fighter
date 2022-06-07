package main.item;

import main.inventory.Inventory;

/**
 * Food class.
 * Represents an item that is a type of food.
 * 
 * Extends {@link Item}.
 */

public abstract class Food extends Item {
	
	/**
	 * The constructor for Food.
	 */
	public Food() {
		setItemType("Food");
	}

	@Override
	public void buyIn(Inventory inventory, int cost) {
		inventory.addFood(this, cost);
	}

	@Override
	public void sellOut(Inventory inventory, int income) {
		inventory.removeFood(this, income);
	}
}
