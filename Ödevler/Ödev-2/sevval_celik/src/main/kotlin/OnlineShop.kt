class OnlineShop {
    val sepet: MutableList<Product> = mutableListOf()

    fun productEkle(product: Product) {
        sepet.add(product)
    }
    fun urunCikar(urun: Product) {
        sepet.remove(urun)
    }
    fun sepetiTemizle() {
        sepet.clear()
    }
    fun toplamHarcamayiHesapla(): Double {
        var toplam = 0.0
        for (urun in sepet) {
            toplam += urun.fiyat
        }
        return toplam
    }

}