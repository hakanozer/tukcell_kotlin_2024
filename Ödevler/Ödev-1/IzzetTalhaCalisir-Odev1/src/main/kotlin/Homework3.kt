package org.example

fun <T> turnOver(addedList: List<T>): List<T> {
    val turneds = mutableListOf<T>()
    for (i in addedList.size - 1 downTo 0) {
        turneds.add(addedList[i])
    }
    return turneds
}