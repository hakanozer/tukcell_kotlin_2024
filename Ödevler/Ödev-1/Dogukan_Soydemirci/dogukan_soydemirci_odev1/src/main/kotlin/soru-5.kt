fun sesliHarfHesapla(dizi: CharArray): Int {
    val sesliHarfler = setOf('a', 'e', 'i', 'o', 'u')
    var sesliHarfSayisi = 0

    for (harf in dizi) {
        if (harf.toLowerCase() in sesliHarfler) {
            sesliHarfSayisi++
        }
    }

    return sesliHarfSayisi
}

fun main() {
    val dizi = charArrayOf('d', 'e', 'n', 'e', 'm', 'e', 'h', 'e', 'y', 'i')
    val sonuc = sesliHarfHesapla(dizi)
    println("Sesli harf sayısı: $sonuc")
}