package question_1

fun main() {
    // We create our food for Menu Items
    val pizza = Food("Pizza", 15.00)
    val cheeseBurger = Food("Cheese Burger", 11.00)
    val spicyChicken = Food("Spicy Chicken", 26.50)
    val sandwich = Food("Sandwich", 19.88)

    // Add food in Menu
    val menu = Menu(listOf(pizza, cheeseBurger, spicyChicken, sandwich))

    // Print all food in Menu
    menu.printAllFoodInMenu()
    println()

    // Filter menu by price
    menu.filterMenuByPrice(16.00)
    println()

    // To order food, we choose food from the Menu.
    menu.selectFood(listOf(cheeseBurger, sandwich))
    println()

    // ****** Holiday Menu ******
    println("****** Holiday Menu ******")
    println("Attention: If the total price more than \$50 then you will get a discount about %20 (ONLY FOR HOLIDAY MENU!!!)")
    println()

    // We create our food for Holiday Menu Items
    val chickenLasagna = Food("Chicken Lasagna", 23.55)
    val spiralSlicedHam = Food("Spiral Sliced Ham", 42.99)
    val wholeSmokedHam = Food("Whole Smoked Ham", 65.40)

    // Add food in Holiday Menu
    val holidayMenu = HolidayMenu(listOf(chickenLasagna, spiralSlicedHam, wholeSmokedHam))

    // Print all food in Holiday Menu
    holidayMenu.printAllFoodInMenu()
    println()

    // Filter menu by price for Holiday Menu items
    holidayMenu.filterMenuByPrice(40.00)
    println()

    // To order food, we choose food from the Holiday Menu.
    holidayMenu.selectFood(listOf(wholeSmokedHam))
}

/**
 * I used println() to make it look more tidy.
 */