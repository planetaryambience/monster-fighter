package main.monster;

import java.util.ArrayList;

/**
 * Mass Healer class.
 * Represents a monster of Mass Healer type.
 * Extends {@link Monster}.
 */

public class MassHealer extends Monster {
	
	/**
	 * The constructor for MassHealer.
	 */
	public MassHealer() {
		super("Bune", "Mass Healer", 75, 10, 16);
		setDescription("\"I always wondered why I was a scorpion.\n"
				+ "Just like why you were a human.\"");
		setBuyAndSellPrices(92);
	}
	
	/**
	 * Heals entire team by MassHealer's heal amount.
	 * 
	 * @param allyTeam array list of player's current monsters
	 */
	public void massHeal(ArrayList<Monster> allyTeam) {
		for (Monster monster: allyTeam) {
			if (!monster.getIsFainted()) {
				monster.heal(this.getMonsterHealAmount());
			}
		}
	}

}
