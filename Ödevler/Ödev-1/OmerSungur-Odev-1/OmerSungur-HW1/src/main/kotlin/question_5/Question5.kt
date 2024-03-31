package question_5

fun main() {
    val userInput = arrayOf("Omer", "Mehmet", "Ahmet", "Hakan", "Eda", "Gizem", "Utku")
    println(calculateTheNumberOfVowels(userInput)) // {o=1, e=6, a=4, i=1, u=2}
}

/**
 * calculateTheNumberOfVowels function takes one parameter which type is Array<String>. This parameter represents user input.
 * This function returns Map<Char,Int>
 * The map which named is numberOfVowel represents the result. This tells us how many vowels there are.
 * We look at each word with the forEach function.
 * After changing all letters to lowercase we group the vowels of this word with the groupBy function.
 * If the character is equals a, e, i, o or u then we assign it to the numberOfVowel.
 */
fun calculateTheNumberOfVowels(wordList: Array<String>): Map<Char, Int> {
    val numberOfVowel = mutableMapOf<Char, Int>()

    wordList.forEach { word ->
        word.lowercase().groupBy { character ->
            when (character) {
                'a', 'e', 'i', 'o', 'u' -> {
                    numberOfVowel[character] = numberOfVowel[character]?.plus(1) ?: 1
                }
            }
        }
    }
    return numberOfVowel
}