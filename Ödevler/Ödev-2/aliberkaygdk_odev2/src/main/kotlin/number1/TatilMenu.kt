package number1

class TatilMenu : Menu() {
    private val liste = mutableMapOf<String, Int>("pizza" to 600, "hamburger" to 700)

    override fun ekle(isim: String, fiyat: Int) {
        liste[isim] = fiyat
        println("$isim eklendi")
    }

    override fun listele(min: Int, max: Int) {
        val yeniListe = liste.filterValues { it in min..max }
        println(yeniListe)
    }
}