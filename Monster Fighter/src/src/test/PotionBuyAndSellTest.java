package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.inventory.Inventory;
import main.item.*;

/**
 * JUnit tests for testing buy and sell for Potion Item.
 */
public class PotionBuyAndSellTest {
	/**
	 * The test Inventory.
	 */
	private Inventory inventory;

	/**
	 * Creates default Inventory before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		inventory = new Inventory();
	}

	/**
	 * Tests buyIn and sellOut for potions.
	 */
	@Test
	public void testPotionBuyAndSell() {
		HealingPotion hPotion = new HealingPotion();
		MaxHealthPotion mhPotion = new MaxHealthPotion();
		
		inventory.addGold(10);
		assertEquals(210, inventory.getGold());
		
		hPotion.buyIn(inventory, 10);
		hPotion.buyIn(inventory, 0);
		hPotion.buyIn(inventory, 1);
		
		assertEquals(true, inventory.hasItem("Healing Potion"));
		assertEquals(false, inventory.hasItem("Max Health Potion"));
		assertEquals(hPotion, inventory.getPotion("Healing Potion"));
		assertEquals(null, inventory.getPotion("healing potion"));
		
		mhPotion.buyIn(inventory, mhPotion.getBuyPrice());
		assertEquals(4, inventory.getPotionList().size());
		
		mhPotion.sellOut(inventory, mhPotion.getSellPrice());
		assertEquals(3, inventory.getPotionList().size());
	}
}
