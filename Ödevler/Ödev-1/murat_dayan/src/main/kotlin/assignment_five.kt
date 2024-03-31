
/*
Verilen bir dizideki sesli harflerin sayısını hesaplayan ve sonucu döndüren bir
fonksiyon yazın. (Sesli harfler: a, e, i, o, u)
*/

fun main() {

    val wordList = mutableListOf("Turkcell","Kotlin","Java","Yazılım","Android")

    val result = getNumberOfVowels(wordList)

    println(result)

}

fun getNumberOfVowels(list:List<String>) : Int{
    val vowels = "aeiıoöüu"  // sesli harfleri belirledik
    var count =0

    // 2 döngüyle hem liste elemanlarını hem de her elemanın harflerini döndürdük ve içindeki harfleri kontrol ettik sesliyse count'u  artırdık
    for (word in list){
        for (char in word){
            if (char in vowels){
                count++            }
        }
    }
    return  count
}






