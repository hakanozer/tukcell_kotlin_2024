package question_2

fun main() {
    val userInput = arrayOf("Omer", "Mehmet", "Ahmet", "Hakan", "Eda", "Gizem")
    println(findNumbersOfLetters(userInput)) // {o=1, m=5, e=6, r=1, h=3, t=2, a=4, k=1, n=1, d=1, g=1, i=1, z=1}
}

/**
 * findNumberOfLetters function takes one parameter which type is Array<String>. This parameter represents user input.
 * This function returns Map<Char,Int>
 * The map which named is lettersAndTheirNumber represents the result. It tells us how many of each letter there are.
 * We look at each word with the forEach function. If the word is not blank, do these:
 * After changing all letters to lowercase we look at every character of this word with the forEach function.
 * We accept whatever letter is on it as a key and give the value as 0 by default.
 * We increase this value by 1 in each cycle. This is how we can find how many letters there are when we exit the loop.
 */
fun findNumbersOfLetters(wordList: Array<String>): Map<Char, Int> {
    val lettersAndTheirNumber = mutableMapOf<Char, Int>()

    wordList.forEach { word ->
        if (word.isNotBlank()) {
            word.lowercase().forEach { character ->
                lettersAndTheirNumber[character] = lettersAndTheirNumber.getOrDefault(character, 0) + 1
            }
        }
    }
    return lettersAndTheirNumber
}

/**
 * Second way for this problem:
 * lettersAndTheirNumber[character] = lettersAndTheirNumber[character]?.plus(1) ?: 1
 */


