package Soru_4

open class Library {

    var books: MutableList<Book> = mutableListOf<Book>()

    init {
        createBooks()
    }

    fun createBooks(){
        val libraryBooks = listOf(
            Book("İntibah", "Namık Kemal",1876),
            Book("Cezmi", "Namık Kemal",1880),
            Book("Sergüzeşt", "Samipaşazade Sezai", 1887),
            Book("Araba Sevdası", "Recaizade Mahmut Ekrem", 1898),
            Book("Don Kişot", "Miguel de Cervantes", 1605),
            Book("Romeo ve Juliet", "William Shakespeare",1597),
            Book("Sefiller", "Victor Hugo", 1862),
            Book("Suç ve Ceza", "Fyodor Dostoevsky",1866),
            Book("Karamazov Kardeşler", "Fyodor Dostoyevski", 1880)
        )
        books.addAll(libraryBooks)
    }

    fun addBook(book: Book){
        books.add(book)
    }

    open fun listBooks(){
        println("Kütüphanedeki kitaplar: ")
        for (it in books){
            println("${it.name} - ${it.author}")
        }
    }

    open fun listBooks(author: String){
        println("$author adlı yazarın kitapları: ")
        for(it in books){
            if (it.author == author){
                println(it.name)
            }
        }
    }
}