package library

class Library(private val bookList: MutableList<Book>) {

    fun filterByAuthor(author: String) : List<Book>{
        return bookList.filter { it.author == author }
    }

    fun addBook(book: Book) {
        bookList.add(book)
    }

    fun getBooks() : List<Book> {
        return bookList.toList()
    }
}