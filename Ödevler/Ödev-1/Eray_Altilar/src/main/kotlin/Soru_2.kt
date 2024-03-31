/// Soru 2
import java.util.*


fun main() {
    val names = listOf("Eray", "Altilar", "Ahmet", "Veli" )

    val repeatingLetters = repeatingLetterFinder(names)

    //print(repeatingLetters)
    /// Map'in icerisindeki harfleri duzgun sekilde yazdiralim
    println("Listedeki harfler: ")

    for ((letter, repeat) in repeatingLetters) {
        print("$letter:$repeat ")
    }
}
fun repeatingLetterFinder(names: List<String>): Map<Char, Int> {
    val repeat = mutableMapOf<Char, Int>()

    for (name in names) {
        /// toLowerCase fonksiyonunu kullanarak bütün harfleri eşit değerlendirmeyi sağlıyoruz.
        val lowerCaseName = name.lowercase(Locale.getDefault())
        for (letter in lowerCaseName) {
            repeat[letter] = repeat.getOrDefault(letter, 0) + 1
        }
    }

    return repeat
}
