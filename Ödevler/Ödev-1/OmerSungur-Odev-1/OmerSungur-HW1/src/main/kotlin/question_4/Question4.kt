package question_4

fun main() {
    val userInput = 10..40
    findOddNumbers(userInput) // [11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39]
}

/**
 * findOddNumbers function takes one parameter which type is IntRange. This parameter represents user input.
 * The variable oddNumbers represents the result of odd numbers.
 * We look at each element with the for loop
 * If the number is not divisible by two without a remainder, it is odd.
 */
fun findOddNumbers(numberRange: IntRange) {
    val oddNumbers = arrayListOf<Int>()

    for (i in numberRange) {
        if (i % 2 != 0) {
            oddNumbers.add(i)
        }
    }
    println(oddNumbers)
}