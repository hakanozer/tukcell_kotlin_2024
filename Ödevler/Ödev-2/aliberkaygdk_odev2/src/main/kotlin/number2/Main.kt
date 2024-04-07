package number2

fun main() {

    val n1 = Student("ali", 19, listOf("ingilizce", "matematik"))
    val n2 = Student("osman", 20, listOf("coğrafya", "türkçe"))
    val n3 = Student("salih", 21, listOf("tarih", "biyoloji", "beden eğitimi"))

    val ogrenciler = listOf(n1, n2, n3)

    dersListesi(ogrenciler)
    enCokDersliOgr(ogrenciler)

}

fun dersListesi(list: List<Student>) {

    for (ogrenci in list) {
        println("${ogrenci.ad} = ${ogrenci.dersler}")

    }
}

fun enCokDersliOgr(list: List<Student>) {

    val ogrenci = list.maxByOrNull { it.dersler.size }?.ad

    println("En yüksek ders sayısına sahip öğrenci: $ogrenci ")

}

