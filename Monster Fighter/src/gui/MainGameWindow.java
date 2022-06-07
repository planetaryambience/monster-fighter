package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import main.actor.Player;
import main.game.Game;
import main.inventory.Inventory;
import main.monster.HeavyTank;
import main.monster.LightTank;
import main.monster.MassHealer;
import main.monster.Monster;
import main.monster.RangeDamageDealer;
import main.monster.SingleTargetDamageDealer;
import main.monster.SingleTargetHealer;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;
/**
 * The main game window.
 * Includes options to view inventory and monsters, visit shop, sleep, and battle.
 */
public class MainGameWindow {

	/**
	 * MainGameWindow frame.
	 */
	private JFrame windowMainGame;
	
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
	 * @param p player
	 * @param inv inventory
	 */
	public MainGameWindow(Player p, Inventory inv) {
		player = p;
		inventory = inv;
		initialize();
		windowMainGame.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		windowMainGame.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowMainGame = new JFrame();
		windowMainGame.setResizable(false);
		windowMainGame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowMainGame.setTitle("What To Do Next?");
		windowMainGame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGameWindow.class.getResource("/img/Game Icon.png")));
		windowMainGame.setBounds(100, 100, 600, 350);
		windowMainGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowMainGame.getContentPane().setLayout(null);
		
		JButton btnMonsters = new JButton("");
		btnMonsters.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Button_Monsters_15_.png")));
		btnMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				PlayerMonstersWindow playerMonsters = new PlayerMonstersWindow(player, inventory);
			}
		});
		
		JButton btnGoToArena = new JButton("");
		btnGoToArena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(windowMainGame, "Go to the Arena?", "Arena", JOptionPane.OK_CANCEL_OPTION);
				if (input == 0) {
					ChooseBattleWindow CBW = new ChooseBattleWindow(player, inventory);
					windowMainGame.dispose();
				}
			}
		});
		btnGoToArena.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Button_Arena_15_.png")));
		btnGoToArena.setBounds(187, 271, 203, 48);
		windowMainGame.getContentPane().add(btnGoToArena);
		btnMonsters.setBounds(0, 233, 294, 40);
		windowMainGame.getContentPane().add(btnMonsters);
		
		if (inventory.getNumOfMonsters() < 1) {
			btnGoToArena.setEnabled(false);
		}
		
		JButton btnInventory = new JButton("");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				InventoryWindow inv = new InventoryWindow(player, inventory);
			}
		});
		btnInventory.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Button_Inventory_15_.png")));
		btnInventory.setBounds(290, 233, 308, 40);
		windowMainGame.getContentPane().add(btnInventory);
		
		JButton btnVisitShop = new JButton("");
		btnVisitShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				ShopWindow shop = new ShopWindow(player, inventory);
			}
		});
		btnVisitShop.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Button_Shop_15_.png")));
		btnVisitShop.setBounds(0, 271, 188, 48);
		windowMainGame.getContentPane().add(btnVisitShop);
		
		JLabel lblDay = new JLabel("");
		lblDay.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Day_Label_125_.png")));
		lblDay.setBounds(79, 80, 294, 121);
		windowMainGame.getContentPane().add(lblDay);
		
		JLabel lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/1 Label(125).png")));
		lbl1.setBounds(416, 80, 58, 121);
		windowMainGame.getContentPane().add(lbl1);
		
		JLabel lblYourScore = new JLabel("");
		lblYourScore.setText("Score: " + player.getGameScore());
		lblYourScore.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblYourScore.setIcon(null);
		lblYourScore.setBounds(10, 11, 164, 34);
		windowMainGame.getContentPane().add(lblYourScore);
		
		JLabel lblGold = new JLabel("");
		lblGold.setText("Gold: " + inventory.getGold());
		lblGold.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblGold.setBounds(10, 47, 116, 21);
		windowMainGame.getContentPane().add(lblGold);
		
		JLabel lblDays = new JLabel("");
		lblDays.setText("Days Remaining: " + (player.getNumOfDays() - player.getCurrentDay()));
		lblDays.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDays.setBounds(361, 18, 158, 21);
		windowMainGame.getContentPane().add(lblDays);
		
		JButton btnTutorial = new JButton("?");
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TutorialWindow tutorial = new TutorialWindow(player, inventory);
				windowMainGame.setVisible(false);
			}
		});
		btnTutorial.setBounds(529, 11, 45, 34);
		windowMainGame.getContentPane().add(btnTutorial);
		
		JLabel lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/2 Label(125).png")));
		lbl2.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("");
		lbl3.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/3 Label(125).png")));
		lbl3.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("");
		lbl4.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/4 Label(125).png")));
		lbl4.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("");
		lbl5.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/5 Label(125).png")));
		lbl5.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("");
		lbl6.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/6 Label(125).png")));
		lbl6.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl6);
		
		JLabel lbl7 = new JLabel("");
		lbl7.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/7 Label(125).png")));
		lbl7.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl7);
		
		JLabel lbl8 = new JLabel("");
		lbl8.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/8 Label(125).png")));
		lbl8.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl8);
		
		JLabel lbl9 = new JLabel("");
		lbl9.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/9 Label(125).png")));
		lbl9.setBounds(389, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl9);
		
		JLabel lblDay10s = new JLabel("");
		lblDay10s.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Day_Label_125_.png")));
		lblDay10s.setBounds(36, 80, 294, 121);
		windowMainGame.getContentPane().add(lblDay10s);
		
		JLabel lbl10 = new JLabel("");
		lbl10.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/1 Label(125).png")));
		lbl10.setBounds(366, 80, 58, 121);
		windowMainGame.getContentPane().add(lbl10);
		
		JLabel lbl10_0 = new JLabel("");
		lbl10_0.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/0 Label(125).png")));
		lbl10_0.setBounds(422, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl10_0);
		
		JLabel lbl10_1 = new JLabel("");
		lbl10_1.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/1 Label(125).png")));
		lbl10_1.setBounds(439, 80, 66, 121);
		windowMainGame.getContentPane().add(lbl10_1);
		
		JLabel lbl10_2 = new JLabel("");
		lbl10_2.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/2 Label(125).png")));
		lbl10_2.setBounds(422, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl10_2);
		
		JLabel lbl10_3 = new JLabel("");
		lbl10_3.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/3 Label(125).png")));
		lbl10_3.setBounds(422, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl10_3);
		
		JLabel lbl10_4 = new JLabel("");
		lbl10_4.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/4 Label(125).png")));
		lbl10_4.setBounds(422, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl10_4);
		
		JLabel lbl10_5 = new JLabel("");
		lbl10_5.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/5 Label(125).png")));
		lbl10_5.setBounds(422, 80, 116, 121);
		windowMainGame.getContentPane().add(lbl10_5);

		
		turnAllLabelsInvisible( lblDay,  lbl1,  lbl2,  lbl3,  lbl4,
				 lbl5,  lbl6,  lbl7,  lbl8,  lbl9,  lblDay10s,  lbl10,
				 lbl10_0,  lbl10_1,  lbl10_2,  lbl10_3,  lbl10_4,  lbl10_5);
		showCurrentDay(player,  lblDay,  lbl1,  lbl2,  lbl3,  lbl4,
				 lbl5,  lbl6,  lbl7,  lbl8,  lbl9,  lblDay10s,  lbl10,
				 lbl10_0,  lbl10_1,  lbl10_2,  lbl10_3,  lbl10_4,  lbl10_5);
		
		JButton btnGoToSleep = new JButton("");
		btnGoToSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(windowMainGame, "Go to sleep?", "Sleep", JOptionPane.OK_CANCEL_OPTION);
				
				if (input == 0) {
					if (player.getCurrentDay() < player.getNumOfDays()) {
						player.addDay();
						turnAllLabelsInvisible( lblDay,  lbl1,  lbl2,  lbl3,  lbl4,
								 lbl5,  lbl6,  lbl7,  lbl8,  lbl9,  lblDay10s,  lbl10,
								 lbl10_0,  lbl10_1,  lbl10_2,  lbl10_3,  lbl10_4,  lbl10_5);
						showCurrentDay(player,  lblDay,  lbl1,  lbl2,  lbl3,  lbl4,
								 lbl5,  lbl6,  lbl7,  lbl8,  lbl9,  lblDay10s,  lbl10,
								 lbl10_0,  lbl10_1,  lbl10_2,  lbl10_3,  lbl10_4,  lbl10_5);
						
						for (Monster monster: inventory.getMonsterList()) {
							monster.heal(monster.getMonsterHealAmount());
						}
						
						Game.randomEvents(windowMainGame, player, inventory);

						lblDays.setText("Days Remaining: " + (player.getNumOfDays() - player.getCurrentDay()));
						
					if (player.getCurrentDay() == player.getNumOfDays()) {
						JOptionPane.showMessageDialog(windowMainGame, "Today is your last day!");
					}
				}
				else {
					closeWindow();
					GameResultWindow gameEnd = new GameResultWindow(player, inventory);
				}
			}
		}});
		btnGoToSleep.setIcon(new ImageIcon(MainGameWindow.class.getResource("/img/Button_Sleep_15_.png")));
		btnGoToSleep.setBounds(389, 271, 209, 48);
		windowMainGame.getContentPane().add(btnGoToSleep);
	}
	
	/**
	 * Sets all label's visibility to false.
	 * @param lblDay Day label
	 * @param lbl1 1 label
	 * @param lbl2 2 label
	 * @param lbl3 3 label
	 * @param lbl4 4 label
	 * @param lbl5 5 label
	 * @param lbl6 6 label
	 * @param lbl7 7 label
	 * @param lbl8 8 label
	 * @param lbl9 9 label
	 * @param lblDay10s Day 10 label
	 * @param lbl10 10 label
	 * @param lbl10_0 10_0 label
	 * @param lbl10_1 11 label
	 * @param lbl10_2 12 label
	 * @param lbl10_3 13 label
	 * @param lbl10_4 14 label
	 * @param lbl10_5 15 label
	 */
	public void turnAllLabelsInvisible(JLabel lblDay, JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4,
			JLabel lbl5, JLabel lbl6, JLabel lbl7, JLabel lbl8, JLabel lbl9, JLabel lblDay10s, JLabel lbl10,
			JLabel lbl10_0, JLabel lbl10_1, JLabel lbl10_2, JLabel lbl10_3, JLabel lbl10_4, JLabel lbl10_5) {
		lblDay.setVisible(false);
		lbl1.setVisible(false);
		lbl2.setVisible(false);
		lbl3.setVisible(false);
		lbl4.setVisible(false);
		lbl5.setVisible(false);
		lbl6.setVisible(false);
		lbl7.setVisible(false);
		lbl8.setVisible(false);
		lbl9.setVisible(false);
		lblDay10s.setVisible(false);
		lbl10.setVisible(false);
		lbl10_0.setVisible(false);
		lbl10_1.setVisible(false);
		lbl10_2.setVisible(false);
		lbl10_3.setVisible(false);
		lbl10_4.setVisible(false);
		lbl10_5.setVisible(false);		
	}
	
	/**
	 * Shows the current day player is on.
	 * Changes depending on what day it is.
	 * @param player player
	 * @param lblDay Day label
	 * @param lbl1 1 label
	 * @param lbl2 2 label
	 * @param lbl3 3 label
	 * @param lbl4 4 label
	 * @param lbl5 5 label
	 * @param lbl6 6 label
	 * @param lbl7 7 label
	 * @param lbl8 8 label
	 * @param lbl9 9 label
	 * @param lblDay10s Day 10 label
	 * @param lbl10 10 label
	 * @param lbl10_0 10_0 label
	 * @param lbl10_1 11 label
	 * @param lbl10_2 12 label
	 * @param lbl10_3 13 label
	 * @param lbl10_4 14 label
	 * @param lbl10_5 15 label
	 */
	public void showCurrentDay(Player player, JLabel lblDay, JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4,
			JLabel lbl5, JLabel lbl6, JLabel lbl7, JLabel lbl8, JLabel lbl9, JLabel lblDay10s, JLabel lbl10,
			JLabel lbl10_0, JLabel lbl10_1, JLabel lbl10_2, JLabel lbl10_3, JLabel lbl10_4, JLabel lbl10_5) {
		
		if (player.getCurrentDay() < 10) {
			lblDay.setVisible(true);
		}
		else {
			lblDay10s.setVisible(true);
			lbl10.setVisible(true);
		}
		
		if (player.getCurrentDay() == 1) {
			lbl1.setVisible(true);
		}
		else if (player.getCurrentDay() == 2) {
			lbl2.setVisible(true);
		}
		else if (player.getCurrentDay() == 3) {
			lbl3.setVisible(true);
		}
		else if (player.getCurrentDay() == 4) {
			lbl4.setVisible(true);
		}
		else if (player.getCurrentDay() == 5) {
			lbl5.setVisible(true);
		}
		else if (player.getCurrentDay() == 6) {
			lbl6.setVisible(true);
		}
		else if (player.getCurrentDay() == 7) {
			lbl7.setVisible(true);
		}
		else if (player.getCurrentDay() == 8) {
			lbl8.setVisible(true);
		}
		else if (player.getCurrentDay() == 9) {
			lbl9.setVisible(true);
		}
		else if (player.getCurrentDay() == 10) {
			lbl10_0.setVisible(true);
		}
		else if (player.getCurrentDay() == 11) {
			lbl10_1.setVisible(true);
		}
		else if (player.getCurrentDay() == 12) {
			lbl10_2.setVisible(true);
		}
		else if (player.getCurrentDay() == 13) {
			lbl10_3.setVisible(true);
		}
		else if (player.getCurrentDay() == 14) {
			lbl10_4.setVisible(true);
		}
		else if (player.getCurrentDay() == 15) {
			lbl10_5.setVisible(true);
		}
	}
	
}
