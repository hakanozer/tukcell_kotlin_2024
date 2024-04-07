open class Menu {
    private val yemekler = mutableMapOf<String, Double>()

    fun yemekEkleme(yemek: String, fiyat: Double) {
        yemekler[yemek] = fiyat
    }

    fun belirliAraliktaYemekListelemek(enDüsük: Double, enYuksek: Double): List<Pair<String, Double>> {
        return yemekler.filter { it.value in enDüsük..enYuksek }.toList()
    }

}