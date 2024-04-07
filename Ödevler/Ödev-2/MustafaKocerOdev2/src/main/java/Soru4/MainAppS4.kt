package Soru4

fun main(){
    val book1 = Book("1984", "George Orwell", 328)
    val book2 = Book("Sapiens: Homo Deus", "Yuval Noah Harari", 443)
    val book3 = Book("To Kill a Mockingbird", "Harper Lee", 281)
    val book4 = Book("Pride and Prejudice", "Jane Austen", 432)
    val book5 = Book("The Catcher in the Rye", "J.D. Salinger", 277)
    val book6 = Book("The Great Gatsby", "F. Scott Fitzgerald", 218)
    val book7 = Book("Brave New World", "Aldous Huxley", 311)
    val book8 = Book("The Hobbit", "J.R.R. Tolkien", 310)
    val book9 = Book("The Lord of the Rings", "J.R.R. Tolkien", 1178)
    val book10 = Book("Crime and Punishment", "Fyodor Dostoevsky", 671)

    val bookList = mutableListOf(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10)

    val kutuphane = Library(bookList)
    val book11 = Book("The Alchemist", "Paulo Coelho", 208)
    kutuphane.kitaplariListele()

    kutuphane.kitapEkle(book11)

    kutuphane.kitaplariListele()


}