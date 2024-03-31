package question_3

fun main() {
    val userInput = listOf(3, 5, 7, 11, 1, 2, 2)
    println(reverseTheList(userInput)) // [2, 2, 1, 11, 7, 5, 3]
    val userInput2 = listOf("Ali", "Veli", "Omer")
    println(reverseTheList(userInput2)) // [Omer, Veli, Ali]
}

/**
 * reverseTheList function takes one parameter which type is Array<Any>. This parameter represents user input.
 * The variable reversedList represents the result of new list which is reversed.
 * With the for loop, we move from the index of the last element to the index of
 * the first element and add each element to the reversedList.
 */
fun reverseTheList(list: List<Any>): List<Any> {
    val reversedList = mutableListOf<Any>()

    for (i in list.lastIndex.downTo(list.indices.first)) {
        reversedList.add(list[i])
    }
    return reversedList
}

/**
 * Easy way: list.reversed()
 */