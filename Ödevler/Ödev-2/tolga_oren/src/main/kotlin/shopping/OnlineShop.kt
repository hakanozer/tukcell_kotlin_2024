package shopping

open class OnlineShop {

    protected val basket = mutableListOf<Product>()

    fun addProduct(product: Product) {
        basket.add(product)
    }

    fun removeProduct(product: Product) {
        basket.remove(product)
    }

    fun clearBasket() {
        basket.clear()
    }

    fun getProducts() : List<Product> {
        return basket.toList()
    }

    open fun totalPrice() : Double {
        var price = 0.0
        basket.forEach {
            price += it.price
        }
        return price
    }



}