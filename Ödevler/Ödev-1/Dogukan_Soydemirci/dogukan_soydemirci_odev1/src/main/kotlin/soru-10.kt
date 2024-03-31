fun <T> fark(liste: List<T>, set: Set<T>): List<T> {
    val farklist = mutableListOf<T>()

    for (eleman in liste) {
        if (eleman !in set) {
            farklist.add(eleman)
        }
    }

    return farklist
}

fun main() {
    val liste = listOf(1, 3,5,7,9,11)
    val set = setOf(8, 6, 1, 3, 7)

    val fark = fark(liste, set)
    println("Fark: $fark")
}
