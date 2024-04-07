// Ürün sınıfımız
open class Product(val name: String, val price: Double)

// Sepet sınıfımız
open class Cart {
    val items: MutableList<Product> = mutableListOf()

    open fun addItem(item: Product) {
        items.add(item)
    }

    open fun removeItem(item: Product) {
        items.remove(item)
    }

    open fun clearCart() {
        items.clear()
    }

    open fun calculateTotal(): Double {
        return items.sumByDouble { it.price }
    }
}
