class OnlineShop {
    // Since there will be more than one user, a user list was created.
    private val users = mutableListOf<User>()

    // It can be added the user to the user list in this shop
    fun addUser(user: User) {
        users.add(user)
    }

    // It can be deleted the user from the user list in this shop
    fun removeUser(user: User) {
        users.remove(user)
    }

    // Thanks to mutable list, it easily adds the product to the user basket.
    fun addProductToBasket(user: User, product: Product){
        user.userBasket.add(product)
    }

    fun removeProductFromBasket(user: User, product: Product){
        user.userBasket.remove(product)
    }

    fun resetBasket(user: User) {
        user.userBasket.clear()
    }

    fun calculateBasket(user: User) {
        var totalPrice = 0.0
        // It browses products in basket using foreach and then sum their prices
        user.userBasket.forEach { product ->
            totalPrice += product.price
        }
        println("Total price of ${user.username}'s basket: $totalPrice")
    }
}