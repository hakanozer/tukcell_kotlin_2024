package soru1


fun main() {

    // 1.SORU
    //Menu Class
    var menu = Menu()
    menu.addFood("Pizza", 78.5)
    println(menu.listFood(50.0, 90.0)) //Çıktı {Taco=67.9, Burger=88.5, Meat=55.5, Pizza=78.5}

    //Vacation Menu Class
    var vacationMenu = VacationMenu()
    vacationMenu.addFood("Pasta", 78.0)
    println(vacationMenu.listFood(50.0, 90.0)) //Çıktı {Taco=67.9, Burger=88.5, Meat=55.5, Pasta=78.0}
    println(vacationMenu.listVacationFood(50.0, 90.0)) //Çıktı {Grilled Cheese=67.0, Arrabbiata=67.0, Cheese Burger=67.0, Pasta=78.0}


}