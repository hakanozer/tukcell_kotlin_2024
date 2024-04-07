

fun main() {
    // OnlineShop örneği oluştur
    val onlineShop = OnlineShop()

    // Ürünler oluşturma
    val product1 = Product("Kazak", 99.99)
    val product2 = Product("Atkı", 45.99)
    val product3 = Product("Jean Pantolon", 199.99)
    val product4 = Product("Kumaş Pantolon", 199.99)
    val product5 = Product("Ceket", 499.99)
    val product6 = Product("Çorap", 29.99)
    val product7 = Product("Kravat", 79.99)
    val product8 = Product("Papyon", 79.99)
    val product9 = Product("Gömlek", 109.99)


    // Ürünleri sepete ekleme
    onlineShop.addItem(product1)
    onlineShop.addItem(product3)
    onlineShop.addItem(product5)

    // Sepeti listele
    println("Sepetim :")
    onlineShop.items.forEach { println("${it.name}: ${it.price}") }

    // Toplam tutarı hesapla
    println("\nSepet Toplam Tutarı :: ${onlineShop.calculateTotal()}")

    // Sepeti temizle
    onlineShop.clearCart()
    println("Sepet Temizlendi")
}
