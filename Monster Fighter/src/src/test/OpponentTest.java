package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.actor.Opponent;
import main.actor.Player;
import main.inventory.Inventory;
import main.monster.MassHealer;

/**
 * JUnit tests for Opponent class.
 */
public class OpponentTest {
	/**
	 * The test Opponent.
	 */
	Opponent testOpponent;
	
	/**
	 * The test Inventory.
	 */
	Inventory inventory;

	/**
	 * Creates default Opponent and Inventory instances before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testOpponent = new Opponent();
		inventory = new Inventory();
	}

	/**
	 * Tests generating opponent team of 4 monsters.
	 */
	@Test
	public void testOpponentBattleTeam4() {
		inventory.addMonster(new MassHealer(), 0);
		inventory.addMonster(new MassHealer(), 0);
		inventory.addMonster(new MassHealer(), 0);
		inventory.addMonster(new MassHealer(), 0);
		
		testOpponent.generateOpponentBattleTeam(inventory);
		assertEquals(4, testOpponent.getOpponentMonsterList().size());
	}
	
	/**
	 * Tests generating opponent team of 3 monsters.
	 */
	@Test
	public void testOpponentBattleTeam3() {
		inventory.addMonster(new MassHealer(), 0);
		inventory.addMonster(new MassHealer(), 0);
		inventory.addMonster(new MassHealer(), 0);
		
		testOpponent.generateOpponentBattleTeam(inventory);
		assertEquals(3, testOpponent.getOpponentMonsterList().size());
	}
	
	/**
	 * Tests opponent's level is based on player's current day.
	 */
	@Test
	public void testOpponentLevel() {
		Player player = new Player("test player", "normal", 8);
		assertEquals(10, testOpponent.opponentLevel(player));
		
		player.addDay();
		assertEquals(14, testOpponent.opponentLevel(player));
	}

}
