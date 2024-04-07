package question_4

fun main() {



    val bookList = arrayOf(
            Book("Masumiyet Müzesi", "Orhan Pamuk"),
            Book("Kara Kitap", "Orhan Pamuk"),
            Book("Sefiller", "Victor Hugo"),
            Book("Dom Quixote", "Miguel de Cervantes"),
            Book("Yerdeniz Üçlemesi", "Ursula K. Le Guin"),
            Book("Suç ve Ceza", "Fyodor Dostoyevski"),
            Book("Karamazov Kardeşler", "Fyodor Dostoyevski"),
            Book("Harry Potter ve Felsefe Taşı", "J.K. Rowling"),
            Book("Harry Potter ve Zümrüdüanka Yoldaşlığı", "J.K. Rowling"),
            Book("Göçebe", "Khaled Hosseini")
    )

    val library = Library()

    for(book in bookList){
        library.addBook(book)
    }

    val books = library.getAllBooks()

    books.forEach {
        book ->

        println("Book: ${book.bookName} Author: ${book.bookAuthor}")
    }

    /*
    Output:

    Book: Masumiyet Müzesi Author: Orhan Pamuk
    Book: Kara Kitap Author: Orhan Pamuk
    Book: Sefiller Author: Victor Hugo
    Book: Dom Quixote Author: Miguel de Cervantes
    Book: Yerdeniz Üçlemesi Author: Ursula K. Le Guin
    Book: Suç ve Ceza Author: Fyodor Dostoyevski
    Book: Karamazov Kardeşler Author: Fyodor Dostoyevski
    Book: Harry Potter ve Felsefe Taşı Author: J.K. Rowling
    Book: Harry Potter ve Zümrüdüanka Yoldaşlığı Author: J.K. Rowling
    Book: Göçebe Author: Khaled Hosseini
*/

    val desiredBook = library.getBooksByAuthor("J.K. Rowling")

    desiredBook.forEach {
        desiredBook->

        println("Book: ${desiredBook.bookName} Author: ${desiredBook.bookAuthor}")
    }

    /*
    Output:

    Book: Harry Potter ve Felsefe Taşı Author: J.K. Rowling
    Book: Harry Potter ve Zümrüdüanka Yoldaşlığı Author: J.K. Rowling
    */


}