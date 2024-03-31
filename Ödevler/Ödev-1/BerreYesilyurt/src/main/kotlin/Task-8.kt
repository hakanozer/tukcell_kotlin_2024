package org.example

fun main() {

    val wordsArray= arrayOf<String>("Götür küpü", "dök", "küpü", "Getir küpü", "dök küpü")

    findMostUsedWord(wordsArray) // Kelime dizisini fonksiyona gönderdik

}

fun findMostUsedWord(wordsArray:Array<String>):String{
    var wordsList= mutableListOf<String>() // Tüm kelimelerin ayrılarak tek bir kelime olarak tutulduğu yer

    wordsArray.forEach {
        if(it.contains(" ")){ // Tüm cümleler, ya da tek kelimeler bir listede birleştirilir. Küçük harfe çevrilerek
            var words=it.split(" ")
            wordsList.addAll(words) // Kelimeler listeye eklenir
        }
        else{
            wordsList.add(it)
        }
    }

    wordsList.replaceAll{ it.toLowerCase() } // Büyük harfli kelimeler farklı kelime olarak algılanmasın diye hepsini küçük harfe dönüştürüyoruz

    val usedWordsNumbers=wordsList.groupingBy { it }.eachCount() // Her kelimeden kaç tane olduğunu gruplar
    var maxValue=0 // Max kez tekrarlanan kelime sayısını tutan değişken
    var wordOfMaxValue="" // Max kez tekrarlanan kelimeyi tutan değişken


    for((key,value) in usedWordsNumbers){ // Her elemanının value değerine bakar ve max olanı alır
        if(value>maxValue){
            maxValue=value
            wordOfMaxValue=key
        }
    }

    return wordOfMaxValue // En sık tekrarlanan kelime döndürülür
}