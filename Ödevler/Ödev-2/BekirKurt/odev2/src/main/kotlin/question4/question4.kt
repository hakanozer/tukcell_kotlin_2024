fun main() {
    val library = Library()

    // add books
    library.addBook(Book("Sinekli Bakkal",1912,"Halide Edib Adıvar"))
    library.addBook(Book("Saatleri Ayarlama Enstitüsü",1961,"Ahmet Hamdi Tanpınar"))
    library.addBook(Book("Kürk Mantolu Madonna",1943," Sabahattin Ali"))
    library.addBook(Book("Huzur",1949,"Ahmet Hamdi Tanpınar"))
    library.addBook(Book("Hanımın Çiftliği",1949,"Orhan Kemal"))


    // list books in library
    library.listBooks()

    // list
    // authors books
    println("------------------------")
    library.listBooksByAuthor("Ahmet Hamdi Tanpınar")
}