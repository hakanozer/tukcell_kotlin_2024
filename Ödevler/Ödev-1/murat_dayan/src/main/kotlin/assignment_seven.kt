
/*
Verilen bir dizideki kelime sayısını hesaplayan ve sonucu döndüren bir fonksiyon
yazın

*/

fun main() {

    val wordsList = arrayOf<String>("Turkcell","Kotlin","Android","Yazılım","Java")

    val result = getNumberOfWord(wordsList)
    println(result)
}

fun getNumberOfWord(list:Array<String>) : Int{

    var count=0

    list.onEach {
        count +=1
    }
    return count
}