package assignment_four

open class Library {

    var books = mutableListOf<Book>()


    fun addBook(bookName:String){
        var newId = 0
        if (books.isNotEmpty()){
            newId = books.last().bookId +1
        }
        val newBook = Book(newId,bookName)
        books.add(newBook)
    }

    fun addBook(bookName:String,bookAuthor:String){
        var newId = 0
        if (books.isNotEmpty()){
            newId = books.last().bookId +1
        }
        val newBook = Book(newId,bookName,bookAuthor)
        books.add(newBook)
    }
    fun getBookList(): List<Book> {
        return books
    }

    fun getBooksByAuthor(authorName:String) : List<Book>{

        val result = books.filter { book ->
            book.bookAuthor == authorName
        }
        return result
    }

}