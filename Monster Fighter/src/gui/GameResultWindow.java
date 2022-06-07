package gui;

import javax.swing.JFrame;

import main.actor.Player;
import main.inventory.Inventory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * A window that shows a summary of the player's game after the game has ended.
 */
public class GameResultWindow {

	/**
	 * GameResultWindow frame.
	 */
	private JFrame windowGameEnd;
	
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
	 * @param player player
	 * @param inventory the player's inventory
	 */
	public GameResultWindow(Player player, Inventory inventory) {
		this.player = player;
		this.inventory = inventory;
		initialize();
		windowGameEnd.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowGameEnd = new JFrame();
		windowGameEnd.setTitle("Game Over");
		windowGameEnd.setBounds(100, 100, 600, 350);
		windowGameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowGameEnd.getContentPane().setLayout(null);
		
		JLabel lblPlayerName = new JLabel("");
		lblPlayerName.setText(player.getPlayerName());
		lblPlayerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName.setBounds(119, 15, 346, 69);
		windowGameEnd.getContentPane().add(lblPlayerName);
		
		JLabel lblDays = new JLabel("");
		lblDays.setText("Days: " + player.getCurrentDay() + "/" + player.getNumOfDays());
		lblDays.setHorizontalAlignment(SwingConstants.CENTER);
		lblDays.setBounds(183, 140, 218, 45);
		windowGameEnd.getContentPane().add(lblDays);
		
		JLabel lblScore = new JLabel("");
		lblScore.setText("Total Score: " + player.getGameScore());
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(206, 191, 171, 45);
		windowGameEnd.getContentPane().add(lblScore);
		
		JLabel lblGold = new JLabel("");
		lblGold.setText("Gold: " + inventory.getGold());
		lblGold.setHorizontalAlignment(SwingConstants.CENTER);
		lblGold.setBounds(206, 90, 171, 45);
		windowGameEnd.getContentPane().add(lblGold);
		
		JButton btnContinue = new JButton("");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowGameEnd.dispose();
				EndCreditsWindow ECW = new EndCreditsWindow();
			}
		});
		btnContinue.setIcon(new ImageIcon(GameResultWindow.class.getResource("/img/ContinueButton(25).png")));
		btnContinue.setBounds(240, 271, 125, 30);
		windowGameEnd.getContentPane().add(btnContinue);
	}
}
