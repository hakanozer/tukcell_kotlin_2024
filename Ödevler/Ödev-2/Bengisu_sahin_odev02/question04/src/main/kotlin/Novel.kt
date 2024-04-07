class Novel(
    title: String,
    author: String,
    private val genre: String = "Novel" ) : Book(title, author) {
    override fun print() {
        println("This book's genre is $genre")
    }
}