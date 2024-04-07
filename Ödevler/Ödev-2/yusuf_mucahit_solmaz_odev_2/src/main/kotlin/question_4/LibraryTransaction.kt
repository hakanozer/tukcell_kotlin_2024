package question_4

interface LibraryTransaction {

    fun addBook(book: Book)

    fun getAllBooks() : List<Book>

    fun getBooksByAuthor(author:String) :List<Book>
}