package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.MassHealer;
import main.monster.Monster;
import main.monster.RangeDamageDealer;

/**
 * JUnit tests for RangeDamageDealer class.
 */
public class RangeDamageDealerTest {
	/**
	 * The test RangeDamageDealer.
	 */
	private RangeDamageDealer testMonster;

	/**
	 * Creates default RangeDamageDealer instance before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testMonster = new RangeDamageDealer();
	}

	/**
	 * Tests a default RangeDamageDealer.
	 */
	@Test
	public void testRangeDamageDealer() {
		assertEquals("Focalor", testMonster.getMonsterName());
		assertEquals("Range Damage Dealer", testMonster.getMonsterType());
		assertEquals(8, testMonster.getMonsterHealAmount());
		assertEquals(80, testMonster.getMonsterMaxHealth());
	}
	
	/**
	 * Tests RangeDamageDealer's special ability to damage entire enemy team.
	 */
	@Test
	public void testRangeAttack() {
		ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
		MassHealer massHealer = new MassHealer();
		RangeDamageDealer eRDD = new RangeDamageDealer();
		enemyTeam.add(massHealer);
		enemyTeam.add(eRDD);
		
		testMonster.rangeAttack(enemyTeam);
		
		assertEquals(53, massHealer.getMonsterHealth());
		assertEquals(58, eRDD.getMonsterHealth());
	}
	
	/**
	 * Tests setting a new monster level and if the monster's stats change as expected.
	 */
	@Test
	public void testSetMonsterLevel() {
		testMonster.setMonsterLevel(15);
		assertEquals(15, testMonster.getMonsterLevel());
		assertEquals("<html>Focalor<br>\"Range Damage Dealer\"<br>Level: 15<br>85 / 85 HP"
				+ "<br>Attack: 23<br>Heal: 8<br>Defending: false", testMonster.monsterBattleStats());
	}

}
