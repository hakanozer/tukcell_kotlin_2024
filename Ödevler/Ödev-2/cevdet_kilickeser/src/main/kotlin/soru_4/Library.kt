package soru_4

class Library {
    private val kitaplistesi = mutableListOf<Kitap>()

    fun kitapEkle(kitap: Kitap) {
        kitaplistesi.add(kitap)
    }

    fun kitaplariListele() {
        println("Kütüphanedeki Kitaplar:")
        kitaplistesi.forEach { it.kitapBilgisiGoster() }
    }

    fun yazaraGoreKitapListele(yazar: String) {
        println("$yazar tarafından yazılan kitaplar:")
        kitaplistesi.filter { it.yazar == yazar }.forEach { it.kitapBilgisiGoster() }
    }
}
