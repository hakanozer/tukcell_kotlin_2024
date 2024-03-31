///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-1 için
///Umut Yusuf Çınar tarafından oluşturuldu.

//Ödevde belirtilen 10 adet fonksiyonu ödevdeki soru başlıklarıyla beraber
//sırayla alt kısımda teker teker yazacağım.
//Fonksiyonların hepsini deneyebilmeniz için main fonksiyonu içerisinde çağıracağım.
package org.example

import java.util.*

fun main() {
    //1. fonksiyon için parametre verilmesi ve fonksiyonun çağırılması
    val array1 = arrayOf(1,2,3,4,5,6,7,8,9,10)
    val list1 = getEvenNumber(array1)
    println("Girilen dizi içerisindeki çift sayların listesi: $list1")

    //2. fonksiyon için parametrelerin verilmesi ve fonksiyonun çağırılması
    val array2 = arrayOf('u', 'y', 'c', 'c', 'y', 'u')
    val frequencValues = letterFrequencyCalculator(array2)
    //önce diziyi kullanıcıya gösteriyorum ardından harf frekanslarını ekrana bastırıyorum
    println("Dizi: ${array2.contentToString()}")
    println("Harf Frekansları:")
    for((letter, frequnce) in frequencValues){
        println("$letter: $frequnce")
    }

    //3. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val originalList = listOf(1,2,3,4,5)
    val reversedList = reverse(originalList)
    println("Orijinal Liste: ${originalList}")
    println("Ters Çevirilmiş Liste: ${reversedList}")

    //4. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    print("Başlangıç tamsayı değerini giriniz: ")
    val firstValue = readLine()!!.toInt() //kullanıcıdan null gelmeyecek garantisi verdim
    print("Bitiş tamsayı değerini giriniz: ")
    val lastValue = readLine()!!.toInt()

    val oddNumbersArray = createOddNumbersArrayFromRange(firstValue,lastValue)

    //let ile arrayin null olmadığı durumda kod bloğunun çalışmasını sağlıyoruz

    oddNumbersArray?.let {
        println("Belirtilen aralıktaki tek sayılar:")
        it.forEach { println(it) }
    }

    //5. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val array5 = charArrayOf('a', 'b', 'c', 'd', 'e', 'u', 'y', 'c')
    val vowelsCount = calculateVowelCount(array5)
    println("Dizideki sesli harf sayısı: $vowelsCount")

    //6. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val num = 100 //istenen sayıyı burada belirttim
    val primeNumbersList = findPrimeNumbers(num)
    println("1 ile $num arasındaki asal sayılar:")
    println(primeNumbersList)

    //7. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val array7 = arrayOf("Merhaba", "", "Ben", "", "Umut", "Yusuf", "Çınar")
    val wordCount = calculateWordCount(array7)
    println("Dizideki toplam kelime sayısı: $wordCount")

    //8. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val array8 = arrayOf("Umut", "Yusuf", "Yusuf", "Çınar", "Çınar", "Çınar",)
    val mostFrequentlyRepeatedWord = findMostFrequentlyRepeatedWord(array8)
    println("Dizideki en sık tekrar eden kelime: $mostFrequentlyRepeatedWord")

    //9. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val firsString = "Yusuf"
    val secondString = "Çınar"
    val resultString = concateStrings(firsString, secondString)
    println(resultString)

    //10. fonksiyon için parametrelerin verilmesi ve fonskiyonun çağırılması
    val list = listOf<String>("1", "2", "3", "4", "5", "6", "9", "1")
    val set = setOf("3", "4", "5", "6", "7")
    val differentOfListAndSet = findTheDifferent(list, set)
    println("Liste ve set arasındaki fark (listede bulunmayan sette bulunan öğeler): $differentOfListAndSet")
}


//1. Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu

fun getEvenNumber(array: Array<Int>): MutableList<Int> {
    //listeyi mutableList alıp mutableList döndüreceğim
    var evenNumbersList = mutableListOf<Int>()

    for(number in array){
        if(number%2==0){
            evenNumbersList.add(number)
        }
    }

    return evenNumbersList
}


//2. Verilen bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan
//ve sonuçları bir harita(Map) olarak döndüren bir fonksiyon

fun letterFrequencyCalculator(array: Array<Char>): MutableMap<Char, Int> {
    val frequences = mutableMapOf<Char, Int>()

    for (letter in array){
        if(frequences.containsKey(letter)){
            //Derslerde getOrDefault metodunu kullanmadık diye hatırlıyorum
            // o yüzden manuel null kontrolü ile kodu yazacağım
            frequences[letter] = frequences[letter]!! + 1
        } else{
            frequences[letter] = 1
        }
    }

    return  frequences
}


//3. Verilen bir listenin elemanlarını tersine çeviren ve
//bu ters çevirilmiş listeyi döndüren fonksiyon

//listenin veri tipi belirtilmediği için ve
//gösterilmeyen konuları kullanmayın dediğiniz için
//generic yerine int kullanacağım hocam
fun reverse(list: List<Int>): List<Int>{
    val reversedList = mutableListOf<Int>()

    //listeyi tersten dolaşabilmek için listeyi for içinde ters çeviriyorum
    for (i in list.indices.reversed()){
        reversedList.add(list[i])
    }
    return reversedList
}


//4. Belirli aralıktaki tüm tek tamsayıları içeren bir dizi oluşturan bir fonksiyon.
//Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır.

fun createOddNumbersArrayFromRange(firstInt: Int, lastInt:Int): IntArray?{
    //kullanıcı tarafından bir giriş hatası olmasına karşın
    //bitiş değerinin başlanngıç değerinden büyüklüğünü kontrol edeceğim
    if(firstInt>=lastInt){
        println("Başlangıç değeri bitiş değerinden küçük olmalıdır!")
        return null
    }

    val range = ((lastInt-firstInt)/2) + 1
    //array eleman sayısı belirli bir yapı olduğundan burada range veriyorum
    val oddNumbersArray = IntArray(range)
    var index = 0

    for (i in firstInt..lastInt){
        if(i%2 != 0){
            oddNumbersArray[index] = i
            index++
        }
    }

    return oddNumbersArray
}


//5. Verilen bir dizideki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir fonksiyon

fun calculateVowelCount(array: CharArray): Int{
    //öncelikle ödevde belirtilen sesli harfleri dahil ediyorum
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var vowelsCount = 0

    for(letter in array){
        if(letter in vowels){
            vowelsCount++
        }
    }

    return  vowelsCount
}


//6. Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan fonksiyon

fun findPrimeNumbers(num:Int): List<Int>{
    val primeNumbers = mutableListOf<Int>()

    //for içerisinde until kullanarak 2 den belirtilen sınıra kadar dolaşacağım
    for(i in 2 until num){
        var isPrimeNumber = true

        //asallığı kontrol edeceğim bir for yazacağım
        for(j in 2 until i){
            if(i%j == 0){
                isPrimeNumber = false
                break
            }
        }//içerideki for sonu

        //sayı asal ise listeye ekliyorum
        if(isPrimeNumber){
            primeNumbers.add(i)
        }

    }//dışarıdaki for sonu

    return primeNumbers
}


//7. Verilen bir dizideki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon

fun calculateWordCount(array: Array<String>): Int{
    var wordCount = 0

    for(word in array){
        if(word.isNotBlank()){ //boşluk içermeyen kelimeleri sayıyorum
            wordCount++
        }
    }

    return wordCount
}


//8. Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren fonksiyon

fun findMostFrequentlyRepeatedWord(array: Array<String>): String{
    //dizideki kelimeleri ve tekrar sayılarını anahtar değer çifti
    //olarak tutabilmek için bir map oluşturuyorum
    var wordCounts = mutableMapOf<String, Int>()

    //dizideki kelimeleri dolaşıp her birinin tekrar sayısını hesaplıyorum
    for(word in array){
        //kelime zaten map içerisinde varsa, tekrar sayısını bir artırıyorum
        //aksi durumda ise yeni bir giriş oluşturup tekrar sayısını 1 olarak ayarlıyorum
        //bunun için getOrDefault metodundan faydalanıyorum
        wordCounts[word] = wordCounts.getOrDefault(word, 0) + 1
    }

    //en yüksek tekrar sayısını tutmak için bir değişken oluşturuyorum
    var mostFrequentlyRepeatedWordCount= 0

    //en sık tekrar edilen kelimeyi tutmak için bir değişken oluşturuyorum
    var mostFrequentlyRepeatedWord = ""

    //mapteki her girişi for ile dolaşıyorum
    for((word, repeatCount) in wordCounts){
        // Eğer bu kelimenin tekrar sayısı, şu ana kadar gördüğüm en yüksek tekrar sayısından büyükse
        // Bu kelimeyi en sık tekrar eden kelime olarak ayarlıyorum ve en yüksek tekrar sayısını güncelliyorum
        if(repeatCount > mostFrequentlyRepeatedWordCount){
            mostFrequentlyRepeatedWordCount = repeatCount
            mostFrequentlyRepeatedWord = word
        }
    }
    return mostFrequentlyRepeatedWord
}


//9. İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon.
//Ancak birleştirilen dizeler birbiriyle aynı harf sayısına sahipse
//bu dizeler büyük harflerle birleştirilmeli

fun concateStrings(string1: String, string2: String): String{
    var concatedString = ""
    if(string1.length == string2.length){
        concatedString = string1.uppercase() + string2.uppercase()
    }else{
        concatedString = string1 + string2
    }
    return  concatedString
}


//10. Bir liste ve bir set arasındaki farkı döndüren fonksiyon
//Yani, liste içinde bulunmayan ancak sette bulunan öğeleri tespit edecek

//veri tipi belirtilmediği için ve
//gösterilmeyen konuları kullanmayın dediğiniz için
////generic yerine String kullanacağım hocam
fun findTheDifferent(list: List<String>, set: Set<String>): Set<String>{
    //döndüreceğim fark için bir değişken tanımlıyorum
    val different = mutableSetOf<String>()

    for(element in set){
        //eğer set içerisindeki eleman listede yoksa farka ekliyorum
        if(!list.contains(element)){
            different.add(element)
        }
    }
    return  different
}