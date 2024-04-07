package question_5

class OnlineShop : CartTransaction() {

    val userCart = mutableListOf<UserCart>()

    override fun addToCart(user: User, product: Product) {
        val existingUserCart = userCart.find { it.user == user }
        if (existingUserCart != null) {
            existingUserCart.userProduct.add(product)
        } else {
            val newUserCart = UserCart(user, mutableListOf(product))
            userCart.add(newUserCart)
        }
    }

    override fun removeFromCart(userId: Int, productId: Int) {
        val userCart = userCart.find { it.user.userId == userId }
        userCart?.let {
            it.userProduct.removeIf { product -> product.productId == productId }
        }
    }

    override fun clearUserCart(userId: Int) {
        val userCartIndex = userCart.indexOfFirst { it.user.userId == userId }
        if (userCartIndex != -1) {
            userCart.removeAt(userCartIndex)
        }
    }

    override fun calculateUserSpend(userId: Int): Int {
        val userCart = userCart.find { it.user.userId == userId }
        return userCart?.userProduct?.sumBy { it.productPrice } ?: 0
    }
}