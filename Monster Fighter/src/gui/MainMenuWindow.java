package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gui.setup.SetupPlayerWindow;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.SystemColor;

/**
 * The main menu window.
 */
public class MainMenuWindow {

	/**
	 * MainMenuWindow frame.
	 */
	private JFrame windowMainMenu;

	/**
	 * Create the application.
	 */
	public MainMenuWindow() {
		initialize();
		windowMainMenu.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		windowMainMenu.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowMainMenu = new JFrame();
		windowMainMenu.setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenuWindow.class.getResource("/img/Game Icon.png")));
		windowMainMenu.getContentPane().setBackground(Color.LIGHT_GRAY);
		windowMainMenu.setResizable(false);
		windowMainMenu.setTitle("Monster Fighter");
		windowMainMenu.setBounds(100, 100, 600, 350);
		windowMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowMainMenu.getContentPane().setLayout(null);
		
		JLabel lblMainMenuLogo = new JLabel("");
		lblMainMenuLogo.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/img/Logo.png")));
		lblMainMenuLogo.setBounds(26, 21, 524, 84);
		windowMainMenu.getContentPane().add(lblMainMenuLogo);
		
		JButton btnNewGame = new JButton("");
		btnNewGame.setBackground(SystemColor.controlHighlight);
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				SetupPlayerWindow setup = new SetupPlayerWindow();
			}
		});
		btnNewGame.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/img/NEW GAME Button.png")));
		btnNewGame.setBounds(178, 132, 224, 44);
		windowMainMenu.getContentPane().add(btnNewGame);
		
		JButton btnLeaderboard = new JButton("");
		btnLeaderboard.setBackground(SystemColor.controlHighlight);
		btnLeaderboard.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/img/LEADERBOARD Button.png")));
		btnLeaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				LeaderboardWindow leaderboard = new LeaderboardWindow();
			}
		});
		btnLeaderboard.setBounds(143, 186, 296, 44);
		windowMainMenu.getContentPane().add(btnLeaderboard);
		
		JButton btnQuit = new JButton("");
		btnQuit.setBackground(SystemColor.controlHighlight);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnQuit.setFont(new Font("SimSun", Font.PLAIN, 5));
		btnQuit.setIcon(new ImageIcon(MainMenuWindow.class.getResource("/img/QUIT Button.png")));
		btnQuit.setBounds(237, 240, 107, 44);
		windowMainMenu.getContentPane().add(btnQuit);
	}
}
