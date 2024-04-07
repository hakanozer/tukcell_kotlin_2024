package assignment_four

fun main() {



    val library = Library()
    library.addBook("Suç Ve Ceza","Dostoyevski")
    library.addBook("Yeraltından Notlar","Dostoyevski")
    library.addBook("Kuyucaklı Yusuf")

    val bookList = library.getBookList()

    /*bookList.forEach { book->
        println(book.bookName)
    }*/

    val dostoyevskiBooks = library.getBooksByAuthor("Dostoyevski")

    dostoyevskiBooks.onEach { book ->
        println(book.bookName)
    }


}