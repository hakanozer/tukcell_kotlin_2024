open class Menu() {
     val menuItems = mutableMapOf<String, Double>()

    fun addFood(foodName : String , price : Double) {
        /// parametre olarak aldigimiz "yemek" degiskenini iceren degerin fiyatini degistiriyoruz
        menuItems[foodName] = price
    }

    fun foodByPrice(minPrice : Double , maxPrice : Double) : List<String> {
        /// menuItems mapindeki elemanlarin belirtilen miktarlar arasinda olanlari bir liste olarak kaydediyoruz
        val filteredMenuItems = menuItems.filterValues { it in minPrice..maxPrice}.keys
        /// Eger fiyat araliginde yemek yoksa haber verelim
        if(filteredMenuItems.isEmpty()) {
            println("Bu fiyat aralığında yemek bulunamadı !")
        }

        return filteredMenuItems.toList()
    }
}

    /// menu sinifini miras alarak yemek ekleme fonksyionunu burada da kullanabiliyoruz
class HolidayMenu : Menu() {
    fun holidaySpecialFoods(holidayFoods: Map<String , Double>)
    {
        for ((foodName,price) in holidayFoods){
            /// Menu classinin bir fonksyionu olan addFood fonksyionunu direk kullaniyoruz
            addFood(foodName,price)
        }
    }

}

fun main() {
    val menu = Menu()
    menu.addFood("Patates" , 10.0)
    menu.addFood("Domates" , 20.0)
    menu.addFood("Su" , 15.0)
    menu.addFood("Kola", 25.0)
    menu.addFood("Salata", 100.0)

    println("Menü :  ${menu.menuItems}")

    val minPrice = 15.0
    val maxPrice = 50.0
    val foodByPrice = menu.foodByPrice(minPrice, maxPrice)
    println("Food by Price: $foodByPrice")

    val holidayMenu = HolidayMenu()
    val holidayFoods = mapOf("Et Döner" to 100.0 , "Tavuk Döner" to 80.0)
    holidayMenu.holidaySpecialFoods(holidayFoods)
    println("Holiday Menu : ")
    for ((foodName, price) in holidayFoods) println("$foodName: $price")
}