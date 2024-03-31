//2. soru
fun tekrarEdenHarf(dizii: String): Map<Char,Int> {
    val harfSayisi = mutableMapOf<Char, Int>()
    for (i in dizii) {
        if (i.isLetterOrDigit()) {
            val sayi = harfSayisi.getOrDefault(i,0)
            harfSayisi[i] = sayi +1
        }
    }
    return harfSayisi
}

//3. soru
fun tersCevir(liste: List<Any>): List<Any> {
    return liste.reversed()
}

//4. soru
fun teksayidiziolusturma(ilkSayi: Int, sonSayi: Int) :List<Int>{
    val tekSayi = mutableListOf<Int>()
    for (i in ilkSayi..sonSayi){
        if (i %2 != 0) {
            tekSayi.add(i)
        }
    }
    return tekSayi
}

//5. soru
fun sesliharfhesapla(dizi: String):Int {
    val sesliharfler = mutableSetOf('a', 'e', 'ı', 'i', 'o', 'ö', 'u', 'ü', 'A', 'E', 'I','İ','O','Ö','U','Ü' )
    var sesliharfsayisi = 0 //var kullanma sebebi sürekli artacak olan bir değer olduğu için

    for (i in dizi) {
        if (i in sesliharfler) {
            sesliharfsayisi ++
        }
    }
    return sesliharfsayisi
}

//7.soru
fun kelimeSayisiHesaplama(dizi7: String): Int{
    var kelimeSayisi = 0
    var kelime = true

    for (karakter in dizi7) {
        if (karakter.isLetterOrDigit() && kelime) {
            kelimeSayisi++
            kelime = false
        } else if (!karakter.isLetterOrDigit()) {
            kelime = true
        }
    }
    return kelimeSayisi
}

//9. soru
fun ikidizibirlestirme(dizi1: String, dizi2: String): String{
    return if(dizi1.length==dizi2.length){
        dizi1.toUpperCase()+dizi2.toUpperCase()
    } else {
        dizi1 + dizi2
    }

}

