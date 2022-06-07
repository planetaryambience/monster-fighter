package main.actor;

import main.inventory.Inventory;
import main.monster.HeavyTank;
import main.monster.LightTank;
import main.monster.MassHealer;
import main.monster.Monster;
import main.monster.RangeDamageDealer;
import main.monster.SingleTargetDamageDealer;
import main.monster.SingleTargetHealer;

import java.util.ArrayList;
import java.util.Random;

/**
 * Opponent class.
 * Represents an opponent that the player can battle with.
 */

public class Opponent {
	/**
	 * An array with Monster objects.
	 * The opponent's team of monsters that will go into battle.
	 */
	private ArrayList<Monster> opponentMonsterList = new ArrayList<Monster>();
	
	 /**
	 * Generates a battle team for the player's opponent according to how many monsters the player has.
	 * Uses a random number generator to determine the monster types in the team.
	 * @param inventory the player's {@link Inventory}
	 */
	public void generateOpponentBattleTeam(Inventory inventory) {
		Random rand = new Random();
		
		for (int i = 0; i < inventory.getNumOfMonsters(); i++) {
			int rNum = rand.nextInt(6);
			if (rNum == 0) {
				HeavyTank newMon = new HeavyTank();
				this.getOpponentMonsterList().add(newMon);
			}
			else if (rNum == 1) {
				LightTank newMon = new LightTank();
				this.getOpponentMonsterList().add(newMon);
			}
			else if (rNum == 2) {
				MassHealer newMon = new MassHealer();
				this.getOpponentMonsterList().add(newMon);
			}
			else if (rNum == 3) {
				SingleTargetDamageDealer newMon = new SingleTargetDamageDealer();
				this.getOpponentMonsterList().add(newMon);
			}
			else if (rNum == 4) {
				RangeDamageDealer newMon = new RangeDamageDealer();
				this.getOpponentMonsterList().add(newMon);
			}
			else if (rNum == 5) {
				SingleTargetHealer newMon = new SingleTargetHealer();
				this.getOpponentMonsterList().add(newMon);
			}
		}
	}
	
	/** 
	 * Calculates the opponent's level depending on the player's current day.
	 * @param player {@link Player}
	 * @return the opponent's level
	 */
	public int opponentLevel(Player player) {
		return player.getCurrentDay() * 4 + 6;
	}

	/**
	 * Gets the monster team of the opponent.
	 * @return {@link opponentMonsterList} the opponent's monsters
	 */
	public ArrayList<Monster> getOpponentMonsterList() {
		return opponentMonsterList;
	}

	
}
