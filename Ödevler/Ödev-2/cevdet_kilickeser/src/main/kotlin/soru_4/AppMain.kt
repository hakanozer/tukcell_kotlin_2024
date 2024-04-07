package soru_4

fun main() {
    val library = Library()

    val kitap1 = Roman("Suç ve Ceza", "Fyodor Dostoyevski")
    val kitap2 = Roman("Karamazov Kardeşler", "Fyodor Dostoyevski")
    val kitap3 = Ansiklopedi("Tarih Ansiklopedisi", "İlber Ortaylı")

    library.kitapEkle(kitap1)
    library.kitapEkle(kitap2)
    library.kitapEkle(kitap3)

    library.kitaplariListele()
    println()

    library.yazaraGoreKitapListele("Fyodor Dostoyevski")
}