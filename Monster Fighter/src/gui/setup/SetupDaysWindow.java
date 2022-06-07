package gui.setup;

import javax.swing.JFrame;
import javax.swing.JSlider;

import main.actor.Player;
import main.game.Game;
import main.inventory.Inventory;

import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A window for the player to select how many number of days they want the game to last.
 */
public class SetupDaysWindow {

	/**
	 * SetupDaysWindow frame.
	 */
	private JFrame windowSetNumOfDays;
	
	/**
	 * The player's name.
	 */
	private String playerName;
	
	/**
	 * The difficulty of the game.
	 */
	private String difficulty;
	
	/**
	 * Create the application.
	 * @param name the player's name
	 * @param diff the difficulty of the game
	 */
	public SetupDaysWindow(String name, String diff) {
		playerName = name;
		difficulty = diff;
		initialize();
		windowSetNumOfDays.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		windowSetNumOfDays.dispose();
	}
	
	/**
	 * Closes the window by calling Game.closeSetupDays().
	 * @param p player
	 */
	public void finishedWindow(Player p) {
		Game game = new Game();
		game.closeSetupDays(this, p);
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		windowSetNumOfDays = new JFrame();
		windowSetNumOfDays.setIconImage(Toolkit.getDefaultToolkit().getImage(SetupDaysWindow.class.getResource("/img/Game Icon.png")));
		windowSetNumOfDays.setTitle("Set Up Your Game!");
		windowSetNumOfDays.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowSetNumOfDays.setBounds(100, 100, 600, 350);
		windowSetNumOfDays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowSetNumOfDays.getContentPane().setLayout(null);
		
		JSlider sldNumOfDays = new JSlider();
		sldNumOfDays.setValue(10);
		sldNumOfDays.setSnapToTicks(true);
		sldNumOfDays.setPaintTicks(true);
		sldNumOfDays.setPaintLabels(true);
		sldNumOfDays.setMinimum(5);
		sldNumOfDays.setMaximum(15);
		sldNumOfDays.setMajorTickSpacing(1);
		sldNumOfDays.setBackground(SystemColor.inactiveCaptionBorder);
		sldNumOfDays.setBounds(91, 131, 391, 72);
		windowSetNumOfDays.getContentPane().add(sldNumOfDays);
		
		JButton btnConfirm = new JButton("");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int days = sldNumOfDays.getValue();
				Inventory inventory = new Inventory();
				Player player = new Player(playerName, difficulty, days);
				finishedWindow(player);
			}
		});
		btnConfirm.setIcon(new ImageIcon(SetupDaysWindow.class.getResource("/img/button_Confirm_25_.png")));
		btnConfirm.setBounds(217, 233, 129, 33);
		windowSetNumOfDays.getContentPane().add(btnConfirm);
		
		JLabel lblSelectDays = new JLabel("");
		lblSelectDays.setIcon(new ImageIcon(SetupDaysWindow.class.getResource("/img/SelectNumOfDays_45_.png")));
		lblSelectDays.setBounds(32, 43, 502, 55);
		windowSetNumOfDays.getContentPane().add(lblSelectDays);
	}

}
