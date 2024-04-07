class OnlineShop {
    private val userBasket: MutableMap<String, Basket> = mutableMapOf()

    // create basket
    fun createUserBasket(userId: String, userCart: Basket) {
        userBasket[userId] = userCart
    }
}