package assignment_one

fun main() {
    //  tatil menüsü oluşturuldu
    val holidayMenu = mutableMapOf("Hamburger" to 22,"Pizza" to 50)


    val specialMenu = SpecialMenu(specialMenu = holidayMenu )
    val normalMenu = Menu()

    //tatil menüsüne ekstra yemek ekleme
    specialMenu.addFoodMenu("Kola",14)


    println(specialMenu.menu)
    println(normalMenu.menu)

    println(specialMenu.getFoodsInPriceRange(30,100))
    println(normalMenu.getFoodsInPriceRange(30,100))

}