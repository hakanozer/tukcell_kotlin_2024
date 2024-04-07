
fun main() {
    val shop = OnlineShop()

    /// Sepete urunlar ekleniyor
    shop.addToCart(Product("Laptop", 35000.0))
    shop.addToCart(Product("Koltuk", 5000.0))
    shop.addToCart(Product("Kulaklık", 1000.0))
    shop.addToCart(Product("Ekran", 3000.0))

    /// Sepeti yazdiriyoruz
    shop.listCartItems()

    /// Sepetten bir urun cikartmak
    val removedProduct = Product("Kulaklık", 100.0)
    shop.removeFromCart(removedProduct)
    println("\n${removedProduct.name} Sepetten Çıkarıldı")

    /// Silme isleminden sonra tekrar sepeti yazdiriyoruz
   shop.listCartItems()

    /// Sepet temizleniyor
    shop.clearCart()
    println("\nSepet Temizlendi")

    /// Toplam tutari duzgun gorebilmek icin clearCart Fonksyionunu silin
    /// Toplam sepet tutari gosteriliyor

    println("\nToplam Harcama: ${shop.calculateTotal()} TL")
}


data class Product(val name: String, val price: Double)

class OnlineShop {
    private val cart: MutableList<Product> = mutableListOf()

    /// Sepete urun eklemek
    fun addToCart(product: Product) {
        cart.add(product)
    }


    /// Sepetten urun cikarmak
    fun removeFromCart(product: Product) {
        cart.remove(product)
    }

    /// sepeti tamamen bosaltmak
    fun clearCart() {
        cart.clear()
    }

    /// toplam fiyat hesaplamak
    fun calculateTotal(): Double {
        return cart.sumOf { it.price } /// Listedeki double degerleri toplayan kotlin fonksyionu
    }

    /// Urun yazdirma islemini bircok kez disarida kullanacagimizden bir kere burada kullandim
    fun listCartItems() {
        if (cart.isEmpty()) {
            println("Sepetiniz boş.")
        } else {
            println("\nSepetteki Ürünler:")
            for ((index, product) in cart.withIndex()) {
                println("${index + 1}. Ürün: ${product.name}, Fiyat: ${product.price}")
            }
        }
    }
}

