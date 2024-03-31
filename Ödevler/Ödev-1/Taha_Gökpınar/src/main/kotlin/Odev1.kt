fun main() {
    println("Dizideki çift sayılar:")
    val arr = arrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val arr1 = ciftList(arr)
    println(arr1)

    println("Dizideki kelimelerin harflerinin tekrar sayısı:")
    val arr2 = arrayOf("kelime", "harf", "tekrar", "sayısı")
    val harfSayisi = harfMap(arr2)
    println(harfSayisi)

    println("Verilen listenin tersi:")
    val list = listOf("kelime", "harf", "liste")
    val reverseList = reverseList(list)
    println(reverseList)

    println("Verilen başlangıç ve bitiş değerleri arasındaki tek sayılar:")
    val arr3 = tekSayilar(0,50)
    for (i in arr3){
        print("$i ")
    }

    println("")
    println("Bir dizideki sesli harf sayısı:")
    val arr4 = arrayOf("Taha", "Gökpınar")
    val sesliHarfler = sesliHarfler(arr4)
    println(sesliHarfler)

    println("0'dan verilen sayıya kadar olan asal sayılar:")
    val asallist = asalSayi(23)
    println(asallist)

    println("Verilen bir metindeki kelime sayısı:")
    val metin = " metin 1 2 3 kelime "
    val kelimeSayisi = kelimeSayisi(metin)
    println(kelimeSayisi)

    println("Bir metinde en çok tekrar eden kelime:")
    val metin1 = " aa ddd dd aa fff ff fdf ff ff ff aa bb aa aa "
    val kelime = tekrarEdenKelime(metin1)
    println(kelime)

    println("Dizelerin birleşimi:")
    val dize1 = " aa bb cc "
    val dize2 = " dd ee ff "
    val birlesim = dizeBirlestir(dize1, dize2)
    println(birlesim)

    println("Bir liste ve set arasındaki fark:")
    val liste = listOf("aa", "bb", "cc", "dd", 5)
    val set = setOf("aa", 1, 2, 3, 4)
    val fark = listSetFarki(liste,set)
    println(fark)
}

//1.Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu
// yazın.

fun ciftList(dizi: Array<Int>): List<Int>{
    val ciftSayilar  = mutableListOf<Int>()

    for (it in dizi ){
        if (it % 2 == 0){
            ciftSayilar.add(it)
        }
    }

    return ciftSayilar
}

//2.Verilen bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan ve sonuçları
//bir harita(Map) olarak döndüren bir fonksiyon yazın.

fun harfMap(dizi: Array<String>): Map<Char, Int>{
    val harfSayisi = mutableMapOf<Char, Int>()

    for (kelime in dizi) {
        for (harf in kelime) {
            val harf1 = harf.lowercaseChar()
            if (harf1 in harfSayisi) {
                harfSayisi[harf1] = harfSayisi[harf1]!! + 1
            } else {
                harfSayisi[harf1] = 1
            }
        }
    }

    return  harfSayisi
}

//3.Verilen bir listenin elemanlarını tersine çeviren ve bu ters çevrilmiş listeyi
//döndüren bir fonksiyon yazın.

fun reverseList(list: List<Any>): List<Any>{
    val reversedList = mutableListOf<Any>()

    for(i in 0..< list.size){
        reversedList.add(list[(list.size) - 1 - i])
    }

    return reversedList
}

//4. Belirli bir aralıktaki tüm tek sayıları içeren bir dizi oluşturan bir fonksiyon yazın.
//Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır.

fun tekSayilar(baslangic: Int, bitis: Int): Array<Int> {
    val dizi = mutableListOf<Int>()

    if (bitis >= baslangic) {
        for (sayi in baslangic..bitis) {
            if (sayi % 2 != 0) {
                dizi.add(sayi)
            }
        }
    }
    else{
        println("Bitiş değeri başlangıç değerinden büyük olamaz!")
    }

    return dizi.toTypedArray()
}

//5.Verilen bir dizideki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir
//fonksiyon yazın. (Sesli harfler: a, e, i, o, u)

fun sesliHarfler(dizi: Array<String>): Int{
    val sesliHarfler = listOf('a','e','i','o','u')
    var toplam = 0

    for (kelime in dizi) {
        for (harf in kelime) {
            val harf1 = harf.lowercaseChar()
            if (harf1 in sesliHarfler) {
                toplam ++
            }
        }
    }

    return  toplam
}

//6.Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon
//yazın.

fun asalSayi(sayi: Int): List<Int>{
    val asalSayilar = mutableListOf<Int>()

    for(num in 2..sayi){
        var asalMi = 1
        for (i in 2..num/2) {
            if (num % i == 0) {
                asalMi = 0
                break
            }
        }
        if (asalMi == 1){
            asalSayilar.add(num)
        }
    }

    return asalSayilar
}

//7.Verilen bir dizideki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon
//yazın.

fun kelimeSayisi(metin: String): Int{
    val kelimeler = metin.split("\\s+".toRegex())
    var toplam = 0

    for(kelime in kelimeler){
        if(kelime.isNotBlank()){
            toplam ++
        }
    }

    return toplam
}

//8.Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir
//fonksiyon yazın.

fun tekrarEdenKelime(metin: String): String{
    val kelimeler = metin.split("\\s+".toRegex())
    val kelimeSayilari = mutableMapOf<String, Int>()

    for(kelime in kelimeler){
        if (kelime in kelimeSayilari) {
            kelimeSayilari[kelime] = kelimeSayilari[kelime]!! + 1
        } else {
            kelimeSayilari[kelime] = 1
        }
    }

    var enCokTekrarEdenKelime:String =" "
    var enCokTekrarEdenKelimeSayisi = 0

    for((kelime, sayi) in kelimeSayilari){
        if(sayi > enCokTekrarEdenKelimeSayisi){
            enCokTekrarEdenKelimeSayisi = sayi
            enCokTekrarEdenKelime = kelime
        }
    }

    return enCokTekrarEdenKelime
}

//9.İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon yazın. Ancak, birleştirilen
//dize birbiriyle aynı harf sayısına sahipse, bu dizeyi büyük harflerle
//birleştirmelisiniz.

fun dizeBirlestir(dize1: String, dize2: String): String{
    val metin1 = dize1.trim(' ')
    val metin2 = dize2.trim(' ')
    var birlesim = " "

    if(metin1.length == metin2.length){
        birlesim = dize1 + " " + dize2.uppercase()
    }
    else{
        birlesim = dize1 + " " + dize2
    }

    return birlesim
}

//10.Bir liste ve bir set arasındaki farkı döndüren bir fonksiyon yazın. Yani, liste içinde
//bulunan ancak sette bulunmayan öğeleri bulun.

fun listSetFarki(list: List<Any>, set: Set<Any>): List<Any>{
    val fark = mutableListOf<Any>()

    for(it in list){
        var ayni = 0
        for (item in set){
            if(it == item){
                ayni = 1
                break
            }
        }
        if(ayni == 0){
            fark.add(it)
        }
    }

    return fark
}