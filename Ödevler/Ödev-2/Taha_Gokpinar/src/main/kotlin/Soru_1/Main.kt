package Soru_1

fun main() {
    val menu = Menu()
    menu.addMenuItem("Tavuk Kanat", 200)

    val tatilMenu = TatilMenu()
    tatilMenu.addMenuItem("Katmer", 150)

    poliCall(menu)
    poliCall(tatilMenu)

}

fun poliCall(menu: Menu){
    if (menu is TatilMenu){
        menu.listTatilMenu(50,200)
    }

    menu.listMenu(50,200)
}