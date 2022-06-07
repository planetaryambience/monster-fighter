package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.item.HealingPotion;
import main.monster.HeavyTank;

/**
 * JUnit test for HealingPotion class.
 */
public class HealingPotionTest {
	/**
	 * The test HealingPotion.
	 */
	HealingPotion testHealingPotion = new HealingPotion();

	/**
	 * Tests using a healing potion on a monster will heal the monster.
	 */
	@Test
	public void testUseItem() {
		HeavyTank testMonster = new HeavyTank();
		testMonster.takeDamage(100);
		assertEquals(100, testMonster.getMonsterHealth());
		testHealingPotion.useItem(testMonster);
		assertEquals(140, testMonster.getMonsterHealth());
	}

	/**
	 * Tests HealingPotion instantiated with default values.
	 */
	@Test
	public void testHealingPotion() {
		assertEquals("Healing Potion", testHealingPotion.getItemName());
		assertEquals("Healing Potion", testHealingPotion.toString());
		assertEquals("Potion", testHealingPotion.getItemType());
		assertEquals(60, testHealingPotion.getBuyPrice());
		assertEquals(45, testHealingPotion.getSellPrice());
	}

}
