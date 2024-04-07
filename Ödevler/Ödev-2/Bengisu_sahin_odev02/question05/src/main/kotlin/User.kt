class User(val username: String) {
    // A mutable list was used because the same product could be added more than once.
    var userBasket = mutableListOf<Product>()
}