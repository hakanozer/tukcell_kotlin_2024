fun main() {
    val book = Book("Fareler ve İnsanlar", "John Steinbeck")
    val book2 = Novel("Türkan", "Ayşe Kulin")
    val book3 = Book("Toplum Sözleşmesi", "Jean Jacques Rousseau")
    val book4 = Book("Aeden", "Azra Kohen")

    val books = mutableListOf(book,book2,book3,book4)

    val bookList = Library(books)
    bookList.addNewBook(FairyTale("La Fontaine Masalları","Jean de La Fontaine"))
    books[4].print()

    bookList.listBooks()

    bookList.listAuthorBooks("Azra Kohen")
}