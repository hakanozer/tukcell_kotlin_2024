package org.example

fun findPrimeNumbers(n: Int): List<Int> {
    val primeList = mutableListOf<Int>()

    for (number in 2 until n) {
        var isPrime = true
        for (i in 2 until number) {
            if (number % i == 0) {
                isPrime = false
                break
            }
        }
        if (isPrime) {
            primeList.add(number)
        }
    }

    return primeList
}