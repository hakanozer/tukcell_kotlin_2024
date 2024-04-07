package Soru4

class Library {

    private val book = mutableListOf<Book>()

    // Kitap ekleme
    fun addBook(books : Book)
    {
        book.add(books)
    }
    // Kitap Listeleme
    fun bookList()
    {
        if(book.isEmpty())
        {
            println("Kitap bulunamadı...")
        }

        book.forEach {
            println("${it.bookName} - ${it.author}")
        }
    }
    // Yazara göre listeleme
    fun authorWithList (author : String)
    {
        println("Yazarı : $author olan kitaplar :")
        book.filter { it.author == author }.forEach {
            println("${it.author} - ${it.bookName} - ${it.year}")
        }
    }
}