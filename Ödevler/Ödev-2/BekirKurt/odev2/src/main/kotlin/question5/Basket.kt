open class Basket {
    protected val products: MutableList<Product> = mutableListOf()

    // add to basket product
    open fun addToBasket(product: Product) {
        products.add(Product(product.name, product.price))
    }

    // list basket
    fun listBasket(){
        if(products.isEmpty()){
            println("There are no products in the basket")
        }
        for (product in products){
            println(product.name)
        }
    }

    // remove product from basket
    open fun removeFromBasket(productName: String) {
        val productToRemove = products.find { it.name == productName }
        productToRemove?.let { products.remove(it) }
    }

    // clear basket
    open fun clearBasket() {
        products.clear()
    }

    // total price
    open fun calculateTotalPrice(): Double {
        return products.sumOf { it.price }
    }
}