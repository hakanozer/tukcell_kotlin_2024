package Soru_5

open class OnlineShop {

    val sepet = mutableMapOf<String, Int>()

    fun sepeteEkle(urunAdi: String, miktar: Int, fiyat: Int){
        if(sepet.containsKey(urunAdi)){
            sepet[urunAdi] = sepet[urunAdi]!! + (fiyat*miktar)
        }
        else{
            sepet[urunAdi] = fiyat*miktar
        }
    }

    fun sepettenCikar(urunAdi: String, miktar: Int, fiyat: Int,){
        if (sepet.containsKey(urunAdi)){
            val kalanUrun = sepet[urunAdi]!! - (fiyat*miktar)
            if(kalanUrun <= 0){
                sepet.remove(urunAdi)
                println("$urunAdi sepetten kaldırıldı.")
            }
            else{
                sepet[urunAdi] = kalanUrun
                println("$miktar adet $urunAdi sepetten kaldırıldı.")
            }
        }
        else{
            println("$urunAdi adlı ürün sepetinizde bulunmamaktadır.")
        }
    }

    fun sepetTemizle(){
        sepet.clear()
        println("Sepetiniz boşaltıldı.")
    }

    fun sepetiGoruntule(){
        for((urunAdi, fiyat) in sepet){
            println("$urunAdi - $fiyat")
        }
    }

    open fun toplamHarcama(): Double{
        var toplam = 0.0
        for ((urunAdi, fiyat) in sepet){
            toplam += fiyat
        }
        return toplam + 25
    }
}