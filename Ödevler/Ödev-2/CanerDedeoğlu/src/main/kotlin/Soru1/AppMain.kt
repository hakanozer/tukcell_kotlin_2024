package Soru1

fun main() {

    val menu = Menu()

    menu.addFood("Köri Soslu Tavuk", 210.0)

    menu.addFood("Makarna",90.0)

    val dessert = Dessert()

    dessert.addDesert("Sufle",80.0)
    dessert.addDesert("Traliçe",80.0)

    menu.listFoodInPriceRange(25.0,95.0)
    dessert.listFoodInPriceRange(70.0,95.0)
}