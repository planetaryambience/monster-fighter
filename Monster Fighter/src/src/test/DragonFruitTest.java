package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.item.DragonFruit;
import main.monster.HeavyTank;

/**
 * JUnit tests for DragonFruit class.
 */
public class DragonFruitTest {
	/**
	 * The test DragonFruit.
	 */
	DragonFruit testDragonFruit = new DragonFruit();
	
	/**
	 * Tests useItem method on a monster.
	 */
	@Test
	public void testUseItem() {
		HeavyTank testMonster = new HeavyTank();
		testDragonFruit.useItem(testMonster);
		assertEquals(220, testMonster.getMonsterMaxHealth());
	}

	/**
	 * Tests that a DragonFruit instance has the expected default values.
	 */
	@Test
	public void testDragonFruit() {
		assertEquals("Dragon Fruit", testDragonFruit.getItemName());
		assertEquals("Food", testDragonFruit.getItemType());
		assertEquals(56, testDragonFruit.getBuyPrice());
		assertEquals(42, testDragonFruit.getSellPrice());
	}
}
