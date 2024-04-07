package number1

fun main() {

    val list = Menu()
    list.ekle("baklava", 200)
    list.ekle("kebab", 250)
    list.listele(0, 1000)

    println("------")

    val tatilMenu = TatilMenu()
    tatilMenu.ekle("pasta", 100)
    tatilMenu.listele(0, 1000)
}