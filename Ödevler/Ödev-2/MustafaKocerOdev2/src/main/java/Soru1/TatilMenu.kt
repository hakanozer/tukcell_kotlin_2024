package Soru1

class TatilMenu: Menu {
    var tumTatilMenuIsım : MutableList<String> = mutableListOf()
    var tumTatilMenuFiyat : MutableList<Double> = mutableListOf()


    constructor(yemekListesi: MutableList<String>, fiyatListesi: MutableList<Double>, ekstraMenuIsim: MutableList<String>, ekstraMenuFiyat: MutableList<Double>) : super(yemekListesi, fiyatListesi) {
        // İkincil kurucu fonksiyonla yapılacak işlemler buraya gelebilir
        tumTatilMenuIsım = yemekListesi
        tumTatilMenuIsım.addAll(ekstraMenuIsim)

        tumTatilMenuFiyat = fiyatListesi
        tumTatilMenuFiyat.addAll(ekstraMenuFiyat)
    }

    fun tatilMenuGetir(): MutableMap<String,Double>{
        val tatilMenum : MutableMap<String,Double> = mutableMapOf()
        tumTatilMenuIsım.forEachIndexed { index, yemekIsmi ->
            tatilMenum.put(yemekIsmi, tumTatilMenuFiyat.get(index))
        }

        return tatilMenum
    }

    override fun araliktaListele(kucukAralik: Double, buyukAralik: Double): MutableMap<String, Double> {
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

        tumTatilMenuFiyat.forEachIndexed { index, fiyat ->
            if (fiyat > kucuk && fiyat < buyuk){
                secilenYemekMap.put(tumTatilMenuIsım.get(index), fiyat)
            }
        }
        return secilenYemekMap
    }

}