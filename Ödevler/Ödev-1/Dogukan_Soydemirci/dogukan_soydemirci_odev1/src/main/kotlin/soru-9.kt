fun dizibirlestirmefonk(dize1: String, dize2: String): String {

    val keluzunluk1 = dize1.length
    val keluzunluk2 = dize2.length


    if (keluzunluk1 == keluzunluk2) {

        return dize1.toUpperCase() + dize2.toUpperCase()
    } else {

        return dize1 + dize2
    }
}

fun main() {
    val dizi1 = "deneme"
    val dizi2 = "biriki"
    val birlesikdizi = dizibirlestirmefonk(dizi1, dizi2)
    println("Birleştirilmiş Dize: $birlesikdizi")
}
