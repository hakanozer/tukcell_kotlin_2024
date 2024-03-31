fun main() {
    val array = arrayOf("Bengisu Sahin","kotlin","Akdeniz Üniversitesi","Antalya","aaa")

    println("The number of words in a given string: ${calculateWordCount(array)}")
}

fun calculateWordCount(array: Array<String>) : Int{
    var count = 0
    // Firstly we check every string and then check the count of words in strings.
    array.forEach {
        // We split the string into word lists with separators as spaces or multiple spaces.
        val wordList = it.trim().split("\\s+".toRegex())
        count += wordList.size
    }

    return count
}
