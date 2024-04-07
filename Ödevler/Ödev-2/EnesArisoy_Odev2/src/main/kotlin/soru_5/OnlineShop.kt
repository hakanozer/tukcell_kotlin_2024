package org.example.soru_5

/**
 *  Bir online alışveriş uygulamasını temsil eden OnlineShop adında bir sınıf oluşturun. Bu
 * sınıf, kullanıcıların sepetlerini ve sepetlerindeki ürünleri içermelidir. Sepete ürün
 * eklemek, çıkarmak ve sepeti temizlemek için metodlar ekleyin. Ayrıca, kullanıcıların
 * toplam harcamalarını hesaplamak için bir fonksiyon ekleyin.
 */

class OnlineShop {
    val cart = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cart.add(product)
    }

    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    fun clearCart() {
        cart.clear()
    }

    fun calculateTotal(): Double {
        var total = 0.0
        for (product in cart) {
            total += product.price
        }
        return total
    }
}

