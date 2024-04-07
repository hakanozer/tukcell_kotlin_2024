package org.example

// Ürün sınıfı
data class Product(val name: String, val price: Double)

// Online alışveriş uygulaması sınıfı
class OnlineShop {
    private val userCarts: MutableMap<String, MutableList<Product>> = mutableMapOf()

    // Sepete ürün ekleyen metod
    fun addProductToCart(username: String, product: Product) {
        val cart = userCarts.getOrPut(username) { mutableListOf() }
        cart.add(product)
    }

    // Sepetten ürün çıkaran metod
    fun removeProductFromCart(username: String, product: Product) {
        val cart = userCarts[username]
        cart?.remove(product)
    }

    // Sepeti temizleyen metod
    fun clearCart(username: String) {
        userCarts.remove(username)
    }

    // Kullanıcının toplam harcamasını hesaplayan fonksiyon
    fun calculateTotalSpending(username: String): Double {
        val cart = userCarts[username]
        return cart?.sumOf { it.price } ?: 0.0
    }
}
