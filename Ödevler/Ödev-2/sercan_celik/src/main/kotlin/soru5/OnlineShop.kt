package soru5

open class OnlineShop {
    val users = mutableMapOf<String, MutableMap<String, Double>>()
    open fun addToCart(username: String, product: String, price: Double) {
        val userCart = users.getOrPut(username) {
            mutableMapOf()
        }
        userCart[product] = price
        println("$product ürünü $username kullanıcısının sepetine eklendi.")
    }

    open fun removeFromCart(username: String, product: String) {
        if (users.containsKey(username)) {
            val userCart = users[username]
            if (userCart != null) {
                if (userCart.remove(product) != null) {
                    println("$product ürünü $username kullanıcısının sepetinden çıkarıldı.")
                } else {
                    println("$username kullanıcısının sepetinde $product ürünü bulunmamaktadır.")
                }
            }
        } else {
            println("$username kullanıcısının bir sepeti bulunmamaktadır.")
        }
    }

    fun clearCart(username: String) {
        if (users.containsKey(username)) {
            users[username]?.clear()
            println("$username kullanıcısının sepeti temizlendi.")
        } else {
            println("$username kullanıcısının bir sepeti bulunmamaktadır.")
        }
    }

    open fun calcTotal(username: String): String? {
        val userCart = users[username]
        val total = userCart?.values?.sum()
        return total?.toString() + " TL"
    }
}
