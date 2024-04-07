package Soru_1

class TatilMenu: Menu() {

    val tatilMenu = mutableMapOf("Patates Kızartması" to 80,
                                 "Hamburger" to 190,
                                 "Margarita Pizza" to 250,
                                 "Sucuklu Pizza" to 230,
                                 "Baklava" to 130)

    override fun addMenuItem(itemName: String, price: Int) {
        if (menu.containsKey(itemName) || tatilMenu.containsKey(itemName)){
            println("$itemName menülerin içinde yer almaktadır")
        }
        else
        {
            tatilMenu[itemName] = price
        }
    }

    override fun listMenu(minPrice: Int, maxPrice: Int) {
        println("Menülerdeki $minPrice₺ - $maxPrice₺ Arasındaki Yemekler ve Fiyatları")
        menu.putAll(tatilMenu)
        menu.filterValues {
            it in minPrice..maxPrice
        }.forEach { itemName, price ->
                println("              $itemName - $price₺")
        }
    }

    fun listTatilMenu(minPrice: Int, maxPrice: Int) {
        println("Tatil Menüsündeki $minPrice₺ - $maxPrice₺ Arasındaki Yemekler ve Fiyatları")
        tatilMenu.filterValues {
            it in minPrice..maxPrice
        }.forEach { itemName, price ->
            println("              $itemName - $price₺")
        }
    }

}