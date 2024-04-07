package Soru4

open class Book(val bookName: String, val year: Int, val author : String) {

    // Kitap tanımı
    open fun tanım()
    {
        println("$bookName , $author tarafından $year yılında yazılmıştır.")
    }

}