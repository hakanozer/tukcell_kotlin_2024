import kotlin.math.max


fun main() {
    var num = intArrayOf(1,2,4,6,12,43,25,56,76,43,67,1231,678,9876,1002) //  İnteger Dizi tanımlama
    var word =  arrayOf("apple","pen","fruit","new","word","element","open","animal","home","new","new","new","apple","home")//string dizi tanımlama
    var word2 ="Java dilinden aşina olduğumuz üzere, her fonksiyonun ait olduğu bir sınıf vardı. Kotlin dilinde ise, fonksiyonel programlamanın desteklenmesi sebebiyle sınıflara bağımlı olmayan fonksiyonlar yazabileceğimizi söylemiştik."
    val TheList = mutableListOf<String>("salt","new","can","world","fit")
    val numStart = 5
    val numStop = 200
    var s="merhaba"
    var s1="Merhaba"

    evenNumber(num)//fonsiyon çağırma işlemi
    repeatCharCount(word)
    turnOver(TheList)
    oddNum(numStart,numStop)
    vowelCount(word)
    İsPrime(numStop)
    var count =wordCount(word2)
    var maxRepeat = repeatWord(word)
    println("7. Soru Dizideki kelime sayısı : $count")
    println("8. Soru Dizideki en çok tekrar eden kelime: ${maxRepeat}")
    var stringComb=combination(s,s1)
    println("9. Dize Birleştirme : $stringComb")
    val arrayList = differenceListAndSet()

    println("10. Soru Liste ve Set arasındaki fark $arrayList")
}

//============ 1. Soru ============
//Çift bulma fonsiyonu
fun evenNumber(array: IntArray){

    val evenList = mutableListOf<Int>() // Liste tanımalam
for (item in array ){
    //dizi for dongüsüne alınır
    if (item % 2 == 0){// if yapısında dizi mod 2 ile kontrol edilir.

        evenList.add(item)// koşulu sağlayan elamanlar listeye eklenir
    }
}
    //Çift sayılardan oluşan listemizin ekrana bastırılması
    println("1. Soru Dizideki çift sayılar")
    for (item in evenList){
      print("$item , ")

    }
    println()

}
//============ 2. Soru ============
//Dizideki  harf adetlerini bulma
val charCountMap = mutableMapOf<Char,Int>() // map tanımı
fun repeatCharCount(array: Array<String>){
    var str =""
    for (item in array){
    str = str+item
    //Diziyi birleştirme
    }


    for (item in str) { // birleştirilen dizi içindeki geçen harf adetleri sayma
        var count = 0
        for (i in str.indices) {
            if (str[i] == item ) {
                count++
            }
        }
        charCountMap[item] = count
    }


    println("2. Soru Harf Adetleri:")
    charCountMap.forEach { (key, value) ->
        println("'$key'  harfinden : $value adet kullanılmıştır ")
    }


}
//
fun  turnOver(list: MutableList<String> = mutableListOf()){
//============ 3. Soru ============
//Listeyi ters çevirme
println("3. Soru Listenin ters hali")
println(list.asReversed())// liste ters çevrirme methodu

}
//============ 4. Soru ============
//Tek Sayı üretici

fun oddNum(num:Int,num2:Int){
    var i = 0
    val arrayNum = Array<Int>((num2-num+1)/2){0} // Sarı aralıgına uygun dizi üretme
    for (item in num..num2){ //verilen aralıgı döngüye alma

        if (item % 2 == 1){ // tek sayıları ayrıştırma
            arrayNum[i] = item
            i++
        }

    }
    println("4. Soru dizideki tek sayılar")
    for (item in arrayNum){
        print("$item , ")

    }

}
//============ 5. Soru ============
fun vowelCount(array: Array<String>){
    println()
    print("5. Soru Sesli harf adetleri")
    var str =""
    for (item in array){
        str = str+item
        //Diziyi birleştirme
    }
    var a =0
    var e = 0
    var i = 0
    var o = 0
    var u = 0

    for (item in str){
        if (item =='a'){
            a++;
        } else if (item =='e'){
            e++;
        }else if (item =='i'){
            i++;
        }else if (item =='o'){
            o++;
        }else if (item =='u'){
            u++;
        }
    }
    println()
    println("a  adeti : $a")
    println("e  adeti : $e")
    println("i  adeti : $i")
    println("o  adeti : $o")
    println("u  adeti : $u")

}
//============ 6. Soru ============
fun  İsPrime(num: Int){

var isPrimeList = mutableListOf<Int>()

println("6. Soru Asal Sayılar : ")
    for (num in 2..num) {
        var isPrime = true
        for (i in 2..num/2) {
            if (num % i == 0) {
                isPrime = false
                break
            }
        }

        if (isPrime)
            isPrimeList.add(num)
    }
println(isPrimeList)
}
//============ 7. Soru ============

fun wordCount(words:String):Int{
    var count =0
    for (item in words){
        if (item ==' '){
          count++;
        }
    }
    return count+1
}

//============ 8. Soru ============
fun repeatWord(array: Array<String>): String{
    var wordCount = mutableMapOf<String, Int>()
    for(word in array){
        wordCount[word] = wordCount.getOrDefault(word, 0)+1 // var olanı getirme yoksa default değer  olarak 0 atama
    }
    var mostRepeatWordCount= 0
    var mostRepeatWord = ""
    for((word, repeatCount) in wordCount){
        if(repeatCount > mostRepeatWordCount){
            mostRepeatWordCount = repeatCount
            mostRepeatWord = word
        }
    }
    return mostRepeatWord
}
//============ 9. Soru ============
fun  combination(s:String,s1:String):String{
    var sc=s.length //dize uzunlugu bulma
    var sc1 =s1.length
    var comb="" // boş dize
    if (sc==sc1){ // dize uzunluk karşılaştırma
       comb= s.capitalize()+s1.capitalize() // kelimeleri büyük harf ile birleştir
    }
    else{
        comb = s+s1 // normal birleştirme
    }
    return comb
}
//============ 10. Soru ============
fun  differenceListAndSet():ArrayList<String>{
    val theList = listOf("Elma","Armut","Muz","Çilek","Karpuz")
    val theSet = setOf("Armut","Muz","Çilek")
    val arrayList = ArrayList<String>() // Fark listesi
    for (item in theList){
        if (item !in theSet){
            //listte olupta sette olmayanlar
            arrayList.add(item)
        }

    }

    return arrayList
}

