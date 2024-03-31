/// 1. Soru
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val evenNumberArrayList = evenNumberMaker(list)

    println("Dizideki çift sayılar: $evenNumberArrayList")
}

fun evenNumberMaker(evenNumberParameterArray: List<Int>): List<Int> {
    /// Listeye ekleme islemi yapabilmek icin mutable bir liste olusturuyoruz
    val evenNumbers = mutableListOf<Int>()
    /// Parametre olarak alacagimiz listenin icindeki elemanlari
    /// 2 ye kalansız bolunenleri olusturdugumuz mutable listeye ekliyoruz
     for (item in evenNumberParameterArray) {
        if (item % 2 == 0) {
            evenNumbers.add(item)
        }
}
    return evenNumbers
    }