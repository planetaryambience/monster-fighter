package gui.setup;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A window that lets player select the game difficulty.
 */
public class SetupDiffWindow {

	/**
	 * SetupDiffWindow frame.
	 */
	private JFrame windowSetDiff;
	
	/**
	 * ButtonGroup for two difficulty choices.
	 */
	private final ButtonGroup btnGroupDiff = new ButtonGroup();
	
	/**
	 * The player's name.
	 */
	private String playerName;
	
	/**
	 * Create the application.
	 * @param name the player's name
	 */
	public SetupDiffWindow(String name) {
		playerName = name;
		initialize();
		windowSetDiff.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowSetDiff = new JFrame();
		windowSetDiff.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowSetDiff.setResizable(false);
		windowSetDiff.setTitle("Set Up Your Game!");
		windowSetDiff.setIconImage(Toolkit.getDefaultToolkit().getImage(SetupDiffWindow.class.getResource("/img/Game Icon.png")));
		windowSetDiff.setBounds(100, 100, 600, 350);
		windowSetDiff.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowSetDiff.getContentPane().setLayout(null);
		
		JLabel lblHard = new JLabel("");
		lblHard.setIcon(new ImageIcon(SetupDiffWindow.class.getResource("/img/Hard_30_.png")));
		lblHard.setBounds(303, 121, 97, 30);
		windowSetDiff.getContentPane().add(lblHard);
		
		JLabel lblNormal = new JLabel("");
		lblNormal.setIcon(new ImageIcon(SetupDiffWindow.class.getResource("/img/Normal_30_.png")));
		lblNormal.setBounds(151, 121, 134, 30);
		windowSetDiff.getContentPane().add(lblNormal);
		
		JLabel lblSelectDiff = new JLabel("");
		lblSelectDiff.setIcon(new ImageIcon(SetupDiffWindow.class.getResource("/img/SelectDiff_45_.png")));
		lblSelectDiff.setBounds(102, 41, 358, 54);
		windowSetDiff.getContentPane().add(lblSelectDiff);
		
		JRadioButton rbtNormalDifficulty = new JRadioButton("");
		rbtNormalDifficulty.setSelected(true);
		rbtNormalDifficulty.setBackground(SystemColor.inactiveCaptionBorder);
		btnGroupDiff.add(rbtNormalDifficulty);
		rbtNormalDifficulty.setBounds(213, 157, 21, 23);
		windowSetDiff.getContentPane().add(rbtNormalDifficulty);
		
		JRadioButton rbtHardDifficulty = new JRadioButton("");
		rbtHardDifficulty.setBackground(SystemColor.inactiveCaptionBorder);
		btnGroupDiff.add(rbtHardDifficulty);
		rbtHardDifficulty.setBounds(341, 157, 21, 23);
		windowSetDiff.getContentPane().add(rbtHardDifficulty);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String difficulty = "normal";
				boolean hasErrors = false;

				if (rbtNormalDifficulty.isSelected()) {
					difficulty = "normal";
				}
				else if (rbtHardDifficulty.isSelected()) {
					difficulty = "hard";
				}
				else {
					hasErrors = true;
					JOptionPane.showMessageDialog(null, "Please select a difficulty.");
				}
				
				if (!hasErrors) {
					windowSetDiff.dispose();
					SetupDaysWindow setupDays = new SetupDaysWindow(playerName, difficulty);
				}
			}
		});
		btnConfirm.setIcon(new ImageIcon(SetupDiffWindow.class.getResource("/img/button_Confirm_25_.png")));
		btnConfirm.setBounds(223, 228, 129, 33);
		windowSetDiff.getContentPane().add(btnConfirm);
	}
}
