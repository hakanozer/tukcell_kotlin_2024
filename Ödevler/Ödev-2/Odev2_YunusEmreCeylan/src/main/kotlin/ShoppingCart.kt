package org.example


//5. Soru
    class ShoppingCart {
        private val cart = mutableMapOf<String, Double>()

        fun addItemToCart(item: String, price: Double) {
            if (cart.containsKey(item)) {
                // Eğer ürün sepette varsa, miktarını artttır
                cart[item] = cart.getValue(item) + price
            } else {
                cart[item] = price
            }
            println("$item sepete eklendi.")
        }

        fun removeItemFromCart(item: String) {
            if (cart.containsKey(item)) {
                cart.remove(item)
                println("$item sepetten çıkarıldı.")
            } else {
                println("$item sepettek yok.")
            }
        }

        fun clearCart() {
            cart.clear()
            println("Sepet temizlendi.")
        }

        fun calculateTotalAmount(): Double {
            var totalSpent = 0.0
            cart.values.forEach { totalSpent += it }
            return totalSpent
        }
    }
