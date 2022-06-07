package test;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.inventory.Inventory;
import main.inventory.MonsterCapacityReachedException;
import main.monster.LightTank;

/**
 * Tests MonsterCapacityReachedException exception class.
 */
public class MonsterCapacityReachedTest {
	/**
	 * The test Inventory.
	 */
	private Inventory inventory;
	
	/**
	 * Creates a default inventory that has an empty monsterList.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		inventory = new Inventory();
	}

	/**
	 * Throws MonsterCapacityReachedException by trying to add more than 4 monsters to inventory.
	 */
	@Test
	public void testInsufficientGoldException() {
		inventory.addMonster(new LightTank(), 0);
		inventory.addMonster(new LightTank(), 0);
		inventory.addMonster(new LightTank(), 0);
		inventory.addMonster(new LightTank(), 0);
		Exception exceptionMonster = assertThrows(MonsterCapacityReachedException.class, () -> {
			inventory.addMonster(new LightTank(), 0);
	    });
	}

}
