fun main() {

    //1. soru
    val ciftsayi = mutableListOf<IntRange>()

    for (ciftsayi in 1..10) {
        if (ciftsayi % 2 == 0) {
            println(ciftsayi)
        }
    }

    //2. soru
    val dizii = "bugün hava çok güneşli"
    val harfSayisi = tekrarEdenHarf(dizii)

    println("dizideki harf sayıları: $harfSayisi")

    //3. soru
    val liste = listOf(1, 2, 3, 4, 5)
    val tersListe = tersCevir(liste)

    println(tersListe)

    //4. soru
    println("İlk ve Son Sayıyı Girin:")
    val ilkSayi = readLine()!!.toInt()
    val sonSayi = readLine()!!.toInt()
    val tekSayilar = teksayidiziolusturma(ilkSayi, sonSayi)

    println("tek sayılar: $tekSayilar")

    //5. soru
    val dizi = "bugün hava çok güzel, BUGÜN HAVA ÇOK GÜZEL"
    val sesliHarfSayısı = sesliharfhesapla(dizi)

    println("Sesli Harf Sayısı: $sesliHarfSayısı")

    //6. soru


    //7. soru
    val dizi7 = "bugün hava çok güzel"
    val kelimeSayisi = kelimeSayisiHesaplama(dizi7)
    println("dizideki kelime sayısı: $kelimeSayisi")

    //8. soru

    //9. soru
    val dizi1 = "Maide"
    val dizi2 = "Beyza"
    val birlestirilmis = ikidizibirlestirme(dizi1, dizi2)

    println("Birleştirilmiş dizi: $birlestirilmis")

    //10. soru
    val dizi101 = listOf(1,2,3,4,5)
    val dizi102 = setOf(4,5,6,7,8,9)
    val fark = dizi101.subtract(dizi102)

    println("liste içinde olan ama sette bulunmayan öğeler: $fark")




}





