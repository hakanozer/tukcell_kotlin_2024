fun tekrarsayiHesapla(dizi: Array<Char>): Map<Char, Int> {
    val tekrarsayi = mutableMapOf<Char, Int>()

    for (harf in dizi) {
        if (tekrarsayi.containsKey(harf)) {

            val mevcutFrekans = tekrarsayi[harf] ?: 0
            tekrarsayi[harf] = mevcutFrekans + 1
        } else {

            tekrarsayi[harf] = 1
        }
    }

    return tekrarsayi
}

fun main() {
    val dizi = arrayOf('a', 'b', 'c', 'a', 'b', 'c', 'a', 'b', 'c', 'd')
    val tekrarsayi = tekrarsayiHesapla(dizi)


    for ((harf, frekans) in tekrarsayi) {
        println("$harf : $frekans")
    }
}
