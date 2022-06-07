package main.item;

import main.inventory.Inventory;

/**
 * Potion class.
 * Represents an item that is a potion.
 * 
 * Extends {@link Item}.
 */
public abstract class Potion extends Item {
	
	/**
	 * The constructor for Potion.
	 */
	public Potion() {
		setItemType("Potion");
	}

	@Override
	public void buyIn(Inventory inventory, int cost) {
		inventory.addPotion(this, cost);
	}

	@Override
	public void sellOut(Inventory inventory, int income) {
		inventory.removePotion(this, income);
	}
}
