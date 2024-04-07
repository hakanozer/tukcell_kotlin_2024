package Soru_5

fun main() {
    val shop = OnlineShop()
    val shop1 = ShoppingApp()

    shop.sepeteEkle("Telefon",1,5000)
    shop.sepeteEkle("Laptop",1,10000)
    shop.sepeteEkle("kitap",5,100)
    //shop.sepettenCikar("kitap",1,100)

    shop1.sepeteEkle("Telefon",1,5000)
    shop1.sepeteEkle("Laptop",1,10000)
    shop1.sepeteEkle("kitap",5,100)

    //shop.sepetTemizle()

    shop.sepetiGoruntule()

    val total = shop.toplamHarcama()
    println("Ödemeniz gereken tutar: $total")

    println("=========================")

    val total1 = shop1.toplamHarcama()
    println("Ödemeniz gereken tutar: $total1")
}