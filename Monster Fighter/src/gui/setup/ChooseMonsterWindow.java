package gui.setup;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;

import main.actor.Player;
import main.game.Game;
import main.inventory.Inventory;
import main.monster.*;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUI implementation of ChooseMonsterWindow.
 * A window that allows user to choose from three monsters.
 */
public class ChooseMonsterWindow {

	/**
	 * ChooseMonsterWindow frame.
	 */
	private JFrame windowChooseMonster;
	
	/**
	 * JTextField for player to name their monster.
	 */
	private JTextField txtMonsterName;
	
	/**
	 * ButtonGroup of monster options.
	 */
	private final ButtonGroup btnGroupMonsters = new ButtonGroup();
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory = new Inventory();
	
	/**
	 * Create the application using overloaded constructor.
	 * @param p player
	 */
	public ChooseMonsterWindow(Player p) {
		player = p;
		initialize();
		windowChooseMonster.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowChooseMonster = new JFrame();
		windowChooseMonster.setResizable(false);
		windowChooseMonster.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowChooseMonster.setTitle("Your First Monster!");
		windowChooseMonster.setIconImage(Toolkit.getDefaultToolkit().getImage(ChooseMonsterWindow.class.getResource("/img/Monster Page Icon.png")));
		windowChooseMonster.setBounds(100, 100, 600, 350);
		windowChooseMonster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowChooseMonster.getContentPane().setLayout(null);
		
		JLabel lblDialogue1 = new JLabel("\"You are new here... I see you don't have a monster yet");
		lblDialogue1.setVerticalAlignment(SwingConstants.TOP);
		lblDialogue1.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDialogue1.setBounds(61, 12, 449, 26);
		windowChooseMonster.getContentPane().add(lblDialogue1);
		
		JLabel lblDialogue2 = new JLabel("Don't worry, I'll give you one for free, cuz I'm the Monster Professor.\"");
		lblDialogue2.setVerticalAlignment(SwingConstants.TOP);
		lblDialogue2.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblDialogue2.setBounds(15, 35, 571, 39);
		windowChooseMonster.getContentPane().add(lblDialogue2);
		
		JRadioButton rbtSTDD = new JRadioButton("<html>Single Target <br> Damage Dealer</html>");
		btnGroupMonsters.add(rbtSTDD);
		rbtSTDD.setBackground(SystemColor.inactiveCaptionBorder);
		rbtSTDD.setBounds(228, 175, 127, 43);
		windowChooseMonster.getContentPane().add(rbtSTDD);
		
		JRadioButton rbtLT = new JRadioButton("Light Tank");
		rbtLT.setSelected(true);
		btnGroupMonsters.add(rbtLT);
		rbtLT.setBackground(SystemColor.inactiveCaptionBorder);
		rbtLT.setBounds(76, 177, 118, 23);
		windowChooseMonster.getContentPane().add(rbtLT);
		
		JRadioButton rbtSTH = new JRadioButton("<html>Single Target <br> Healer</html>");
		btnGroupMonsters.add(rbtSTH);
		rbtSTH.setBackground(SystemColor.inactiveCaptionBorder);
		rbtSTH.setBounds(383, 175, 127, 43);
		windowChooseMonster.getContentPane().add(rbtSTH);
		
		JLabel lblLT = new JLabel("");
		lblLT.setIcon(new ImageIcon(ChooseMonsterWindow.class.getResource("/img/Eligor_LT_.png")));
		lblLT.setBounds(100, 74, 64, 64);
		windowChooseMonster.getContentPane().add(lblLT);
		
		JLabel lblSTH = new JLabel("");
		lblSTH.setIcon(new ImageIcon(ChooseMonsterWindow.class.getResource("/img/Vapula_STH_.png")));
		lblSTH.setBounds(414, 74, 64, 74);
		windowChooseMonster.getContentPane().add(lblSTH);
		
		JLabel lblSTDD = new JLabel("");
		lblSTDD.setIcon(new ImageIcon(ChooseMonsterWindow.class.getResource("/img/Labolas_STDD_.png")));
		lblSTDD.setBounds(260, 74, 64, 64);
		windowChooseMonster.getContentPane().add(lblSTDD);
		
		JButton btnViewStatsLT = new JButton("View Stats");
		btnViewStatsLT.setFont(new Font("Dialog", Font.BOLD, 10));
		btnViewStatsLT.setToolTipText("<html> Eligor <br> Health: 150/150  <br> Attack: 25 <br> Heal: 6 </html>");
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(60000);
		btnViewStatsLT.setBounds(83, 149, 99, 23);
		windowChooseMonster.getContentPane().add(btnViewStatsLT);
		
		JButton btnViewStatsSTDD = new JButton("View Stats");
		btnViewStatsSTDD.setFont(new Font("Dialog", Font.BOLD, 10));
		btnViewStatsSTDD.setToolTipText("<html> Vapula <br> Health: 100/100  <br> Attack: 50 <br> Heal: 10 </html>");
		btnViewStatsSTDD.setBounds(242, 149, 99, 23);
		windowChooseMonster.getContentPane().add(btnViewStatsSTDD);
		
		JButton btnViewStatsSTH = new JButton("View Stats");
		btnViewStatsSTH.setFont(new Font("Dialog", Font.BOLD, 10));
		btnViewStatsSTH.setToolTipText("<html> Labolas <br> Health: 80/80  <br> Attack: 10 <br> Heal: 40 </html>");
		btnViewStatsSTH.setBounds(397, 149, 99, 23);
		windowChooseMonster.getContentPane().add(btnViewStatsSTH);
		
		JLabel lbldontForgetTo = new JLabel("\"Don't forget to give your monster a name!\"");
		lbldontForgetTo.setVerticalAlignment(SwingConstants.TOP);
		lbldontForgetTo.setFont(new Font("Dialog", Font.PLAIN, 16));
		lbldontForgetTo.setBounds(15, 236, 359, 26);
		windowChooseMonster.getContentPane().add(lbldontForgetTo);
		
		txtMonsterName = new JTextField();
		txtMonsterName.setHorizontalAlignment(SwingConstants.CENTER);
		txtMonsterName.setBounds(15, 266, 351, 21);
		windowChooseMonster.getContentPane().add(txtMonsterName);
		txtMonsterName.setColumns(10);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean hasError = false;
				
				if (rbtLT.isSelected()) {
					inventory.addMonster(new LightTank(), 0);;
				}
				else if (rbtSTH.isSelected()) {
					inventory.addMonster(new SingleTargetHealer(), 0);;
					
				}
				else {  // rbtSTDD
					inventory.addMonster(new SingleTargetDamageDealer(), 0);;
					
				}
				
				// optional: give monster a custom name.
				if (!txtMonsterName.getText().isBlank()) {
					inventory.getMonster(0).setMonsterName(txtMonsterName.getText());
				}
				
				
				windowChooseMonster.dispose();
				Game.launchMainGame(player, inventory);
			}
		});
		btnConfirm.setIcon(new ImageIcon(ChooseMonsterWindow.class.getResource("/img/button_Confirm_25_.png")));
		btnConfirm.setBounds(419, 254, 129, 33);
		windowChooseMonster.getContentPane().add(btnConfirm);
	}
}
