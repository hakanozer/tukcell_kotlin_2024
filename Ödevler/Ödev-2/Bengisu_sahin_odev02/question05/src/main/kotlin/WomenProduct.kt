class WomenProduct(name: String, price: Double, private val size: String = "xs,s,m,l") : Product(name, price) {
    // Prints a message with sizes of women's products specifically.
    override fun printSize() {
        println("Women sizes $size")
    }
}