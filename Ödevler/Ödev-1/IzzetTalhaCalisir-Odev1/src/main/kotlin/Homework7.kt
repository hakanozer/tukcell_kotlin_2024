package org.example

fun countWordNumber(array: List<String>): Int {
    var wordNumber = 0

    for (word in array) {
        if (word.isNotEmpty()) {
            wordNumber++
        }
    }

    return wordNumber
}