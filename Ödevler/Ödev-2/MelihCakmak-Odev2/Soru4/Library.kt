package Soru4

class Library {

    private val bookList = mutableListOf<Book>()

    fun addBook(book: Book) {
        bookList.add(book)
    }

    fun listOfBooks() :MutableList<Book>{
        println("--------------Books------------")
        for (book in bookList) {
            println("Author: ${book.author}, Book Name: ${book.name}")
        }
        return  bookList
    }

    fun booksByAuthor(author: String): List<Book> {
        println("Books of $author:")
        val filteredList: List<Book> =bookList.filter { it.author == author }
        println(filteredList.forEach {
            book->
            println(book.name)
        })
        return filteredList
    }
}
