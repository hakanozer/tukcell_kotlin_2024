package org.example.soru_4

/**
 *  Bir kitap kütüphanesini temsil eden Library adında bir sınıf oluşturun. Bu sınıf,
 * kütüphanedeki kitapların bir listesini içermeli ve yeni kitapları eklemek ve mevcut
 * kitapları listelemek için metodlar içermelidir. Ayrıca, belirli bir yazarın kitaplarını
 * listelemek için bir fonksiyon ekleyin.
 */

class Library {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun listBooks() {
        println("Kütüphanedeki Kitaplar:")
        books.forEach { it.displayDetails() }
    }

    fun listBooksByAuthor(author: String) {
        println("$author tarafından yazılan kitaplar:")
        val booksByAuthor = books.filter { it.author == author }
        if (booksByAuthor.isEmpty()) {
            println("Bu yazarın kütüphanede kitabı bulunmamaktadır.")
        } else {
            booksByAuthor.forEach { it.displayDetails() }
        }
    }
}


