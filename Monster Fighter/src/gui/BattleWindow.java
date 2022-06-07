package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import main.actor.Opponent;
import main.actor.Player;
import main.inventory.Inventory;
import main.monster.*;

/**
 * The window that will display battles.
 */
public class BattleWindow {

	/**
	 * BattleWindow frame.
	 */
	private JFrame windowBattle;
	
	/**
	 * The player's monster team.
	 */
	private ArrayList<Monster> playerTeam;
	
	/**
	 * The opponent's monster team.
	 */
	private ArrayList<Monster> oppoTeam;
	
	/**
	 * Whose turn it is.
	 */
	private String currentTurn = "Player Turn";
	
	/**
	 * Current player's monster that is battling.
	 */
	private int currentPlayerMon = 0;
	
	/**
	 * Current opponent's monster that is battling.
	 */
	private int currentOppoMon = 0;
	
	/**
	 * Opponent's level.
	 */
	private int oppoLevel;

	/**
	 * The player's monster at the front.
	 */
	private int pTeamFrontMon = 0;
	
	/**
	 * The opponent's monster at the front.
	 */
	private int oTeamFrontMon = 0;
	
	/**
	 * The potential amount of levels that can be gained from a battle.
	 */
	private int potentialLevelsGained;
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory;

	
	/**
	 * Create the application.
	 * @param player the player
	 * @param inventory the player's inventory
	 * @param opponent the opponent the player will battle
	 * @param opponentLevel the opponent's level
	 * @param potentialLevelsGained potential levels that can be gained from a game
	 */
	public BattleWindow(Player player, Inventory inventory, Opponent opponent, int opponentLevel, int potentialLevelsGained) {
		playerTeam = inventory.getMonsterList();
		oppoTeam = opponent.getOpponentMonsterList();
		
		oppoLevel = opponentLevel;
		
		for (Monster monster: oppoTeam) {
			monster.setMonsterLevel(opponentLevel);
		}
		
		if (player.getGameDifficulty() == "hard"){
			for (Monster monster: oppoTeam) {
				monster.hardDiffBoost();
			}
		}
		
		this.player = player;
		this.inventory = inventory;
		
		this.potentialLevelsGained = potentialLevelsGained;
		
		initialize();}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		windowBattle = new JFrame();
		windowBattle.setTitle("V.S.");
		windowBattle.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowBattle.setIconImage(Toolkit.getDefaultToolkit().getImage(BattleWindow.class.getResource("/img/Game Icon.png")));
		windowBattle.setResizable(false);
		windowBattle.setBounds(100, 100, 714, 410);
		windowBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowBattle.getContentPane().setLayout(null);
		
		
		JLabel lblAllyMon4 = new JLabel("");
		lblAllyMon4.setBounds(10, 46, 70, 76);
		if (playerTeam.size()>3) {
		showMonPicPlayer(lblAllyMon4, playerTeam.get(3));}
		
		
		JLabel lblArrow = new JLabel("");
		lblArrow.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Arrow.png")));
		lblArrow.setBounds(270, 10, 24, 36);
		windowBattle.getContentPane().add(lblArrow);

		
		
		JButton btnEscape = new JButton("");
		btnEscape.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Button Escape(25).png")));
		btnEscape.setBounds(516, 297, 122, 36);
		windowBattle.getContentPane().add(btnEscape);
		btnEscape.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTurn == "Player Turn") {
					int input = JOptionPane.showConfirmDialog(windowBattle, "Escape?", "You sure?", JOptionPane.OK_CANCEL_OPTION);
					if (input == 0) {
						Random rand = new Random();
						int chance = rand.nextInt(2);
						if (chance == 0) {
							JOptionPane.showConfirmDialog(windowBattle, "Failed To Escape!", "Press Continue", JOptionPane.WARNING_MESSAGE);
							currentTurn = "Opponent Turn";
							
							// go to next oppo mon
							currentOppoMon += 1;
							if (currentOppoMon == playerTeam.size()) {
								currentOppoMon = 0;
							}
							while (oppoTeam.get(currentOppoMon).getIsFainted()) {
								currentOppoMon += 1;
								if (currentOppoMon == oppoTeam.size()) {
									currentOppoMon = 0;
								}
							}
							
							if (currentOppoMon == 0) {
								lblArrow.setBounds(397, 10, 24, 36);
							}
							else if (currentOppoMon == 1) {
								lblArrow.setBounds(477, 10, 24, 36);
							}
							else if (currentOppoMon == 2) {
								lblArrow.setBounds(557, 10, 24, 36);
							}
							else if (currentOppoMon == 3) {
								lblArrow.setBounds(637, 10, 24, 36);
							}
						}
						else if (chance == 1) {
							JOptionPane.showConfirmDialog(windowBattle, "You Escaped!", "You Escaped", JOptionPane.WARNING_MESSAGE);
							for (Monster monster: playerTeam) {
								monster.revive();
								monster.heal(50);
							}
							MainGameWindow mGW = new MainGameWindow(player, inventory);
							windowBattle.dispose();
							
						}
					}
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});


		
		JLabel lblBattleInfo4 = new JLabel();
		lblBattleInfo4.setForeground(Color.YELLOW);
		lblBattleInfo4.setFont(null);
		
		lblBattleInfo4.setBounds(386, 213, 312, 23);
		windowBattle.getContentPane().add(lblBattleInfo4);
		
		JLabel lblBattleInfo3 = new JLabel();
		lblBattleInfo3.setForeground(Color.YELLOW);
		lblBattleInfo3.setFont(null);
		lblBattleInfo3.setBounds(386, 230, 312, 23);
		windowBattle.getContentPane().add(lblBattleInfo3);
		
		JLabel lblBattleInfo2 = new JLabel();
		lblBattleInfo2.setForeground(Color.YELLOW);
		lblBattleInfo2.setFont(null);
		lblBattleInfo2.setBounds(386, 247, 312, 23);
		windowBattle.getContentPane().add(lblBattleInfo2);
		
		JLabel lblBattleInfo1 = new JLabel();
		lblBattleInfo1.setText("Battle begins!");
		lblBattleInfo1.setForeground(Color.YELLOW);
		lblBattleInfo1.setFont(null);
		lblBattleInfo1.setBounds(386, 264, 312, 23);
		windowBattle.getContentPane().add(lblBattleInfo1);
		windowBattle.getContentPane().add(lblAllyMon4);
		
		JLabel lblAllyMon3 = new JLabel("");
		lblAllyMon3.setBounds(90, 46, 70, 76);
		if (playerTeam.size()>2) {
			showMonPicPlayer(lblAllyMon3, playerTeam.get(2));}
		windowBattle.getContentPane().add(lblAllyMon3);
		
		JLabel lblAllyMon2 = new JLabel("");
		lblAllyMon2.setBounds(170, 46, 70, 76);
		if (playerTeam.size()>1) {
		showMonPicPlayer(lblAllyMon2, playerTeam.get(1));}
		windowBattle.getContentPane().add(lblAllyMon2);
		
		JLabel lblAllyMon1 = new JLabel("");
		lblAllyMon1.setBounds(250, 46, 70, 76);
		showMonPicPlayer(lblAllyMon1, playerTeam.get(0));
		windowBattle.getContentPane().add(lblAllyMon1);
		
		JLabel lblOppoMon4 = new JLabel("");
		lblOppoMon4.setBounds(617, 46, 70, 76);
		if (oppoTeam.size()>3) {
			showMonPicOppo(lblOppoMon4, oppoTeam.get(3));
		}
		windowBattle.getContentPane().add(lblOppoMon4);
		
		JLabel lblOppoMon3 = new JLabel("");
		lblOppoMon3.setBounds(537, 46, 70, 76);
		if (oppoTeam.size()>2) {
			showMonPicOppo(lblOppoMon3, oppoTeam.get(2));
		}
		windowBattle.getContentPane().add(lblOppoMon3);
		
		JLabel lblOppoMon2 = new JLabel("");
		lblOppoMon2.setBounds(457, 46, 70, 76);
		if (oppoTeam.size()>1) {
			showMonPicOppo(lblOppoMon2, oppoTeam.get(1));
		}
		windowBattle.getContentPane().add(lblOppoMon2);
		
		JLabel lblOppoMon1 = new JLabel("");
		lblOppoMon1.setBounds(377, 46, 70, 76);
		showMonPicOppo(lblOppoMon1, oppoTeam.get(0));
		windowBattle.getContentPane().add(lblOppoMon1);
		
		JButton btnStatsAllyMon4 = new JButton("Stats");
		btnStatsAllyMon4.setFont(null);
		btnStatsAllyMon4.setBackground(new Color(0, 255, 0));
		btnStatsAllyMon4.setBounds(10, 132, 70, 23);
		windowBattle.getContentPane().add(btnStatsAllyMon4);
		
		JButton btnStatsAllyMon3 = new JButton("Stats");
		btnStatsAllyMon3.setFont(null);
		btnStatsAllyMon3.setBackground(Color.GREEN);
		btnStatsAllyMon3.setBounds(90, 132, 70, 23);
		windowBattle.getContentPane().add(btnStatsAllyMon3);
		
		JButton btnStatsAllyMon2 = new JButton("Stats");
		btnStatsAllyMon2.setFont(null);
		btnStatsAllyMon2.setBackground(Color.GREEN);
		btnStatsAllyMon2.setBounds(170, 132, 70, 23);
		windowBattle.getContentPane().add(btnStatsAllyMon2);
		
		JButton btnStatsAllyMon1 = new JButton("Stats");
		btnStatsAllyMon1.setFont(null);
		btnStatsAllyMon1.setToolTipText(playerTeam.get(0).monsterBattleStats());
		btnStatsAllyMon1.setBackground(Color.GREEN);
		btnStatsAllyMon1.setBounds(250, 132, 70, 23);
		windowBattle.getContentPane().add(btnStatsAllyMon1);
		JButton btnStatsOppoMon4 = new JButton("Stats");
		btnStatsOppoMon4.setFont(null);
		
		btnStatsOppoMon4.setBackground(new Color(0, 255, 0));
		btnStatsOppoMon4.setBounds(617, 132, 70, 23);
		
		if (playerTeam.size()>3) {
			btnStatsAllyMon4.setVisible(true);
			btnStatsAllyMon4.setToolTipText(playerTeam.get(3).monsterBattleStats());
			btnStatsOppoMon4.setVisible(true);
			btnStatsOppoMon4.setToolTipText(oppoTeam.get(3).monsterBattleStats());
		}
		else {
			btnStatsAllyMon4.setVisible(false);
			btnStatsOppoMon4.setVisible(false);
		}
		
		windowBattle.getContentPane().add(btnStatsOppoMon4);
		
		JButton btnStatsOppoMon1 = new JButton("Stats");
		btnStatsOppoMon1.setToolTipText(oppoTeam.get(0).monsterBattleStats());

		btnStatsOppoMon1.setBackground(Color.GREEN);
		btnStatsOppoMon1.setFont(null);
		btnStatsOppoMon1.setBounds(377, 132, 70, 23);
		windowBattle.getContentPane().add(btnStatsOppoMon1);
		
		JButton btnStatsOppoMon2 = new JButton("Stats");
		btnStatsOppoMon2.setBackground(Color.GREEN);
		btnStatsOppoMon2.setFont(null);
		btnStatsOppoMon2.setBounds(457, 132, 70, 23);
		if (playerTeam.size()>1) {
			btnStatsAllyMon2.setVisible(true);
			btnStatsAllyMon2.setToolTipText(playerTeam.get(1).monsterBattleStats());
			btnStatsOppoMon2.setVisible(true);
			btnStatsOppoMon2.setToolTipText(oppoTeam.get(1).monsterBattleStats());
		}
		else {
			btnStatsAllyMon2.setVisible(false);
			btnStatsOppoMon2.setVisible(false);
		}
		
		windowBattle.getContentPane().add(btnStatsOppoMon2);
		
		JButton btnStatsOppoMon3 = new JButton("Stats");
		btnStatsOppoMon3.setFont(null);
		btnStatsOppoMon3.setBackground(Color.GREEN);
		btnStatsOppoMon3.setBounds(537, 132, 70, 23);
		
		if (playerTeam.size()>2) {
			btnStatsAllyMon3.setVisible(true);
			btnStatsAllyMon3.setToolTipText(playerTeam.get(2).monsterBattleStats());
			btnStatsOppoMon3.setVisible(true);
			btnStatsOppoMon3.setToolTipText(oppoTeam.get(2).monsterBattleStats());
		}
		else {
			btnStatsAllyMon3.setVisible(false);
			btnStatsOppoMon3.setVisible(false);
		}
		
		windowBattle.getContentPane().add(btnStatsOppoMon3);
		
		JButton btnAttack = new JButton("Attack");
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTurn == "Player Turn") {
					playerTeam.get(currentPlayerMon).setIsDefending(false);
					
					// Player mon single attacks or range attacks depends on their type
					if (playerTeam.get(currentPlayerMon).getMonsterType() == "Range Damage Dealer") {
						RangeDamageDealer pRDD = (RangeDamageDealer) playerTeam.get(currentPlayerMon);
						pRDD.rangeAttack(oppoTeam);
					}
					else {
						playerTeam.get(currentPlayerMon).attack(oppoTeam.get(oTeamFrontMon));
					}
					
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
					
					String newBattleInfo = "Ally Team: " + playerTeam.get(currentPlayerMon).getMonsterName() + " Attacked!";
					updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);

					
					for (int i = 0; i < oppoTeam.size(); i++) {
						if (oppoTeam.get(i).getIsFainted()) {
							if (i == 0) {
								btnStatsOppoMon1.setBackground(Color.red);}
							else if (i == 1) {
								btnStatsOppoMon2.setBackground(Color.red);}
							else if (i == 2) {
								btnStatsOppoMon3.setBackground(Color.red);}
							else if (i == 3) {
								btnStatsOppoMon4.setBackground(Color.red);}
						}
					}
					
					
					
					// check oppo team front monster if is fainted
					if (oppoTeam.get(oTeamFrontMon).getIsFainted()) {
						oTeamFrontMon += 1;
						if (oTeamFrontMon == oppoTeam.size()) {
							int scoresGained = 5 * oppoLevel * oppoTeam.size() + player.getCurrentDay() * 10;
							if (player.getGameDifficulty() == "hard") {
								scoresGained = (int) (scoresGained * 1.3);
								BattleResultWindow brw = new BattleResultWindow(player, inventory, true, scoresGained, potentialLevelsGained);
								windowBattle.dispose();
							}

						}
					}
					
					// check if oppo team all fainted, if so, then win
					if (checkIfAllFainted(oppoTeam) == true) {
						int scoresGained = 5 * oppoLevel * oppoTeam.size() + player.getCurrentDay() * 10;
						if (player.getGameDifficulty() == "hard") {
							scoresGained = (int) (scoresGained * 1.3);
						}
						BattleResultWindow brw = new BattleResultWindow(player, inventory, true, scoresGained, potentialLevelsGained);
						windowBattle.dispose();
					}
					
					

					// go to next player mon
					currentPlayerMon += 1;
					if (currentPlayerMon == playerTeam.size()) {
						currentPlayerMon = 0;
					}
					while (playerTeam.get(currentPlayerMon).getIsFainted()) {
						currentPlayerMon += 1;
						if (currentPlayerMon == playerTeam.size()) {
							currentPlayerMon = 0;
						}
					}
				}
				

				
				
				// not player's turn, gives warning
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
				
				currentTurn = "Opponent Turn";
				if (currentOppoMon == 0) {
					if (oppoTeam.get(currentOppoMon).getIsFainted() == true) {
						currentOppoMon += 1;
					}
					else {
						lblArrow.setBounds(397, 10, 24, 36);
					}
				}
				if (currentOppoMon == 1 && oppoTeam.size()>1) {
					if (oppoTeam.get(currentOppoMon).getIsFainted() == true) {
						currentOppoMon += 1;
					}
					else {
						lblArrow.setBounds(477, 10, 24, 36);
						}
				}
				if (currentOppoMon == 2  && oppoTeam.size()>2) {
					if (oppoTeam.get(currentOppoMon).getIsFainted() == true) {
						currentOppoMon += 1;
					}
					else {
						lblArrow.setBounds(557, 10, 24, 36);
					}
				}
				if (currentOppoMon == 3  && oppoTeam.size()>3) {
					if (oppoTeam.get(currentOppoMon).getIsFainted() == true) {
						currentOppoMon += 1;
					}
					else {
						lblArrow.setBounds(637, 10, 24, 36);
					}
				}
				if (currentOppoMon == 0) {
					if (oppoTeam.get(currentOppoMon).getIsFainted() == true) {
						currentOppoMon += 1;
					}
					else {
						lblArrow.setBounds(397, 10, 24, 36);
					}
				}
			}
		});
		btnAttack.setFont(null);
		btnAttack.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Icon Attack.png")));
		btnAttack.setBounds(28, 228, 108, 27);
		windowBattle.getContentPane().add(btnAttack);
		
		JButton btnChickenBreast = new JButton("");
		btnChickenBreast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentTurn == "Player Turn") {
					if (inventory.hasItem("Chicken Breast")) {
						inventory.getFood("Chicken Breast").useItem(playerTeam.get(currentPlayerMon));
						inventory.removeFood(inventory.getFood("Chicken Breast"), 0);
						JOptionPane.showConfirmDialog(windowBattle, "Chicken Breast Consumed!", "Hell Yeah!", JOptionPane.WARNING_MESSAGE);
						refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
								btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
						
					}
					else {
						JOptionPane.showConfirmDialog(windowBattle, "You don't have any Chicken Breast!", "Failed To Use Item", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnChickenBreast.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Chicken Breast Icon.png")));
		btnChickenBreast.setBounds(164, 228, 86, 40);
		windowBattle.getContentPane().add(btnChickenBreast);
		
		JButton btnHealingPotion = new JButton("");
		btnHealingPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentTurn == "Player Turn") {
					if (inventory.hasItem("Healing Potion")) {
						inventory.getPotion("Healing Potion").useItem(playerTeam.get(currentPlayerMon));
						inventory.removePotion(inventory.getPotion("Healing Potion"), 0);
						JOptionPane.showConfirmDialog(windowBattle, "Healing Potion Consumed!", "Hell Yeah!", JOptionPane.WARNING_MESSAGE);
						refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
								btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
						
					}
					else {
						JOptionPane.showConfirmDialog(windowBattle, "You don't have any Healing Potion!", "Failed To Use Item", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnHealingPotion.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Healing Potion Icon.png")));
		btnHealingPotion.setBounds(164, 280, 86, 40);
		windowBattle.getContentPane().add(btnHealingPotion);
		
		JButton btnDragonFruit = new JButton("");
		btnDragonFruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentTurn == "Player Turn") {
				if (inventory.hasItem("Dragon Fruit")) {
					inventory.getFood("Dragon Fruit").useItem(playerTeam.get(currentPlayerMon));
					inventory.removeFood(inventory.getFood("Dragon Fruit"), 0);
					JOptionPane.showConfirmDialog(windowBattle, "Dragon Fruit Consumed!", "Hell Yeah!", JOptionPane.WARNING_MESSAGE);
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
					
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "You don't have any Dragon Fruit!", "Failed To Use Item", JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
			}
		}
			
		});
		btnDragonFruit.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Dragon Fruit Icon.png")));
		btnDragonFruit.setBounds(260, 228, 86, 40);
		windowBattle.getContentPane().add(btnDragonFruit);
		
		JButton btnMaxHealthPotion = new JButton("");
		btnMaxHealthPotion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentTurn == "Player Turn") {
					if (inventory.hasItem("Max Health Potion")) {
						inventory.getPotion("Max Health Potion").useItem(playerTeam.get(currentPlayerMon));
						inventory.removePotion(inventory.getPotion("Max Health Potion"), 0);
						JOptionPane.showConfirmDialog(windowBattle, "Max Health Potion Consumed!", "Hell Yeah!", JOptionPane.WARNING_MESSAGE);
						refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
								btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
						
					}
					else {
						JOptionPane.showConfirmDialog(windowBattle, "You don't have any Max Health Potion!", "Failed To Use Item", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnMaxHealthPotion.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Max Health Potion Icon.png")));
		btnMaxHealthPotion.setBounds(260, 280, 86, 40);
		windowBattle.getContentPane().add(btnMaxHealthPotion);
		
		JButton btnDefend = new JButton("Defend");
		btnDefend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTurn == "Player Turn") {
					
					playerTeam.get(currentPlayerMon).setIsDefending(true);
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
					
					String newBattleInfo = "Ally Team: " + playerTeam.get(currentPlayerMon).getMonsterName() + " is now Defending!";
					updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);
					
					// go to next player mon
					currentPlayerMon += 1;
					if (currentPlayerMon == playerTeam.size()) {
						currentPlayerMon = 0;
					}
					while (playerTeam.get(currentPlayerMon).getIsFainted()) {
						currentPlayerMon += 1;
						if (currentPlayerMon == playerTeam.size()) {
							currentPlayerMon = 0;
						}
					}
					
					currentTurn = "Opponent Turn";
					if (currentOppoMon == 0) {
						lblArrow.setBounds(397, 10, 24, 36);
					}
					else if (currentOppoMon == 1) {
						lblArrow.setBounds(477, 10, 24, 36);
					}
					else if (currentOppoMon == 2) {
						lblArrow.setBounds(557, 10, 24, 36);
					}
					else if (currentOppoMon == 3) {
						lblArrow.setBounds(637, 10, 24, 36);
					}
					
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnDefend.setFont(null);
		btnDefend.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Icon Defence.png")));
		btnDefend.setBounds(28, 260, 108, 27);
		windowBattle.getContentPane().add(btnDefend);
		
		JButton btnHeal = new JButton("Heal  ");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTurn == "Player Turn") {
					playerTeam.get(currentPlayerMon).setIsDefending(false);
					
					if (playerTeam.get(currentPlayerMon).getMonsterType() == "Mass Healer") {
						MassHealer pMH = (MassHealer) playerTeam.get(currentPlayerMon);
						pMH.massHeal(playerTeam);
					}
					else {
						playerTeam.get(pTeamFrontMon).heal(playerTeam.get(currentPlayerMon).getMonsterHealAmount());
					}
					
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
				
					String newBattleInfo = "Ally Team: " + playerTeam.get(currentPlayerMon).getMonsterName() + " Healed ally monster(s)!";
					updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);
					
					// go to next player mon
					currentPlayerMon += 1;
					if (currentPlayerMon == playerTeam.size()) {
						currentPlayerMon = 0;
					}
					while (playerTeam.get(currentPlayerMon).getIsFainted()) {
						currentPlayerMon += 1;
						if (currentPlayerMon == playerTeam.size()) {
							currentPlayerMon = 0;
						}
					}
					
					currentTurn = "Opponent Turn";
					if (currentOppoMon == 0) {
						lblArrow.setBounds(397, 10, 24, 36);
					}
					else if (currentOppoMon == 1) {
						lblArrow.setBounds(477, 10, 24, 36);
					}
					else if (currentOppoMon == 2) {
						lblArrow.setBounds(557, 10, 24, 36);
					}
					else if (currentOppoMon == 3) {
						lblArrow.setBounds(637, 10, 24, 36);
					}
				
				}
				else {
					JOptionPane.showConfirmDialog(windowBattle, "Not your turn!", "Press Continue", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnHeal.setFont(null);
		btnHeal.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Icon Heal.png")));
		btnHeal.setBounds(28, 293, 108, 27);
		windowBattle.getContentPane().add(btnHeal);
		
		JLabel lblFrame = new JLabel("");
		lblFrame.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/frame1.png")));
		lblFrame.setBounds(10, 207, 357, 136);
		windowBattle.getContentPane().add(lblFrame);
		
		JLabel lblFrameBG = new JLabel("");
		lblFrameBG.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/frame background.png")));
		lblFrameBG.setForeground(Color.MAGENTA);
		lblFrameBG.setBackground(Color.MAGENTA);
		lblFrameBG.setBounds(10, 215, 349, 123);
		windowBattle.getContentPane().add(lblFrameBG);
		
		JButton btnContinue = new JButton("");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentTurn == "Opponent Turn"){
					Random rand = new Random();
					int option = rand.nextInt(3);
					if (option == 0) {
						playerTeam.get(currentPlayerMon).setIsDefending(false);
						
						// Oppo mon single attacks or range attacks depends on their type
						if (oppoTeam.get(currentOppoMon).getMonsterType() == "Range Damage Dealer") {
							RangeDamageDealer pRDD = (RangeDamageDealer) oppoTeam.get(currentOppoMon);
							pRDD.rangeAttack(playerTeam);
						}
						else {
							oppoTeam.get(currentOppoMon).attack(playerTeam.get(pTeamFrontMon));
						}
						
						refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
								btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
						
						String newBattleInfo = "Opponent Team: " + oppoTeam.get(currentOppoMon).getMonsterName() + " Attacked!";
						updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);

						
						for (int i = 0; i < playerTeam.size(); i++) {
							if (playerTeam.get(i).getIsFainted()) {
								if (i == 0) {
									btnStatsAllyMon1.setBackground(Color.red);}
								else if (i == 1) {
									btnStatsAllyMon2.setBackground(Color.red);}
								else if (i == 2) {
									btnStatsAllyMon3.setBackground(Color.red);}
								else if (i == 3) {
									btnStatsAllyMon4.setBackground(Color.red);}
							}
						}
					
						
						// check player team front monster if is fainted, if all fainted, player loses
						if (playerTeam.get(pTeamFrontMon).getIsFainted()) {
							pTeamFrontMon += 1;
							if (pTeamFrontMon == oppoTeam.size()) {
								BattleResultWindow brw = new BattleResultWindow(player, inventory, false, 0, 0);
								windowBattle.dispose();
							}
						}
						
						// check if player team all fainted, if so, then lose
						if (checkIfAllFainted(playerTeam) == true) {
								BattleResultWindow brw = new BattleResultWindow(player, inventory, false, 0, 0);
								windowBattle.dispose();
							}
					}
				else if (option == 1) {
					oppoTeam.get(currentOppoMon).setIsDefending(true);
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
					
					String newBattleInfo = "Opponent Team: " + oppoTeam.get(currentOppoMon).getMonsterName() + " is now Defending!";
					updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);

				}
				else if (option == 2){
					oppoTeam.get(currentOppoMon).setIsDefending(false);

					if (oppoTeam.get(currentOppoMon).getMonsterType() == "Mass Healer") {
						
						MassHealer pMH = (MassHealer) oppoTeam.get(currentOppoMon);
						pMH.massHeal(oppoTeam);
					}
					else {
						oppoTeam.get(oTeamFrontMon).heal(oppoTeam.get(currentOppoMon).getMonsterHealAmount());
					}
					
					refreshStats(btnStatsAllyMon1, btnStatsAllyMon2, btnStatsAllyMon3, btnStatsAllyMon4,
							btnStatsOppoMon1, btnStatsOppoMon2, btnStatsOppoMon3, btnStatsOppoMon4);
				
					String newBattleInfo = "Opponent Team: " + oppoTeam.get(currentOppoMon).getMonsterName() + " Healed opponent monster(s)!";
					updateBattleInfo(newBattleInfo, lblBattleInfo1, lblBattleInfo2, lblBattleInfo3, lblBattleInfo4);
					}
				currentTurn = "Player Turn";
				if (currentPlayerMon == 0) {
					if (playerTeam.get(currentPlayerMon).getIsFainted() == true) {
						currentPlayerMon += 1;
					}
					else {
						lblArrow.setBounds(270, 10, 24, 36);
					}
				}
				if (currentPlayerMon == 1 && playerTeam.size()>1) {
					if (playerTeam.get(currentPlayerMon).getIsFainted() == true) {
						currentPlayerMon += 1;
					}
					else {
						lblArrow.setBounds(190, 10, 24, 36);
						}
				}
				if (currentPlayerMon == 2 && playerTeam.size()>2) {
					if (playerTeam.get(currentPlayerMon).getIsFainted() == true) {
						currentPlayerMon += 1;
					}
					else {
						lblArrow.setBounds(110, 10, 24, 36);
					}
				}
				if (currentPlayerMon == 3 && playerTeam.size()>3) {
					if (playerTeam.get(currentPlayerMon).getIsFainted() == true) {
						currentPlayerMon += 1;
					}
					else {
						lblArrow.setBounds(30, 10, 24, 36);
					}
				}
				if (currentPlayerMon == 0) {
					if (playerTeam.get(currentPlayerMon).getIsFainted() == true) {
						currentPlayerMon += 1;
					}
					else {
						lblArrow.setBounds(270, 10, 24, 36);
					}
				}
				// go to next oppo mon
				currentOppoMon += 1;
				if (currentOppoMon == playerTeam.size()) {
					currentOppoMon = 0;
				}
				while (oppoTeam.get(currentOppoMon).getIsFainted()) {
					currentOppoMon += 1;
					if (currentOppoMon == oppoTeam.size()) {
						currentOppoMon = 0;
					}
				}
		}}});
		btnContinue.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Button_Continue_25_.png")));
		btnContinue.setBounds(377, 297, 122, 36);
		windowBattle.getContentPane().add(btnContinue);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Battle Background.png")));
		lblBackground.setBounds(-77, -90, 846, 471);
		windowBattle.getContentPane().add(lblBackground);
		
		windowBattle.setVisible(true);
	}
	
	/**
	 * Shows monster pictures for the opponent's team.
	 * @param monsterPic the image
	 * @param monster the monster
	 */
	public void showMonPicOppo(JLabel monsterPic, Monster monster) {
		if (monster.getMonsterType()=="Light Tank") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Eligor_LT_.png")));
		}
		else if (monster.getMonsterType()=="Heavy Tank") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Cerberus_HT_.png")));
		}
		else if (monster.getMonsterType()=="Mass Healer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Bune_MH_.png")));
		}
		else if (monster.getMonsterType()=="Single Target Healer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Vapula_STH_.png")));
		}
		else if (monster.getMonsterType()=="Single Target Damage Dealer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Labolas_STDD_.png")));
		}
		else if (monster.getMonsterType()=="Range Damage Dealer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Focalor_RDD_.png")));
		}
	}
	
	/**
	 * Shows monster pictures for the player's team.
	 * @param monsterPic the image
	 * @param monster the monster
	 */
	public void showMonPicPlayer(JLabel monsterPic, Monster monster) {
		if (monster.getMonsterType()=="Light Tank") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Eligor(LT) Reversed.png")));
		}
		else if (monster.getMonsterType()=="Heavy Tank") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Cerberus(HT) Reversed.png")));
		}
		else if (monster.getMonsterType()=="Mass Healer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Bune(MH) Reversed.png")));
		}
		else if (monster.getMonsterType()=="Single Target Healer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Vapula(STH) Reversed.png")));
		}
		else if (monster.getMonsterType()=="Single Target Damage Dealer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Labolas(STDD) Reversed.png")));
		}
		else if (monster.getMonsterType()=="Range Damage Dealer") {
			monsterPic.setIcon(new ImageIcon(BattleWindow.class.getResource("/img/Focalor(RDD) Reversed.png")));
		}
	}
	
	/**
	 * Refreshes monster stats after a turn.
	 * @param pMonButton1 monster button 1
	 * @param pMonButton2 monster button 2
	 * @param pMonButton3 monster button 3
	 * @param pMonButton4 monster button 4
	 * @param pOppoButton1 opponent monster button 1
	 * @param pOppoButton2 opponent monster button 2
	 * @param pOppoButton3 opponent monster button 3
	 * @param pOppoButton4 opponent monster button 4
	 */
	public void refreshStats(JButton pMonButton1, JButton pMonButton2, JButton pMonButton3, JButton pMonButton4,
			JButton pOppoButton1, JButton pOppoButton2, JButton pOppoButton3, JButton pOppoButton4) {
		pMonButton1.setToolTipText(playerTeam.get(0).monsterBattleStats());
		pOppoButton1.setToolTipText(oppoTeam.get(0).monsterBattleStats());
		if (playerTeam.size()>1) {
			pMonButton2.setToolTipText(playerTeam.get(1).monsterBattleStats());
			pOppoButton2.setToolTipText(oppoTeam.get(1).monsterBattleStats());
		}
		if (playerTeam.size()>2) {
			pMonButton3.setToolTipText(playerTeam.get(2).monsterBattleStats());
			pOppoButton3.setToolTipText(oppoTeam.get(2).monsterBattleStats());
		}
		if (playerTeam.size()>3) {
			pMonButton4.setToolTipText(playerTeam.get(3).monsterBattleStats());
			pOppoButton4.setToolTipText(oppoTeam.get(3).monsterBattleStats());
		}
		
	}
	
	/**
	 * Updates battle information after each turn.
	 * @param newInfo information
	 * @param battleInfoLabel1 info label 1
	 * @param battleInfoLabel2 info label 2
	 * @param battleInfoLabel3 info label 3
	 * @param battleInfoLabel4 info label 4
	 */
	private void updateBattleInfo(String newInfo, JLabel battleInfoLabel1, JLabel battleInfoLabel2, JLabel battleInfoLabel3, JLabel battleInfoLabel4) {
		battleInfoLabel4.setText(battleInfoLabel3.getText());
		battleInfoLabel3.setText(battleInfoLabel2.getText());
		battleInfoLabel2.setText(battleInfoLabel1.getText());
		battleInfoLabel1.setText(newInfo);
	}
	
	/**
	 * Checks if all the monsters in a team are fainted.
	 * @param monsterList the monster team
	 * @return true if all fainted, false otherwise
	 */
	private boolean checkIfAllFainted(ArrayList<Monster> monsterList) {
		for (Monster monster : monsterList) {
			if (monster.getIsFainted() == false){
				return false;
			}
		}
		return true;
	}
}
