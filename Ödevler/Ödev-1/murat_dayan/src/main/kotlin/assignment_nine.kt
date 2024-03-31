
/*

İki dizeyi birleştiren ve sonucu döndüren bir fonksiyon yazın. Ancak, birleştirilen
dize birbiriyle aynı harf sayısına sahipse, bu dizeyi büyük harflerle
birleştirmelisiniz.

*/

fun main() {

    val word1 = "Turkcell"
    val word2 = "Kotlin"
    val word3 = "Software"

    println(combineStrings(word1,word3))

}

fun combineStrings(word1:String,word2:String):String{

    val combinedString = word1 + word2

    return  if (word1.length == word2.length) combinedString.toUpperCase() else combinedString
}