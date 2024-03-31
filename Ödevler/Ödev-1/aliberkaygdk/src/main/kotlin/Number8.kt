fun main() {
    val list = listOf("araba", "ev", "kalem", "ev", "araba")
    val result = mostRepetition(list)
    println(result)
}

fun mostRepetition(array: List<String>): String {
    val rMap = mutableMapOf<String, Int>()


    for (index in array) {
        rMap[index] = rMap.getOrDefault(index, 0) + 1
    }

    var wMost = ""
    var rCount = 0

    for ((word, repeat) in rMap) {
        if (repeat > rCount) {
            wMost = word
            rCount = repeat
        }
    }


    return wMost
}