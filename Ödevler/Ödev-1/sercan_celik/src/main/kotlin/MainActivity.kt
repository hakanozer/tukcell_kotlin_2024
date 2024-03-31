fun main() {

    println("============== 1.Soru =============")
    val arr1 = arrayOf(0, 5, 8, 6, 4, 2, 4, 8, 3, 48, 864, 4686, 868, 878, 12156, 8498498, 6545, 9, 45, 25, 15, -54)
    ciftBulListeyeEkle(arr1)

    println("============== 2.Soru =============")
    val arr2 = arrayOf("kotlin", "coding", "java", "pyhton", "dart", "swift")
    println(harfTekrariBulMapDonder(arr2))

    println("============== 3.Soru =============")
    val list1 = listOf(161566, 84, 886, 651, 651, 561, 546, 48, 4, 897, 9, 156, 1465, 46, 48, 94, 9, 4, 4, 1, 3)
    println(terseCevir(list1))

    println("============== 4.Soru =============")
    tekSayiAraliktaBul(12, 21)

    println("============== 5.Soru =============")
    val arr3 = arrayOf("kotlin", "coding", "java", "pyhton", "dart", "swift")
    println(sesliHarfTekrariBulMapDonder(arr3))

    println("============== 6.Soru =============")
    println(belirliSayiyaKadarAsalBulListDonder(375))

    println("============== 7.Soru =============")
    val arr4 = arrayOf("Merhabalar kotlin ben Sercan Çelik", "Ben ödev yapıyorum", "kotlin dili ile kod yazıyorum")
    println("Kelime sayısı: ${kelimeSayisiHesapla(arr4)}")

    println("============== 8.Soru =============")
    val arr5 = arrayOf("Merhabalar kotlin ben Sercan Çelik", "Ben ödev yapıyorum", "Kotlin ile kod yazıyorum")
    println(enCokTekrarEdenKelimeyiBul(arr5))

    println("============== 9.Soru =============")
    val dize1 = "sercan"
    val dize2 = "123456"
    println(stringBirlestir(dize1, dize2))

    println("============== 10.Soru =============")
    val liste = listOf(8, 14, 4156, 56, 5, 15, 25, 57)
    val set = setOf(11, 55, 57, 899, 51, 4156, 4, 5, 6, 7)
    println(listSetFarkiBulDonder(liste, set))
}

// 1.Soru İçin Fonksiyon
fun ciftBulListeyeEkle(arr: Array<Int>) {
    val ciftListesi = mutableListOf<Int>()
    arr.forEach {
        if (it % 2 == 0) {
            ciftListesi.add(it)
        }
    }
    println("Çift Sayılar Litesi Elemanları: $ciftListesi")
}

// 2.Soru İçin Fonksiyonu
fun harfTekrariBulMapDonder(arr: Array<String>): Map<Char, Int> {
    val mapTekrarlar = mutableMapOf<Char, Int>()
    arr.forEach { str ->
        str.lowercase().forEach { char ->
            if (mapTekrarlar.containsKey(char)) {
                mapTekrarlar[char] = mapTekrarlar.getValue(char) + 1
            } else {
                mapTekrarlar[char] = 1
            }
        }

    }
    return mapTekrarlar
}

// 3.Soru İçin Fonksiyon
fun terseCevir(list: List<Int>): List<Int> {
    val tersDizi = mutableListOf<Int>()
    for (i in list.size - 1 downTo 0) {
        tersDizi.add(list[i])
    }
    return tersDizi
}

// 4.Soru İçin Fonksiyon
fun tekSayiAraliktaBul(baslangic: Int, bitis: Int) {
    val tekSayiDizisi = arrayListOf<Int>()
    for (i in baslangic + 1..<bitis) {
        if (i % 2 != 0) {
            tekSayiDizisi.add(i)
        }
    }
    println(tekSayiDizisi)
}

// 5.Soru İçin Fonksiyon
fun sesliHarfTekrariBulMapDonder(arr: Array<String>): Map<Char, Int> {
    val mapTekrarlar = mutableMapOf<Char, Int>()
    val sesliHarfler = arrayOf('a', 'e', 'i', 'o', 'u')
    arr.forEach { str ->
        str.lowercase().forEach { char ->
            if (char in sesliHarfler) {
                mapTekrarlar[char] = mapTekrarlar.getOrDefault(char, 0) + 1
            }
        }
    }
    return mapTekrarlar
}

// 6.Soru İçin Fonksiyon
fun belirliSayiyaKadarAsalBulListDonder(bitis: Int): List<Int> {
    val asallar = mutableListOf<Int>()
    for (sayi in 2..bitis) {
        var asaldir = true
        for (bolen in 2 until sayi) {
            if (sayi % bolen == 0) {
                asaldir = false
            }
        }
        if (asaldir) {
            asallar.add(sayi)
        }
    }
    return asallar
}

// 7.Soru İçin Fonksiyon
fun kelimeSayisiHesapla(dizi: Array<String>): Int {
    var toplamKelimeSayisi = 0
    for (cumle in dizi) {
        var kelimeSayisi = 0
        var kelimeBaslama = false
        for (char in cumle) {
            if (char == ' ') {
                kelimeBaslama = false
            } else if (!kelimeBaslama) {
                kelimeBaslama = true
                kelimeSayisi++
            }
        }
        toplamKelimeSayisi += kelimeSayisi
    }
    return toplamKelimeSayisi
}

// 8.Soru İçin Fonksiyon
fun enCokTekrarEdenKelimeyiBul(dizi: Array<String>): String {
    val kelimeSayilariMap = mutableMapOf<String, Int>()
    val birlesmisKelimeler = dizi.joinToString(" ").lowercase()
    birlesmisKelimeler.split(" ").forEach { kelime ->
        kelimeSayilariMap[kelime] = kelimeSayilariMap.getOrDefault(kelime, 0) + 1
    }
    var enCokGorulenKelime = ""
    var enCokTekrarKelimeSayisi = 0
    kelimeSayilariMap.forEach { (kelime, sayi) ->
        if (sayi > enCokTekrarKelimeSayisi) {
            enCokGorulenKelime = kelime
            enCokTekrarKelimeSayisi = sayi
        }
    }
    return enCokGorulenKelime
}

// 9.Soru İçin Fonksiyon
fun stringBirlestir(dize1: String, dize2: String): String {
    var birlesmisDize = ""
    if (dize1.length == dize2.length) {
        birlesmisDize += dize1 + dize2
        birlesmisDize.uppercase()
        return birlesmisDize
    } else {
        return dize1 + dize2
    }
}

// 10.Soru İçin Fonksiyon
fun listSetFarkiBulDonder(liste: List<Int>, set: Set<Int>): List<Int> {
    val farkListesi = mutableListOf<Int>()
    for (i in liste) {
        if (!set.contains(i)) {
            farkListesi.add(i)
        }
    }
    return farkListesi
}




