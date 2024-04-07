data class Book(val title: String, val release: Int, val author: String) {
    override fun toString(): String {
        return "$title - $author - $release"
    }
}