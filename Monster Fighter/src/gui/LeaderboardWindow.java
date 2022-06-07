package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;


/**
 * A window that shows a leaderboard of high scores.
 */
public class LeaderboardWindow {

	/**
	 * LeaderboardWindow frame.
	 */
	private JFrame frmLeaderboard;

	/**
	 * Create the application.
	 */
	public LeaderboardWindow() {
		initialize();
		frmLeaderboard.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLeaderboard = new JFrame();
		frmLeaderboard.setResizable(false);
		frmLeaderboard.setTitle("Leaderboard");
		frmLeaderboard.setIconImage(Toolkit.getDefaultToolkit().getImage(LeaderboardWindow.class.getResource("/img/Leaderboard Icon.PNG")));
		frmLeaderboard.setBounds(100, 100, 600, 350);
		frmLeaderboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeaderboard.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/High Scores.png")));
		lblNewLabel.setBounds(30, 10, 523, 63);
		frmLeaderboard.getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("");
		btnBack.setForeground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLeaderboard.dispose();
				MainMenuWindow mainMenu = new MainMenuWindow();
			}
		});
		btnBack.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Back Button.png")));
		btnBack.setBounds(465, 267, 109, 34);
		frmLeaderboard.getContentPane().add(btnBack);
		
		JLabel lblLDBD_Rank1 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1.setBounds(74, 95, 216, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1);
		
		JLabel lblLDBD_Rank1_1 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1_1.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1_1.setBounds(74, 139, 216, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1_1);
		
		JLabel lblLDBD_Rank1_2 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1_2.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1_2.setBounds(74, 183, 216, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1_2);
		
		JLabel lblLDBD_Rank1_3 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1_3.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1_3.setBounds(331, 95, 243, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1_3);
		
		JLabel lblLDBD_Rank1_4 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1_4.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1_4.setBounds(331, 139, 243, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1_4);
		
		JLabel lblLDBD_Rank1_5 = new JLabel("1,000,000 - PlayerName2011");
		lblLDBD_Rank1_5.setFont(new Font("SimSun", Font.PLAIN, 15));
		lblLDBD_Rank1_5.setBounds(331, 183, 243, 34);
		frmLeaderboard.getContentPane().add(lblLDBD_Rank1_5);
		
		JLabel lblRank1Pic = new JLabel("");
		lblRank1Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank1.png")));
		lblRank1Pic.setBounds(40, 95, 31, 34);
		frmLeaderboard.getContentPane().add(lblRank1Pic);
		
		JLabel lblRank2Pic = new JLabel("");
		lblRank2Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank2.png")));
		lblRank2Pic.setBounds(30, 139, 42, 34);
		frmLeaderboard.getContentPane().add(lblRank2Pic);
		
		JLabel lblRank3Pic = new JLabel("");
		lblRank3Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank3.png")));
		lblRank3Pic.setBounds(30, 183, 42, 34);
		frmLeaderboard.getContentPane().add(lblRank3Pic);
		
		JLabel lblRank4Pic = new JLabel("");
		lblRank4Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank4.png")));
		lblRank4Pic.setBounds(289, 95, 42, 34);
		frmLeaderboard.getContentPane().add(lblRank4Pic);
		
		JLabel lblRank5Pic = new JLabel("");
		lblRank5Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank5.png")));
		lblRank5Pic.setBounds(289, 139, 42, 34);
		frmLeaderboard.getContentPane().add(lblRank5Pic);
		
		JLabel lblRank6Pic = new JLabel("");
		lblRank6Pic.setIcon(new ImageIcon(LeaderboardWindow.class.getResource("/img/Rank6.png")));
		lblRank6Pic.setBounds(289, 183, 42, 34);
		frmLeaderboard.getContentPane().add(lblRank6Pic);
	}
}
