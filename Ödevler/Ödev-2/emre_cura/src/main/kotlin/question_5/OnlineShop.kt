package question_5

class OnlineShop {
    val basket = Basket()

    fun addToBasket(product: Product) {
        basket.addProduct(product)
    }

    fun removeFromBasket(product: Product) {
        basket.removeProduct(product)
    }

    fun clearBasket() {
        basket.removeAllProducts()
    }
    fun totalPrice(): Double {
        return basket.totalCost()
    }

    fun printElements(){
        basket.products.forEach {
            println("{ID: ${it.id} - Name: ${it.name} - Price: ${it.price}} ")

        }
    }
}