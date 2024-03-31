fun main() {
    val array = arrayOf("Bengisu Sahin","Sahin","Sahin","kotlin","kotlin","kotlin","Akdeniz Üniversitesi","Antalya","Akdeniz")

    println("The most frequently occurring word in a given string: ${findFrequentWord(array)}")
}

fun findFrequentWord(array: Array<String>) : String{
    var freqWord = ""
    var maxCount = 0
    val wordCounts = mutableMapOf<String, Int>()

    // Firstly we check every string and then check the count of words in strings.
    for (string in array) {
        // We split the string into word lists with separators as spaces or multiple spaces.
        val wordList = string.trim().split("\\s+".toRegex())
        for (word in wordList){
            val count = wordCounts.getOrDefault(word, 0) + 1
            wordCounts[word] = count
            //println(word)
            //println("${word}-${wordCounts[word]}")

            // If there is an equal count of words one more than then the first one is the frequent word.
            if (count > maxCount){
                maxCount = count
                freqWord = word
            }
        }
    }

    return freqWord
}
