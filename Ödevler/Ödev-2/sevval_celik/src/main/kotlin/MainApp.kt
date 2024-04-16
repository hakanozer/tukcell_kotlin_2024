fun main() {
    //Soru-1
    val menu = Menu()
    menu.yemekEkle("Köfte", 100)
    menu.yemekEkle("Tavuk Fajita", 280)
    menu.yemekEkle("Ton balıklı Salata", 150)
    menu.yemekEkle("Pizza", 300)
    menu.yemekEkle("Makarna", 150)
    println("Belirli fiyat aralığındaki yemeklerin listesi:")
    println( menu.yemekListele(100, 200))
    val tatilMenu = Tatil()
    tatilMenu.tatilYemekEkle("Tiramisu", 150)
    tatilMenu.tatilYemekEkle("Izgara Tavuk", 200)
    tatilMenu.tatilYemekEkle("Humus", 115)
    tatilMenu.tatilYemekEkle( "Deniz Mahsulleri Izgara", 125)
    tatilMenu.tatilYemekEkle("San Sebastiab", 120)
    tatilMenu.tatilYemekEkle("Cheesecake", 100)
    tatilMenu.tatilYemekEkle("Cookie", 110)
    tatilMenu.tatilYemekEkle("BAklava", 160)
    println("Belirli fiyat aralığındaki tatil yemekleri:")
    println(tatilMenu.yemekListele(100, 130))

    //Soru-2
    val ogr1 = Student("Rümeysa", 977, listOf("Edebiyat", "Fizik", "Kimya"))
    val ogr2 = Student("Elif", 369, listOf("Tarih", "Coğrafya","Matematik","Edebiyat"))
    val ogr3 = Student("Şevval", 644, listOf("Biyoloji", "Kimya", "Fizik", "Matematik","İngilizce"))

    val ogrenciler = listOf(ogr1, ogr2, ogr3)

    println("Tüm öğrencilerin aldığı dersler:")
    for (ogrenci in ogrenciler) {
        ogrenci.dersleriListele()
        println()
    }

    val enYuksekDersliOgrenci = ogr1.enYuksekDersSayisinaSahipOgrenciyiBul(listOf(ogr1, ogr2, ogr3))
    if (enYuksekDersliOgrenci != null) {
        println("En yüksek ders sayısına sahip öğrenci: ${enYuksekDersliOgrenci.ogrenciAd} - ${enYuksekDersliOgrenci.ogrenciNumara} - ${enYuksekDersliOgrenci.ogrenciDers.size} ders")
    } else {
        println("en yüksek ders sayısına sahip öğrenci yok.")
    }

    //Soru-3
    val aslan = Animal("Kaplumbağa", "Sürüngen", "Kara")
    val fil = Animal("Fil", "Memeli", "Orman")
    val penguen = Animal("Penguen", "Kuş", "Buzullar")
    val yunus=Animal("Yunus", "Memeli", "Deniz")
    val balina=Animal("Balina", "Memeli", "Deniz")

    val zoo = Zoo()
    zoo.hayvanEkle(aslan)
    zoo.hayvanEkle(fil)
    zoo.hayvanEkle(penguen)
    zoo.hayvanEkle(yunus)
    zoo.hayvanEkle(balina)

    val denizHayvanlari = zoo.yasamAlaninaSahipHayvanlariListele("Deniz")
    println("Denizde yaşayan hayvanlar:")
    for (hayvan in denizHayvanlari) {
        println("${hayvan.hayvanAd} - ${hayvan.hayvanTuru}")
    }

    //Soru-4
    val library = Library()
    library.addBook(Book("Fareler ve İnsanlar", "John Steinbeck"))
    library.addBook(Book("Hayvan Çiftliği", "George Orwell"))
    library.addBook(Book("1984", "George Orwell"))
    library.addBook(Book("Gazap Üzümleri", "John Steinbeck"))
    library.addBook(Book("Dorian Gray'in Portresi", "Oscar Wilde"))
    library.addBook(Book("Yıldız Çocuk", "Oscar Wilde"))

    println("Mevcut Kitaplar:")
    for (book in library.kitapListele()) {
        println("${book.title} - ${book.author}")
    }

    val author = "John Steinbeck"
    println("\n$author'nın Kitapları:")
    for (book in library.yazarinKitaplariniListele(author)) {
        println("${book.title} - ${book.author}")
    }

    //Soru-5
    val onlineShop = OnlineShop()
    val urun1 = Product("Pantolon", 1000.0)
    val urun2 = Product("Etek", 600.0)
    val urun3 = Product("Ayakkabı", 2000.0)

    onlineShop.productEkle(urun1)
    onlineShop.productEkle(urun2)
    onlineShop.productEkle(urun3)

    println("Sepetiniz:")
    for (product in onlineShop.sepet) {
        println("${product.name} - ${product.fiyat} TL")
    }
    onlineShop.urunCikar(urun1)

    println("\nGüncellenmiş Sepetiniz:")
    for (product in onlineShop.sepet) {
        println("${product.name} - ${product.fiyat} TL")
    }

    val total = onlineShop.toplamHarcamayiHesapla()
    println("\nToplam Harcama: $total TL")

    onlineShop.sepetiTemizle()
    println("\nSepet Temizlendi")


}