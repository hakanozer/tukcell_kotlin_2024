package question_4

class AntalyaLibrary : Library {

    constructor(bookList: MutableList<Book>) : super(bookList) {
        this.bookList = bookList
    }

    override fun listBook() {
        super.listBook()
    }

    override fun addBook(book: Book) {
        super.addBook(book)
    }
    override fun findBooksOfAuthor(authorName: String): MutableList<Book> {
        return super.findBooksOfAuthor(authorName)
    }
}