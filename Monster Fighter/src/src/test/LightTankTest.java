package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.LightTank;

/**
 * JUnit tests for LightTank class.
 */
public class LightTankTest {
	/**
	 * The test LightTank.
	 */
	private LightTank testMonster;

	/**
	 * Creates default LightTank instance before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testMonster = new LightTank();
	}

	/**
	 * Tests LightTank is instantiated with default values.
	 */
	@Test
	public void testLightTank() {
		assertEquals("Eligor", testMonster.toString());
		assertEquals("Light Tank", testMonster.getMonsterType());
		assertEquals("\"Woof.\"", testMonster.getMonsterDescription());
		assertEquals(6, testMonster.getMonsterHealAmount());
		assertEquals(150, testMonster.getMonsterMaxHealth());
	}
	
	/**
	 * Tests LightTank monster type takes expected damage when defending.
	 */
	@Test
	public void testTakeDamageWhileDefending() {
		int damageTaken = 40;
		int expectedHealth = (int)(testMonster.getMonsterHealth() - (damageTaken * 0.6));
		
		testMonster.setIsDefending(true);
		testMonster.takeDamage(damageTaken);
		assertEquals(expectedHealth, testMonster.getMonsterHealth());
	}
	
	/**
	 * Tests that the monster's stats are updated after leveling up.
	 */
	@Test
	public void testSetMonsterLevel() {
		testMonster.setMonsterLevel(20);
		assertEquals(20, testMonster.getMonsterLevel());
		assertEquals("Eligor\nHealth: 163\nAttack: 26\nHeal: 7\nBuy Price: 76", testMonster.altMonsterInfo());
	}
	
	
	/**
	 * Tests monster stats are updated after calling hardDiffBoost method.
	 */
	@Test
	public void testHardDiffBoost() {
		testMonster.hardDiffBoost();
		
		assertEquals(195, testMonster.getMonsterMaxHealth());
		assertEquals(195, testMonster.getMonsterHealth());
		assertEquals(32, testMonster.getMonsterDamageAmount());
		assertEquals(7, testMonster.getMonsterHealAmount());
	}
	
	/**
	 * Tests chance of a monster leaving will change.
	 */
	@Test
	public void testLeaveChance() {
		testMonster.addMonsterLeaveTeamChance();
		assertEquals(2, testMonster.getMonsterLeaveTeamChance());
	}
}
