package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.SingleTargetDamageDealer;

/**
 * JUnit tests for SingleTargetDamageDealer class.
 */
public class SingleTargetDamageDealerTest {
	/**
	 * The test SingleTargetDamageDealer.
	 */
	private SingleTargetDamageDealer testMonster;

	/**
	 * Creates default SingleTargetDamageDealer.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testMonster = new SingleTargetDamageDealer();
	}
	
	/**
	 * Tests a default instance of SingleTargetDamageDealer.
	 */
	@Test
	public void testSingleTargetDamageDealer() {
		assertEquals("Labolas", testMonster.getMonsterName());
		assertEquals("Single Target Damage Dealer", testMonster.getMonsterType());
		assertEquals(10, testMonster.getMonsterHealAmount());
		assertEquals(100, testMonster.getMonsterMaxHealth());
	}
	
	/**
	 * Tests setting a custom user input name for monster's name.
	 */
	@Test
	public void testSetCustomName() {
		testMonster.setMonsterName("monsterrr");
		assertEquals("monsterrr", testMonster.getMonsterName());
	}
	
	/**
	 * Tests monster's attack.
	 */
	@Test
	public void testAttack() {
		SingleTargetDamageDealer enemyMonster = new SingleTargetDamageDealer();
		testMonster.attack(enemyMonster);
		assertEquals(50, enemyMonster.getMonsterHealth());
	}

	/**
	 * Tests monster takes expected damage while using its defend ability.
	 */
	@Test
	public void testTakeDamageWhileDefending() {
		int damageTaken = 40;
		int expectedHealth = (int)(testMonster.getMonsterHealth() - (damageTaken * 0.8));
		
		testMonster.setIsDefending(true);
		testMonster.takeDamage(damageTaken);
		assertEquals(expectedHealth, testMonster.getMonsterHealth());
	}
	
	/**
	 * Tests damageBoost method that will increase the monster's damage amount.
	 */
	@Test
	public void testDamageBoost() {
		testMonster.damageBoost(10);
		assertEquals(60, testMonster.getMonsterDamageAmount());
	}
	
	/**
	 * Tests MaxHealthBoost method that will increase the monster's max health amount.
	 */
	@Test
	public void testMaxHealthBoost() {
		testMonster.maxHealthBoost(20);
		assertEquals(120, testMonster.getMonsterMaxHealth());
	}

}
