class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun kitapListele(): List<Book> {
        return books
    }
    fun yazarinKitaplariniListele(author: String): List<Book> {
        return books.filter { it.author == author }
    }

}