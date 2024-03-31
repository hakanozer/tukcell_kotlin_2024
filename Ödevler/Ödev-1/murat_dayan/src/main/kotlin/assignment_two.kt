import java.util.*

/*
Verilen bir dizideki her bir harfin kaç kez tekrarlandığını
hesaplayan ve sonuçları bir harita (Map) olarak döndüren bir fonksiyon yazın
*/

fun main() {

    val wordsList = listOf("Tturkcell:","Yaz.ılım","Kotçlin","Java","Android","İntellij Idea")

    val result = getCharNumbers(wordsList)

    println(result)
}

fun getCharNumbers(list:List<String>) : Map<Char,Int>{
    val charMap = mutableMapOf<Char,Int>()
    for (word in list){
        val regex = Regex("[ -.,?!;:']") // kelimelerdeki harf olmayan karakterleri tanır
        val wordWithoutSpacesOrPunctuation = word.replace(regex, "") // bu  harf olmayan karakterleri kaldırırız
        for(char in wordWithoutSpacesOrPunctuation.lowercase(Locale.getDefault())){ // listedeki tüm kelimelerin harflerini küçük yaptık ve char olarak döndürüyoruz
            val count = charMap.getOrDefault(char,0)+1 // her harf key olur, keydeki value değerini alır ve key zaten varsa artırır yoksa yeni key oluşturur 1 ekler
            charMap[char] = count // oluşturulan key değerine count'u yazdırır
        }
    }
    return charMap
}