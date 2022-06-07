package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.monster.MassHealer;
import main.monster.Monster;

/**
 * JUnit tests for MassHealer class.
 */
public class MassHealerTest {
	/**
	 * The test MassHealer.
	 */
	private MassHealer testMonster;

	/**
	 * Creates a MassHealer instance before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testMonster = new MassHealer();
	}

	/**
	 * Tests monster has expected default values.
	 */
	@Test
	public void testMassHealer() {
		assertEquals("Bune (level 10)\nType: Mass Healer\nCurrent Health: 75/75\nAttack: 10\nHeal: 16\n\n"
				+ "\"I always wondered why I was a scorpion.\nJust like why you were a human.\"", testMonster.getMonsterInfo());
	}
	
	/**
	 * Tests MassHealer's special ability to mass heal entire team.
	 */
	@Test
	public void testMassHeal() {
		ArrayList<Monster> allyTeam = new ArrayList<Monster>();
		MassHealer anotherHealer = new MassHealer();
		allyTeam.add(testMonster);
		allyTeam.add(anotherHealer);
		
		anotherHealer.takeDamage(20);
		testMonster.massHeal(allyTeam);
		
		assertEquals(75, testMonster.getMonsterHealth());
		assertEquals(71, anotherHealer.getMonsterHealth());
	}
	
	/**
	 * Tests monster's stats update after leveling up.
	 */
	@Test
	public void testSetMonsterLevel() {
		testMonster.setMonsterLevel(25);
		assertEquals(25, testMonster.getMonsterLevel());
		assertEquals(91, testMonster.getMonsterMaxHealth());
		assertEquals(20, testMonster.getMonsterHealAmount());
	}

}
