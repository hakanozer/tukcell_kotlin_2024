package soru4

open class Library {
    private val books = mutableMapOf<String, String>()

    open fun addBook(title: String, author: String) {
        books[title] = author
        println("$title kitabı kütüphaneye eklendi.")
    }

    open fun listBooks() {
        if (books.isEmpty()) {
            println("Kütüphanede hiç kitap yok.")
        } else {
            println("Kütüphanedeki Kitaplar:")
            for ((title, author) in books) {
                println("$title - $author")
            }
        }
    }

    open fun listOfBooksByAuthor(author: String) {
        val authorBooks = books.filter {
            it.value.equals(author, ignoreCase = true)
        }
        if (authorBooks.isEmpty()) {
            println("$author adlı yazarın kitapları bulunmamaktadır.")
        } else {
            println("$author adlı yazarın Kitapları:")
            for ((title) in authorBooks) {
                println(title)
            }
        }
    }
}