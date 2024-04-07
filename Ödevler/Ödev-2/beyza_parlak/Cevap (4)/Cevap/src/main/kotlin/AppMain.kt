fun main(){
    // burada library için bir object oluşturuyorum
    val library = Library()

    // object içerisine kitap-yazar verilerini ekliyorum
    library.addBook("1984",                 "George Orwell")
    library.addBook("The Hobbit",           "J.R.R. Tolkien")
    library.addBook("Pride and Prejudice",  "Jane Austen")
    library.addBook("Don Quijote",          "Miguel de Cervantes")

    // Library() sınıfından listBooks() metodunu çağırıyorum, Kütüphanedeki kitapları listeleyecek
    library.listBooks()

    println("-------------------------------------------------")

    // Library() sınıfından bookFilter() metodunu çağırıyorum, verilen yazarın kitaplarını listeleyecek
    library.bookFilter("George Orwell")



}