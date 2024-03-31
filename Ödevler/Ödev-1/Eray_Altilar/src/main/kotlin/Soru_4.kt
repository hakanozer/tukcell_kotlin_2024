/// Soru 4
fun main() {
    /// kullanicinin girdigini varsaydigimiz degerler
    val start = 20
    val final = 99

    val oddNumberList = OddNumberFinder(start, final)

    println("Dizideki tek sayılar: ${oddNumberList.joinToString(", ")}")
}

fun OddNumberFinder(start: Int, final: Int): List<Int> {

    val oddNums = mutableListOf<Int>()

    for (num in start..final) {
        if (num % 2 != 0) {
            oddNums.add(num)
        }
    }

    return oddNums
}
