package Question_1


abstract class Menu {
    val foodList = mutableListOf<MenuItem>()
    val filteredFoodList = mutableListOf<MenuItem>()

    abstract fun addFood(menuItem: MenuItem)
    abstract fun filterMenuItemsByPrice(startingPrice: Int, endingPrice: Int)

}