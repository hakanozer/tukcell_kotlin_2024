package question_5

abstract class CartTransaction {

    abstract fun addToCart(user: User, product: Product)

    abstract fun removeFromCart(userId: Int, productId: Int)

    abstract fun clearUserCart(userId: Int)

    abstract fun calculateUserSpend(userId: Int): Int

}