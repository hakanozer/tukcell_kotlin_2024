package soru1

open class Menu {

    private val menu = mutableMapOf<String, Double>()

    constructor() {
        menu.put("Taco", 67.9)
        menu.put("Burger", 88.5)
        menu.put("Meat", 55.5)

    }

    //Menuye ekleme yapılmaktadır.
    open fun addFood(food: String, price: Double) {
        menu.put(food, price)
    }

    //Verilen aralıktaki fiyatı sağlayan yemekler döndürülür.
    //List food'a open keywordu verilmemiştir çünkü vacation menu içerisinden de genel menüye ulaşım sağlanması amaçlanmıştır.
    fun listFood(bottomPrice: Double, topPrice: Double): Map<String, Double> = menu.filter {
        it.value in bottomPrice..topPrice
    }


}