fun main() {

    val numberList = IntArray(5)
    numberList[0] = 1
    numberList[1] = 2
    numberList[2] = 3
    numberList[3] = 4
    numberList[4] = 5

    findEvenNumbers(numberList)

    val wordsList = Array(4) { "" }
    wordsList[0] = "Ne"
    wordsList[1] = "Mutlu"
    wordsList[2] = "Türküm"
    wordsList[3] = "Diyene"

    for((key,value) in findCharRepeatCount(wordsList)){
        println("Harf: $key, Tekrar: $value")
    }

    val list:List<Any> = listOf("bir",2,'3')

    println("Ters çevrilmiş liste: ${reverseList(list)}")

    findOddNumners(3,19)

    println("Sesli harf sayısı: ${findVowelCount(wordsList)}")

    println("Asal sayılar: ${findPrimeNumbers(7)}")

    val sentenceList = Array(4){""}
    sentenceList[0] = "Ne Mutlu Türküm Diyene"
    sentenceList[1] = "İstikbal Göklerdedir"
    sentenceList[2] = "Ben sporcunun zeki çevik aynı zamanda ahlaklısını severim"
    sentenceList[3] = "Bütün ümidim gençliktedir"

    println("Kelime sayısı : ${wordCount(sentenceList)}")

    val sentence = "Bir tarlaya ekin ekmişler\n" +
            "İki kürkü yırtık kel kör kirpi dadanmış\n" +
            "Biri kürkü yırtık erkek kel kör kirpi\n" +
            "Digeri kürkü yırtık dişi kel kör kirpikürkü yırtık erkek kel kör kirpinin kürkünü\n" +
            "Kürkü yırtık dişi kel kör kirpinin kürküne\n" +
            "Kürkü yırtık dişi kel kör kirpinin kürkünü de\n" +
            "Kürkü yırtık erkek kel kör kirpinin\n" +
            "Kürküne eklemişler\n" +
            "Bir tarlaya kemeken ekmişler\n" +
            "İki kürkü yırtık kel kör kirpi dadanmış\n" +
            "Biri erkek kürkü yırtık kel kör kirpi\n" +
            "öteki dişi kürkü yırtık kel kör kirpi\n" +
            "kürkü yırtık erkek kel kör kirpinin yırtık kürkünü\n" +
            "kürkü yırtık dişi kel kör kirpinin yırtık kürkünü\n" +
            "kürkü yırtık erkek kel kör kirpinin yırtık kürküne eklemişler"

    println("En çok tekrar eden kelime: ${findMaxRepeatWord(sentence)}")

    println("Birleşmiş kelime: ${connectStrings("cevdet","cevdet")}")

    val list2:List<Any> = listOf("bir",2,'3',4.5,true)
    val set2:Set<Any> = setOf("bir",'3',false)

    println("Farklı elemanlar: ${findDifference(list2,set2)}")

}

fun findEvenNumbers(numberList:IntArray) {
    val evenList = mutableListOf<Int>()
    numberList.forEach {
        if (it % 2 == 0){
            evenList.add(it)
        }
    }
    println("Çift sayılar: $evenList")
}

fun findCharRepeatCount(wordsList:Array<String>) : Map<Char,Int>{
    var allWords = ""
    val charSet:MutableSet<Char> = mutableSetOf()
    val charRepeatMap: MutableMap<Char, Int> = mutableMapOf()
    for (i in wordsList){
        allWords+=i.lowercase()
    }
    for (t in allWords){
        charSet.add(t)
    }
    for (x in charSet){
        val count = allWords.count { it == x }
        charRepeatMap[x] = count
    }
    return charRepeatMap
}

fun reverseList(list:List<Any>) : List<Any> {
    val reversedList = list.reversed()
    return reversedList
}

fun findOddNumners(start:Int,finish:Int){
    var odds = ""
    val oddList: MutableList<Int> = mutableListOf()
    for (i in start..finish){
        if (i % 2 != 0){
            odds += "$i  "
            oddList.add(i)
        }
    }
    println("Tek Sayılar: $odds")
    println("Tek Sayılar Liste: $oddList")
}

fun findVowelCount(wordsList:Array<String>) : Int {
    var count = 0
    var allWords = ""
    for (i in wordsList){
        allWords+=i.lowercase()
    }
    for (i in allWords){
        if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u'){
            count++
        }
    }
    return count
}

fun findPrimeNumbers(num:Int) : List<Int>{
    val primeList = mutableListOf<Int>()
    for (i in 2..num){
        var prime = true
        for (t in 2 until i){
            if (i % t == 0){
                prime = false
                break
            }
        }
        if (prime){
            primeList.add(i)
        }
    }
    return primeList
}

fun wordCount(sentenceList: Array<String>) : Int{
    var count = 0
    for (i in sentenceList){
        val wordsList = i.split(" ")
        count += wordsList.size
    }
    return count
}

fun findMaxRepeatWord(sentence : String) : String {
    var maxRepeatedWord = ""
    var count = 0
    val wordsList = sentence.split(" ")
    for (i in wordsList){
        val newCount = wordsList.count { it == i }
        if (count < newCount){
            count = newCount
            maxRepeatedWord = i
        }
    }
    return maxRepeatedWord
}

fun connectStrings(firstString: String,secondString: String) : String{
    var connectedStrings = ""
    if (firstString.length == secondString.length){
        connectedStrings = firstString + secondString.uppercase()
    }else{
        connectedStrings = firstString + secondString
    }
    return connectedStrings
}

fun findDifference(list: List<Any>,set: Set<Any>) : MutableList<Any> {
    val differenceList:MutableList<Any> = mutableListOf()
    for (i in list){
        if (set.contains(i)){
            continue
        }else{
            differenceList.add(i)
        }
    }
    return differenceList
}