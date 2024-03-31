/// Soru 8
fun main() {
    val list = listOf("Eray", "Altilar", "Ahmet", "Veli" , "Eray" , "Patates","Domates" , "Eray" , "Domates")
    val frequentWord = frequentWordFinder(list)
    println("En sık tekrar edilen kelime: $frequentWord")
}

fun frequentWordFinder(list: List<String>): String? {
    val frequency = mutableMapOf<String, Int>()

    /// Her kelimenin frekansını hesapla
    for (word in list) {
        frequency[word] = frequency.getOrDefault(word, 0) + 1
    }

    var popularWord: String? = null
    var highestFrequency = 0

    /// En yüksek frekansa sahip kelimeyi bul
    for ((word, frekans) in frequency) {
        if (frekans > highestFrequency) {
            highestFrequency = frekans
            popularWord = word
        }
    }

    return popularWord
}

