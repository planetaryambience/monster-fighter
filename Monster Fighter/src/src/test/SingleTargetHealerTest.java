package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.SingleTargetHealer;

/**
 * JUnit tests for SingleTargetHealer class.
 */
public class SingleTargetHealerTest {
	/**
	 * The test SingleTargetHealer.
	 */
	private SingleTargetHealer testMonster;

	/**
	 * Creates new SingleTargetHealer instance before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testMonster = new SingleTargetHealer();
	}
	
	/**
	 * Tests SingleTargetHealer instantiated with expected default values.
	 */
	@Test
	public void testSingleTargetHealer() {
		assertEquals("Vapula", testMonster.getMonsterName());
		assertEquals("Single Target Healer", testMonster.getMonsterType());
		assertEquals(40, testMonster.getMonsterHealAmount());
		assertEquals(80, testMonster.getMonsterMaxHealth());
	}

	/**
	 * Tests the monster taking damage.
	 */
	@Test
	public void testTakeDamage() {
		int damageTaken = 20;
		int expectedHealth = testMonster.getMonsterHealth() - damageTaken;
		
		testMonster.takeDamage(damageTaken);
		assertEquals(expectedHealth, testMonster.getMonsterHealth());
	}
	
	/**
	 * Tests the monster's heal ability.
	 */
	@Test
	public void testHeal() {
		int healAmount = testMonster.getMonsterHealAmount();
		testMonster.takeDamage(50);
		testMonster.heal(healAmount);
		assertEquals(70, testMonster.getMonsterHealth());
		
		testMonster.heal(healAmount);
		assertEquals(80, testMonster.getMonsterHealth());
	}
	
	/**
	 * Tests healAmountBoost will increase monster's heal amount.
	 */
	@Test
	public void testBoostHeal() {
		testMonster.healAmountBoost(10);
		assertEquals(50, testMonster.getMonsterHealAmount());
	}
	
	/**
	 * Tests if monster has fainted if their health reaches 0.
	 */
	@Test
	public void testIsFainted() {
		testMonster.takeDamage(90);
		assertEquals(true, testMonster.getIsFainted());
	}

}
