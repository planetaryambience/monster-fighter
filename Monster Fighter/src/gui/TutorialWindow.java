package gui;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ToolTipManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import main.actor.Player;
import main.inventory.Inventory;

/**
 * A window with some tutorials.
 */
public class TutorialWindow {

	/**
	 * TutorialWindow frame.
	 */
	private JFrame windowTutorial;
	
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
	public TutorialWindow(Player player, Inventory inventory) {
		this.player = player;
		this.inventory = inventory;
		initialize();
		windowTutorial.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowTutorial = new JFrame();
		windowTutorial.setResizable(false);
		windowTutorial.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		windowTutorial.setTitle("Welcome to the Arena!");
		windowTutorial.setIconImage(Toolkit.getDefaultToolkit().getImage(TutorialWindow.class.getResource("/img/Game Icon.png")));
		windowTutorial.setBounds(100, 100, 600, 350);
		windowTutorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		windowTutorial.getContentPane().setLayout(null);
		
		JLabel lblProfPic = new JLabel("");
		lblProfPic.setIcon(new ImageIcon(TutorialWindow.class.getResource("/img/Prof._Pic.png")));
		lblProfPic.setBounds(-48, -13, 253, 459);
		windowTutorial.getContentPane().add(lblProfPic);
		
		JLabel lbliCanAnswer = new JLabel("\"I can answer your question about...\"");
		lbliCanAnswer.setFont(new Font("Dialog", Font.PLAIN, 18));
		lbliCanAnswer.setBounds(188, 23, 385, 48);
		windowTutorial.getContentPane().add(lbliCanAnswer);
		
		JButton btnTutorialArena = new JButton("The Arena");
		btnTutorialArena.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialArena.setToolTipText("<html>"+
		"The Monster Arena is a place"+"<br>"
		+"where Monster Fighters from all"+"<br>"
		+"over the world comes together to"+"<br>"
		+"test their fighting skill. You are"+"<br>"
		+"here for the same reason!");
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(60000);
		btnTutorialArena.setBounds(235, 83, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialArena);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon(TutorialWindow.class.getResource("/img/Back Button.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				windowTutorial.dispose();
				MainGameWindow mainGame = new MainGameWindow(player, inventory);
			}
		});
		btnBack.setBounds(453, 270, 110, 31);
		windowTutorial.getContentPane().add(btnBack);
		
		JButton btnTutorialMonsters = new JButton("Monsters");
		btnTutorialMonsters.setToolTipText("<html>"+
		"Monsters are powerful creatures"+"<br>"
		+"that can be s̶l̶a̶v̶e̶d̶ trained by"+"<br>"
		+"us humans, anad us Monster"+"<br>"
		+"Fighters put them into battles"+"<br>"
		+"for ̶f̶u̶n̶ honor! Like many other"+"<br>"
		+"games, there are tanks, damage"+"<br>"
		+"dealers and healers, you will"+"<br>"
		+"find out more about the monsters"+"<br>"
		+"when you step into the Arena"+"<br>"
		+"yourself!");
		btnTutorialMonsters.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialMonsters.setBounds(369, 83, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialMonsters);
		
		JButton btnTutorialShop = new JButton("The Shop");
		btnTutorialShop.setToolTipText("<html>"+
		"Evil Pixel Mage is running"+"<br>"
		+ "a shop in the Arena,"+"<br>"
		+ "go visit sometimes, "+"<br>"
		+ "maybe you can find some"+"<br>"
		+ "items or monsters you need.");
		btnTutorialShop.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialShop.setBounds(369, 125, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialShop);
		
		JButton btnTutorialBattles = new JButton("Battles");
		btnTutorialBattles.setToolTipText("<html>"+
		"You are going to have"+"<br>"
		+"turn-based battles with"+"<br>"
		+"other Monster Fighters in"+"<br>"
		+"the Arena.");
		btnTutorialBattles.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialBattles.setBounds(235, 125, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialBattles);
		
		JButton btnTutorialPotions = new JButton("Potions");
		btnTutorialPotions.setToolTipText("<html>"+
		"Potions are used to restore"+"<br>"
		+"your monsters' health.");
		btnTutorialPotions.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialPotions.setBounds(235, 168, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialPotions);
		
		JButton btnTutorialFood = new JButton("Foods");
		btnTutorialFood.setToolTipText("<html>"+
		"Foods can permanantly boost"+"<br>"
		+"your monsters' stats.");
		btnTutorialFood.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialFood.setBounds(369, 168, 110, 23);
		windowTutorial.getContentPane().add(btnTutorialFood);
		
		JButton btnTutorialTheGame = new JButton("The Game");
		btnTutorialTheGame.setToolTipText("<html>The game ends when you have played<br>all the days or you have no<br>monsters left and not enough<br>money to buy a new one.");
		btnTutorialTheGame.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialTheGame.setBounds(223, 211, 122, 23);
		windowTutorial.getContentPane().add(btnTutorialTheGame);
		
		JButton btnTutorialHardMode = new JButton("Hard Mode");
		btnTutorialHardMode.setToolTipText("<html>"+
				"In the hard mode your opponent"+"<br>"
				+ "monsters will be 1.3 times"+"<br>"
				+"stronger than the same monster"+"<br>"
				+"in the normal mode.");
		btnTutorialHardMode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		btnTutorialHardMode.setBounds(369, 211, 122, 23);
		windowTutorial.getContentPane().add(btnTutorialHardMode);
	}
}
