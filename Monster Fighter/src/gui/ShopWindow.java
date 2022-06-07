package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.ToolTipManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.actor.Player;
import main.game.Game;
import main.inventory.*;
import main.item.*;
import main.monster.*;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
/**
 * A window that displays the shop.
 */
public class ShopWindow {

	/**
	 * ShopWindow frame.
	 */
	private JFrame windowShop;
	
	/**
	 * ButtonGroup of items for sale.
	 */
	private final ButtonGroup btgItems = new ButtonGroup();
	
	/**
	 * @see LightTank
	 */
	private LightTank lightTank = new LightTank();
	
	/**
	 * @see HeavyTank
	 */
	private HeavyTank heavyTank = new HeavyTank();
	
	/**
	 * @see MassHealer
	 */
	private MassHealer massHealer = new MassHealer();
	
	/**
	 * @see RangeDamageDealer
	 */
	private RangeDamageDealer rangeDamageDealer = new RangeDamageDealer();
	
	/**
	 * @see SingleTargetDamageDealer
	 */
	private SingleTargetDamageDealer singleTargetDamageDealer = new SingleTargetDamageDealer();
	
	/**
	 * @see SingleTargetHealer
	 */
	private SingleTargetHealer singleTargetHealer = new SingleTargetHealer();
	
	/**
	 * @see ChickenBreast
	 */
	private ChickenBreast chickenBreast = new ChickenBreast();
	
	/**
	 * @see DragonFruit
	 */
	private DragonFruit dragonFruit = new DragonFruit();
	
	/**
	 * @see HealingPotion
	 */
	private HealingPotion healingPotion = new HealingPotion();
	
	/**
	 * @see MaxHealthPotion
	 */
	private MaxHealthPotion maxHealthPotion = new MaxHealthPotion();
	
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
	 * @param inv the player's inventory
	 */
	public ShopWindow(Player player, Inventory inv) {
		this.player = player;
		inventory = inv;
		initialize();
		windowShop.setVisible(true);
	}
	
	/**
	 * Closes the window.
	 */
	public void closeWindow() {
		windowShop.dispose();
	}
	
	/**
	 * Refreshes window.
	 * Used after making a purchase or sale.
	 */
	public void refreshWindow() {
		if (inventory.getGold() < 76 && inventory.getMonsterList().isEmpty()) {
			JOptionPane.showMessageDialog(windowShop, "You've run out of money to buy a monster.", "Game Over", 0);
			closeWindow();
			GameResultWindow gameResult = new GameResultWindow(player, inventory);
		}
		else {
			closeWindow();
			ShopWindow shop = new ShopWindow(player, inventory);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		windowShop = new JFrame();
		windowShop.setIconImage(Toolkit.getDefaultToolkit().getImage(ShopWindow.class.getResource("/img/Shop Icon.png")));
		windowShop.getContentPane().setBackground(Color.WHITE);
		windowShop.setTitle("Evil Pixel Mage's Evil Shop");
		windowShop.setResizable(false);
		windowShop.setBounds(100, 100, 600, 350);
		windowShop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDialogueIcon = new JLabel("");
		lblDialogueIcon.setBounds(167, 10, 40, 29);
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(60000);
		windowShop.getContentPane().setLayout(null);
		lblDialogueIcon.setToolTipText("Hehehe...Welcome Monster Fighter, hope there's something you like...");
		lblDialogueIcon.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/ShopDialogue.png")));
		windowShop.getContentPane().add(lblDialogueIcon);
		
		JLabel lblGold = new JLabel("Gold: " + inventory.getGold());
		lblGold.setForeground(Color.WHITE);
		lblGold.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGold.setBounds(211, 10, 89, 38);
		windowShop.getContentPane().add(lblGold);
		
		JTextArea txaInfo = new JTextArea();
		txaInfo.setLineWrap(true);
		txaInfo.setEditable(false);
		txaInfo.setFont(new Font("Dialog", Font.PLAIN, 10));
		txaInfo.setBounds(307, 192, 267, 71);
		windowShop.getContentPane().add(txaInfo);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(506, 274, 68, 27);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				Game.launchMainGame(player, inventory);
			}
		});
		btnBack.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/Button_Back_25_.png")));
		windowShop.getContentPane().add(btnBack);
		
		JButton btnSell = new JButton("Sell");
		btnSell.setBounds(229, 274, 89, 27);
		btnSell.setEnabled(false);
		windowShop.getContentPane().add(btnSell);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(328, 274, 89, 27);
		btnBuy.setEnabled(false);
		windowShop.getContentPane().add(btnBuy);
		
		JLabel lblInventory = new JLabel("Inventory");
		lblInventory.setBounds(190, 53, 120, 14);
		windowShop.getContentPane().add(lblInventory);
		
		DefaultListModel<Object> invListModel = new DefaultListModel<Object>();
		invListModel.addAll(inventory.getMonsterList());
		invListModel.addAll(inventory.getFoodList());
		invListModel.addAll(inventory.getPotionList());
				
		JList<Object> lstInventory = new JList<Object>(invListModel);
		lstInventory.setBounds(190, 69, 107, 194);
		lstInventory.setVisibleRowCount(10);
		lstInventory.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lstInventory.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Object selected = lstInventory.getSelectedValue();
					int sellPrice;
					String description;
					String type;
					
					if (selected instanceof Monster) {
						sellPrice = ((Monster) selected).getSellPrice();
						description = "";
						type = "\n" + ((Monster) selected).getMonsterType();
					}
					else {
						sellPrice = ((Item) selected).getSellPrice();
						description = ((Item) selected).getItemDescription();
						type = "";
					}

					txaInfo.setText(selected.toString() + type +
							"\n" + description + "\nSell Price: " + sellPrice);
					
					btnSell.setEnabled(true);
					btnBuy.setEnabled(false);
					btgItems.clearSelection();
				}
			}
		});
		lstInventory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		windowShop.getContentPane().add(lstInventory);
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object selected = lstInventory.getSelectedValue();
				
				int input = JOptionPane.showConfirmDialog(windowShop, "Are you sure you want to sell " +
															selected + "?", "Sell",  0);
				if (input == 0) {
					if (selected instanceof Monster) {
						inventory.removeMonster(((Monster) selected), ((Monster) selected).getSellPrice());
					}
					else if (selected instanceof Food) {
						inventory.removeFood(((Food) selected), ((Food) selected).getSellPrice());
					}
					else {
						inventory.removePotion(((Potion) selected), ((Potion) selected).getSellPrice());
					}
					
					refreshWindow();
				}
			}
		});
		
		JLabel lblMarket = new JLabel("Market");
		lblMarket.setBounds(330, 10, 198, 20);
		windowShop.getContentPane().add(lblMarket);
		
		JRadioButton rbtMonster1 = new JRadioButton("");
		rbtMonster1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				if (rbtMonster1.getText() == "Light Tank") {
					txaInfo.setText(lightTank.altMonsterInfo());
				}
				else {
					txaInfo.setText(rangeDamageDealer.altMonsterInfo());
				}
			}
		});
		btgItems.add(rbtMonster1);
		rbtMonster1.setBounds(328, 28, 233, 23);
		windowShop.getContentPane().add(rbtMonster1);
		
		JRadioButton rbtItem1 = new JRadioButton("");
		rbtItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				if (rbtItem1.getText() == "Max Health Potion") {
					txaInfo.setText(maxHealthPotion.getItemName() + "\n" + maxHealthPotion.getItemDescription()
					+ "\nBuy Price: " + maxHealthPotion.getBuyPrice());
				}
				else {
					txaInfo.setText(healingPotion.getItemName() + "\n" + healingPotion.getItemDescription()
					+ "\nBuy Price: " + healingPotion.getBuyPrice());
				}
			}
		});
		btgItems.add(rbtItem1);
		rbtItem1.setBounds(328, 54, 233, 23);
		windowShop.getContentPane().add(rbtItem1);
				
		JRadioButton rbtMonster2 = new JRadioButton("");
		rbtMonster2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				if (rbtMonster2.getText() == "Single Target Damage Dealer") {
					txaInfo.setText(singleTargetDamageDealer.altMonsterInfo());
				}
				else if (rbtMonster2.getText() == "Heavy Tank") {
					txaInfo.setText(heavyTank.altMonsterInfo());
				}
				else {
					txaInfo.setText(massHealer.altMonsterInfo());
				}
			}
		});
		btgItems.add(rbtMonster2);
		rbtMonster2.setBounds(328, 80, 233, 23);
		windowShop.getContentPane().add(rbtMonster2);
		
		JRadioButton rbtItem2 = new JRadioButton("");
		rbtItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				if (rbtItem2.getText() == "Chicken Breast") {
					txaInfo.setText(chickenBreast.getItemName() + "\n" + chickenBreast.getItemDescription()
					+ "\nBuy Price: " + chickenBreast.getBuyPrice());
				}
				else {
					txaInfo.setText(healingPotion.getItemName() + "\n" + healingPotion.getItemDescription()
					+ "\nBuy Price: " + healingPotion.getBuyPrice());
				}
			}
		});
		btgItems.add(rbtItem2);
		rbtItem2.setBounds(328, 106, 233, 23);
		windowShop.getContentPane().add(rbtItem2);
		
		JRadioButton rbtMonster3 = new JRadioButton("");
		rbtMonster3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				if (rbtMonster3.getText() == "Single Target Healer") {
					txaInfo.setText(singleTargetHealer.altMonsterInfo());
				}
				else {
					txaInfo.setText(rangeDamageDealer.altMonsterInfo());
				}
			}
		});
		btgItems.add(rbtMonster3);
		rbtMonster3.setBounds(328, 133, 233, 23);
		windowShop.getContentPane().add(rbtMonster3);
		
		JRadioButton rbtItem3 = new JRadioButton("");
		rbtItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuy.setEnabled(true);
				btnSell.setEnabled(false);
				
				txaInfo.setText(dragonFruit.getItemName() + "\n" + dragonFruit.getItemDescription()
								+ "\nBuy Price: " + dragonFruit.getBuyPrice());
			}
		});
		btgItems.add(rbtItem3);
		rbtItem3.setBounds(328, 159, 233, 23);
		windowShop.getContentPane().add(rbtItem3);
		
	
		
		if (player.getCurrentDay() == 1) {
			rbtMonster1.setText("Light Tank");
			rbtMonster2.setText("Single Target Damage Dealer");
			rbtMonster3.setText("Single Target Healer");
			rbtItem1.setText("Healing Potion");
			rbtItem2.setText("Chicken Breast");
			rbtItem3.setText("Dragon Fruit");
			
		}
		else if (player.getCurrentDay() == 2) {
			rbtMonster1.setText("Light Tank");
			rbtMonster2.setText("Single Target Damage Dealer");
			rbtMonster3.setText("Single Target Healer");
			rbtItem1.setText("Max Health Potion");
			rbtItem2.setText("Healing Potion");
			rbtItem3.setText("Dragon Fruit");
			
		}
		else if (player.getCurrentDay() == 3) {
			rbtMonster1.setText("Light Tank");
			rbtMonster2.setText("Single Target Damage Dealer");
			rbtMonster3.setText("Single Target Healer");
			rbtItem1.setText("Max Health Potion");
			rbtItem2.setText("Chicken Breast");
			rbtItem3.setText("Dragon Fruit");
			
		}
		else if ((player.getCurrentDay() > 3) && (player.getCurrentDay() % 2 == 0)) {
			rbtMonster1.setText("Light Tank");
			rbtMonster2.setText("Mass Healer");
			rbtMonster3.setText("Range Damage Dealer");
			rbtItem1.setText("Max Health Potion");
			rbtItem2.setText("Healing Potion");
			rbtItem3.setText("Dragon Fruit");
		}
		else {
			rbtMonster1.setText("Range Damage Dealer");
			rbtMonster2.setText("Heavy Tank");
			rbtMonster3.setText("Single Target Healer");
			rbtItem1.setText("Max Health Potion");
			rbtItem2.setText("Chicken Breast");
			rbtItem3.setText("Dragon Fruit");
		}
		
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rbtMonster1.isSelected()) {
						if (rbtMonster1.getText() == "Light Tank") {
							inventory.addMonster(lightTank, lightTank.getBuyPrice());
						}
						else {
							inventory.addMonster(rangeDamageDealer, rangeDamageDealer.getBuyPrice());
						}
					}
					else if (rbtMonster2.isSelected()) {
						if (rbtMonster2.getText() == "Single Target Damage Dealer") {
							inventory.addMonster(singleTargetDamageDealer, singleTargetDamageDealer.getBuyPrice());
						}
						else if (rbtMonster2.getText() == "Heavy Tank") {
							inventory.addMonster(heavyTank, heavyTank.getBuyPrice());
						}
						else {
							inventory.addMonster(heavyTank, massHealer.getBuyPrice());
						}
					}
					else if (rbtMonster3.isSelected()) {
						if (rbtMonster3.getText() == "Single Target Healer") {
							inventory.addMonster(singleTargetHealer, singleTargetHealer.getBuyPrice());
						}
						else {
							inventory.addMonster(rangeDamageDealer, rangeDamageDealer.getBuyPrice());
						}
					}
					else if (rbtItem1.isSelected()) {
						if (rbtItem1.getText() == "Max Health Potion") {
							inventory.addPotion(maxHealthPotion, maxHealthPotion.getBuyPrice());
						}
						else {
							inventory.addPotion(healingPotion, healingPotion.getBuyPrice());
						}
						
					}
					else if (rbtItem2.isSelected()) {
						if (rbtItem2.getText() == "Chicken Breast") {
							inventory.addFood(chickenBreast, chickenBreast.getBuyPrice());
						}
						else {
							inventory.addPotion(healingPotion, healingPotion.getBuyPrice());
						}
					}
					else {
						inventory.addFood(dragonFruit, dragonFruit.getBuyPrice());
					}
				}
				
				catch (InsufficientGoldException insufficientGoldEx) {
					JOptionPane.showMessageDialog(windowShop, insufficientGoldEx.getMessage());
				}
				catch (MonsterCapacityReachedException monsterCapacityReachedExceptionEx) {
					JOptionPane.showMessageDialog(windowShop, monsterCapacityReachedExceptionEx.getMessage());
				}
				
				refreshWindow();
			}
		});
		
		JLabel lblWizardGif = new JLabel("");
		lblWizardGif.setBounds(-53, 0, 266, 378);
		lblWizardGif.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/Wizard(shop).gif")));
		windowShop.getContentPane().add(lblWizardGif);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 611, 333);
		lblBackground.setIcon(new ImageIcon(ShopWindow.class.getResource("/img/Shop Background.png")));
		windowShop.getContentPane().add(lblBackground);
	}
}
