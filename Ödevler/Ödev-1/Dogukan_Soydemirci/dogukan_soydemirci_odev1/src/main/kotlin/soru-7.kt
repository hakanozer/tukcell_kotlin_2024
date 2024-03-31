fun kelimeSayihesapla(dizi: String): Int {
    var kelimeSayisi = 0
    var kelimebaslangic  = false

    for (karakter in dizi) {
        if (karakter.isLetterOrDigit()) {
            if (!kelimebaslangic ) {
                kelimeSayisi++
                kelimebaslangic  = true
            }
        } else {
            kelimebaslangic = false
        }
    }

    return kelimeSayisi
}

fun main() {
    val deneDizi = "Deneme bir iki uc"
    val kelimeSayisi = kelimeSayihesapla(deneDizi)
    println("Kelime sayısı: $kelimeSayisi")
}
