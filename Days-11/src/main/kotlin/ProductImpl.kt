import kotlin.random.Random


class ProductImpl : IProduct, IBasket {

    override var name: String = ""
        get() = field
        set(value) { field = value}

    override fun addProduct(product: Product): Product {
        product.pid = Random.nextInt(100)
        return product
    }

    override fun removeProduct(pid: Int): Int {
        return Random.nextInt(100)
    }

    override fun addBasket(product: Product): Boolean {
        return false
    }

}