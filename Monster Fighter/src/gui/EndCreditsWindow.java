package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * An end credits window.
 */
public class EndCreditsWindow {

	/**
	 * EndCreditsWindow frame.
	 */
	private JFrame windowEndCredits;

	/**
	 * Create the application.
	 */
	public EndCreditsWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowEndCredits = new JFrame();
		windowEndCredits.setIconImage(Toolkit.getDefaultToolkit().getImage(EndCreditsWindow.class.getResource("/img/Heart.png")));
		windowEndCredits.setBounds(100, 100, 600, 350);
		windowEndCredits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowEndCredits.getContentPane().setLayout(null);
		windowEndCredits.setVisible(true);
		
		JButton btnMainMenu = new JButton("");
		btnMainMenu.setIcon(new ImageIcon(EndCreditsWindow.class.getResource("/img/MainMenuButton(25).png")));
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowEndCredits.dispose();
				MainMenuWindow mainMenu = new MainMenuWindow();
			}
		});
		btnMainMenu.setBounds(333, 267, 142, 34);
		windowEndCredits.getContentPane().add(btnMainMenu);
		
		JButton btnQuit = new JButton("");
		btnQuit.setIcon(new ImageIcon(EndCreditsWindow.class.getResource("/img/QuitButton(25).png")));
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowEndCredits.dispose();
			}
		});
		btnQuit.setBounds(485, 267, 89, 34);
		windowEndCredits.getContentPane().add(btnQuit);
		
		JLabel lblThx = new JLabel("");
		lblThx.setIcon(new ImageIcon(EndCreditsWindow.class.getResource("/img/Thank you for playing our game.png")));
		lblThx.setBounds(90, 10, 389, 118);
		windowEndCredits.getContentPane().add(lblThx);
		
		JLabel lblNewLabel_1 = new JLabel("A game by:");
		lblNewLabel_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(241, 135, 101, 21);
		windowEndCredits.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Jessie F.          Xu H.");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(194, 166, 209, 21);
		windowEndCredits.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\"A LOT OF MONSTERS WERE HARMED DURING THE MAKING OF THIS GAME\"®");
		lblNewLabel_1_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(42, 211, 513, 21);
		windowEndCredits.getContentPane().add(lblNewLabel_1_1_1);
	}
}
