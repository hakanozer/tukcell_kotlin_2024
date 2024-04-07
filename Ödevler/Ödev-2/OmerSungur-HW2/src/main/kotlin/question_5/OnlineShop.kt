package question_5

class OnlineShop(private val user: User) {
    private val productList = mutableListOf<Product>()

    fun addToBasket(mProductList: List<Product>) {
        mProductList.forEach { product ->
            productList.add(product)
        }
    }

    fun removeFromBasket(mProductList: List<Product>) {
        mProductList.forEach {
            productList.remove(it)
        }
    }

    fun clearBasket() {
        productList.clear()
    }

    fun calculateTotalPrice() {
        var totalPrice = 0.0
        productList.forEach {
            totalPrice += it.productPrice
        }
        println("Total Price: $$totalPrice")
    }

    fun printBasketInfo() {
        println("*** BASKET *** \nUser Name: ${user.userName}")
        if (productList.isNotEmpty()) {
            println(productList.joinToString { product ->
                "${product.productName} = $${product.productPrice}"
            })
        }
    }
}