package org.example.soru_1

class TatilMenu : Menu() {

    override fun yemekEkle(yemekAdi: String, fiyat: Double) {
        yemekListesi[yemekAdi] = fiyat
    }
}