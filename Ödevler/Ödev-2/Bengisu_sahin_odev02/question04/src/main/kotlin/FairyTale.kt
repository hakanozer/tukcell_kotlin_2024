class FairyTale(
    title: String,
    author: String,
    private val genre: String = "Fairy Tale" ) :Book(title, author) {
    override fun print() {
        println("This book's genre is $genre")
    }
}