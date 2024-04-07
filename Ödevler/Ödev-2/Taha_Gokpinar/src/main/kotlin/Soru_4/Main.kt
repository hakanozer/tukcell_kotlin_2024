package Soru_4

fun main() {

    val library = Library()
    val yearLibrary = LibraryYear()

    val book1 = Book("Mai ve Siyah","Halit Ziya", 1897)
    val book2 = Book("Eylül","Mehmet Rauf",1900)

    library.addBook(book1)
    library.addBook(book2)

    poliCall(library)
    println("==================")
    poliCall(yearLibrary)
}

fun poliCall(library: Library){
    library.listBooks()
    println("==================")
    library.listBooks("Namık Kemal")
}