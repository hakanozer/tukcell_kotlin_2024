package Soru1

open class Menu {

    private val food = mutableMapOf<String, Double>()

    // Yiyecek ekleme
    fun addFood( name :String, price : Double)
    {
        food[name] = price

        println("$name isimli yemek menüye eklenmiştir : $price TL")
    }
    // Belirli fiyat aralığında filtreleme

    fun listFoodInPriceRange(minPrice: Double, maxPrice: Double) {
        println("Fiyat aralığı $minPrice - $maxPrice TL arasındaki yemekler:")
        val filteredFoods = food.filter { it.value in minPrice..maxPrice }
        if (filteredFoods.isEmpty()) {
            println("Bu fiyat aralığında yemek bulunamadı.")
        } else {
            filteredFoods.forEach { println("${it.key}: ${it.value} TL") }
        }
    }
}