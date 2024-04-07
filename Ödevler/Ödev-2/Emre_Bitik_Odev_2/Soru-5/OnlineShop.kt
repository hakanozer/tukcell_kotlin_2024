// OnlineShop sınıfımız
class OnlineShop : Cart() {
    override fun addItem(item: Product) {
        super.addItem(item)
    }

    override fun removeItem(item: Product) {
        super.removeItem(item)
    }

    override fun clearCart() {
        super.clearCart()
    }

    override fun calculateTotal(): Double {
        return super.calculateTotal()
    }
}
