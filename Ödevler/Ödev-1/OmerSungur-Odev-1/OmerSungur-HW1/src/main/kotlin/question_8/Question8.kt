package question_8

fun main() {
    val userInput = arrayOf("Omer", "Mehmet", "Ahmet", "Utku", "Hakan", "Eda", "Gizem", "Utku", "Utku", "Omer")
    findMostCommonWord(userInput) // Utku=3
}

/**
 * findMostCommonWord function takes one parameter which type is Array<String>. This parameter represents user input.
 * This function returns Map.Entry<String, Int>?, and this value represents most common word, and it's number.
 * allWords variable represents how many of each word there are.
 * With forEach function, we get all element of this wordList value.
 * When we find the same word, we obtain a map structure by increasing its value by one.
 * Finally, we returned the one with the highest map value.
 */
fun findMostCommonWord(wordList: Array<String>): Map.Entry<String, Int>? {
    val allWords = mutableMapOf<String, Int>()

    wordList.groupBy { word ->
        allWords[word] = allWords[word]?.plus(1) ?: 1
    }
    return allWords.maxByOrNull { it.value }
}