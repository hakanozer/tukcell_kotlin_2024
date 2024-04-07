class Library() {
    // kitap - yazar verilerini tutmak için mutablemap oluşturuyorum
    val books: MutableMap<String,String> = mutableMapOf()

    // listeye kitapları eklemek için fonk yazıyorum. parametre olarak kitap-yazar alınacak ve eşitlenecek
    fun addBook(book: String, author: String){
        books[book] = author
    }

    // kitapları listelemek için fonk yazıyorum. listenin içi boş ise kitap bulunamadı
    // değilse for ile listeyi gezinip çıktı olarak kitap-yazar verecek
    fun listBooks() {
        if (books.isEmpty()) {
            println("Kütüphanede kitap bulunamadı.")
        } else {
            println("Kütüphanedeki kitaplar: ")
            for ((book, author) in books) {
                println("$book - $author")
            }
        }
    }

    // verilen bilgiye göre yazar filtreleme işlemi yapacağım ve dönüş olarak birden fazla kitao olmak ihtimalinden dolayı liste döndüreceğim
    fun bookFilter(author: String): List<String> {
        // listede yazarın adının karşılığında kitao var ise keys verecek
        val bookFilter = books.filterValues {
            it == author
        }.keys.toList()
        if (bookFilter.isEmpty()) {
            println("$author kütüphanede kitabı bulunamadı.")
        } else { // kitaplari listeleyecek, for döngüsü ile
            println("$author yazarın kitapları: ")
            for (book in bookFilter) {
                println(book)
            }
        }
        return bookFilter
    }
}