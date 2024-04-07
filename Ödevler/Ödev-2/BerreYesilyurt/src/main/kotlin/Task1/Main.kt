package org.example.Task1

fun main() {

    val menu=Menu()
    menu.addMeals("Salata",150)
    val specialHolidayMenu=HolidayMenu()
    specialHolidayMenu.addMeals("Lazanya",300)

    println(menu.menu)
    println(specialHolidayMenu.specialHolidayMenu)

}