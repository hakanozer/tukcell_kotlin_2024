fun main() {
    val menu = Menu()
    menu.addMeal("Mantı",150.0)
    menu.addMeal("Mercimek Çorbası",70.0)

    menu.printMenu()

    menu.filterPrice(0.0, 80.0)

    val holidayMenu = HolidayMenu()
    holidayMenu.addMeal("Hamburger",250.0)
    holidayMenu.addMeal("Cheeseburger",212.0)
    holidayMenu.printMenu()

    holidayMenu.filterPrice(100.0,220.0)

}