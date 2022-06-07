package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.inventory.InsufficientGoldException;
import main.inventory.Inventory;
import main.item.DragonFruit;
import main.item.HealingPotion;
import main.monster.LightTank;

/**
 * Tests InsufficientGoldException exception class.
 */
public class InsufficientGoldExceptionTest {
	/**
	 * The test Inventory.
	 */
	private Inventory inventory;
	
	/**
	 * Creates a default Inventory with 100 gold before each test.
	 * @throws Exception exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		inventory = new Inventory();
	}

	/**
	 * Throws InsufficientGoldException by buying items that cost more gold than the player has.
	 */
	@Test
	public void testInsufficientGoldException() {
		Exception exceptionMonster = assertThrows(InsufficientGoldException.class, () -> {
			LightTank monster = new LightTank();
    		monster.buyIn(inventory, 201);
	    });
		assertEquals("Not enough gold to buy monster!", exceptionMonster.getMessage());
		
		Exception exceptionFood = assertThrows(InsufficientGoldException.class, () -> {
			DragonFruit food = new DragonFruit();
			food.buyIn(inventory, 300);
		});
		assertEquals("Not enough gold to buy food!", exceptionFood.getMessage());
		
		Exception exceptionPotion = assertThrows(InsufficientGoldException.class, () -> {
			HealingPotion potion = new HealingPotion();
			potion.buyIn(inventory, 1000);
		});
		assertEquals("Not enough gold to buy potion!", exceptionPotion.getMessage());
	}

}
