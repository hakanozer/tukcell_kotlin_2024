package Soru_1

open class Menu {

    val menu = mutableMapOf("Mercimek Çrbası" to 80,
                            "İçli Köfte" to 90,
                            "Ciğer Tava" to 240,
                            "Mevsim Salata" to 110,
                            "Adana Kebap" to 230,
                            "Tavuk Şiş" to 220,
                            "Izgara Köfte" to 250,
                            "Izgara Bonfile" to 460,
                            "Kuzu İncik" to 400,
                            "Dana Pirzola" to 540,
                            "Künefe" to 110,
                            "Fırın Sütlaç" to 100)

    open fun addMenuItem( itemName: String, price: Int){
        if (menu.containsKey(itemName)){
            println("$itemName zaten menüde var.")
        }
        else{
            menu.put(itemName, price)
        }
    }

    open fun listMenu(minPrice: Int, maxPrice: Int) {
        println("Menüdeki $minPrice₺ - $maxPrice₺ Arasındaki Yemekler ve Fiyatları")
        val filteredMenu = mutableMapOf<String, Int>()
        for (it in menu){
            if (minPrice <= it.value && it.value <= maxPrice){
                filteredMenu.put(it.key, it.value)
            }
        }
        for (item in filteredMenu){
            println("              ${item.key} - ${item.value}₺")
        }
    }
}