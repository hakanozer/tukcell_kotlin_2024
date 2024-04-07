package soru4

open class Library {

    companion object {
        private val bookList = mutableListOf<Book>()

        fun getAllBook() = bookList

        //Author'a göre filtreleme yapılmaktadır.
        fun filteredBook(author: String) = bookList.filter { it.author == author }
    }

    //Bu fonksiyon sayesinde listeye book eklenmektedir.
    //Bu fonksiyon protected olarak oluşturulmuş olup sadece Book sınıfında çağırılması amaçlanmıştır.
    //Book sınıfından her nesne oluşturulduğunda fonksiyon tetiklenmektedir.
    protected fun addBook(book: Book) = bookList.add(book)



}