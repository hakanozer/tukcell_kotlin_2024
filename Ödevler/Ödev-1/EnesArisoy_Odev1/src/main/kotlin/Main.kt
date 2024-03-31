package org.example

fun main() {
    println("Enes Arısoy Hafta 1 Ödevi")

    // Soru 1
    println("--------------------------------")
    /**
     *  1. Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu
     * yazın.
     */
    println("Soru 1")

    fun findEvensInList(numberList: List<Int>): List<Int> =
        numberList.filter {
            it % 2 == 0
        }

    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evens = findEvensInList(list)
    println("Dizideki çift sayılar: $evens")

    println("--------------------------------")
    /**
     *  2.Verilen bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan ve sonuçları
     * bir harita(Map) olarak döndüren bir fonksiyon yazın.
     */

    println("Soru 2")

    fun calculateCharCount(givenString: String): Map<Char, Int> {
        val charCount = mutableMapOf<Char, Int>()

        for (char in givenString) {
            if (char.isLetter()) {
                val character =
                    char.toLowerCase()
                if (charCount.containsKey(character)) {
                    charCount[character] = charCount.getValue(character) + 1
                } else {
                    charCount[character] = 1
                }
            }
        }

        return charCount
    }

    val givenString = "Turkcell Bootcamp"
    val charCount = calculateCharCount(givenString)
    println("Her bir harfin tekrar sayıları:")
    charCount.forEach { (char, sum) ->
        println("$char : $sum")
    }

    println("--------------------------------")

    /**
     *  3. Verilen bir listenin elemanlarını tersine çeviren ve bu ters çevrilmiş listeyi
     * döndüren bir fonksiyon yazın.
     */

    println("Soru 3")

    fun reverseTheList(list: List<Int>): List<Int> {
        return list.reversed()
    }

    val originalList = listOf(1, 2, 3, 4, 5)
    val reversedList = reverseTheList(originalList)
    println("Orijinal Liste: $originalList")
    println("Ters Liste: $reversedList")

    println("--------------------------------")

    /**
     *  4. Belirli bir aralıktaki tüm tek sayıları içeren bir dizi oluşturan bir fonksiyon yazın.
     * Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır.
     */

    println("Soru 4 -> Listedeki tek sayıları bul")

    fun createOddNumbersList(list: MutableList<Int>, start: Int, end: Int): MutableList<Int> {
        list.clear()
        val oddNumbers = (start..end).filter { it % 2 != 0 }
        list.addAll(oddNumbers)
        return list
    }

    println("Başlangıç değerini giriniz: ")
    val first = readlnOrNull()
    var start = first?.toIntOrNull()
    while (start == null) {
        println("Başlangıç değeri geçersiz! Tekrar giriniz: ")
        start = readlnOrNull()?.toIntOrNull()
    }

    println("Son değeri giriniz: ")
    val last = readlnOrNull()
    var end = last?.toIntOrNull()
    while (end == null) {
        println("Son değer geçersiz! Tekrar giriniz: ")
        end = readlnOrNull()?.toIntOrNull()
    }

    val oddNumbers = createOddNumbersList(mutableListOf<Int>(), start, end)
    println("Listedeki tek sayılar: ")
    println(oddNumbers)

    println("--------------------------------")

    /**
     *  5. Verilen bir stringteki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir
     * fonksiyon yazın. (Sesli harfler: a, e, i, o, u)
     */

    println("Soru 5")

    fun countVowels(str: String): Int {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')
        return str.count { it.toLowerCase() in vowels }
    }

    val metin = "Turkcell Kotlin Bootcamp!"
    val vowelsCount = countVowels(metin)
    println("Metindeki sesli harf sayısı: $vowelsCount")

    println("--------------------------------")

    /**
     *  6. Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon
     * yazın.
     */

    println("Soru 6 -> Belirli bir sayıya kadar olan sayıları bul")

    fun isPrime(number: Int): Boolean = number <= 1 || (2 until number).none { number % it == 0 }

    val limit = 100
    println("$limit sayısına kadar olan asal sayılar: ${(2..limit).filter { isPrime(it) }.joinToString(", ")}")

    println("--------------------------------")

    /**
     *  7. Verilen bir stringteki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon
     * yazın.
     */

    println("Soru 7")

    fun calculateWordCount(sentence: String): Int {
        var wordCount = 0
        var isWordStart = false

        sentence.forEach { character ->
            if (character.isLetterOrDigit()) {
                if (!isWordStart) {
                    wordCount++
                    isWordStart = true
                }
            } else {
                isWordStart = false
            }
        }

        return wordCount
    }
    val sentence = "Selamlar, Turkcell Kotlin Bootcamp."
    val wordCount = calculateWordCount(sentence)
    println("Yazıdaki kelime sayısı: $wordCount")

    println("--------------------------------")

    /**
     *  8. Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir
     * fonksiyon yazın.
     */

    println("Soru 8")

    fun findMostFrequentWord(input: String): String? {
        val words = input.split(" ")

        val wordCounts = mutableMapOf<String, Int>()
        var mostFrequentWord: String? = null
        var maxFrequency = 0

        for (word in words) {
            val count = wordCounts.getOrDefault(word, 0) + 1
            wordCounts[word] = count

            if (count > maxFrequency) {
                mostFrequentWord = word
                maxFrequency = count
            }
        }

        return mostFrequentWord
    }

    val text = "enes enes turkcell turkcell android kotlin enes"
    val mostFrequentWord = findMostFrequentWord(text)
    println("En çok kullanılan kelime: $mostFrequentWord")

    println("--------------------------------")

    /**
     *  9. İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon yazın. Ancak, birleştirilen
     * dize birbiriyle aynı harf sayısına sahipse, bu dizeyi büyük harflerle
     * birleştirmelisiniz.
     */

    println("Soru 9")

    fun mergeStrings(firstString: String, secondString: String): String {
        return if (firstString.length == secondString.length) {
            firstString.toUpperCase() + secondString.toUpperCase()
        } else {
            firstString + secondString
        }
    }

    val string1 = "turkcell"
    val string2 = "bootcamp"
    val result = mergeStrings(string1, string2)
    println("Birleştirilen string: $result")

    println("--------------------------------")

    /**
     *  10. Bir liste ve bir set arasındaki farkı döndüren bir fonksiyon yazın. Yani, liste içinde
     * bulunan ancak sette bulunmayan öğeleri bulun.
     */

    println("Soru 10")

    fun differenceFrom(list: List<Int>, set: Set<Int>): List<Int> {
        return list.filter { it !in set }
    }

    val liste = listOf(1, 2, 3, 4, 5)
    val set = setOf(3, 4, 5, 6, 7)
    val differ = differenceFrom(liste, set)
    println("Liste ve Set arasındaki farklar: $differ")
}