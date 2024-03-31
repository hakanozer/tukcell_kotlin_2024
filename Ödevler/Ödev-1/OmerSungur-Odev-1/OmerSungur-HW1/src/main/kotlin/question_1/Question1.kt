package question_1

fun main() {
    val userInput = arrayOf(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    findEvenNumbers(userInput) // [-2, 0, 2, 4, 6, 8, 10]
}

/**
 * findEvenNumbers function takes one parameter which type is Array. This parameter represents user input.
 * The variable evenNumbers represents the result of even numbers.
 * We look at each array element with the forEach function.
 * It is an even number if this element is divisible by two without a remainder, add in evenNumbers list.
 */
fun findEvenNumbers(numberList: Array<Int>) {
    val evenNumbers = mutableListOf<Int>()
    numberList.forEach {
        if (it % 2 == 0) {
            evenNumbers.add(it)
        }
    }
    println(evenNumbers)
}