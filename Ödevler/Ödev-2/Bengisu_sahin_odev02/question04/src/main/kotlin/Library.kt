class Library(private val books: MutableList<Book>) {

    fun addNewBook(book: Book){
        books.add(book)
    }

    // Thanks to foreach, it browses the books in the library and displays name and author information.
    fun listBooks(){
        books.forEach {
            println("Book's title : ${it.title} - Book's author: ${it.author} ")
        }
    }

    fun listAuthorBooks(author: String){
        // It filters authors according to the given author name using filter func.
        val listAuthorBooks = books.filter { it.author == author }
        // If the author has a book, this control shows the author's books.
        if (listAuthorBooks.isNotEmpty()){
            println("\nThe $author's book:")
            listAuthorBooks.forEach {
                println(it.title)
            }
        } else {
            println("$author has not a book in this library.")
        }
    }

}