package question_4

class Library: LibraryTransaction {

    val books = mutableListOf<Book>()
    override fun addBook(book: Book) {
        books.add(book)
    }

    override fun getAllBooks(): List<Book> {
        return books
    }

    override fun getBooksByAuthor(author: String) :List<Book> {
        return books.filter {
            it.bookAuthor == author
        }
    }
}