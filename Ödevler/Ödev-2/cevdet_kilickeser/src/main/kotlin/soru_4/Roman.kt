package soru_4

import java.awt.print.Book

class Roman (isim: String, yazar: String) : Kitap(isim, yazar) {
    override fun kitapBilgisiGoster() {
        println("Roman: $isim, Yazar: $yazar")
    }
}