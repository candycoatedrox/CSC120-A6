import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    // no need to organically find bugs via tests --
    // make tests to catch the bugs you see in the code!!

    // COMPUTER TESTS
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
    @Test
    public void testShopConstructor() {
        ResaleShop testShop = new ResaleShop();

        assertTrue(testShop.inventory.isEmpty());
    }

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

    public static void main(String[] args) {
        System.out.println("Running");
        ShopTest runTests = new ShopTest();
        runTests.testRefurbishOS();
    }
    
}
