import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {

//Soru1--Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu yazın.

question1_find_even(list = arrayOf<Int>(1,2,3,4,5))

//Soru2--Verilen bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan ve sonuçları map olarak döndüren bir fonksiyon yazın

question2_find_repeat("Denememmeeeeee")

//Soru3--Verilen bir listenin elemanlarını tersine çeviren ve bu ters çevrilmiş listeyi döndüren bir fonksiyon yazın
question3_reverse_list(listOf<Int>(1,2,3,4,5,6,7,8,9))

/*Soru4--Belirli bir aralıktaki tüm tek sayıları içeren bir dizi oluşturan bir fonksiyon yazın.
* Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır.*/
    question4_odd_numbers_in_range(start = 1, end = 11)

//Soru5--Verilen bir dizideki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir fonksiyon yazın(a,e,i,o,u)
question5_vowels("Bu bir deneme yazisidir")

//Soru6--Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon yazın
question6_prime_numbers(10)

//Soru7--Verilen bir dizideki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon yazın.
question7_word_count("Turkcell geleceği yazanlar kotlin bootcampinin ilk ödevidir.")

//Soru8--Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir fonksiyon yazın.
question8_word_frequency("deneme deneme kotlin turkcell")

//Soru9--İki dizeyi birleştiren ve sonucu döndüren fonksiyon.Ancak,birleştirilen dize birbiriyle aynı harf
//sayısına sahipse ,bu diezyi büyük harflerle birleştirmelisiniz.

question9_string_concatenation("deneme yazısı","deneme yazısı")

//Soru10--Bir liste ve set arasındaki farkı döndüren bir fonksiyon yazın
println(question10_difference(list_ = listOf<String>("Deneme","Kargaşa"),set_=setOf<String>("Deneme")))

    
}


//--------------------------------------------------------------------------------------------

fun question1_find_even(list: Array<Int>){
    val new_list=list.filter { it%2==0 }

    println("Çift Sayılar--"+new_list)
}
//--------------------------------------------------------------------------------------------

fun question2_find_repeat(str:String):Map<Char,Int>{
    val newMap= mutableMapOf<Char,Int>()

        str.forEach {
            character->
            if (newMap.contains(character)){
                newMap[character]=newMap[character]!!+1
            }
            else{
                newMap[character] = 1
            }
        }


    println("Kullanılan harf sayıları--$newMap")
    return newMap
    }

//--------------------------------------------------------------------------------------------
fun question3_reverse_list(list: List<Any>): MutableList<Any> {
    val newList= mutableListOf<Any>()

    for (i in list.size-1 downTo 0){
        newList.add(list[i])
    }
    println("Yeni Liste: $newList")
    return newList


}

//--------------------------------------------------------------------------------------------

fun question4_odd_numbers_in_range(start:Int,end:Int):List<Int>{
    val oddNumbers= mutableListOf<Int>()
    for (i in start..end){
        if (i%2==1) oddNumbers.add(i)
    }
    println("$start ile $end arasındaki tak sayılar: "+oddNumbers)
    return oddNumbers
}
//---------------------------------------------------------------------------------------------

fun question5_vowels(str: String):Int{
    var count:Int=0
    val chars= arrayOf('a','e','i','o','u')


        str.forEach {
            c: Char ->
            if (chars.contains(c)){
               count++
            }
        }

    println("Sesli harf sayısı : $count")
    return count
}

//---------------------------------------------------------------------------------------------

fun question6_prime_numbers(limit:Int){
    val primeNumbers= mutableListOf<Int>()

    for(i in 2..limit){
        var isPrime=true


        for (a in 3 until  i){

            if (i%a==0){
                isPrime=false
                break
            }


        }
        if (isPrime) primeNumbers.add(i)

    }

    println("Bu aralıktaki asal sayılar: "+primeNumbers)



}

//---------------------------------------------------------------------------------------------

fun question7_word_count(string:String):Int{
    var counter=1
    string.forEach {
        character->
        if(character==' ') counter++
    }
    println("Verilen dizideki kelime sayısı: $counter")
    return counter


}
//---------------------------------------------------------------------------------------------


fun question8_word_frequency(string:String):String{

    val wordCountMap= mutableMapOf<String,Int>()
   val wordList= string.split(" ")
    var word_temp=wordList[0]
    wordList.forEach {
        word->
        if(wordCountMap.contains(word)){
            wordCountMap[word]=wordCountMap[word]!!+1

        }
        else{
            wordCountMap[word]=1
        }

    }
     wordCountMap.forEach { pair->
         if (pair.value>wordCountMap[word_temp]!!){
             word_temp=pair.key
         }

     }
    println("En sık tekrar eden kelime: $word_temp")

    return  word_temp

}
//---------------------------------------------------------------------------------------------


fun question9_string_concatenation(string1: String,string2: String):String{
    var result=""
    if (string2.length!=string1.length){
        result=string1+string2
    }
    else{
        result =string1+string2.uppercase()
    }
    println(result)
    return  result
}
//---------------------------------------------------------------------------------------------

fun question10_difference(list_:List<Any>,set_: Set<Any>):List<Any>{

    return list_.minus(set_.toList())
}



