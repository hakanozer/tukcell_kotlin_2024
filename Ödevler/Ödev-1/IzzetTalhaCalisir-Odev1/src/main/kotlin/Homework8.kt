package org.example

fun findMostRepeated(array: List<String>): String? {
    val wordfrq = mutableMapOf<String, Int>()

    for (word in array) {
        wordfrq[word] = wordfrq.getOrDefault(word, 0) + 1
    }

    var mostRepeatedWord: String? = null
    var mostFreq = 0

    for ((words, frequency) in wordfrq) {
        if (frequency > mostFreq) {
            mostRepeatedWord = words
            mostFreq = frequency
        }
    }

    return mostRepeatedWord
}
