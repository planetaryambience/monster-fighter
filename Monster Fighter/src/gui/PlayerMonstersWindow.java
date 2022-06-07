package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import main.actor.Player;
import main.game.Game;
import main.inventory.Inventory;
import main.monster.Monster;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * A window that displays all the monsters in a player's inventory.
 */
public class PlayerMonstersWindow {

	/**
	 * PlayerMonstersWindow frame.
	 */
	private JFrame windowPlayerMonsters;
	
	/**
	 * ArrayList of monsters.
	 */
	private ArrayList<Monster> monsters;
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory;

	/**
	 * Create the application using overloaded constructor.
	 * @param p player
	 * @param inventory the player's inventory
	 */
	public PlayerMonstersWindow(Player p, Inventory inventory) {
		player = p;
		this.inventory = inventory;
		monsters = inventory.getMonsterList();
		
		initialize();
		windowPlayerMonsters.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		windowPlayerMonsters.dispose();
	}
	
	/**
	 * Refreshes the window after a change is made.
	 */
	public void refreshWindow() {
		closeWindow();
		PlayerMonstersWindow monstersWindow = new PlayerMonstersWindow(player, inventory);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowPlayerMonsters = new JFrame();
		windowPlayerMonsters.setIconImage(Toolkit.getDefaultToolkit().getImage(PlayerMonstersWindow.class.getResource("/img/Monster Page Icon.png")));
		windowPlayerMonsters.setResizable(false);
		windowPlayerMonsters.setTitle("View Monsters");
		windowPlayerMonsters.setBounds(100, 100, 600, 350);
		windowPlayerMonsters.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowPlayerMonsters.getContentPane().setLayout(null);
		
		JTextArea txaMonsterInfo = new JTextArea();
		txaMonsterInfo.setEditable(false);
		txaMonsterInfo.setBounds(233, 83, 311, 144);
		windowPlayerMonsters.getContentPane().add(txaMonsterInfo);

		JButton btnRename = new JButton("Rename");
		btnRename.setEnabled(false);
		btnRename.setBounds(369, 242, 97, 27);
		windowPlayerMonsters.getContentPane().add(btnRename);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Game.launchMainGame(player, inventory);
			}
		});
		btnBack.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/Button_Back_25_.png")));
		btnBack.setBounds(476, 242, 68, 27);
		windowPlayerMonsters.getContentPane().add(btnBack);
		
		JButton btnSetFirst = new JButton("Set First");
		btnSetFirst.setEnabled(false);
		btnSetFirst.setBounds(256, 242, 104, 27);
		windowPlayerMonsters.getContentPane().add(btnSetFirst);
		
		// create ListModel that stores names of monsters in JList
		DefaultListModel<Monster> monsterListModel = new DefaultListModel<Monster>();
		monsterListModel.addAll(monsters);
		
		JList<Monster> lstMonsters = new JList<Monster>(monsterListModel);
		lstMonsters.addListSelectionListener(new ListSelectionListener() {
			// displays monster information in a TextAreaBox when selected
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					txaMonsterInfo.setText(lstMonsters.getSelectedValue().getMonsterInfo());
					btnRename.setEnabled(true);
					
					if (monsters.size() > 1) {
						btnSetFirst.setEnabled(true);
					}
				}
			}
		});
		lstMonsters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstMonsters.setBounds(49, 83, 158, 186);
		windowPlayerMonsters.getContentPane().add(lstMonsters);
		
		JLabel lblMonsterOrder = new JLabel("In order from 1st to last:");
		lblMonsterOrder.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblMonsterOrder.setBounds(49, 62, 158, 15);
		windowPlayerMonsters.getContentPane().add(lblMonsterOrder);
		
		JLabel lblMonsters = new JLabel("Monsters");
		lblMonsters.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMonsters.setBounds(49, 12, 133, 44);
		windowPlayerMonsters.getContentPane().add(lblMonsters);
		
		btnRename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newName = JOptionPane.showInputDialog("Enter a new name:");
				
				if (newName != null && !newName.isBlank()) {
					lstMonsters.getSelectedValue().setMonsterName(newName);
					refreshWindow();
				}
			}
		});
		
		btnSetFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Monster selected = lstMonsters.getSelectedValue();
				monsters.remove(selected);
				monsters.add(0, selected);
				refreshWindow();
			}
		});
	}
}
