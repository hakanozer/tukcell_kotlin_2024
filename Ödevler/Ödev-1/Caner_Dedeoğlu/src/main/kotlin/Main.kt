fun main() {

    // 1.soru

    val dizi = mutableListOf<Int>(5,7,9,2,18,36,4,1,6,41)

    val cift = math().evenNumbers(dizi)

    println(cift)

    // 2. Soru
    val list = mutableListOf("Ayşe", "Ahmet", "Hatice", "Caner")

    val result = string().letter_again(list)
    println(result)

    // 3.soru

    val liste = arrayListOf(15,20,30,40,50)
    val string = arrayListOf("Ahmet", "Ayşe", "İbrahim", "Aslan")
    val ters = math().tersListe(liste)
    val ters_string = string().tersListe(string)
    println(ters)
    println(ters_string)

    // 4. soru

    val basla = 1
    val bit = 90
    val tek_sayılar = math().odd_numbers(basla,bit)
    println(tek_sayılar)

    // 5.soru

    val random = mutableListOf("Ahmet","Kotlin","Java","Android","Bootcamp")
    val sesli_harf = string().vowel(random)
    println(sesli_harf)

    // 6.soru

    val bitis = 70
    val asal_sayılar = math().prime_numbers(bitis)
    println(asal_sayılar)

    //7.soru

    val dizi2 = arrayListOf("merhaba","kotlin","bu","bir","basit","bir","dizidir")
    val kelime_sayısı = string().words(dizi2)
    println(kelime_sayısı)

    // 8.soru

    val dizi3 = arrayListOf("merhaba","kotlin","bu","bir","basit","bir","dizidir")

    val tekrar = string().repetitive(dizi3)
    println(tekrar)

    // 9.soru

    val string1 = "caner dedeoğlu"
    val string2 = "caner dedeoğlu"

    val sonuc = string().birlestirme(string1,string2)
    println(sonuc)


    // 10.soru

    val listeler = listOf("elma", "armut", "muz", "kiraz")
    val set = mutableSetOf("muz", "kiraz", "elma")

    val farkı = string().different(listeler,set)

    println(farkı)


}