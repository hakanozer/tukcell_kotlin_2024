package question_7

fun main() {
    val userInput = arrayOf("Hello, I am Ömer Sungur", "How is it going?", "I hope everything is going great.")
    println(calculateWordNumber(userInput)) // 15
}

/**
 * calculateWordNumber function takes one parameter which type is Array<String>. This parameter represents user input.
 * This function returns Int, and this value represents numbers of words.
 * With forEach function, we get all element of this wordList value.
 * We separate each word within an element by a space character.
 * When we add up these separated elements, we find how many words there are.
 */
fun calculateWordNumber(wordList: Array<String>): Int {
    var numberOfWords = 0

    wordList.forEach { element ->
        val word = element.split(" ")
        numberOfWords += word.size

    }
    return numberOfWords
}