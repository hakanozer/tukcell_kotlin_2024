import java.util.*

/// Soru 5
fun main() {
    val list = listOf("Eray", "Altilar", "Ahmet", "Veli" )
    val result = vowelFinder(list)
    println("Verilen dizideki sesli harf sayısı: $result")
}

fun vowelFinder(list: List<String>): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var count = 0

    for (word in list) {
        for (letter in word.lowercase(Locale.getDefault())) {
            if (letter in vowels) {
                count++
            }
        }
    }

    return count
}

