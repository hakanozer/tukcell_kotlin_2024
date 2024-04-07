package question_4

open class Library {
    var bookList = mutableListOf<Book>()

    constructor(bookList: MutableList<Book>){
        this.bookList = bookList
    }

    open fun listBook(){
        bookList.forEach { book ->
            println("Id: ${book.id} Name: ${book.name} Author: ${book.author}")
        }
    }

    open fun addBook( book: Book) {
        bookList.add(book)
        println("Book with ${book.id} IDs added")
    }

    open fun findBooksOfAuthor(authorName: String) : MutableList<Book> {
        var books = mutableListOf<Book>()
        bookList.forEach {book ->
            if (book.author == authorName){
                books.add(book)
            }
        }
        return books
    }

}