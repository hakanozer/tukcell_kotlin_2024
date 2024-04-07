package soru5

class OnlineShop {

    private val basket = mutableListOf<Product>()

    fun addBasket(product: Product) = basket.add(product)

    fun removeBasket(id: Int) = basket.removeIf { it.id == id }

    fun clearBasket() = basket.clear()

    fun totalPrice(): Double = basket.map { it.price }.reduce { acc, price -> acc + price }

    fun getBasket() = basket

}