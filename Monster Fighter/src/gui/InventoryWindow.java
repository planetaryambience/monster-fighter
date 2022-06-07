package gui;

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
import main.item.*;
import main.monster.Monster;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * GUI implementation of InventoryWindow.
 * A window that displays all items in a player's inventory.
 */
public class InventoryWindow {

	/**
	 * InventoryWindow frame.
	 */
	private JFrame windowInventory;
	
	/**
	 * The {@link Player}.
	 */
	private Player player;
	
	/**
	 * The player's {@link Inventory}.
	 */
	private Inventory inventory;
	
	/**
	 * ArrayList of all the food in the player's inventory.
	 */
	private ArrayList<Food> food;
	
	/**
	 * ArrayList of all the potions in the player's inventory.
	 */
	private ArrayList<Potion> potions;
	
	/**
	 * Create the application using overloaded constructor.
	 * @param player player
	 * @param inventory the player's inventory
	 */
	public InventoryWindow(Player player, Inventory inventory) {
		this.player = player;
		this.inventory = inventory;
		food = inventory.getFoodList();
		potions = inventory.getPotionList();
		initialize();
		windowInventory.setVisible(true);
	}
	
	/**
	 * Closes current window.
	 */
	public void closeWindow() {
		windowInventory.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowInventory = new JFrame();
		windowInventory.setIconImage(Toolkit.getDefaultToolkit().getImage(InventoryWindow.class.getResource("/img/Inventory Icon.png")));
		windowInventory.setTitle("View Inventory");
		windowInventory.setBounds(100, 100, 600, 350);
		windowInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowInventory.getContentPane().setLayout(null);
		
		JTextArea txaMonsterInfo = new JTextArea();
		txaMonsterInfo.setEditable(false);
		txaMonsterInfo.setBounds(233, 74, 311, 144);
		windowInventory.getContentPane().add(txaMonsterInfo);
		
		JLabel lblGold = new JLabel();
		lblGold.setBounds(233, 42, 141, 14);
		windowInventory.getContentPane().add(lblGold);
		lblGold.setText("Gold : " + inventory.getGold());

		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Game.launchMainGame(player, inventory);
			}
		});
		btnBack.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/Button_Back_25_.png")));
		btnBack.setBounds(476, 242, 68, 27);
		windowInventory.getContentPane().add(btnBack);
		
		JButton btnUseItem = new JButton("Use Item");
		btnUseItem.setEnabled(false);
		btnUseItem.setBounds(345, 242, 107, 27);
		windowInventory.getContentPane().add(btnUseItem);
		
		// create ListModel that stores all items in player inventory in JList
		DefaultListModel<Item> itemListModel = new DefaultListModel<Item>();
		itemListModel.addAll(potions);
		itemListModel.addAll(food);
		
		JList<Item> lstItems = new JList<Item>(itemListModel);
		lstItems.addListSelectionListener(new ListSelectionListener() {
			// displays monster information in a TextAreaBox when selected
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					txaMonsterInfo.setText(lstItems.getSelectedValue().getItemInfo());
					btnUseItem.setEnabled(true);
				}
			}
		});
		lstItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstItems.setBounds(49, 41, 158, 228);
		windowInventory.getContentPane().add(lstItems);
		
		// when btnUseItem is clicked
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] monsterChoices = inventory.getMonsterList().toArray();
				
				// Dialogue popup for user to select monster to use item on
				Monster selectedMonster = (Monster) JOptionPane.showInputDialog(
	                    windowInventory,
	                    "Pick the monster",
	                    "Use Item on Monster",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    monsterChoices,
	                    null);
				
				if (selectedMonster != null) {
					Item selectedItem = lstItems.getSelectedValue();
					if (selectedItem instanceof Food) {
						inventory.removeFood((Food) selectedItem, 0);
					}
					
					if (selectedItem instanceof Potion) {
						inventory.removePotion((Potion) selectedItem, 0);
					}
					
					selectedItem.useItem(selectedMonster);
					closeWindow();
					InventoryWindow invWindow = new InventoryWindow(player, inventory);
				}
			}
		});
	}
}
