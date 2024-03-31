fun main() {
    val list = listOf(1,2,3,4,5)
    val set = setOf(3,5)
    val result = difference(list,set)
    println(result)

}

fun difference(list: List<Int>, set: Set<Int>): List<Int> {

    val dNumbers = mutableListOf<Int>()

    for (index in list) {

        if (!set.contains(index)) {
            dNumbers.add(index)
        }

    }
    return dNumbers
}