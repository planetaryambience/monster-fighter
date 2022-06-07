package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.actor.Player;
import main.game.Game;
import main.inventory.Inventory;
import main.monster.Monster;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A window that displays the result of the battle after the player wins/loses.
 */
public class BattleResultWindow {

	/**
	 * BattleResultWindow frame.
	 */
	private JFrame windowBattleResult;
	
	/**
	 * If player won the game (true if won, otherwise false). 
	 */
	private boolean ifWon;
	
	/**
	 * Score gained after a game.
	 */
	private int scoreGained;
	
	/**
	 * Levels gained after a game.
	 */
	private int levelsGained;
	
	/**
	 * Gold gained after a game.
	 */
	private int goldGained;
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory;

	/**
	 * Creates the application.
	 * @param player the player
	 * @param inventory the player's inventory
	 * @param won if player won the game or not
	 * @param scoreGained the score gained from the game
	 * @param levelsGained the levels gained from the game
	 */
	public BattleResultWindow(Player player, Inventory inventory, boolean won, int scoreGained, int levelsGained) {
		initialize();
		windowBattleResult.setVisible(true);
		
		this.levelsGained = levelsGained;
		this.scoreGained = scoreGained;
		goldGained = inventory.getNumOfMonsters() * 30 + (15 - player.getCurrentDay());
		
		this.player = player;
		this.inventory = inventory;
		
		ifWon = won;
		JLabel lblYouWin = new JLabel("");
		lblYouWin.setIcon(new ImageIcon(BattleResultWindow.class.getResource("/img/YouWin(100).png")));
		lblYouWin.setBounds(10, 29, 564, 127);
		windowBattleResult.getContentPane().add(lblYouWin);
		
		JLabel lblYouLose = new JLabel("");
		lblYouLose.setIcon(new ImageIcon(BattleResultWindow.class.getResource("/img/YouLose(110).png")));
		lblYouLose.setBounds(34, 29, 528, 127);
		windowBattleResult.getContentPane().add(lblYouLose);
		
		JLabel lblLevelsGained = new JLabel();
		lblLevelsGained.setText("Monster Levels Gained: " + levelsGained);
		lblLevelsGained.setBounds(211, 164, 187, 21);
		windowBattleResult.getContentPane().add(lblLevelsGained);
		
		JLabel lblScoresGained = new JLabel();
		lblScoresGained.setText("Scores Gained: " + scoreGained);
		lblScoresGained.setBounds(235, 195, 142, 21);
		windowBattleResult.getContentPane().add(lblScoresGained);
		
		JLabel lblGoldGained = new JLabel();
		lblGoldGained.setText("Gold Gained: "+ goldGained);
		lblGoldGained.setBounds(245, 228, 134, 21);
		windowBattleResult.getContentPane().add(lblGoldGained);
		
		if (ifWon == true) {
			lblYouWin.setVisible(true);
			lblYouLose.setVisible(false);
		}
		else if (ifWon == false){
			lblYouWin.setVisible(false);
			lblYouLose.setVisible(true);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowBattleResult = new JFrame();
		windowBattleResult.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowBattleResult.setIconImage(Toolkit.getDefaultToolkit().getImage(BattleResultWindow.class.getResource("/img/Heart.png")));
		windowBattleResult.setResizable(false);
		windowBattleResult.setBounds(100, 100, 600, 350);
		windowBattleResult.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowBattleResult.getContentPane().setLayout(null);

		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventory.addGold(goldGained);
				player.addScore(scoreGained);
				
				for (Monster monster : inventory.getMonsterList()) {
					monster.setMonsterLevel(levelsGained + monster.getMonsterLevel());
					if (monster.getIsFainted() == true) {
						monster.revive();
						monster.addMonsterLeaveTeamChance();
					}
					
					monster.heal(50 + (player.getCurrentDay() * 2));
				}
				
				if (player.getCurrentDay() >= player.getNumOfDays()) {
					windowBattleResult.dispose();
					GameResultWindow gameEnd = new GameResultWindow(player, inventory);
				}
				else {
					player.addDay();
					JOptionPane.showMessageDialog(windowBattleResult, "Your monsters are tired and went to sleep for the day.");
					
					Game.randomEvents(windowBattleResult, player, inventory);
					
					windowBattleResult.dispose();
					Game.launchMainGame(player, inventory);
					
				}
			}
		});
		btnBack.setIcon(new ImageIcon(BattleResultWindow.class.getResource("/img/Button_Back_25_.png")));
		btnBack.setBounds(259, 270, 71, 31);
		windowBattleResult.getContentPane().add(btnBack);
	}
}
