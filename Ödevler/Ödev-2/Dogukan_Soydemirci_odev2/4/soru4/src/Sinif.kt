open class Book(val title: String, val author: String) {
    override fun toString(): String {
        return "$title by $author"
    }
}

class Library {
    private val books: MutableList<Book> = mutableListOf()

    fun kitapEkle(book: Book) {
        books.add(book)
    }

    fun kitaplariListele() {
        if (books.isEmpty()) {
            println("Kütünphane boş")
        } else {
            println("Kütüphanedeki kitaplar: ")
            for (book in books) {
                println(book)
            }
        }
    }

    fun yazarKitaplariListele(author: String) {
        val yazarinKitaplari = books.filter { it.author == author }
        if (yazarinKitaplari.isEmpty()) {
            println("Bu yazar icin kitap bulunamadi: $author.")
        } else {
            println("Kitaplarin yazari: $author:")
            for (book in yazarinKitaplari) {
                println(book)
            }
        }
    }
}

fun main() {
    val library = Library()

    val book1 = Book("Book1", "Author1")
    val book2 = Book("Book2", "Author2")
    val book3 = Book("Book3", "Author1")
    val book4 = Book("Book4", "Author3")

    library.kitapEkle(book1)
    library.kitapEkle(book2)
    library.kitapEkle(book3)
    library.kitapEkle(book4)

    library.kitaplariListele()

    println()

    library.yazarKitaplariListele("Author1")
}
