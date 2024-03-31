package org.example

fun findDoubleNumbers(array: List<Int>): List<Int> {
    val doubleNumbers = mutableListOf<Int>()

    for (number in array) {
        if (number % 2 == 0) {
            doubleNumbers.add(number)
        }
    }
    return doubleNumbers
}