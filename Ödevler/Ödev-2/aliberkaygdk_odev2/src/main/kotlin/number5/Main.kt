package number5

fun main() {
    val kisi1 = User(1, "Ali")
    val kisi2 = User(2, "Veli")

    val araba = Urun("Araba",100000.0)
    val telefon = Urun("Samsung", 10500.0)

    val shop = OnlineShop(kisi1)
    shop.urunEkle(listOf(araba,telefon))
    shop.hesapla()

    shop.silinecekler(listOf(araba))
    shop.hesapla()
    shop.temizle()
    shop.hesapla()


}