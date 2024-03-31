package org.example

fun <T> listSetDifference(list: List<T>, set: Set<T>): List<T> {
    val difference = mutableListOf<T>()

    for (i in list) {
        if (!set.contains(i)) {
            difference.add(i)
        }
    }

    return difference
}