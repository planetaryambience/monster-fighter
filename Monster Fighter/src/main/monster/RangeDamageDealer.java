package main.monster;

import java.util.ArrayList;

/**
 * Range Damage Dealer class.
 * Represents a monster of Range Damage Dealer type.
 * Extends {@link Monster}.
 */

public class RangeDamageDealer extends Monster {

	/**
	 * The constructor for Range Damage Dealer.
	 */
	public RangeDamageDealer() {
		super("Focalor", "Range Damage Dealer", 80, 22, 8);
		setDescription("\"I love to AoE damage my enemies lol.\"");
		setBuyAndSellPrices(120);
	}
	
	/**
	 * Attacks every monster on enemy team by Range Damage Dealer's damage amount.
	 * 
	 * @param enemyTeam array list of the enemy team
	 */
	public void rangeAttack(ArrayList<Monster> enemyTeam) {
		for (Monster monster: enemyTeam) {
			monster.takeDamage(this.getMonsterDamageAmount());
		}
	}
	
}
