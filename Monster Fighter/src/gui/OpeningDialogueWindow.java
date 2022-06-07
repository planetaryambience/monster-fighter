package gui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;

import gui.setup.ChooseMonsterWindow;
import main.actor.Player;

import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A window that goes through an opening dialogue for the game.
 */
public class OpeningDialogueWindow {

	/**
	 * OpeningDialogueWindow frame.
	 */
	private JFrame windowOpeningDialogue;
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * Create the application.
	 * @param p player
	 */
	public OpeningDialogueWindow(Player p) {
		player = p;
		initialize();
		windowOpeningDialogue.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowOpeningDialogue = new JFrame();
		windowOpeningDialogue.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowOpeningDialogue.setIconImage(Toolkit.getDefaultToolkit().getImage(OpeningDialogueWindow.class.getResource("/img/Game Icon.png")));
		windowOpeningDialogue.setTitle("Welcome to the Arena!");
		windowOpeningDialogue.setResizable(false);
		windowOpeningDialogue.setBounds(100, 100, 600, 350);
		windowOpeningDialogue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowOpeningDialogue.getContentPane().setLayout(null);
		
		JLabel lblProfPic = new JLabel("");
		lblProfPic.setIcon(new ImageIcon(OpeningDialogueWindow.class.getResource("/img/Prof._Pic.png")));
		lblProfPic.setBounds(-48, -13, 253, 459);
		windowOpeningDialogue.getContentPane().add(lblProfPic);
		
		
		JButton btnConfirm = new JButton("");
		btnConfirm.setIcon(new ImageIcon(OpeningDialogueWindow.class.getResource("/img/button_Confirm_25_.png")));
		btnConfirm.setVisible(false);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowOpeningDialogue.dispose();
				ChooseMonsterWindow chooseMonster = new ChooseMonsterWindow(player);
			}
		});
		btnConfirm.setBounds(419, 253, 129, 33);
		windowOpeningDialogue.getContentPane().add(btnConfirm);
		
		JLabel lblDialogue4 = new JLabel("\"My name is Brian,");
		lblDialogue4.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblDialogue4.setVisible(false);
		lblDialogue4.setBounds(197, 35, 371, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue4);
		
		JLabel lblDialogue5 = new JLabel("But everyone calls me");
		lblDialogue5.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblDialogue5.setVisible(false);
		lblDialogue5.setBounds(197, 93, 371, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue5);
		
		JLabel lblDialogue6 = new JLabel("the Monster Professor.\"");
		lblDialogue6.setFont(new Font("Dialog", Font.PLAIN, 23));
		lblDialogue6.setVisible(false);
		lblDialogue6.setBounds(197, 151, 371, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue6);
		
		JLabel lblDialogue1 = new JLabel("\"Hi " + player.getPlayerName() + "!");
		lblDialogue1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		lblDialogue1.setBounds(207, 35, 346, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue1);
		
		JLabel lblDialogue2 = new JLabel("Welcome to the Arena");
		lblDialogue2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		lblDialogue2.setBounds(207, 93, 346, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue2);
		
		JLabel lblDialogue3 = new JLabel("of Monster Fighters!\"");
		lblDialogue3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 23));
		lblDialogue3.setBounds(207, 151, 346, 48);
		windowOpeningDialogue.getContentPane().add(lblDialogue3);
		
		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext.setVisible(false);
				btnConfirm.setVisible(true);
				lblDialogue1.setVisible(false);
				lblDialogue2.setVisible(false);
				lblDialogue3.setVisible(false);
				lblDialogue4.setVisible(true);
				lblDialogue5.setVisible(true);
				lblDialogue6.setVisible(true);
			}
		});
		btnNext.setIcon(new ImageIcon(OpeningDialogueWindow.class.getResource("/img/Button_Next_25_.png")));
		btnNext.setBounds(473, 253, 75, 33);
		windowOpeningDialogue.getContentPane().add(btnNext);

	}

	
}
