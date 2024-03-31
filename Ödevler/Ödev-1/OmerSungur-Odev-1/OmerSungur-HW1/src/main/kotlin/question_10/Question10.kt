package question_10

fun main() {
    val list = listOf(1, 2, 3, 4, "A", "B", 1, 1)
    val set = setOf(1, 2, "B")
    findDiffBetweenListAndSet(list, set) // [3, 4, A, 1, 1]
}

/**
 * findDiffBetweenListAndSet function takes two parameters which type are List<Any> and Set<Any. These parameters represent user input.
 * mutableList variable represents result of difference between list and set.
 * With forEach function, we get all set elements, and we remove each of them in the mutableList variable.
 * That's how we can get the difference between list and set elements.
 */
fun findDiffBetweenListAndSet(list: List<Any>, set: Set<Any>) {
    val mutableList = list.toMutableList()

    set.forEach { element ->
        mutableList.remove(element)
    }
    println(mutableList)
}
