package org.example.soru_1

fun main() {
    val menu = Menu()
    menu.yemekEkle("Köfte", 225.0)
    menu.yemekEkle("Salata", 85.0)
    menu.yemekEkle("Pilav", 70.0)
    menu.yemekEkle("Tatlı", 180.0)

    println("150 TL ile 300 TL arasındaki yemekler:")
    val belirliFiyatAraligindakiYemekler = menu.yemekleriListele(150.0, 300.0)
    belirliFiyatAraligindakiYemekler.forEach { println(it) }

    val tatilMenu = TatilMenu()
    tatilMenu.yemekEkle("Adana", 140.0)
    tatilMenu.yemekEkle("Ayran", 35.0)
    tatilMenu.yemekEkle("Salata", 40.0)

    println("10 TL ile 125 TL arasındaki yemekler:")
    val tatilMenuFiyatAraligi = tatilMenu.yemekleriListele(10.0, 125.0)
    tatilMenuFiyatAraligi.forEach { println(it) }
}