fun main() {

    //randomArray fonksiyonu ile uzunluğunu parametre olarak verdiğimiz random dizi oluşturabiliriz(isteğe bağlı)
    //kesinlikle sayı dizisi istendiğinden, yapı int primitiv tipli diziyle kurgulanmıştır

    //val myArray = randomArray(5)

    val myArray = intArrayOf(1, 2, 3, 4, 5)
    evenNumberSearcher(myArray)


}

//verilen int dizisi üzerinde gezen ve çiftleri arayan fonksiyon
fun evenNumberSearcher(intArray: IntArray) {

    val evenList = mutableListOf<Int>()

    for (index in intArray) {

        //çiftleri bulup listeye ekle
        if (index.mod(2) == 0) {
            evenList.add(index)
        }
        //println(index) isteğe bağlı
        println(index)
    }
    println(evenList)

}

//istediğiniz uzunlukta rastgele bir rakam dizisi üreten fonksiyon
fun randomArray(length: Int): IntArray {

    val rArray = IntArray(length) { (0..9).random() }


    return rArray
}