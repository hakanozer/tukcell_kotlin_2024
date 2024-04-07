package soru5

class PremiumUserShop : OnlineShop() {
    override fun addToCart(username: String, product: String, price: Double) {
        val originalPrice = users[username]?.get(product) ?: price
        val discountedPrice = price * 0.8
        super.addToCart(username, product, discountedPrice)
        println("Premium üye indirimi kazandınız. Önceki fiyat: $originalPrice TL, Yeni fiyat: $discountedPrice TL")
    }

    override fun removeFromCart(username: String, product: String) {
        val userCart = users[username]
        if (userCart != null) {
            val productPrice = userCart[product]
            if (productPrice != null) {
                super.removeFromCart(username, product)
                println("Ürün iade edildiği için hediye kaldırıldı.")
            } else {
                println("$username kullanıcısının sepetinde $product ürünü bulunmamaktadır.")
            }
        } else {
            println("$username kullanıcısının bir sepeti bulunmamaktadır.")
        }
    }
}