package gui.setup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import main.game.NameValidator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

/**
 * A window that lets player input a name.
 */
public class SetupPlayerWindow {

	/**
	 * SetupPlayerWindow frame.
	 */
	private JFrame windowSetupPlayer;
	
	/**
	 * JTextField for user to input a player name.
	 */
	private JTextField txtPlayerName;

	/**
	 * Create the application.
	 */
	public SetupPlayerWindow() {
		initialize();
		windowSetupPlayer.setVisible(true);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		windowSetupPlayer = new JFrame();
		windowSetupPlayer.setIconImage(Toolkit.getDefaultToolkit().getImage(SetupPlayerWindow.class.getResource("/img/Game Icon.png")));
		windowSetupPlayer.setResizable(false);
		windowSetupPlayer.setTitle("Your Name, Monster Fighter?");
		windowSetupPlayer.setBounds(100, 100, 601, 350);
		windowSetupPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowSetupPlayer.getContentPane().setLayout(null);
		
		JLabel lblEnterName = new JLabel("");
		lblEnterName.setIcon(new ImageIcon(SetupPlayerWindow.class.getResource("/img/NameInput.png")));
		lblEnterName.setBounds(63, 30, 458, 138);
		windowSetupPlayer.getContentPane().add(lblEnterName);
		
		txtPlayerName = new JTextField();
		txtPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlayerName.setBounds(169, 198, 247, 20);
		windowSetupPlayer.getContentPane().add(txtPlayerName);
		txtPlayerName.setColumns(10);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String playerName = txtPlayerName.getText();
				boolean hasErrors = false;
				
				if (!NameValidator.isValidPlayerName(playerName)) {
					hasErrors = true;
					JOptionPane.showMessageDialog(windowSetupPlayer, "Player name must be:"
							+ "\n- A length of 3-15 characters.\n- Only contain letters.");
				}
				
				if (!hasErrors) {
					windowSetupPlayer.dispose();
					SetupDiffWindow setupDiff = new SetupDiffWindow(playerName);
				}
			}
		});
		btnConfirm.setBounds(218, 248, 149, 31);
		btnConfirm.setIcon(new ImageIcon(SetupDiffWindow.class.getResource("/img/button_Confirm_25_.png")));
		windowSetupPlayer.getContentPane().add(btnConfirm);
	}
}
