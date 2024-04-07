package number5

class OnlineShop(private val user: User) {

    private val urunListe = mutableListOf<Urun>()

    fun urunEkle(urunList: List<Urun>){
        urunList.forEach { urun ->
            urunListe.add(urun)
        }
    }

    fun silinecekler(urunList: List<Urun>){
        urunList.forEach {
            urunListe.remove(it)
        }
    }

    fun temizle(){
        urunListe.clear()
    }

    fun hesapla() {
        var toplam = 0.0
        urunListe.forEach {
            toplam += it.fiyat
        }
        println("Toplam: $toplam")
    }


}