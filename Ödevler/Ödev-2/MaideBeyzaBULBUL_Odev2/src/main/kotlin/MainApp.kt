fun main() {

    println("1. soru")
    val menu = Menu()
    menu.yemekEkleme("kinoalı bowl",250.50)
    menu.yemekEkleme("somon bowl",200.0)
    menu.yemekEkleme("ızgara köfteli humuslu salata",350.0)
    menu.yemekEkleme("tteokbokki",210.0)
    menu.yemekEkleme("kimbap",190.99)

    val enDusuk = 190.99
    val enYuksek = 350.0
    val mealsInRange = menu.belirliAraliktaYemekListelemek(enDusuk,enYuksek)
    println("Menüde $enDusuk - $enYuksek aralığında olan yemekler:")
    mealsInRange.forEach {
        println("${it.first}: ${it.second} TL") }

    val TatilMenu = TatilMenu()
    TatilMenu.ekstraYemekEkleme("Mezgit", 150.0)
    TatilMenu.ekstraYemekEkleme("Karides", 240.0)
    TatilMenu.ekstraYemekEkleme("İstavrit", 250.0)

    println("\nTatil Menüsü:")
    TatilMenu.belirliAraliktaYemekListelemek(0.0, Double.MAX_VALUE).forEach { println("${it.first}: ${it.second} TL") }


    println("2. soru")
    val database = ogrencilistesi()
    database.ogrenciEkle(ogrenci("Maide", 1, listOf("Elektrik Makinaları", "Güç Elektroniği", "Kontrol Teorisi")))
    database.ogrenciEkle(ogrenci("Beyza", 2, listOf("Elektromanyetik Alan Teorisi", "Anten Teorisi")))
    database.ogrenciEkle(ogrenci("Oğuzhan", 3, listOf("Elektromanyetik Dalga Teorisi", "Olasılık ve İstatistik")))
    database.ogrenciEkle(ogrenci("Esra", 4, listOf("Elektroteknik", "Komplex Değişkenler ve Analiz")))


    val enÇokDersAlanOgrenci = database.enCokDersAlanOgrenci()
    if (enÇokDersAlanOgrenci != null) {
        println("en çok ders alan öğrenci: ${enÇokDersAlanOgrenci.adi}")
    } else {
        println("böyle bir öğrenci bulunmamaktadır")
    }


    println("3. soru")
    val hayvanatBahcesi = hayvanatBahcesi()
    hayvanatBahcesi.hayvanEkleme(hayvanlar("Aslan", "Memeli", "Afrika"))
    hayvanatBahcesi.hayvanEkleme(hayvanlar("Fil", "Memeli", "Afrika"))
    hayvanatBahcesi.hayvanEkleme(hayvanlar("Kaplumbağa", "Sürüngen", "Tropik"))
    hayvanatBahcesi.hayvanEkleme(hayvanlar("Kartal", "Kuş", "Orman"))

    val habitat = "Afrika"
    val hayvanlarınHabitati = hayvanatBahcesi.hayvanlarınlistesi(habitat)
    if (hayvanlarınHabitati.isNotEmpty()) {
        println("Hayvanat Bahçesindeki $habitat habitatındaki hayvanlar:")
        hayvanlarınHabitati.forEach { println("${it.name} (${it.turu})") }
    } else {
        println("Hayvanat Bahçesinde $habitat habitatında hayvan bulunmamaktadır.")
    }


    println("4. soru")
    val library = Kutuphane()
    library.KitapEkle(Kitap("Beyaz Geceler", "Dostoyevski"))
    library.KitapEkle(Kitap("İlber Ortaylı", "Bir Ömür Nasıl Yaşanır"))
    library.KitapEkle(Kitap("Putların Alacakaranlığı", "Friedrich Nietzsche"))
    library.KitapEkle(Kitap("İşte BÖyle Buyurdu Zerdüşt", "Friedrich Nietzsche"))

    val Yazar = "Dostoyevski"
    val YazarinKitablari = library.BelirliYazarinKitaplariniListelemekİcin(Yazar)
    if (YazarinKitablari.isNotEmpty()) {
        println("$Yazar'nın kitapları:")
        YazarinKitablari.forEach { println(it.Isim) }
    } else {
        println("$Yazar'nın kütüphanede kitabı bulunmamaktadır.")
    }


   }





