
/*
Verilen bir listenin elemanlarını tersine çeviren ve bu ters çevrilmiş listeyi
döndüren bir fonksiyon yazın
*/

fun main() {

    val wordsList = listOf("Turkcell","Kotlin","Yazılım","Android","Java")
    val numList = listOf<Short>(1,4,67,843,2)

    // sonuçları yazdırıyoruz
    println(reverseList(wordsList))
    println(reverseList(numList))

}

// istediğimiz türde lsite parametresi alan fonksiyon
fun<T> reverseList(wordlist:List<T>): List<T>{

    val reversedList = mutableListOf<T>()

    for (i in wordlist.size-1 downTo 0){  // liste elemanlarını tersten döndürüyoruz
        reversedList.add(wordlist[i])
    }
    return  reversedList

}