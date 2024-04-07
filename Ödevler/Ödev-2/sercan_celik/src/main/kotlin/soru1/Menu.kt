package soru1

open class Menu {
    private val menuFoods = mutableMapOf<String, Double>()
    open fun addFood(food: String, price: Double) {
        menuFoods[food] = price
    }

    open fun listFoodsInPriceRange(minPrice: Double, maxPrice: Double) {
        val foodsInRange = menuFoods.filter {
            it.value > minPrice && it.value < maxPrice
        }
        for ((food, price) in foodsInRange) {
            println("$food: $price TL")
        }
    }
}