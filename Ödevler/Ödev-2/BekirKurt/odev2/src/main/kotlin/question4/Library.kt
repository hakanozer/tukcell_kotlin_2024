class Library {
    private val books: MutableList<Book> = mutableListOf()

    // add book
    fun addBook(book: Book) {
        books.add(book)
    }

    // list books
    fun listBooks() {
        if (books.isEmpty()) {
            println("books not found")
        } else {
            println("books in library:")
            println("------------------------")
            books.forEach { println(it) }
        }
    }

    // list books by author name
    fun listBooksByAuthor(author: String) {
        val authorBooks = books.filter { it.author == author }
        if (authorBooks.isEmpty()) {
            println("not found $author's books")
        } else {
            println("$author's books:")
            authorBooks.forEach { println(it) }
        }
    }
}
