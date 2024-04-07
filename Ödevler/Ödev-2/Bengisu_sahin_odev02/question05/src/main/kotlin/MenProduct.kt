class MenProduct(name: String, price: Double, private val size:String = "s,m,l,xl,xxl") : Product(name, price) {
    // Prints a message with sizes of men's products specifically.
    override fun printSize() {
        println("Men size's are $size ")
    }
}