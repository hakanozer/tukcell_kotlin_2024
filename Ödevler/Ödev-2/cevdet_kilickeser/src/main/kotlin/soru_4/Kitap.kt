package soru_4

open class Kitap(val isim: String, val yazar: String) {
    open fun kitapBilgisiGoster() {
        println("Kitap Adı: $isim, Yazar: $yazar")
    }
}