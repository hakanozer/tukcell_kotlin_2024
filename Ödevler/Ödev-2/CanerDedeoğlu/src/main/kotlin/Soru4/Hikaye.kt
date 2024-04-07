package Soru4

import java.time.Year

class Hikaye(bookName: String, year: Int,author: String) : Book(bookName, year , author,) {

    // Tanım
    override fun tanım() {

        println("$bookName hikayesi , $author tarafından $year yılında yazılmıştır.")
    }
}