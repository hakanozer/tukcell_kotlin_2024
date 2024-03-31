/// Soru 9
import java.util.*

fun main() {
    val word1 = "Eray"
    val word2 = "Altilar"
    val combinedWord = wordCombiner(word1, word2)
    println("Birleştirilmiş dize: $combinedWord")
}

fun wordCombiner(word1: String, word2: String): String {
    /// eger kelimeler birbirinin ayni boyutunda ise hepsini buyuk harf yapip birlestiriyorum
    return if (word1.length == word2.length) {
        word1.uppercase(Locale.getDefault()) + word2.uppercase(Locale.getDefault())
    } else {
        word1 + word2
    }
}