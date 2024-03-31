fun main() {
    val limitValue = 50

    println(createPrimeNumberList(limitValue))
}

//Prime numbers are natural numbers that are divisible by only 1 and the number itself
fun createPrimeNumberList(limitValue: Int) : MutableList<Int>{
    val primeNumberList = mutableListOf<Int>()

    // Prime numbers start with the number 2
    // For a number to be prime, it must have two divisors so 1 is not a prime number.
    for (value in 2..limitValue) { // 1 2 3 4 5 6 7 8 9
        var isPrime = true
        for (num in 2..< value) {
            if (value % num  == 0 ){
                isPrime = false
                break
            }
//            println(value)
        }
//        println(value)
        // Thanks to the isPrime variable, we can add to the list just prime numbers.
        if (isPrime) {
            primeNumberList.add(value)
        }
    }
    return primeNumberList
}
