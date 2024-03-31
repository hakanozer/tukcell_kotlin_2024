fun main() {
    // question 1:
    println("Q1-----------------------------------------")
    val array = intArrayOf(0,3,32,26,99,86,57,77,1,2,3)
    val evenNumberList = findEvenNumbers(array)
    println("array: $array; even numbers: $evenNumberList")

    // question 2:
    println("Q2-----------------------------------------")
    val q2Array2 = listOf("Bursa","Ankara","Mersin")

    val repeatedLetterCount = repeatedLetterCount(q2Array2)
    println("Repeated letter in: $q2Array2")
    for ((letter, no) in repeatedLetterCount) {
        println("$letter : $no")
    }

    // question 3:
    val q3Array = listOf(11,38,49,75,33)
    val q3Array2 = listOf("apple","banana","orange","lemon","grape")

    println("Q3-----------------------------------------")
    val q3arrayReversed = reversedList(q3Array)
    println("list: $q3Array; reversed: $q3arrayReversed")
    val q3arrayReversed2 = reversedList(q3Array2)
    println("list: $q3Array2; reversed: $q3arrayReversed2")


    // question 4:
    println("Q4-----------------------------------------")
    val subLimit = 46
    val upperLimit = 69
    val oddNumbers = findOddNumbers(subLimit,upperLimit)
    println("Odd numbers between $subLimit - $upperLimit: $oddNumbers")

    // question 5:
    println("Q5-----------------------------------------")
    val q5Array = listOf("apple","orange","lemon","grape")
    val vowelCount = vowelCount(q5Array)
    println(q5Array)
    println("number of vowels: $vowelCount")


    // question 6:
    println("Q6-----------------------------------------")
    val limit = 35
    val primeNumbersUntilLimit = findPrimeNumbers(limit)
    println("Prime numbers until $limit: $primeNumbersUntilLimit")

    // question 7:
    println("Q7-----------------------------------------")
    val q7Array = listOf("this is simple sentence","read book","find the number of words in the sentence")
    println("Number of the words in sentence")
    wordCount(q7Array)

    // question 8:
    println("Q8-----------------------------------------")
    val q8Array = listOf("this is simple sentence sentence","read book","find the number of words in the sentence")
    println("sentences: $q8Array")
    val result = findTheMostFrequentlyRepeatedWord(q8Array)
    println("the most frequent repeated word: $result")

    // question 9:
    println("Q9-----------------------------------------")
    val q9Array = listOf("Leon","Wolf","Tiger")
    val examples1 = mergeText(q9Array[0],q9Array[1])
    val examples2 = mergeText(q9Array[0],q9Array[2])

    println("${q9Array[0]} and ${q9Array[1]} :$examples1")
    println("${q9Array[0]} and ${q9Array[2]} :$examples2")


    // question 10:
    println("Q10-----------------------------------------")
    val listArray = listOf(1,2,3,7,8,9)
    val setArray = setOf(3,4,5,6,7)
    val difference = findDifference(listArray, setArray)
    println("List array: $listArray")
    println("Set array: $setArray")
    println("Difference: $difference")

}

// q1 fun
fun findEvenNumbers(array: IntArray): List<Int>{ return  array.filter { it % 2 == 0 }}

// q2 fun
fun repeatedLetterCount(array: List<String>): Map<Char, Int> {
    val letterMap = mutableMapOf<Char, Int>()
    for(exp in array){
        val lowerCaseExp = exp.lowercase()
        for(letter in lowerCaseExp){
            if (letterMap.containsKey(letter)) {
                letterMap[letter] = letterMap[letter]!! + 1
            } else {
                letterMap[letter] = 1
            }
        }
    }
    return letterMap
}

// q3 fun
fun <T>reversedList(array: List<T>):List<T>{ return array.reversed()}

// q4 fun
fun findOddNumbers(subLimit:Int, upperLimit:Int):List<Int>{
    val oddNumbers = mutableListOf<Int>()
    for (i in subLimit + 1 until upperLimit){
        if(i % 2 != 0 ) oddNumbers.add(i)
    }
    return  oddNumbers
}

// q5 fun apple banana
fun vowelCount(array: List<String>): Int {
    var count = 0
    for(exp in array){
        val lowerCaseExp = exp.lowercase()
        for(letter in lowerCaseExp){
            when(letter){
                'a','e','i','o','u'-> count++
            }
        }
    }
    return count
}

//q6 fun
fun findPrimeNumbers(limit:Int):List<Int>{
    val primeNumbers = mutableListOf<Int>()

    for (i in 2 until limit){
        var isPrime = true
        for(j in 2 until i){
            if(i % j == 0){
                isPrime= false
                break
            }
        }
        if (isPrime) primeNumbers.add(i)
    }
    return primeNumbers
}

// q7 fun
fun wordCount(sentences : List<String>):Unit{
    for(sentence in sentences){
        println("$sentence -> ${sentence.split("\\s+".toRegex()).size} word")
    }
}

// q8 fun
fun findTheMostFrequentlyRepeatedWord(array: List<String>):List<String>{
    if(array.isEmpty()){return  emptyList()}

    val wordFrequency = mutableMapOf<String, Int>()
    val words = mutableListOf<String>()
    for (sentence in array){
        words.addAll(sentence.split(" "))
    }
    println("words: "+ words)
    for (word in words) {
        wordFrequency[word] = wordFrequency.getOrDefault(word, 0) + 1
    }
    // find the highest repeat
    val highestRepeat = wordFrequency.values.maxOrNull()
    val mostFrequentWords = wordFrequency.filter { it.value == highestRepeat }.keys.toList()

    return mostFrequentWords
}

// q9 fun
fun mergeText(dize1: String, dize2:String):String{
    if(dize1.length != dize2.length){ return dize1+dize2 }
    else{ return dize1.uppercase()+dize2.uppercase() }
}

// q10 fun
fun <T> findDifference(listArray: List<T>, setArray: Set<T>): List<T> {
    val differenceList = mutableListOf<T>()
    for (item in listArray) {
        if (item !in setArray) {
            differenceList.add(item)
        }
    }
    return differenceList
}