package gui;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import main.actor.Opponent;
import main.actor.Player;
import main.inventory.Inventory;

import java.awt.Font;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A window for the player to choose a battle.
 */
public class ChooseBattleWindow {

	/**
	 * ChooseBattleWindow frame.
	 */
	private JFrame windowChooseBattle;
	
	/**
	 * Button group for possible battle options.
	 */
	private final ButtonGroup btnGroupOpponents = new ButtonGroup();
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory;
	
	/**
	 * The {@link Opponent}.
	 */
	private Opponent opponent = new Opponent();
	
	/**
	 * The potential amount of levels that can be gained from a battle.
	 */
	private int potentialLevelsGained;


	/**
	 * Create the application.
	 * @param p the player
	 * @param i the player's inventory
	 */
	public ChooseBattleWindow(Player p, Inventory i) {
		player = p;
		inventory = i;
		initialize();
		windowChooseBattle.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowChooseBattle = new JFrame();
		windowChooseBattle.setBackground(SystemColor.inactiveCaptionBorder);
		windowChooseBattle.setIconImage(Toolkit.getDefaultToolkit().getImage(ChooseBattleWindow.class.getResource("/img/Game Icon.png")));
		windowChooseBattle.setTitle("Choose Your Battle!");
		windowChooseBattle.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowChooseBattle.getContentPane().setLayout(null);
		
		JLabel lblOpponentMonsterLevel = new JLabel("");
		lblOpponentMonsterLevel.setText("Lv: " + opponent.opponentLevel(player));
		lblOpponentMonsterLevel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblOpponentMonsterLevel.setBounds(56, 255, 92, 32);
		windowChooseBattle.getContentPane().add(lblOpponentMonsterLevel);
		
		JLabel lblText1 = new JLabel("Opponent Team Monster Levels:");
		lblText1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblText1.setBounds(51, 217, 389, 32);
		windowChooseBattle.getContentPane().add(lblText1);
		
		JRadioButton rdbtnOpponent2 = new JRadioButton("");
		btnGroupOpponents.add(rdbtnOpponent2);
		rdbtnOpponent2.setSelected(true);
		rdbtnOpponent2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	lblOpponentMonsterLevel.setText("Lv: " + (opponent.opponentLevel(player)));
	        }
		});
		
		rdbtnOpponent2.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnOpponent2.setBounds(282, 168, 21, 21);
		windowChooseBattle.getContentPane().add(rdbtnOpponent2);
		
		JRadioButton rdbtnOpponent3 = new JRadioButton("");
		btnGroupOpponents.add(rdbtnOpponent3);
		rdbtnOpponent3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	lblOpponentMonsterLevel.setText("Lv: " + (opponent.opponentLevel(player)+4));
	        }
		});
		rdbtnOpponent3.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnOpponent3.setBounds(460, 168, 21, 21);
		windowChooseBattle.getContentPane().add(rdbtnOpponent3);
		
		JRadioButton rdbtnOpponent1 = new JRadioButton("");
		btnGroupOpponents.add(rdbtnOpponent1);
		rdbtnOpponent1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	lblOpponentMonsterLevel.setText("Lv: " + (opponent.opponentLevel(player)-4));
	        }
		});
		rdbtnOpponent1.setBackground(SystemColor.inactiveCaptionBorder);
		rdbtnOpponent1.setBounds(99, 168, 21, 23);
		windowChooseBattle.getContentPane().add(rdbtnOpponent1);
		
		Random rand = new Random();
		int r1 = rand.nextInt(10);
		int r2 = rand.nextInt(10);
		r1 += 1;
		r2 += 1;
		if (r2 == r1) {
			r2 += 1;
			if (r2 == 11) {
				r2 = 1;
			}
		}
		int r3 = rand.nextInt(10);
		r3 += 1;
		if (r3 == r1) {
			r3 += 1;
			if (r3 == 11) {
				r3 = 1;
			}
		}
		if (r3 == r2) {
			r3 += 1;
			if (r3 == 11) {
				r3 = 1;
			}
		}
		
		JLabel lblOpponent2 = new JLabel("");
		lblOpponent2.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/Round Frame.png")));
		lblOpponent2.setBounds(29, 31, 170, 191);
		windowChooseBattle.getContentPane().add(lblOpponent2);
		
		JLabel lblPortrait1 = new JLabel("");
		lblPortrait1.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/portrait"+r1+".png")));
		lblPortrait1.setBounds(51, 46, 100, 116);
		windowChooseBattle.getContentPane().add(lblPortrait1);
		
		JLabel lblRoundFrame2 = new JLabel("");
		lblRoundFrame2.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/Round Frame.png")));
		lblRoundFrame2.setBounds(209, 31, 170, 191);
		windowChooseBattle.getContentPane().add(lblRoundFrame2);
		
		JLabel lblRoundFrame3 = new JLabel("");
		lblRoundFrame3.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/Round Frame.png")));
		lblRoundFrame3.setBounds(389, 31, 170, 191);
		windowChooseBattle.getContentPane().add(lblRoundFrame3);
		
		JLabel lblPortrait2 = new JLabel("");
		lblPortrait2.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/portrait"+r2+".png")));
		lblPortrait2.setBounds(237, 46, 100, 116);
		windowChooseBattle.getContentPane().add(lblPortrait2);
		
		JLabel lblPortrait3 = new JLabel("");
		lblPortrait3.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/portrait"+r3+".png")));
		lblPortrait3.setBounds(416, 46, 100, 116);
		windowChooseBattle.getContentPane().add(lblPortrait3);
		
		JButton btnFight = new JButton("");
		btnFight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Opponent opponent = new Opponent();
				opponent.generateOpponentBattleTeam(inventory);
				int oppoLevel;
				if (rdbtnOpponent1.isSelected()) {
					oppoLevel = opponent.opponentLevel(player) - 4;
					potentialLevelsGained = 3;
				}
				else if (rdbtnOpponent2.isSelected()) {
					oppoLevel = opponent.opponentLevel(player);
					potentialLevelsGained = 4;
				}
				else {
					oppoLevel = opponent.opponentLevel(player) + 4;
					potentialLevelsGained = 5;
				}
				
				BattleWindow BW = new BattleWindow(player, inventory, opponent, oppoLevel, potentialLevelsGained);
				windowChooseBattle.dispose();
			}
		});
		btnFight.setIcon(new ImageIcon(ChooseBattleWindow.class.getResource("/img/Button Fight(15).png")));
		btnFight.setBounds(460, 271, 124, 40);
		windowChooseBattle.getContentPane().add(btnFight);;
		windowChooseBattle.setResizable(false);
		windowChooseBattle.setBounds(100, 100, 600, 350);
		windowChooseBattle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
