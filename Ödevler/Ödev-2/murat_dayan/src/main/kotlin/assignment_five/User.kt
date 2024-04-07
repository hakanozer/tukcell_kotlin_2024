package assignment_five

class User(userName:String) : OnlineShop() {

    init {
        super.baskets.clear()
    }

    // dynamic polymorphism ile sepete ürün ekleme ve çıkarma
    override fun addBasket(product: Product) {
        super.baskets.add(product)
    }

    override fun getOutOfBasket(productId: Int) {
        super.baskets.map { product ->
            if (product.productId == productId){
                super.baskets.remove(product)
            }
        }
    }
    override fun cleanBasket() {
        super.baskets.clear()
    }

    fun calculateTotalAmount() : Int{
        var count = 0
        super.baskets.onEach { product ->
            count += product.productPrice
        }
        return count
    }
}