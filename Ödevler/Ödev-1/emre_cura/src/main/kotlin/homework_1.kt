import java.util.*

fun main() {

}

// 1. soru
fun findEvenNumbers(list: MutableList<Int>, newList: MutableList<Int>){
    list.forEach {
        if (it % 2 == 0){
            newList.add(it)
        }
    }
}

// 2. soru
fun numberOfLetter(list: MutableList<String>, map: MutableMap<Char, Int>){
    // büyük küçük harfleri aynı harf olarak algılaması ve boşlukları saymaması için
    list.forEach {
    val newStr = it.lowercase().replace("\\s".toRegex(), "")
    newStr.forEach {
        if (!map.containsKey(it)) {
            map.put(it, 1)
        }
        else{
            map.put(it,map.get(it)!!+1)
        }
    }
    }
}

// 3. soru
fun reversOfList(list: MutableList<Any>) : MutableList<Any> {
    val reversedList = mutableListOf<Any>()
    for (i in list.indices.reversed()) {
        reversedList.add(list[i])
    }
    return reversedList
}

// 4. soru
fun findOddNumber(from: Int, to: Int, list: MutableList<Int>){
    for (item in from..to){
        if (item % 2 == 1){
            list.add(item)
        }
    }
}

// 5. soru
fun numberOfVowel(list: MutableList<String>): Int {
    var count = 0
    val vowels = "aeiou"
    list.forEach { str ->
        val newStr = str.lowercase().replace("\\s".toRegex(), "")
        newStr.forEach { char ->
            if (char in vowels) {
                count++
            }
        }
    }
    return count
}
// 6. soru
fun isPrime (number: Int) : Boolean {
    for (num in 2..<number){
        if (number % num == 0){
            return false
        }
    }
    return true
}

fun findPrimeNumbers(number: Int) : MutableList<Int>{
    val list = mutableListOf<Int>()
    for (num in 2..number){
        if (isPrime(num)){
            list.add(num)
        }
    }
    return list
}

// 7. soru
fun countWords(strings: List<String>): Int {
    var wordCount = 0
    strings.forEach { string ->
        val words = string.split("\\s+".toRegex())
        wordCount += words.size
    }
    return wordCount
}

// 8. soru
fun mostRepeatedWord(strings: List<String>): String {
    val wordCountMap = mutableMapOf<String, Int>()

    strings.forEach { string ->
        val words = string.split("\\s+".toRegex())
        words.forEach { word ->
            val currentCount = wordCountMap.getOrDefault(word, 0)
            wordCountMap[word] = currentCount + 1
        }
    }

    var mostRepeatedWord = ""
    var maxCount = 0
    wordCountMap.forEach { (word, count) ->
        if (count > maxCount) {
            maxCount = count
            mostRepeatedWord = word
        }
    }

    return mostRepeatedWord
}

// 9. soru
fun mergeString(string: String, string2: String): String {
    val stringLetters = string.replace("\\s".toRegex(),"")
    val string2Letters = string2.replace("\\s".toRegex(),"")


    val mergedString = "$string $string2"
    if (stringLetters.length == string2Letters.length){
        return mergedString.uppercase(Locale.getDefault())
    }
    else{
        return mergedString
    }
}

// 10. soru
fun differentElements(list: MutableList<Any>, set: Set<Any>) : List<Any> {
    val returnList = mutableListOf<Any>()
    list.forEach {
        if (!set.contains(it)){
            returnList.add(it)
        }
    }
    return returnList
}






