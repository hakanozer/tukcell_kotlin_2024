fun asalSayilariBul(n: Int): List<Int> {
    val asalSayilar = mutableListOf<Int>()

    for (sayi in 2..n) {
        var asalMi = true
        for (i in 2 until sayi) {
            if (sayi % i == 0) {
                asalMi = false
                break
            }
        }
        if (asalMi) {
            asalSayilar.add(sayi)
        }
    }

    return asalSayilar
}

fun main() {
    val n = 50
    val asalListe = asalSayilariBul(n)
    println("1-$n arasındaki asal sayılar:")
    println(asalListe)
}
