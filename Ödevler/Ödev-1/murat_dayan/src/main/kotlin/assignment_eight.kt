
/*
Verilen bir dizideki en sık tekrar eden kelimeyi bulan ve bu kelimeyi döndüren bir
fonksiyon yazın.
*/

fun main() {

    val wordList = listOf<String>("Turkcell","Kotlin","Java","Java","Android","Java","Kotlin")

    mostFrequentWord(wordList)

}

fun mostFrequentWord(wordsList: List<String>){

    var freq = 0
    var res = ""

    // liste boyutuna kadar sayı döndürür
    for (i in 0..wordsList.size){
        var count=0

        // her sayı için i değerinden bi fazlasını listeye göre döndürür
        for (j in i+1 until wordsList.size){

            // eğer j değerindeki indexin karşılık değeri i'ninkine eşitse aynıdır der ve tekrar sayısını artırır
            if (wordsList[j].equals(wordsList[i])){
                count++
            }
        }
        // dönen tekrar değeri mevcut en çok tekrar sayısından büyükse mevcutu artırır
        if (count>freq){
            res = wordsList[i]
            freq = count
        }
    }

    println(res)
}