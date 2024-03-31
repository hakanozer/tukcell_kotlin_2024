package org.example
//Çift sayıları bulma fonksiyonu
fun findEvenNumbers(arr: IntArray): List<Int> {
    val evenNumbers = mutableListOf<Int>()
    for (number in arr) {
        if (number % 2 == 0) {
            evenNumbers.add(number)
        }
    }
    return evenNumbers
}
//Her harfin kaç kez tekrarladığını gösteren fonksiyon
fun countOccurrences(str: String): Map<Char, Int> {
    val upperCaseStr = str.uppercase()
    val occurrences = mutableMapOf<Char, Int>()

    for (char in upperCaseStr) {
        if(char != ' '){
            val count = occurrences.getOrDefault(char, 0)
            occurrences[char] = count + 1
        }
    }
    return occurrences
}
//Diziyi ters çevirme
fun reverseArray(list: List<Any>): List<Any> {
    return list.reversed()

    /*val reversedArray = Array<Any>(array.size) { 0 }
    for (i in array.indices) {
        reversedArray[i] = array[array.size - 1 - i]
    }
    return reversedArray*/
}
//Belirli bi aralıkta tek sayılardan dizi oluşturan fonksiyon
fun oddNumbers(start: Int, end: Int): List<Int> {
    require(start <= end) { "Başlangıç değeri, bitiş değerinden küçük olmalı." }
    val oddNumbers = mutableListOf<Int>()
    for (num in start..end) {
        if (num % 2 != 0) {
            oddNumbers.add(num)
        }
    }
    return oddNumbers
}
//Sesli harf sayısı bulan fonksiyon
fun countVowels(str: String): Int {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    var count:Int = 0
    for (char in str) {
        if (char.lowercaseChar() in vowels) {
            count++
        }
    }
    return count
}
//Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon
fun isPrime(number: Int): Boolean {
    if (number <= 1) {
        return false
    }
    for (i in 2 until number) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}
fun generatePrimes(upTo: Int): List<Int> {
    val primes = mutableListOf<Int>()
    for (number in 2..upTo) {
        if (isPrime(number)) {
            primes.add(number)
        }
    }

    return primes
}
//Verilen bir dizgedeki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon
fun countWords(sentence: String): Int {
    val words = sentence.split("\\s+".toRegex()).filter { it.isNotBlank() }
    return words.size
}
//Verilen bir dizgede en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir fonksiyon
fun findMostFrequentWord(sentence: String): String {
    var temp = sentence.uppercase()
    //cümledeyi boşluklara göre bölüp fazladan boşluk kaldıysa filtreliyoruz
    val words = temp.split(regex = "\\s+".toRegex()).filter { it.isNotBlank() }
    val wordCounts = mutableMapOf<String, Int>()
    for (word in words) {
        val count = wordCounts.getOrDefault(word, 0)
        wordCounts[word] = count + 1
    }

    val maxCount = wordCounts.values.maxOrNull()
    val mostFrequentWords = wordCounts.filterValues { it == maxCount }.keys

    return if (mostFrequentWords.size == 1) {
        mostFrequentWords.first()
    } else {
        "Hepsi ya da bazı kelimeler eşit sıklıkta tekrar etmiş"
    }
}
//İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon
fun mergeStrings(str1: String, str2: String): String {
    val str1Length = str1.replace(" ", "").replace(Regex("\\d+"), "").length
    val str2Length = str2.replace(" ", "").replace(Regex("\\d+"), "").length
    val merged = StringBuilder()

    if( str1Length==str2Length){
       merged.append(str1)
       merged.append(str2.uppercase())
    }else{
        merged.append(str1)
        merged.append(str2)
    }
    return merged.toString()
}
//Bir listeden ve bir setten farkı döndüren bir fonksiyon
fun findDifference(list: List<Any>, set: Set<Any>): List<Any> {
    return list.filter { !set.contains(it) }
}

fun main() {
    // 1.
    val numbers = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers = findEvenNumbers(numbers)
    println("Çift sayılar: $evenNumbers")

    // 2.
    val str = "MerhAba dünya"
    val occurrences = countOccurrences(str)
    println("Harf tekrarları : $occurrences")

   // 3.
    val list = listOf(1, 2, 3, 4, 5)
    val reversedList = reverseArray(list)
    println("Liste ters çevrildi: $reversedList")

    // 4.
    val start = 1
    val end = 10
    val oddNumbers = oddNumbers(start, end)
    println("$start-$end arasındaki tek sayılar: $oddNumbers")

    // 5.
    val vowelsCount = countVowels(str)
    println("Sesli harf sayısı: $vowelsCount")

    // 6.
    val primesUpTo = 20
    val primesList = generatePrimes(primesUpTo)
    println("1-$primesUpTo arasındaki asal sayılar: $primesList")

    // 7.
    val sentence = "Bu bir bu bir örnek cümle"
    val wordCount = countWords(sentence)
    println("Cümledeki kelime sayısı: $wordCount")

    // 8.
    val mostFrequent = findMostFrequentWord(sentence)
    println("En sık tekrar eden kelime: $mostFrequent")

    // 9.
    val str1 = "example"
    val str2 = "ExAmPlE"
    println("Merged String: ${mergeStrings(str1, str2)}")

    // 10.
    val list2 = listOf(1, 2, 3, 4, 5)
    val set2 = setOf(3, 4, 5, 6, 7)
    val difference = findDifference(list2, set2)
    println("Liste ve set arasındaki fark: $difference")
}


