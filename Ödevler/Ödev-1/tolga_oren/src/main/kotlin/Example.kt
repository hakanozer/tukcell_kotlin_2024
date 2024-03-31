
fun main() {

    // for 1. Question
    val integerArray = arrayOf(12, 36, 73, 273, 986, 45, 67, 78)
    findEvenNumbers(integerArray)

    // for 2. Question
    val letterStr = "Take me down to the Paradise City where the grass is green and the girls are pretty"
    val letterResult = findRepeatedLetters(letterStr)
    println(letterResult)

    // for 3. Question
    val anyList: List<Any> = listOf(785, "e", true, 85, "Q", false)
    val reverseResult = reverseList(anyList)
    println(reverseResult)

    // for 4. Question
    val firstInput = 5
    val secondInput = 89
    findOddNumbers(firstInput , secondInput)

    // for 5. Question
    val vowelInput = "Forever trusting who we are and nothing else matters"
    val vowels = arrayOf("a", "i", "e", "u", "o")
    val vowelResult = findVowels(vowelInput, vowels)
    println(vowelResult)

    // for 6. Question
    findPrimeNumbers(34)

    // for 7. Question
    val randomStr = "Shes got a smile that it seems to me reminds me of childhood memories"
    val wordCount = findWordCount(randomStr)
    println(wordCount)

    // for 8. Question
    val wordArray = arrayOf("metal", "heavy", "rap", "jazz", "metal", "rap", "blues", "metal", "opera")
    val mostRepeatedWord = findMostRepeatedWord(wordArray)
    println(mostRepeatedWord)

    // for 9. Question
    val strConcatResult= stringConcatenation("heavy", "metal")
    println(strConcatResult)

    // for 10. Question
    val wordList = listOf("metal", "heavy", "rap", "jazz", "metal", "rap", "blues", "metal", "opera")
    val diffResult = setAndListDifference(wordList)
    println(diffResult)
}

    // for 1. Answer
fun findEvenNumbers(arr: Array<Int>) {
    val evenNumbers = arr.filter {
        it % 2 == 0
    }
    println(evenNumbers)
}

    // for 2. Answer
fun findRepeatedLetters(str: String) : MutableMap<Char, Int>{
    val repeatedMap = mutableMapOf<Char, Int>()
    val strLowercase = str.lowercase().replace("\\s+".toRegex(), "")
        strLowercase.forEach {
            if(repeatedMap.contains(it)) {
                repeatedMap[it] = repeatedMap.getValue(it) + 1
            } else {
                repeatedMap[it] = 1
            }
        }
    return repeatedMap
}

    // for 3. Answer
fun reverseList (list: List<Any>) : List<Any> {
    return list.reversed()
}

    // for 4. Answer
fun findOddNumbers(start: Int, end: Int) {
    val oddNumbers = mutableListOf<Int>()
    for (i in start..end) {
        if(i % 2 == 1) {
            oddNumbers.add(i)
        }
    }
    println(oddNumbers)
}

    // for 5. Answer
fun findVowels(str: String, vowels: Array<String>) : Int {
    var count = 0
    str.forEach {
        val oneCharStr = it.lowercase()
        if(vowels.contains(oneCharStr)) {
            count++
        }
    }
    return count
}

    // for 6. Answer
fun findPrimeNumbers(end: Int) {
    val primeNumbers = mutableListOf<Int>()
    for (i in 2..end) {
        if (isPrime(i)) {
            primeNumbers.add(i)
        }
    }
    println(primeNumbers)
}

fun isPrime(num: Int) : Boolean {
    for (j in 2 until num) {
          if (num % j == 0) {
              return false
          }
    }
    return true
}

    // for 7. Answer
fun findWordCount(str: String) : Int {
    val count = str.split("\\s+".toRegex())
    return count.size
}

    // for 8. Answer
fun findMostRepeatedWord(arr: Array<String>) : String? {
    val wordCountsMap = mutableMapOf<String, Int>()
    arr.forEach {
        if(wordCountsMap.contains(it)) {
            wordCountsMap[it] = wordCountsMap.getValue(it) + 1
        } else {
            wordCountsMap[it] = 1
        }
    }
    return wordCountsMap.maxByOrNull {it.value}?.key
}

    // for 9. Answer
fun stringConcatenation(firstStr: String, secondStr: String) : String {
    if (firstStr.trim().length == secondStr.trim().length) {
        return firstStr + secondStr.uppercase()
    }
    return firstStr + secondStr
}

    // for 10. Answer
fun setAndListDifference(list: List<String>): MutableList<String> {
    val set = list.toSet()
    val allItemsList: MutableList<String> = list.toMutableList()
    set.forEach {
        allItemsList.remove(it)
    }
    return allItemsList
}



