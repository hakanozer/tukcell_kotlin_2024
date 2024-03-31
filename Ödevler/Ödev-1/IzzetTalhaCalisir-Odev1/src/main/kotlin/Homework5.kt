package org.example

fun countVowelWordNumber(array: List<Char>): Int {
    val vowelWords = listOf('a', 'e', 'i', 'o', 'u')
    var vowelWordsNumber = 0

    for (character in array) {
        if (character in vowelWords || character.toLowerCase() in vowelWords) {
            vowelWordsNumber++
        }
    }

    return vowelWordsNumber
}