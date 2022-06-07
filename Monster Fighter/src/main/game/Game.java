package main.game;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.*;
import gui.setup.SetupDaysWindow;
import main.actor.Player;
import main.inventory.Inventory;
import main.monster.HeavyTank;
import main.monster.LightTank;
import main.monster.MassHealer;
import main.monster.Monster;
import main.monster.RangeDamageDealer;
import main.monster.SingleTargetDamageDealer;
import main.monster.SingleTargetHealer;

/**
 * Main game manager.
 */
public class Game {
	
	/**
	 * Launches a {@link MainMenuWindow}
	 */
	public void launchMainMenu() {
		MainMenuWindow mainMenu = new MainMenuWindow();
	}
	
	/**
	 * Closes SetupDaysWindow
	 * @param setupWin the {@link SetupDaysWindow} currently open
	 * @param player the {@link Player}
	 */
	public void closeSetupDays(SetupDaysWindow setupWin, Player player) {
		setupWin.closeWindow();
		launchOpeningDialogue(player);
	}
	
	/**
	 * Launches a {@link OpeningDialogueWindow}
	 * @param player the {@link Player}
	 */
	public void launchOpeningDialogue(Player player) {
		OpeningDialogueWindow opening = new OpeningDialogueWindow(player);
	}
	
	/**
	 * Launches a {@link MainGameWindow}
	 * @param player the {@link Player}
	 * @param inventory the player's {@link Inventory} 
	 */
	public static void launchMainGame(Player player, Inventory inventory) {
		MainGameWindow mainGame = new MainGameWindow(player, inventory);
	}
	
	/**
	 * Random events that can occur.
	 * @param window the JFrame window
	 * @param player  the player
	 * @param inventory the player's inventory
	 */
	public static void randomEvents(JFrame window, Player player, Inventory inventory) {
		Random rand = new Random();
		
		for (Monster monster : inventory.getMonsterList()) {
			int chance3 = rand.nextInt(100);
			if (chance3 < monster.getMonsterLeaveTeamChance()) {
				inventory.removeMonster(monster, 0);
				JOptionPane.showMessageDialog(window, monster.getMonsterName()+" has left your team!");
				break;
			}
		}

		for (Monster monster : inventory.getMonsterList()) {
			int chance2 = rand.nextInt(100);
			if (chance2 < 20) {
				monster.setMonsterLevel(monster.getMonsterLevel()+2);
				JOptionPane.showMessageDialog(window, monster.getMonsterName()+" has gained 2 levels!");
			}
			else if (chance2 < 40) {
				monster.setMonsterLevel(monster.getMonsterLevel()+1);
				JOptionPane.showMessageDialog(window, monster.getMonsterName()+" has gained 1 level!");
			}
		}
		
		int chance = rand.nextInt(100);
		if (chance == 99) {
			inventory.addMonster(new HeavyTank(), 0);
			JOptionPane.showMessageDialog(window, "Cerberus has joined your team!");
		}
		else if (chance == 98) {
			inventory.addMonster(new LightTank(), 0);
			JOptionPane.showMessageDialog(window, "Eligor has joined your team!");
		}
		else if (chance == 97) {
			inventory.addMonster(new MassHealer(), 0);
			JOptionPane.showMessageDialog(window, "Bune has joined your team"
					+ "!");
		}
		else if (chance == 96) {
			inventory.addMonster(new RangeDamageDealer(), 0);
			JOptionPane.showMessageDialog(window, "Focalor has joined your team!");
		}
		else if (chance == 95) {
			inventory.addMonster(new SingleTargetDamageDealer(), 0);
			JOptionPane.showMessageDialog(window, "Labolas has joined your team!");
		}
		else if (chance == 94) {
			inventory.addMonster(new SingleTargetHealer(), 0);
			JOptionPane.showMessageDialog(window, "Vapula has joined your team!");
		}
	}
	
	
	/**
	 * Runs the game...
	 * @param args arguments
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.launchMainMenu();
	}
}
