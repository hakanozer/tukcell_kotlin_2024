
class Library {
    val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun listBooks() {
        if (books.isNotEmpty()) {
            println("Kitaplar : ")
            books.forEach { println(it) }
        } else {
            println("Kitap Bulunamadı:")
        }
    }

    fun listBooksByAuthor(author: String) {
        val authorBooks = books.filter { it.author.equals(author, ignoreCase = true) }
        if (authorBooks.isNotEmpty()) {

            authorBooks.forEach { println(it) }
        } else {
            println("$author Yazarının kitabı yok ")
        }
    }
}
