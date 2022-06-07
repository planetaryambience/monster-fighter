package main.inventory;

/**
 * Purchasable interface.
 */

public interface Purchasable {
	/**
	 * Sets the buy and sell price of an item.
	 * The sell price is determined by the buy price.
	 * @param buyPrice how much the item costs to buy
	 */
	public void setBuyAndSellPrices(int buyPrice);
	
	/**
	 * Buys item and adds item to inventory.
	 * @param inventory the player's current {@link Inventory}
	 * @param cost how much money it costs to buy the item
	 */
	public void buyIn(Inventory inventory, int cost);
	
	/**
	 * Sells item and removes item from inventory.
	 * @param inventory the player's current {@link Inventory}
	 * @param income how much money player will get from selling the item
	 */
	public void sellOut(Inventory inventory, int income);
}
