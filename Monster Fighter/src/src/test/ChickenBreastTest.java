package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.item.ChickenBreast;
import main.monster.HeavyTank;

/**
 * JUnit tests for ChickenBreast class.
 */
public class ChickenBreastTest {
	/**
	 * The test ChickenBreast.
	 */
	private ChickenBreast testChickenBreast = new ChickenBreast();

	/**
	 * Tests UseItem method.
	 */
	@Test
	public void testUseItem() {
		HeavyTank testMonster = new HeavyTank();
		testChickenBreast.useItem(testMonster);
		assertEquals(30, testMonster.getMonsterDamageAmount());
	}

	/**
	 * Tests that ChickenBreast successfully instantiated with default values.
	 */
	@Test
	public void testChickenBreast() {
		assertEquals("Chicken Breast", testChickenBreast.getItemName());
		assertEquals("Food", testChickenBreast.getItemType());
		assertEquals(68, testChickenBreast.getBuyPrice());
		assertEquals(51, testChickenBreast.getSellPrice());

		assertEquals("Chicken Breast\nItem Type: Food\n" + testChickenBreast.getItemDescription(), testChickenBreast.getItemInfo());
	}

}
