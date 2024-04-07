package org.example.soru_1

/**
 *  Bir restoranın menüsünü temsil eden bir Kotlin sınıfı olan Menu oluşturun. Bu sınıf,
 * menüde bulunan yemekleri ve fiyatlarını içermelidir. Ayrıca, menüdeki yemekleri
 * eklemek için bir metod ve belirli bir fiyat aralığındaki yemekleri listelemek için bir başka
 * metod ekleyin. Ardından, Menu sınıfını miras alarak özel bir tatil menüsü oluşturun ve
 * ekstra tatil yemeklerini ve fiyatlarını ekleyin.
 */

open class Menu {

    val yemekListesi: MutableMap<String, Double> = mutableMapOf()

    open fun yemekEkle(yemekAdi: String, fiyat: Double) {
        yemekListesi[yemekAdi] = fiyat
    }

    fun yemekleriListele(minFiyat: Double, maxFiyat: Double): List<Pair<String, Double>> {
        return yemekListesi.filter { it.value in minFiyat..maxFiyat }.toList()
    }
}
