package org.example.soru_4

fun main() {
    val book1 = Book("Game Of Thrones", "George R. R. Martin")
    val book2 = Book("1984", "George Orwell")
    val book3 = Book("Harry Potter", "J.K. Rowling")
    val book4 = Book("House of the Dragon", "George R. R. Martin")
    val book5 = Book("Sefiller", "Victor Hugo")

    val library = Library()
    library.addBook(book1)
    library.addBook(book2)
    library.addBook(book3)
    library.addBook(book4)
    library.addBook(book5)

    library.listBooks()

    println()

    library.listBooksByAuthor("George R. R. Martin")
}