package question_5

class Basket {
    val products = mutableListOf<Product>()

    fun addProduct(product: Product){
        products.add(product)
    }
    fun removeProduct(product: Product) {
        products.remove(product)
    }

    fun removeAllProducts(){
        products.clear()
    }

    fun totalCost(): Double {
        var total = 0.0
        for (product in products) {
            total += product.price
        }
        return total
    }
}