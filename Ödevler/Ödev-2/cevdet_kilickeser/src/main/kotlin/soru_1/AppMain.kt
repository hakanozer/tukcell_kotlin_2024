package soru_1

fun main() {
    val menu = Menu()
    val tatilMenu = TatilMenu()

    menu.addMenuItem("Su",9.90)
    menu.addMenuItem("Kola",24.90)
    menu.addMenuItem("Ezogelin Çorba",24.90)
    menu.addMenuItem("Urfa Kebap",119.90)
    menu.addMenuItem("Künefe",89.90)
    menu.addMenuItem("Mevsim Salata",29.90)

    tatilMenu.addMenuItem("Ayran",19.90)
    tatilMenu.addMenuItem("Mercimek Çorba",39.90)
    tatilMenu.addMenuItem("Adana Kebap",119.90)
    tatilMenu.addMenuItem("Kadayıf",69.90)
    tatilMenu.addMenuItem("Çoban Salata",29.90)

    println(menu.priceList)
    println("*************************************************")
    println(tatilMenu.priceList)
}