package Soru1

open class YemekMenu {

    private val yemekler = mutableListOf<Yemek>()

    fun yemekEkle(yemek: Yemek) {
        yemekler.add(yemek)
    }

    fun fiyatFiltrele(maxFiyat: Int): List<Yemek> {
        return yemekler.filter { it.fiyat <= maxFiyat }
    }

    fun yemekleriListele(){
        println(yemekler)
    }



}