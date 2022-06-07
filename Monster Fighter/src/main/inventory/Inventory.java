package main.inventory;

import java.util.ArrayList;

import main.item.Food;
import main.item.Item;
import main.item.Potion;
import main.monster.Monster;

/**
 * This class is used to create an inventory that the player could
 * access.
 *
 */
public class Inventory {
	
	/**
	 * Monsters in player's inventory.
	 */
	private ArrayList<Monster> monsterList;
	
	/**
	 * Food in player's inventory.
	 */
	private ArrayList<Food> foodList;
	
	/**
	 * Potions in player's inventory.
	 */
	private ArrayList<Potion> potionList;
	
	/**
	 * Amount of gold the player has.
	 */
	private int gold;
	
	/**
	 * The constructor for Inventory.
	 */
	public Inventory() {
		monsterList = new ArrayList<Monster>();
		foodList = new ArrayList<Food>();
		potionList = new ArrayList<Potion>();
		gold = 200;
	}
	
	/**
	 * Gets amount of gold player has in inventory.
	 * @return the player's {@link gold} amount
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * Gets all monsters in player's inventory.
	 * @return the player's {@link monsterList}
	 */
	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}
	
	/**
	 * Gets specific monster from player's inventory based on {@link monsterList} index.
	 * @param index the index of where monster is in player's monsterList
	 * @return the {@link Monster} from inventory
	 */
	public Monster getMonster(int index) {
		return monsterList.get(index);
	}
	
	/**
	 * Gets all food in player's inventory.
	 * @return the player's {@link foodList}
	 */
	public ArrayList<Food> getFoodList() {
		return foodList;
	}
	
	/**
	 * Gets all potions in player's inventory.
	 * @return the player's {@link potionList}
	 */
	public ArrayList<Potion> getPotionList() {
		return potionList;
	}
	
	/**
	 * Adds an amount of gold to player's gold amount.
	 * @param num amount of gold to add
	 */
	public void addGold(int num) {
		gold += num;
	}
	
	/**
	 * Adds monster to player's inventory.
	 * Subtracts cost of monster from player's gold.
	 * @param monster the monster to add to inventory
	 * @param cost amount of gold the monster costs
	 */
	public void addMonster(Monster monster, int cost) {
		if (monsterList.size()<4) {
			if (gold >= cost) {
				gold -= cost;
				monsterList.add(monster);
			}
			
			else {
				throw new InsufficientGoldException("Not enough gold to buy monster!");
			}
		}
		
		else {
			throw new MonsterCapacityReachedException("You can't have more than 4 monsters!");}
		}
	
	/**
	 * Adds food to player's inventory.
	 * Subtracts cost of food from player's gold.
	 * @param food the food to add to inventory
	 * @param cost amount of gold the food item costs
	 */
	public void addFood(Food food, int cost) {
		if (gold >= cost) {
			gold -= cost;
			foodList.add(food);
		}
		else {
			throw new InsufficientGoldException("Not enough gold to buy food!");
		}
	}
	
	/**
	 * Adds potion to player's inventory.
	 * Subtracts cost of potion from player's gold.
	 * @param potion the potion to add to inventory
	 * @param cost amount of gold the potion costs
	 */
	public void addPotion(Potion potion, int cost) {
		if (gold >= cost) {
			gold -= cost;
			potionList.add(potion);
		}
		else {
			throw new InsufficientGoldException("Not enough gold to buy potion!");
		}
	}
	
	/**
	 * Removes monster from player's inventory.
	 * Adds price of monster to player's gold.
	 * @param monster the monster to be removed from inventory
	 * @param income amount of gold the player will earn from selling monster
	 */
	public void removeMonster(Monster monster, int income) {
		gold += income;
		monsterList.remove(monster);
	}
	
	/**
	 * Removes food from player's inventory.
	 * Adds price of food to player's gold.
	 * @param food the food to be removed from inventory
	 * @param income amount of gold the player will earn from selling food
	 */
	public void removeFood(Food food, int income) {
		gold += income;
		foodList.remove(food);
	}
	
	/**
	 * Removes potion from player's inventory.
	 * Adds price of potion to player's gold.
	 * @param potion the potion to be removed from inventory
	 * @param income amount of gold the player will earn from selling potion
	 */
	public void removePotion(Potion potion, int income) {
		gold += income;
		potionList.remove(potion);
	}
	
	/**
	 * Gets the number of monsters in the player's inventory.
	 * @return the number of monsters in {@link monsterList}
	 */
	public int getNumOfMonsters() {
		return monsterList.size();
	}
	
	/**
	 * Gets whether the player has an item in their inventory.
	 * @param name the name of the item
	 * @return boolean true if item in inventory, false otherwise
	 */
	public boolean hasItem(String name){ 
		for (Item item: potionList){ 
			if (item.getItemName() == name){ 
				return true; 
			}
		}
		
		for (Item item: foodList){ 
			if (item.getItemName() == name){ 
				return true; 
			}
		}
		return false;
	} 
	
	/**
	 * Gets food item from inventory.
	 * @param name the name of the food
	 * @return the {@link Food} item
	 */
	public Food getFood(String name){ 
		for (Food item: foodList){ 
			if (item.getItemName() == name){ 
				return item; 
			}
		}
		return null;
	} 
	
	/**
	 * Gets potion item from inventory.
	 * @param name the name of the potion
	 * @return the {@link Potion} item
	 */
	public Potion getPotion(String name){ 
		for (Potion item: potionList){ 
			if (item.getItemName() == name){ 
				return item; 
			}
		}
		return null;
	} 

}
