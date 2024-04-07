fun main() {
    //Soru - 1
    // Menü örneği oluştur
    val ClassicMenu = Menu()
    ClassicMenu.addMeal("Adana Kebab", 250)
    ClassicMenu.addMeal("Büryan", 250)
    ClassicMenu.addMeal("İskender", 300)
    ClassicMenu.addMeal("Salata", 105)
    ClassicMenu.addMeal("Karışık Izgara", 450)
    ClassicMenu.addMeal("Pirzola", 325)
    ClassicMenu.addMeal("Kaburga", 325)
    ClassicMenu.addMeal("Ayran", 35)
    ClassicMenu.addMeal("Su", 10)

    println("\nMenümüz :")
    ClassicMenu.priceRange(0, Int.MAX_VALUE).forEach { (meal, price) ->
        println("$meal: $price")
    }
    println("\n100 Tl ile 250 Tl Arası Yemekler :")
    ClassicMenu.priceRange(100, 250).forEach { (meal, price) ->
        println("$meal: $price")
    }


    val tatilMenu = TatilMenu()

    // Tatil menüsünü yazdır
    println("\nTatil Menüsü:")
    tatilMenu.priceRange(0, Int.MAX_VALUE).forEach { (meal, price) ->
        println("$meal: $price")
    }
}