interface IMenu {
    fun yemekEkle(yemek: String, yemekFiyat: Int): Map<String, Int>
    fun yemekListele(altFiyat: Int, ustFiyat: Int): MutableList<String>
}

class Menu : IMenu {
    private val yemekList = mutableMapOf<String, Int>()

    override fun yemekEkle(yemek: String, yemekFiyat: Int): Map<String, Int> {
        yemekList.put(yemek,yemekFiyat)
        return yemekList
    }

    override fun yemekListele(alt: Int, ust: Int): MutableList<String> {
        val yemekListe = mutableListOf<String>()
        for ((yemek, fiyat) in yemekList) {
            if (fiyat in alt..ust) {
                yemekListe.add("$yemek: $fiyat")
            }
        }
        return yemekListe
    }
}

class Tatil : IMenu {
    private val tatilYemekList = mutableMapOf<String, Int>()

    override fun yemekEkle(yemek: String, yemekFiyat: Int): Map<String, Int> {
        tatilYemekList.put(yemek, yemekFiyat)
        return tatilYemekList
    }

    override fun yemekListele(alt: Int, ust: Int): MutableList<String> {
        val liste = mutableListOf<String>()
        for ((yemek, fiyat) in tatilYemekList) {
            if (fiyat in alt..ust) {
                liste.add("$yemek: $fiyat")
            }
        }
        return liste
    }

    fun tatilYemekEkle(yemek: String, fiyat: Int) {
        tatilYemekList.put(yemek, fiyat)
    }
}