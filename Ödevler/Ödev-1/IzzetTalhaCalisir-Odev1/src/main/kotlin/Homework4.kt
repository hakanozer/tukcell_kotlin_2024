package org.example

fun createSingleNumberArray(start: Int, finish: Int): List<Int> {
    val singleNumbers = mutableListOf<Int>()
    var current = if (start % 2 == 0) start + 1 else start

    while (current <= finish) {
        singleNumbers.add(current)
        current += 2
    }

    return singleNumbers
}