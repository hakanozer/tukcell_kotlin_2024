package soru_4

class Ansiklopedi (isim: String, yazar: String) : Kitap(isim, yazar) {
    override fun kitapBilgisiGoster() {

        println("Ders Kitabı: $isim, Yazar: $yazar")
    }
}