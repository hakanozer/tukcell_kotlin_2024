
fun main() {
    val dizi = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ,11 ,12 ,13 , 14)
    val ciftler = ciftSayilariBul(dizi)
    println("Dizideki çift sayılar: $ciftler")

}


fun ciftSayilariBul(dizi: List<Int>): List<Int> {
    val ciftSayilar = mutableListOf<Int>()
    for (sayi in dizi) {
        if (sayi % 2 == 0) {
            ciftSayilar.add(sayi)
        }
    }
    return ciftSayilar
}

