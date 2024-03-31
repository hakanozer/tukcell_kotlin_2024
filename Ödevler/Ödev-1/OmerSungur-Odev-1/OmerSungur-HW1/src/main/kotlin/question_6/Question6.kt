package question_6

fun main() {
    val userInput = -50..50
    findPrimeNumbers(userInput) // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
}

/**
 * checkPrimeNumber function takes one parameter which type is Int.
 * This parameter represents the integer number coming from the findPrimeNumbers function.
 * This function returns a boolean value. If the boolean value is true then the number is prime number.
 * divider value checks whether the number given as a parameter is fully divisible within a range. The range is from two to number - 1.
 * If the number is less than two, we return false.
 */
fun checkPrimeNumber(number: Int): Boolean {
    var divider = 2

    if (number < 2) {
        return false
    }

    while (divider < number) {
        if (number % divider == 0) {
            return false
        }
        divider++
    }
    return true
}

/**
 * findPrimeNumbers function takes one parameter which type is IntRange. This parameter represents user input.
 * The variable primeNumbers represents the result of prime numbers
 * With the forEach function, we get all value of this list and pass a parameter for checkPrimeNumber function. If the boolean value
 * is true then add that number in primeNumbers variable.
 */
fun findPrimeNumbers(numberList: IntRange) {
    val primeNumbers = mutableListOf<Int>()

    numberList.forEach { value ->
        if (checkPrimeNumber(value)) {
            primeNumbers.add(value)
        }
    }
    println(primeNumbers)
}