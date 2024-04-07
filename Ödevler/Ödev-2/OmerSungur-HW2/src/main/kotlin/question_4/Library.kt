package question_4

open class Library(
    bookList: List<Book>
) {
    private val allBook = bookList.toMutableList()

    fun printBookList() {
        println("Book List:")
        allBook.forEach { book ->
            println(book.bookName)
        }
    }

    fun addBook(bookList: List<Book>) {
        bookList.forEach { book ->
            allBook.add(book)
        }
    }

    fun filterBookByAuthor(authorName: String) {
        println("Filter book by author = $authorName:")
        val filteredBookList = allBook.filter { book ->
            authorName.contains(book.authorName, ignoreCase = true)
        }
        for (book in filteredBookList) {
            println(book.bookName)
        }
    }
}

