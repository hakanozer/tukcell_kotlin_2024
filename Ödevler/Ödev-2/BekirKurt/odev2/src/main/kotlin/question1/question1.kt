
fun main() {
    val menu = Menu()
    menu.addMeal("İskender", 222.99)
    menu.addMeal("Su böreği", 90.99)
    menu.addMeal("Balık", 128.99)
    menu.addMeal("Mantı", 108.99)
    menu.addMeal("Karnı Yarık", 128.99)

    println("List all meals")
    menu.listMeals()

    // List meals between min and max prices
    var min = 110.99
    var max = 300.99
    var meals = menu.listMealsByPriceRange(min,max)
    println("List meals between $min-$max price")
    meals.forEach { println("${it.first}: ${it.second}") }

    // create holiday menu
   val holidayMenu = HolidayMenu()
    // add meals to holiday menu
    holidayMenu.addHolidayMeal("Kebap", 125.99)
    holidayMenu.addHolidayMeal("Karnıyarık", 158.99)
    holidayMenu.addHolidayMeal("Pilav", 127.99)

    println("List holiday meals")
    holidayMenu.listMeals()

    min = 110.99
    max = 200.99
    meals = menu.listMealsByPriceRange(min,max)
    println("List meals between $min-$max price")
    meals.forEach { println("${it.first}: ${it.second}") }
}