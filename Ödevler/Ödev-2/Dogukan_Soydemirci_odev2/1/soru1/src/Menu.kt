open class Menu {
    protected val Menuyemekleri: MutableMap<String, Double> = mutableMapOf()

    // Yemek ekleme metodunu tanımla
    open fun yemekEkle(item: String, price: Double) {
        Menuyemekleri[item] = price
    }

    // Belirli bir fiyat aralığındaki yemekleri listeleme metodunu tanımla
    open fun menuYemeklistele(minPrice: Double, maxPrice: Double) {
        println("Yemekler ve fiyatları:")
        for ((item, price) in Menuyemekleri) {
            if (price in minPrice..maxPrice) {
                println("$item: $price")
            }
        }
    }
}


class TatilMenu : Menu() {

    fun tatilMenuYemekEkle(item: String, price: Double) {
        yemekEkle(item, price)
    }


    override fun menuYemeklistele(minPrice: Double, maxPrice: Double) {
        println("Tatil Yemekleri ve Fiyatları:")
        for ((item, price) in Menuyemekleri) {
            if (price in minPrice..maxPrice) {
                println("$item: $price")
            }
        }
    }
}

fun main() {

    val regularMenu = Menu()
    regularMenu.yemekEkle("Döner", 20.0)
    regularMenu.yemekEkle("Kebap", 30.0)
    regularMenu.yemekEkle("Çorba", 15.0)


    println("Normal Menü:")
    regularMenu.menuYemeklistele(10.0, 20.0)


    val tatilMenu = TatilMenu()
    tatilMenu.tatilMenuYemekEkle("Sütlaç", 30.0)
    tatilMenu.tatilMenuYemekEkle("Tandır", 50.0)


    println("\nTatil Menüsü:")
    tatilMenu.menuYemeklistele(20.0, 35.0)
}