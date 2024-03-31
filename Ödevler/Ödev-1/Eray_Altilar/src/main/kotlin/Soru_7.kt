/// Soru 7
fun main() {
    val list = listOf("Eray", "Altilar", "Ahmet", "Veli" )

    val wordData = wordCounter(list)
    println("Dizideki toplam kelime sayısı: ${wordData.wordCount}")
    println("Dizideki kelimeler:")
    wordData.words.forEach { println(it) }
}
/// wordCounter fonksyionu parametre olarak listeyi aliyoruz
/// Ardindan size kullanarak kac elemandan olustugunu buluyoruz
fun wordCounter(list: List<String>): WordData {
    val wordCount = list.size
    return WordData(wordCount, list)
}

/// 2 farkli veri turunu dondurmek icin kendimize bir data Class olusturuyoruz
data class WordData(val wordCount: Int, val words: List<String>)