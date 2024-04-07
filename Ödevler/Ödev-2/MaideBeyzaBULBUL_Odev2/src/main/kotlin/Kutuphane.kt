open class Kitap(val Isim: String, val Yazar: String)

class Kutuphane {
    private val Kitaplar = mutableListOf<Kitap>()

    fun KitapEkle(kitap: Kitap) {
        Kitaplar.add(kitap)
    }

    fun KitapListesi(): List<Kitap> {
        return Kitaplar.toList()
    }

    fun BelirliYazarinKitaplariniListelemekİcin(Yazar: String): List<Kitap> {
        return Kitaplar.filter { it.Yazar == Yazar }
    }
}