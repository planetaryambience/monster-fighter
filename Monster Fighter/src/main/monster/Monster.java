package main.monster;

import main.inventory.Inventory;
import main.inventory.Purchasable;

/**
 * Monster class.
 * Represents a monster that the player can interact with.
 */

public abstract class Monster implements Purchasable {
	
	/**
	 * The name of a monster.
	 */
	private String monsterName;
	
	/**
	 * Description for a monster.
	 */
	private String monsterDescription;
	
	/**
	 * The type of the monster.
	 */
	private String monsterType;
	
	/**
	 * Maximum health a monster can have.
	 */
	private int monsterMaxHealth;
	
	/**
	 * Current health of a monster.
	 */
	private int monsterHealth;
	
	/**
	 * Amount that monster can heal.
	 */
	private int monsterHealAmount;
	
	/**
	 * Amount of damage monster can do.
	 */
	private int monsterDamage;
	
	/**
	 * What level the monster is.
	 */
	private int monsterLevel = 10;
	
	/**
	 * The buy price of a monster.
	 */
	private int buyPrice;
	
	/**
	 * The sell price of a monster.
	 */
	private int sellPrice;
	
	/**
	 * The chance of a monster to leave the team overnight.
	 */
	private int monsterLeaveTeamChance = 1;
	
	/**
	 * If the current monster has died.
	 * true if monster is dead, false otherwise.
	 */
	private boolean isFainted = false;
	
	/**
	 * If the current monster is defending
	 * true if monster is defending, false otherwise.
	 */
	private boolean isDefending = false;
	
	/**
	 * The constructor of Monster.
	 * 
	 * @param name name of monster
	 * @param type type of monster
	 * @param maxHealth maximum health of monster
	 * @param damage amount of monster deals
	 * @param healAmount amount monster heals
	 */
	public Monster(String name, String type, int maxHealth, int damage, int healAmount) {
		monsterName = name;
		monsterType = type;
		monsterMaxHealth = maxHealth;
		monsterHealth = maxHealth;
		monsterDamage = damage;
		monsterHealAmount = healAmount;
	}
	
	/**
	 * Gets the monster's name.
	 * @return the {@link monsterName}
	 */
	public String getMonsterName() {
		return monsterName;
	}
	
	/**
	 * Gets the monster type.
	 * @return the {@link monsterType}
	 */
	public String getMonsterType() {
		return monsterType;
	}
	
	/**
	 * Gets the monster's current health.
	 * @return the {@link monsterHealth}
	 */
	public int getMonsterHealth() {
		return monsterHealth;
	}
	
	/**
	 * Gets the monster's maximum health.
	 * @return the {@link monsterMaxHealth}
	 */
	public int getMonsterMaxHealth() {
		return monsterMaxHealth;
	}
	
	/**
	 * Gets the monster's damage amount.
	 * @return the {@link monsterDamage} amount
	 */
	public int getMonsterDamageAmount() {
		return monsterDamage;
	}
	
	/**
	 * Gets the monster's heal amount.
	 * @return the {@link monsterHealAmount}
	 */
	public int getMonsterHealAmount() {
		return monsterHealAmount;
	}
	
	/**
	 * Gets the monster's current level.
	 * @return the {@link monsterLevel}
	 */
	public int getMonsterLevel() {
		return monsterLevel;
	}
	
	/**
	 * Gets whether monster is alive or dead.
	 * @return {@link isFainted}
	 */
	public boolean getIsFainted() {
		return isFainted;
	}
	
	
	
	/**
	 * Gets the monster's description.
	 * @return the {@link monsterDescription}
	 */
	public String getMonsterDescription() {
		return monsterDescription;
	}
	
	/**
	 * Gets buy price of monster.
	 * @return the {@link buyPrice} of the monster
	 */
	public int getBuyPrice() {
		return buyPrice;
	}
	
	/**
	 * Gets sell price of monster.
	 * @return the {@link sellPrice} of the monster
	 */
	public int getSellPrice() {
		return sellPrice;
	}
	
	/**
	 * Gets the chance of a monster leaving the team.
	 * @return the chance of monster leaving the team.
	 */
	public int getMonsterLeaveTeamChance() {
		return monsterLeaveTeamChance;
	}
	
	/**
	 * Gets information on a monster.
	 * @return A string representation of a Monster with the following format:<br>
	 * {@link monsterName} (level {@link  monsterLevel})<br>
	 * Type: {@link monsterType}<br>
	 * Current Health: {@link monsterHealth}/{@link monsterMaxHealth}<br>
	 * Attack: {@link monsterDamage}<br>
	 * Heal: {@link monsterHealAmount}<br>
	 * {@link  monsterDescription}
	 */
	public String getMonsterInfo() {
		return String.format("%s (level %d)\nType: %s"
				+ "\nCurrent Health: %d/%d\nAttack: %d\nHeal: %d\n\n%s",
				monsterName, monsterLevel, monsterType, monsterHealth,
				monsterMaxHealth, monsterDamage, monsterHealAmount, monsterDescription);
	}
	
	/**
	 * Gets monster stats.
	 * Formatted for using in GUI.
	 * @return A string representation of the monsters stats
	 */
	public String monsterBattleStats() {
		String stats = String.format("<html>%s<br>\"%s\"<br>Level: %d<br>%d / %d HP<br>Attack: %d<br>Heal: %d<br>Defending: %b", 
				monsterName, monsterType, monsterLevel, monsterHealth, monsterMaxHealth, monsterDamage, monsterHealAmount, isDefending);
		return stats;
	}
	
	/**
	 * Alternative monster info that includes its buy price.
	 * Used for ShopWindow.
	 * @return A string representation of a Monster with the following format: <br>
	 * {@link monsterName}<br>
	 * Health: {@link monsterHealth}<br>
	 * Attack: {@link monsterDamage}<br>
	 * Heal: {@link monsterHealAmount}<br>
	 * Buy Price: {@link buyPrice}
	 */
	public String altMonsterInfo() {
		return String.format("%s\nHealth: %d\nAttack: %d\nHeal: %d\nBuy Price: %d", 
				monsterName, monsterHealth, monsterDamage, monsterHealAmount, buyPrice);
	}
	
	/**
	 * Sets custom monster name.
	 * @param name custom monster name by player
	 */
	public void setMonsterName(String name) {
		monsterName = name;
	}
	
	/**
	 * Sets monster's level and updates monster's stats.
	 * @param level the level of the monster
	 */
	public void setMonsterLevel(int level) {
		monsterLevel = level;
		this.maxHealthBoost(level-10);
		this.damageBoost((int)(level-10)/8);
		this.maxHealthBoost((int)(level-10)/8);
		this.healAmountBoost((int)(level-10)/8);
		this.heal(level-10);
		this.heal((int)(level-10)/8);
		if (getMonsterType() == "Heavy Tank" || getMonsterType() == "Light Tank") {
			this.maxHealthBoost((level-10)/4);
			this.heal((level-10)/4);
		}
		else if (getMonsterType() == "Single Target Damage Dealer" || getMonsterType() == "Range Damage Dealer") {
			this.damageBoost((level-10)/4);
		}
		else if (getMonsterType() == "Single Target Healer" || getMonsterType() == "Mass Healer") {
			this.healAmountBoost((level-10)/4);
		}
	}
	
	/**
	 * Sets a description for monster.
	 * @param description description of what monster looks like
	 */
	public void setDescription(String description) {
		monsterDescription = description;
	}
	
	/**
	 * Sets if monster is defending.
	 * @param value true if defending, false if not defending
	 */
	public void setIsDefending(boolean value) {
		isDefending = value;
	}
	
	/**
	 * Attacks targetMonster, dealing amount of damage specific to the attacking monster.
	 * @param targetMonster the monster that will be attacked
	 */
	public void attack(Monster targetMonster) {
		targetMonster.takeDamage(monsterDamage);
	}
	
	
	/**
	 * Heals current monster.
	 * A monster's health after a heal() cannot exceed monster's maximum health
	 * 
	 * @param healAmount the amount a monster will heal
	 */	
	public void heal(int healAmount) {
		int health = monsterHealth + healAmount;
		
		if (health >= monsterMaxHealth) {
			monsterHealth = monsterMaxHealth;
		}
		else {
			monsterHealth = health;
		}
	}
	
	/**
	 * Revives current monster.
	 */
	public void revive() {
		isFainted = false;
	}
	
	
	/**
	 * Current monster takes damage.
	 * @param damageTaken amount of damage taken
	 */
	public void takeDamage(int damageTaken) {
		
		if (isDefending == true) {
			if (getMonsterType() == "Heavy Tank"){
				damageTaken *= 0.4;
			}
			else if (getMonsterType() == "Light Tank"){
				damageTaken *= 0.6;
			}
			else {
				damageTaken *= 0.8;
			}
			setIsDefending(false);
		}

		int health = monsterHealth - damageTaken;

		if (health <= 0) {
			isFainted = true;
			monsterHealth = 0;
		}
		else {
			monsterHealth = health;
		}
	}
	
	/**
	 * Increases the monster's amount of damage that can be dealt.
	 * @param boost amount to increase monster's damage amount
	 */
	public void damageBoost(int boost) {
		monsterDamage += boost;
	}
	
	/**
	 * Increases the monster's amount of heal that can be dealt.
	 * @param boost amount to increase monster's heal amount
	 */
	public void healAmountBoost(int boost) {
		monsterHealAmount += boost;
	}
	
	/**
	 * Increases the monster's maximum health.
	 * @param boost amount to increase monster's maximum health
	 */
	public void maxHealthBoost(int boost) {
		monsterMaxHealth += boost;
	}

	/**
	 * Increases the monsters stats by 1.3%.
	 * Used by opponent's monsters when player selected 'hard' difficulty.
	 */
	public void hardDiffBoost() {
		this.monsterMaxHealth = (int) (monsterMaxHealth*1.3);
		this.monsterHealth = (int) (monsterHealth*1.3);
		this.monsterDamage = (int) (monsterDamage*1.3);
		this.monsterHealAmount = (int) (monsterHealAmount*1.3);
	}
	
	/**
	 * Increases the chance of a monster leaving by 1.
	 */
	public void addMonsterLeaveTeamChance() {
		this.monsterLeaveTeamChance += 1;
	}
	
	@Override
	public void setBuyAndSellPrices(int price) {
		buyPrice = price;
		sellPrice = price * 3 / 4;
	}
	
	@Override
	public void buyIn(Inventory inventory, int cost) {
		inventory.addMonster(this, cost);
	}

	@Override
	public void sellOut(Inventory inventory, int income) {
		inventory.removeMonster(this, income);
	}

	@Override
	public String toString() {
		return monsterName;
	}
}
