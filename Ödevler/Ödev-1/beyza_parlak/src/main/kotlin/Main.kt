import java.util.*

fun main(){
    // 1-Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu yazın.
    println("-----------------------------------------------------------------------------------------------------------1")

    // öncelikle bir numberArray ve coupleList oluşturuyorum. numberArray tüm sayıları, coupleList ise çift sayıları tutacak
    val numberArray = arrayOf<Int>(1, 52, 60, 39, 27, 0, 99, 82, 22)
    val coupleList = mutableSetOf<Int>()
    // ardından fonksiyon oluşturuyorum ve bu fonk. içinde çift sayıları bulacağım
    // buluğum çift sayıları, fonksiyon içerisinde listeye ekleyeceğim
    fun coupleNumbers(){
        for (c in numberArray){
            // bir sayının 2 ile modu alındığında, kalan 0 a eşitse bu sayı çifttir
            val couple = c % 2
            if (couple == 0){
                coupleList.add(c)
            }
        }
        println("Couple Numbers Array: " + coupleList)
    }
    // sonucu görmek için fonksiyonu çağırıyorum
    coupleNumbers()


    println("-----------------------------------------------------------------------------------------------------------2")
    // 2-Verilen bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan ve sonuçları bir harita(Map) olarak döndüren bir fonksiyon yazın.

    // öncelikle bir stringArray oluşturuyorum
    val stringArray = arrayOf<String>("beyza parlak")
    // fonksiyonun dönüş tipinin Map<Char,Int> olduğunu belirtiyorum
    fun letterCount(stringArray: Array<String>): Map<Char,Int> {
        val letterNumber = mutableMapOf<Char, Int>()
        // for içinde stringArray içini geziyorum
        for (word in stringArray) {
            // for içinde her bir word ile her harfi geziyorum.
            for (letter in word) {
                // program daha önce o harfi gördü mü kontrol ediyoruz eğer gördüyse map içinde harfin sayısını arttırıyorum
                if (letterNumber.contains(letter)) {
                    letterNumber[letter] = letterNumber[letter]!! + 1
                } else { // harfi daha önce görmediyse ilk defa görmüştür ve harf sayısını 1 olarak atarız
                    letterNumber[letter] = 1
                }
            }
        }
        // burada dönüş maptir
        return letterNumber
    }
    //sonuc olarak fonksiyonu çağırıyorum
    val results = letterCount(stringArray)
    println("Letters and numbers in the sequence:")
    // for içinde stringi key ve value olarak ayırır. results->letter,number olarak döner
    for ((letter, number) in results) {
        println("$letter : $number")
    }


    println("-----------------------------------------------------------------------------------------------------------3")

    // 3-Verilen bir listenin elemanlarını tersine çeviren ve bu ters çevrilmiş listeyi döndüren bir fonksiyon yazın.

    // öncelikle bir myList adında liste oluşturuyorum
    val myList = mutableListOf<Any>(12, "hatay", 63, 89, "beyza", 11, "kotlin")
    // ardından ters çevirme işlemi için reverse() methodunu fonksiyon içinde yazıyorum. Ters çevrilmiş listeyi döndürüyorum
    fun reverse(myList: MutableList<Any>): MutableList<Any> {
        myList.reverse()
        return myList
    }
    // bir değişken içerisinde methodu çağırıyorum ve parametre olarak myList veriyorum
    val reverseList = reverse(myList)
    println(reverseList)


    println("-----------------------------------------------------------------------------------------------------------4")
    // 4-Belirli bir aralıktaki tüm tek sayıları içeren bir dizi oluşturan bir fonksiyon yazın. Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır

    val start = 10
    val finish = 50
    // fonksiyon içine integer 2 parametre gönderiyorum ve dönüş tipi List olacaktır
    fun singleNumbersCreate(start: Int, finish: Int): List<Int>{
        val singleNumbers = mutableListOf<Int>()
        // for içinde sayıları başlangiç ve bitiş değeri olarak döndürdüm, sayı artacak. arttıkça 2 ile modu alındığında 0 a eşit mi kontrol edecek.
        // eşit değilse tek sayıları içeren listeye sayıları ekliyorum
        for (number in start..finish){
            if(number % 2 != 0){
                singleNumbers.add(number)
            }
        }
        return singleNumbers
    }
    val singleNumbers = singleNumbersCreate(start, finish)
    println(singleNumbers)


    println("-----------------------------------------------------------------------------------------------------------5")
    // 5-Verilen bir dizideki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir fonksiyon yazın. (Sesli harfler: a, e, i, o, u)

    // öncelikle bir stringArray1 adında dizi oluşturuyorum.
    val stringArray1 = arrayOf("Kotlin Ogreniyorum")
    // Ardından vowelLetter adında sesli harflerin olduğu bir dizi daha oluşturuyorum
    val letters = arrayOf('a','e','i','o','u','A','E','I','O','U')
    // fonksiyon içindeki forda char stringArray1 dizisinin her karakterini dolaşıyorum ve her bir sesli harf için kontrol ediyorum. Varsa count değerine +1 ekliyorum. dönüş olarak int count değerini döndürüyorum
    fun letterCount(stringArray1: String, letters: Char): Int {
        var count = 0
        for (char in stringArray1) {
            if (char == letters) {
                count++
            }
        }
        return count
    }
    // for içinde tüm sesli harflerde dolaşıyorum. fonksiyon içerisinde stringArray1 ve letter değerlerini parametre veriyorum
    for (letter in letters) {
        val count = letterCount(stringArray1.toString(), letter)
        println("Letter: $letter, Count: $count")
    }


    println("-----------------------------------------------------------------------------------------------------------6")
    // 6-Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon yazın.
    val num = 30
    // asal sayılar yalnızca kendine ve 1 e tam bölünür. Fonksiyon dönüşü integer list olacaktır
    fun primeNumbers(num: Int): List<Int> {
        val primeNumbers = mutableListOf<Int>()
        for (number in 2..num) {
            // asal mı ?
            var primeIs = true
            // divisive-bölen değişkeni 2 ile sayı-1 olana kadar dönecek
            for (divisive in 2..number - 1) {
                // sayı 2 den kendine kadar olan sayılardan herhangi bir sayıya bölünürse asal olmaz
                if (number % divisive == 0) {
                    primeIs = false
                    break
                }
            }
            // asal ise primeNumbers listesine eklenir
            if (primeIs) {
                primeNumbers.add(number)
            }
        }
        return primeNumbers
    }
    // primes değişkeni içinde fonksiyonu çağırdım ve parametresini verdim
    val primes = primeNumbers(num)
    println("1-$num prime numbers : $primes")


    println("-----------------------------------------------------------------------------------------------------------7")
    // 7-Verilen bir dizideki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon yazın.

    // Bu soruda kelimeler arasındaki boşluk sayısını +1 yaparak kelime sayısını hesaplayabilirim
    val string1 = "Kotlinle yazılan kod, her satırda bir aşk hikayesi barındırır."
    // fonksiyon string değer alacak ve return olarak integer değer döndürecektir. split() dizi elemanlarını birleştirir ve ardından boşluk karakterine göre böler
    fun splitString(string1: String):Int{
        return string1.split(" ").size
    }
    val result = splitString(string1)
    println("Number of words in string: $result")


    println("-----------------------------------------------------------------------------------------------------------8")
    // 8-Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir fonksiyon yazın.

    val wordsArray = mutableListOf("kotlin", "java", "python", "kotlin", "kotlin")
    // fonksiyona parametre olarak MutableList bir dizi gönderiyorum ve dönüş tipinin String olmasını belirtiyorum
    fun mostRepeatedWord(words: MutableList<String>):String{
        val count = mutableMapOf<String,Int>()

        // foreach içinde kelimeleri sayıyorum ve map e ekliyorum. Word haritada yoksa 0 varsa 1 eklenir
        words.forEach { word ->
            count[word] = (count[word] ?: 0) + 1
        }
        var mostRepeatedWord: String? = null
        var maxCount = 0
        // foreach içinde word ve count alan listeyi döngüye alıyorum. Çiftleri teker teker kontrol ediyorum ve şuana kadar mostRepeatedWord, maxCount olanı döndürüyorum
        count.forEach { (word, count) ->
            if (count > maxCount) {
                mostRepeatedWord = word
                maxCount = count
            }
        }
        return mostRepeatedWord.toString()
    }
    val mostRepeated = mostRepeatedWord(wordsArray)
    println("Most repeated word: $mostRepeated")


    println("-----------------------------------------------------------------------------------------------------------9")
    // 9-İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon yazın. Ancak, birleştirilen dize birbiriyle aynı harf sayısına sahipse, bu dizeyi büyük harflerle birleştirmelisiniz

    /*
    Öncekikle verilen soruyu 2 parçaya böleceğim
    Adım 1. İki dizeyi birleştiren ve sonucu döndür
    Adım 2. Birleştirilen dize birbiriyle aynı harf sayısına sahipse, bu dizeyi büyük harflerle birleştir
    */

    // fonksiyona string2 ve string3 adında iki stringi parametre olarak verdim ve ardından iki kelime için count değişkenleri atadım
    fun mergeString(string2: String, string3: String) {
        var letterCount1 = 0
        var letterCount2 = 0
        // for içlerinde stringi harf harf dolaşacak, her harf geldiğinde countu 1 arttıracak
        for (char in string2) {
            if (char.isLetter()) {
                letterCount1++
            }
        }
        for (char in string3) {
            if (char.isLetter()) {
                letterCount2++
            }
        }
        val newString: String
        // harf sayıları aynıysa tüm harfleri büyük yapacağım (uppercase() metodu ile)
        if (letterCount1 == letterCount2) {
            newString = string2.uppercase(Locale.getDefault()) + string3.uppercase(Locale.getDefault())
            println("New String: $newString")
        } else { // değilse stringleri birleştireceğim
            newString = string2 + string3
            println("New String: $newString")
        }
    }
    val string2 = "Merhaba kotlin"
    val string3 = "Merhaba kotlin"
    mergeString(string2, string3)


    println("-----------------------------------------------------------------------------------------------------------10")
    // 10-Bir liste ve bir set arasındaki farkı döndüren bir fonksiyon yazın. Yani, liste içinde bulunan ancak sette bulunmayan öğeleri bulun

    // öncelikle bir liste ve set oluşturuyorum
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val set = setOf(1, 3, 5, 7, 9)
    // fonksiyon içinde list ve seti parametre olarak alıyorum. Dönüş tipi List<Int> yani mutableListOf olacaktır. Bunun için de ayrı bir mutableList oluşturuyorum
    fun distinctElement(list: List<Int>, set: Set<Int>): List<Int>{
        val distinct = mutableListOf<Int>()
        // for içinde öncelikle list elemanlarını ardından set elememanlarını geziyorum ve setten farklı olanları yeni mutableList içine add() metodu ile ekliyorum
        for (element in list){
            if (element !in set){
                distinct.add(element)
            }
        }
        return distinct
    }
    val reslt1 = distinctElement(list, set)
    println("List and set differences: $reslt1")


}
