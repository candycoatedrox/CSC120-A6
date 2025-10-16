## Bug 1
Brief description: The Computer constructor sets memory to 16 instead of the provided value. 
Failed unit test: testConstructorMemory()

## Bug 2
Brief description: The Computer constructor sets price to 0 instead of the provided value.
Failed unit test: testConstructorPrice()

## Bug 3
Brief description: The setOS method sets operating system to "None" instead of the provided value.
Failed unit test: testSetOS()

## Bug 4
Brief description: Instances of ResaleShop are initialized with a computer already in the inventory.
Failed unit test: testShopConstructor()

## Bug 5
Brief description: The buy method always adds the same arbitrarily defined computer to the inventory.
Failed unit test: testBuy()

## Bug 6
Brief description: The buy method fails to throw an Exception if the given computer is already in the inventory.
Failed unit test: testBuyException()

## Bug 7
Brief description: The sell method fails to throw an Exception if the given computer isn't in the inventory.
Failed unit test: testSellException()

## Bug 8
Brief description: The printInventory method loops through the inventory while its current index is *less than or equal to* instead of *less than* the length of the list.
Failed unit test: testPrintInventoryLoop()

## Bug 9
Brief description: The refurbish method sets price based on which bracket the computer's yearMade falls into; the price set for a computer from 2000-2011 breaks the pattern of the other brackets and seems to have an extra 0 on the end.
Failed unit test: testRefurbishPrice()

## Bug 10
Brief description: The refurbish method compares strings with != instead of .equals().
Failed unit test: testRefurbishOS()