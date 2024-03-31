fun encoktekrarfonk(dizi: List<String>): String {

    val kelimeSayilari = HashMap<String, Int>()


    for (kelime in dizi) {
        if (kelimeSayilari.containsKey(kelime)) {

            kelimeSayilari[kelime] = kelimeSayilari.getValue(kelime) + 1
        } else {

            kelimeSayilari[kelime] = 1
        }
    }


    var maxTekrarEdenKelime = ""
    var maxTekrarSayisi = 0
    for ((kelime, sayi) in kelimeSayilari) {
        if (sayi > maxTekrarSayisi) {
            maxTekrarEdenKelime = kelime
            maxTekrarSayisi = sayi
        }
    }

    return maxTekrarEdenKelime
}

fun main() {
    val dizi = listOf("dene", "dene", "hey", "hey", "dene", "insan", "haber")
    val maxTekrarEdenKelime = encoktekrarfonk(dizi)
    println("En fazla tekrar eden kelime: $maxTekrarEdenKelime")
}
