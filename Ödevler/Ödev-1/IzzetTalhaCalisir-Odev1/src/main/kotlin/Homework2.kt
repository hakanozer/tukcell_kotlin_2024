package org.example

fun findWordFrequencies(array: List<Char>): Map<Char, Int> {
    val frequency = mutableMapOf<Char, Int>()

    for (word in array) {
        if (frequency.containsKey(word)) {
            frequency[word] = frequency[word]!! + 1
        } else {
            frequency[word] = 1
        }
    }

    return frequency
}