package org.example
// 4. Soru
class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun listBooks() {
        println("\nKütüphanedeki kitapler:")
        books.forEach { println(it) }
    }

    fun listBooksByAuthor(authorName: String) {
        println("$authorName tarafından yazılmış kitaplar:")
        val booksByAuthor = books.filter { it.authorName == authorName }
        if (booksByAuthor.isNotEmpty()) {
            booksByAuthor.forEach { println(it) }
        } else {
            println("$authorName adına kiatap bulunamamıştır")
        }
    }
}