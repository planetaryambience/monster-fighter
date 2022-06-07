package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.inventory.Inventory;
import main.item.*;

/**
 * JUnit tests for buying and selling Food.
 */
public class FoodBuyAndSellTest {
	/**
	 * The test Inventory.
	 */
	private Inventory inventory;

	/**
	 * Creates default inventory before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		inventory = new Inventory();
	}

	/**
	 * Tests BuyIn and SellOut method for Food Item.
	 */
	@Test
	public void testFoodBuyAndSell() {
		DragonFruit testFruit = new DragonFruit();
		ChickenBreast testChicken = new ChickenBreast();
		
		testFruit.buyIn(inventory, 0);
		assertEquals(200, inventory.getGold());
		
		assertEquals(true, inventory.hasItem("Dragon Fruit"));
		assertEquals(testFruit, inventory.getFood("Dragon Fruit"));
		assertEquals(null, inventory.getFood("Chicken Breast"));
		
		testFruit.buyIn(inventory, 10);
		assertEquals(190, inventory.getGold());
		
		testChicken.buyIn(inventory, testChicken.getBuyPrice());
		// buyPrice of testChicken == 68
		assertEquals(122, inventory.getGold());
		assertEquals(3, inventory.getFoodList().size());
		
		testFruit.sellOut(inventory, testFruit.getSellPrice());
		// sellPrice of testFruit == 42
		assertEquals(164, inventory.getGold());
		assertEquals(2, inventory.getFoodList().size());
		
		// using all gold in inventory
		testFruit.buyIn(inventory, 164);
		assertEquals(0, inventory.getGold());
	}

}
