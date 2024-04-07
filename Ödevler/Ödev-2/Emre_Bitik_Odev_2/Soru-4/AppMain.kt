
fun main() {
    val library = Library()

    // Kitapları kütüphaneye ekleme
    library.addBook(Book("Bavula Sığmayan", "Nermin Yıldırım"))
    library.addBook(Book("Ev", "Nermin Yıldırım"))
    library.addBook(Book("Şaka Makinesi", "Alexander McCall Smith"))
    library.addBook(Book("Kas Makinesi", "Alexander McCall Smith"))
    library.addBook(Book("11. Kat","Jane Casey"))
    library.addBook(Book("Ölüme Terk Edilenler", "Jane Casey"))
    library.addBook(Book("Çırak", "Şermin Yaşar"))
    // Tüm kitapları listeleme
    library.listBooks()
    // Belirli bir yazarın kitaplarını listeleme
    println(" Şeçilen Yazarın Kitapları")
    library.listBooksByAuthor("Nermin Yıldırım")
}