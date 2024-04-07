package soru1

class HolidayMenu : Menu() {
    private val menuHolidayFoods = mutableMapOf<String, Double>()
    override fun addFood(food: String, price: Double) {
        menuHolidayFoods[food] = price
    }

    override fun listFoodsInPriceRange(minPrice: Double, maxPrice: Double) {
        val foodsInRange = menuHolidayFoods.filter {
            it.value > minPrice && it.value < maxPrice
        }
        for ((food, price) in foodsInRange) {
            println("$food: $price TL")
        }
    }
}