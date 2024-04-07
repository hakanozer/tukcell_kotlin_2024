package org.example.soru_5

fun main() {
    val product1 = Product("Kulaklık", 199.50)
    val product2 = Product("Klavye", 160.0)
    val product3 = Product("Mouse", 99.0)

    val onlineShop = OnlineShop()
    onlineShop.addToCart(product1)
    onlineShop.addToCart(product2)
    onlineShop.addToCart(product3)

    println("Sepetteki Ürünler:")
    onlineShop.cart.forEach { it.displayDetails() }

    println("Toplam Tutar: ${onlineShop.calculateTotal()}")

    onlineShop.removeFromCart(product2)

    println("${product2.name} Sepetten Çıkarıldı.")
    println("Güncel Sepet:")
    onlineShop.cart.forEach { it.displayDetails() }

    onlineShop.clearCart()
    println("Sepet Temizlendi.")
}
