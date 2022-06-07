package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.inventory.Inventory;
import main.monster.SingleTargetDamageDealer;

/**
 * JUnit tests for buying and selling of monsters.
 */
public class MonsterBuyAndSellTest {
	/**
	 * The test Inventory.
	 */
	private Inventory inventory;
	
	/**
	 * The test SingleTargetDamageDealer.
	 */
	private SingleTargetDamageDealer testMonster;
	
	/**
	 * Creates default Inventory and testMonster before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		inventory = new Inventory();
		testMonster = new SingleTargetDamageDealer();
	}
	
	/**
	 * Tests setting buy and sell prices.
	 */
	@Test
	public void testSetPrices() {
		testMonster.setBuyAndSellPrices(100);
		assertEquals(100, testMonster.getBuyPrice());
		assertEquals(75, testMonster.getSellPrice());
		
		testMonster.setBuyAndSellPrices(0);
		assertEquals(0, testMonster.getBuyPrice());
		assertEquals(0, testMonster.getSellPrice());
	}

	/**
	 * Tests buying and selling monsters.
	 */
	@Test
	public void testMonsterBuyAndSell() {
		SingleTargetDamageDealer anotherM = new SingleTargetDamageDealer();
		anotherM.setMonsterName("STDD");
		
		testMonster.buyIn(inventory, 0);
		assertEquals("Labolas", inventory.getMonster(0).getMonsterName());
		
		anotherM.buyIn(inventory, 40);
		assertEquals("STDD", inventory.getMonster(1).getMonsterName());
		assertEquals(2, inventory.getNumOfMonsters());
		
		anotherM.sellOut(inventory, 20);
		assertEquals(1, inventory.getNumOfMonsters());
	}
}
