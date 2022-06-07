package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.HeavyTank;


/**
 * JUnit tests for HeavyTank class.
 */
public class HeavyTankTest {
	/**
	 * The test HeavyMonster.
	 */
	private HeavyTank testMonster;
	
	/**
	 * Creates default HeavyTank monster before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testMonster = new HeavyTank();
	}

	/**
	 * Tests that HeavyTank successfully instantiated with default values.
	 */
	@Test
	public void testHeavyTank() {
		assertEquals("Cerberus", testMonster.getMonsterName());
		assertEquals("Heavy Tank", testMonster.getMonsterType());
		assertEquals(6, testMonster.getMonsterHealAmount());
		assertEquals(200, testMonster.getMonsterMaxHealth());
	}
	
	/**
	 * Tests HeavyTank monster type takes expected amount of damage while in defending mode.
	 */
	@Test
	public void testTakeDamageWhileDefending() {
		int damageTaken = 20;
		int expectedHealth = (int)(testMonster.getMonsterHealth() - (damageTaken * 0.4));
		
		testMonster.setIsDefending(true);
		testMonster.takeDamage(damageTaken);
		assertEquals(expectedHealth, testMonster.getMonsterHealth());
	}
	

}
