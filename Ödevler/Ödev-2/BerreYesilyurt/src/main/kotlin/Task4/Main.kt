package org.example.Task4

fun main() {

    val libray=Library()

    val book1=Book("Falaka","Ömer Seyfettin",89)
    val book2=Book("Suç ve Ceza","Dostoyevski",600)
    val book3=Book("Bir Yufka Yürekli","Dostoyevski",400)
    val book4=Book("Momo","Michael Ende",300)
    val book5=Book("Simyacı","Paulo Coelho",289)

    libray.addBook(book1)
    libray.addBook(book2)
    libray.addBook(book3)
    libray.addBook(book4)
    libray.addBook(book5)

    println(libray.booksOnLibrary)

    libray.booksOnLibrary.forEach {
        println(it.name)
    }

    val a=libray.listBookByWriter("Dostoyevski")

    a.forEach {
        println(it.name)
        println(it.writer)
    }

}