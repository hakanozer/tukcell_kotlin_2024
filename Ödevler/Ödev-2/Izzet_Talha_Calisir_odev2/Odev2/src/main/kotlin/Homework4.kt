package org.example

// Kitap sınıfı
data class Book(val title: String, val author: String)

// Kütüphane sınıfı
class Library {
    private val books: MutableList<Book> = mutableListOf()

    // Yeni bir kitap ekleyen metod
    fun addBook(book: Book) {
        books.add(book)
    }

    // Mevcut kitapları listeleme metod
    fun listBooks() {
        println("Books in the library:")
        books.forEach { println("- ${it.title} - ${it.author}") }
    }

    // Belirli bir yazarın kitaplarını listeleme fonksiyonu
    fun listBooksByAuthor(author: String) {
        println("Books that $author named author:")
        val filteredBooks = books.filter { it.author == author }
        if (filteredBooks.isNotEmpty()) {
            filteredBooks.forEach { println("- ${it.title}") }
        } else {
            println("Couldnt find specified author.")
        }
    }
}