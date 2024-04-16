package soru_5

open class User(val username: String) {
    val shoppingCart = mutableListOf<String>()

    fun addToCart(item: String) {
        shoppingCart.add(item)
    }

    fun removeFromCart(item: String) {
        shoppingCart.remove(item)
    }

    fun clearCart() {
        shoppingCart.clear()
    }

    fun calculateTotalCost(): Double {
        // Burada sepetinizdeki ürünlerin toplam maliyetini hesaplayabilirsiniz
        // Bu örnekte sadece öğe sayısını dikkate alıyoruz
        return shoppingCart.size * 10.0 // Her bir öğe 10 birim maliyetinde olsun varsayalım
    }
}