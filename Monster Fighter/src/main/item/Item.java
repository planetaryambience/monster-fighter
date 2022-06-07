package main.item;

import main.inventory.Purchasable;
import main.monster.Monster;

/**
 * Item class.
 * Represents an item that the player can interact with.
 */

public abstract class Item implements Purchasable {
	
	/**
	 * Name of item.
	 */
	private String itemName;
	
	/**
	 * Type of item.
	 */
	private String itemType;
	
	/**
	 * Item description.
	 */
	private String itemDescription;
	
	/**
	 * Amount of gold an item costs to buy.
	 */
	private int buyPrice;
	
	/**
	 * Amount of gold an item can sell for.
	 */
	private int sellPrice;
	
	/**
	 * Sets item type.
	 * @param type the item type
	 */
	public void setItemType(String type) {
		itemType = type;
	}
	
	/**
	 * Sets item name.
	 * @param name the name of the item
	 */
	public void setItemName(String name) {
		itemName = name;
	}
	
	/**
	 * Sets item description.
	 * @param description a description of the item
	 */
	public void setItemDescription(String description) {
		itemDescription = description;
	}
	
	@Override
	public void setBuyAndSellPrices(int BuyPrice) {
		buyPrice = BuyPrice;
		sellPrice = BuyPrice * 3 / 4;
	}
	
	/**
	 * Gets item name.
	 * @return the {@link itemName}
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * Gets item type.
	 * @return the {@link itemType}
	 */
	public String getItemType() {
		return itemType;
	}
	
	/**
	 * Gets buy price of an item.
	 * @return the {@link buyPrice}
	 */
	public int getBuyPrice() {
		return buyPrice;
	}
	
	/**
	 * Gets sell price of an item.
	 * @return the {@link sellPrice}
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Gets item description.
	 * @return the {@link itemDescription}
	 */
	public String getItemDescription() {
		return itemDescription;
	}
	
	/**
	 * Gets item information in the format:
	 * 
	 * @return String with item information with the format:<br>
	 * {@link itemName}<br>
	 * ItemType: {@link itemType}<br>
	 * {@link itemDescription}
	 */
	public String getItemInfo() {
		return String.format("%s\nItem Type: %s\n%s", itemName, itemType, itemDescription);
	}
	
	/**
	 * Abstract method.
	 * Use case of item differs depending on item.
	 * @param monster the monster that will use the item
	 */
	public abstract void useItem(Monster monster);
	
	
	@Override
	public String toString() {
		return itemName;
	}
}
