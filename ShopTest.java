import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    // COMPUTER TESTS

    /**
     * Create a Computer with its memory set to the given value
     */
    @Test
    public void testConstructorMemory() {
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        assertEquals(64, testComputer.memory);
    }

    /**
     * Create a Computer with its price set to the given value
     */
    @Test
    public void testConstructorPrice() {
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        assertEquals(1500, testComputer.price);
    }

    /**
     * Update a Computer's operatingSystem using setOS()
     */
    @Test
    public void testSetOS() {
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        testComputer.setOS("MacOS Monterey");
        assertEquals("MacOS Monterey", testComputer.operatingSystem);
    }

    // RESALESHOP TESTS

    /**
     * Create a ResaleShop with a new, empty inventory
     */
    @Test
    public void testShopConstructor() {
        ResaleShop testShop = new ResaleShop();

        assertTrue(testShop.inventory.isEmpty());
    }

    /**
     * Add a Computer to the inventory using buy()
     */
    @Test
    public void testBuy() {
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        try {
            testShop.buy(testComputer);
        } catch (Exception e) {
        }

        assertTrue(testShop.inventory.contains(testComputer));
    }
    
    // If I try to test for exceptions using (expected =), the program throws an error
    // This is definitely related to my general JUnit issues, but I can't figure out
    // how to fix it (see reflection.md)
    // I'm using a workaround in the next few tests instead

    /**
     * Throw an Exception when trying to buy() a Computer already in the inventory
     */
    @Test
    public void testBuyException() {
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        boolean exceptionThrown = false;
        // Workaround: If buy() throws an Exception,
        // exceptionThrown is set to true and the test passes
        try {
            testShop.buy(testComputer);
            testShop.buy(testComputer);
        } catch (Exception e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    /**
     * Throw an Exception when trying to sell() a Computer that isn't in the inventory
     */
    @Test
    public void testSellException() {
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        boolean exceptionThrown = false;
        // Workaround: If sell() throws an Exception,
        // exceptionThrown is set to true and the test passes
        try {
            testShop.sell(testComputer);
        } catch (Exception e) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    /**
     * Loop through the inventory in printInventory() without throwing an Exception
     */
    @Test
    public void testPrintInventoryLoop() {
        ResaleShop testShop = new ResaleShop();

        boolean exceptionThrown = false;
        // Workaround: If printInventory() throws an IndexOutOfBoundsException,
        // exceptionThrown is set to true and the test fails
        try {
            testShop.printInventory();
        } catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }

        assertFalse(exceptionThrown);
    }

    /**
     * Update the price of a Computer from 2000-2011 in line with other refurbished prices using refurbish()
     */
    @Test
    public void testRefurbishPrice() {
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer(
            "Mac Pro (Late 2010)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2010, 1500
        );

        // Manually bypass buy(), since it doesn't work
        testShop.inventory.add(testComputer);

        try {
            testShop.refurbish(testComputer, "None");
        } catch (Exception e) {
        }

        assertEquals(250, testComputer.price);
    }

    /**
     * refurbish() checks if a new String "None" .equals() an existing String "None", and does not update operatingSystem
     */
    @Test
    public void testRefurbishOS() {
        ResaleShop testShop = new ResaleShop();
        Computer testComputer = new Computer(
            "Mac Pro (Late 2013)",
            "3.5 GHc 6-Core Intel Xeon E5",
            1024, 64,
            "macOS Big Sur", 2013, 1500
        );

        // Manually bypass buy(), since it doesn't work
        testShop.inventory.add(testComputer);

        try {
            // If refurbish() were using .equals,
            // this wouldn't change testComputer.operatingSystem
            testShop.refurbish(testComputer, new String("None"));
        } catch (Exception e) {
        }

        assertEquals("macOS Big Sur", testComputer.operatingSystem);
    }
    
}
