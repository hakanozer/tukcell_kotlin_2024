fun main(){

    // First Clause

    val firstClause = arrayOf(1,2,3,4,5,6,7,8,9)
    val resultArray = mutableListOf<Int>()

    fun findEvenNumber(array: Array<Int>){
        for (data in array){
            if (data % 2 == 0){
                resultArray.add(data)
            }
        }
    }

    // First Clause Test

    findEvenNumber(firstClause)  // Input: [1,2,3,4,5,6,7,8,9]
    println("First Clause Test Result: $resultArray")  // Output: [2, 4, 6, 8]


    // -----------------------------------------------------------------------------------------------------------------


    // Second Clause
    val secondClause = arrayOf('a','s','a','a','g','s','s','g','c','A','B')

    fun calculateLetters(array: Array<Char>): Map<Char,Int>{

        val resultMap = mutableMapOf<Char,Int>()
        for (char in array){
            val data = char.lowercaseChar()
            if (resultMap.containsKey(data)){
                val count = resultMap[data] ?: 0
                resultMap[data] = count + 1
            }
            else{
                resultMap[data] = 1
            }
        }
        return resultMap
    }

    // Second Clause Test

    val secondResult = calculateLetters(secondClause) //Input: ['a','s','a','a','g','s','s','g','c','A','B']
    println("Second Clause Test Result: $secondResult")  //Output: //Output: {a=4, s=3, g=2, c=1, b=1}



    // -----------------------------------------------------------------------------------------------------------------


    // Third Clause

    val thirdClause = arrayOf("Elma","Armut","Kiraz","Visne")

    fun reverseArray(array:Array<String>): MutableList<String> {
        val resultArray= mutableListOf<String>()
        for (index in array.size-1 downTo 0){
            resultArray.add(array[index])
        }
        return resultArray
    }


    // Third Clause Test

    val thirdResult = reverseArray(thirdClause) // Input: ["Elma","Armut","Kiraz","Visne"]
    println("Third Clause Test Result: $thirdResult")   // Output: [Visne, Kiraz, Armut, Elma]


    // -----------------------------------------------------------------------------------------------------------------


    // Fourth Clause

    fun createOddNumber(start:Int,end:Int): MutableList<Int>{

        val resultList = mutableListOf<Int>()

        for (data in start until end+1){
            if (data % 2 !=0){
                resultList.add(data)
            }
        }
        return resultList
    }

    // Fourth Clause Test

    val fourthResult = createOddNumber(5,11)
    println("Fourth Clause Test Result: $fourthResult") // Output: [5, 7, 9, 11]


    // -----------------------------------------------------------------------------------------------------------------


    // Fifth Clause

    val charArray = charArrayOf('i', 'w', 'a', 'h', 't', 'e', 'v', 'u', 'w', 'm', 'i', 'q', 'd', 'z', 'f')

    fun calculateVowel(array: CharArray):Int{
        var result = 0
        for (data in array){
            when(data){
                'a' -> result++
                'e' -> result++
                'i' -> result++
                'o' -> result++
                'u' -> result++
            }
        }
        return result
    }

    // Fifth Clause Test

    val fifthResult = calculateVowel(charArray)
    println("Fifth Clause Test Result: $fifthResult") // Output: 5


    // -----------------------------------------------------------------------------------------------------------------


    // Sixth Clause

    fun createPrimeNumbers(input: Int): List<Int> {
        val result = mutableListOf<Int>()

        for (number in 2..input) {
            var isPrime = true
            for (i in 2 until number) {
                if (number % i == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) {
                result.add(number)
            }
        }

        return result
    }

    // Sixth Clause Test

    val sixthResult = createPrimeNumbers(15)
    println("Sixth Clause Test Result: $sixthResult") // Output: [2, 3, 5, 7, 11, 13]


    // -----------------------------------------------------------------------------------------------------------------


    // Seventh Clause
    val  wordArray = arrayOf("Kotlin Programlama", "Yusuf Mücahit Solmaz", "Eskişehir")
    fun wordNumberCalculate(wordArray: Array<String>): Int {
        var wordNumber = 0

        for (word in wordArray) {

            wordNumber += word.trim().split("\\s+".toRegex()).size
        }

        return wordNumber
    }

    // Seventh Clause Test

    val seventhResult = wordNumberCalculate(wordArray)
    println("Seventh Clause Test Result: $seventhResult") // Output: 6


    // -----------------------------------------------------------------------------------------------------------------


    // Eighth Clause
    /* Burada benim ilk aklıma gelen yöntem kelimeleri bir map'e alıp orada value'si kimin en çok ise onu döndürmek yönünde oldu.
    Bu durum aslında 2. isterdeki kısıma benziyor.
    */

    fun findMostCommonWord(array:Array<String>):String {

        val wordCounts = HashMap<String, Int>()

        for (word in array) {
            val count = wordCounts.getOrDefault(word, 0) + 1
            wordCounts[word] = count
        }

        var mostCommonWords = ""
        var highestCount = 0

        for ((word, count) in wordCounts) {
            if (count > highestCount) {
                mostCommonWords = word
                highestCount = count
            } else if (count == highestCount) {
                mostCommonWords = "No Most Common Word!"
            }
        }

        return mostCommonWords
    }


    // Eighth Clause Test

    val eighthResult = findMostCommonWord(arrayOf("elma","armut","kiraz","elma","armut","elma"))
    println("Eighth Clause Test Result: $eighthResult")  // Output: elma


    // -----------------------------------------------------------------------------------------------------------------


    // Ninth Clause
    fun mergeArrays(firstInput: String, secondInput: String): String {
        return if (firstInput.length == secondInput.length) {
            firstInput.toUpperCase() + secondInput.toUpperCase()
        } else {
            firstInput + secondInput
        }
    }

    // Ninth Clause Test
    val ninthClauseResult = mergeArrays("vişne","armut")
    println("Ninth Clause Test Result: $ninthClauseResult") // Output: VİŞNEARMUT


    // -----------------------------------------------------------------------------------------------------------------


    // Tenth Clause

    val list = listOf("elma","armut","kiraz")
    val set = setOf("vişne","portakal","armut")

    fun  findDifference(list: List<String>, set: Set<String>): List<String> {
        val difference = mutableListOf<String>()
        for (item in list) {
            if (!set.contains(item)) {
                difference.add(item)
            }
        }
        return difference
    }

    // Tenth Clause Test

    val tenthClauseResult = findDifference(list, set)
    println("Tenth Clause Test Result: $tenthClauseResult") // Output: [elma, kiraz]


    // -----------------------------------------------------------------------------------------------------------------
}