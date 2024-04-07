package Soru1

open class Menu(val yemekListesi: MutableList<String>, val fiyatListesi : MutableList<Double>) {


    fun yemekEkle(yemekAdi : String, yemekFiyat : Double){

        this.yemekListesi.add(yemekAdi)
        this.fiyatListesi.add(yemekFiyat)
    }

    open fun araliktaListele(kucukAralik : Double, buyukAralik : Double): MutableMap<String, Double>{
        var temp = kucukAralik
        var kucuk : Double = 0.0
        var buyuk : Double = 0.0
        if (kucukAralik>buyukAralik){
            kucuk = buyukAralik
            buyuk = temp
        }
        else{
            kucuk = kucukAralik
            buyuk = buyukAralik
        }

        val secilenYemekMap: MutableMap<String, Double> = mutableMapOf()

        fiyatListesi.forEachIndexed { index, fiyat ->
            if (fiyat > kucuk && fiyat < buyuk){
                secilenYemekMap.put(yemekListesi.get(index), fiyatListesi.get(index))
            }
        }
        return secilenYemekMap
    }



}