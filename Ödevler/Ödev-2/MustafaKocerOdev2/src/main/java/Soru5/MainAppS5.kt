package Soru5

fun main(){
    val urun1 = Urun(1, "Telefon", 3000)
    val urun2 = Urun(2, "Laptop", 5000)
    val urun3 = Urun(3, "Kulaklık", 200)
    val urun4 = Urun(4, "Kamera", 1500)
    val urun5 = Urun(5, "Oyun Konsolu", 2500)
    val urun6 = Urun(6, "Tablet", 2000)
    val urun7 = Urun(7, "Akıllı Saat", 700)
    val urun8 = Urun(8, "Televizyon", 4000)
    val urun9 = Urun(9, "Bisiklet", 1000)
    val urun10 = Urun(10, "Gözlük", 300)
    val urun11 = Urun(11, "Kitap", 50)
    val urun12 = Urun(12, "Ev Aletleri Seti", 800)
    val urun13 = Urun(13, "Spor Ayakkabı", 200)
    val urun14 = Urun(14, "Çanta", 150)
    val urun15 = Urun(15, "Masa", 250)
    val urun16 = Urun(16, "Sandalye", 100)
    val urun17 = Urun(17, "Cep Telefon Kılıfı", 50)
    val urun18 = Urun(18, "Yazıcı", 600)
    val urun19 = Urun(19, "Kalem Seti", 20)
    val urun20 = Urun(20, "Müzik Çalar", 150)


    val user1 = User(1, "Ahmet", mutableListOf(urun1, urun2, urun3))
    val user2 = User(2, "Ayşe", mutableListOf(urun4, urun5, urun6))
    val user3 = User(3, "Mehmet", mutableListOf(urun7, urun8, urun9))
    val user4 = User(4, "Fatma", mutableListOf(urun10, urun11, urun12))
    val user5 = User(5, "Zeynep", mutableListOf(urun13, urun14, urun15))

    val userList = mutableListOf(user1, user2, user3, user4, user5)

    val onlineShop = OnlineShop(userList)


    var id = 1
    while (id < 6){
        println(onlineShop.harcamaHesapla(id))
        id++
    }

    val urunEkleme = mutableListOf(urun20,urun19, urun18)
    onlineShop.urunEkle(1,urunEkleme)
    println("Eklendikten Sonra ")
    println(onlineShop.harcamaHesapla(1))

    println("Cikarildiktan sonra")
    onlineShop.urunCikar(1,urun19)
    println(onlineShop.harcamaHesapla(1))

    println("Temizlendikten sonra")
    onlineShop.sepetiTemizle(1)
    println(onlineShop.harcamaHesapla(1))


}