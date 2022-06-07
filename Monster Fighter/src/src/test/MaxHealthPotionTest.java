package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.item.MaxHealthPotion;
import main.monster.HeavyTank;

/**
 * JUnit tests for MaxHealthPotion class.
 */
public class MaxHealthPotionTest {
	/**
	 * The test MaxHealthPotion.
	 */
	MaxHealthPotion testMaxHealthPotion = new MaxHealthPotion();

	/**
	 * Tests item on a monster.
	 */
	@Test
	void testUseItem() {
		HeavyTank testMonster = new HeavyTank();
		testMonster.takeDamage(100);
		assertEquals(100, testMonster.getMonsterHealth());
		testMaxHealthPotion.useItem(testMonster);
		assertEquals(200, testMonster.getMonsterHealth());
	}

	/**
	 * Tests MaxHealthPotion's default values.
	 */
	@Test
	void testMaxHealthPotion() {
		assertEquals("Max Health Potion", testMaxHealthPotion.getItemName());
		assertEquals("Potion", testMaxHealthPotion.getItemType());
		assertEquals(80, testMaxHealthPotion.getBuyPrice());
		assertEquals(60, testMaxHealthPotion.getSellPrice());
	}

}
