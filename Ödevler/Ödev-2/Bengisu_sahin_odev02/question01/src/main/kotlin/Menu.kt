open class Menu {
    // A map was created to put into the menu of the meals and their prices.
    // meals -> String, price -> Double
    // "mutableMapOf" was used because meals are appendable.
    private val menu = mutableMapOf<String, Double>()

    fun addMeal(meal: String, price: Double){
        menu[meal] = price
    }

    // Thanks to "filterValues" easily filter meals according to a given range and return the filtered Meal.
    fun filterPrice(minPrice: Double, maxPrice: Double) {
        val filteredMeals = menu.filterValues {it in minPrice..maxPrice }
        println("Filtered Menu:")
        filteredMeals.forEach { (meal, price) ->
            println("$meal - $price TL")
        }
    }

    open fun printMenu() {
        if (menu.isEmpty()) {
            println("Menu is empty.")
        } else {
            for ((meal, price) in menu) {
                println("$meal - $price TL")
            }
        }
        println()
    }

}