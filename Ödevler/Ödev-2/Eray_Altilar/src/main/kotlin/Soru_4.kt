fun main() {
    val library = Library()

    // Kütüphaneye kitaplar ekleniyor
    library.addBook(Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling"))
    library.addBook(Book("The Lord Of The Rings", "J.R.R Tolkien"))
    library.addBook(Book("Olasılıksız", "Adam Fawer"))
    library.addBook(Book("Tapınak", "Kate Mosse"))
    library.addBook(Book("Başlangıç", "Dan Brown"))
    library.addBook(Book("Da Vinci Şifresi", "Dan Brown"))

    // Kütüphanedeki tüm kitaplar listeleniyor
    println("Kütüphanedeki Tüm Kitaplar:")
    val allBooks = library.listAllBooks()
    for (book in allBooks) {
        println("Başlık: ${book.title}, Yazar: ${book.author}")
    }

    println("============================== ")

    // Belirli bir yazarın kitapları listeleniyor
    val author = "Dan Brown"
    println("\n$author'nin Kitapları:")
    val booksByAuthor = library.listBooksByAuthor(author)
    for (book in booksByAuthor) {
        println("Başlık: ${book.title}, Yazar: ${book.author}")
    }
}


data class Book(val title: String, val author: String)

class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun listAllBooks(): List<Book> {
        return books.toList()
    }

    fun listBooksByAuthor(author: String): List<Book> {
        return books.filter { it.author == author }
    }
}

