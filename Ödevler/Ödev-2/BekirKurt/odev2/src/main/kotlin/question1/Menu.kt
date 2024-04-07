open class Menu {
    private val menu = mutableMapOf<String, Double>()

    // add meal
    open fun addMeal(meal: String, price: Double) {
        menu[meal] = price
    }
    // list all meals
    open fun listMeals():Unit{
        for ((meal, price) in menu) {
            println("$meal - $price TL")
        }
    }
    // list meals between min max values
    open fun listMealsByPriceRange(min: Double, max: Double): List<Pair<String, Double>> {
        return menu.filterValues { it in min..max }.toList()
    }
}