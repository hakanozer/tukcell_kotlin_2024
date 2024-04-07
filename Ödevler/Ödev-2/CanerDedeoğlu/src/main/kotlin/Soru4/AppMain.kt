package Soru4

fun main() {

    val library = Library()

    library.addBook(Roman("ÇalıKuşu",1923 ,"Recep Nuri Güntekin" ))
    library.addBook(Roman("Devlet Ana", 1967, "Kemal Tahir"))
    library.addBook(Roman("Eylül", 1900, "Mehmet Rauf"))
    library.addBook(Hikaye("Bir Serencam", 1950, "Yakup Kadri Karaosmanoğlu"))
    library.addBook(Hikaye("Milli Savaş Hikayeleri", 1975, "Yakup Kadri Karaosmanoğlu" ))
    library.addBook(Hikaye("Otlakçı", 1975, "Memduh Şevket Esendal" ))

    library.bookList()

    println("=============================================================")

    library.authorWithList("Yakup Kadri Karaosmanoğlu")
}