package Soru5

class OnlineShopping {
    private val cart = mutableListOf<Product>()

    fun addProduct(product: Product) {
        cart.add(product)
    }

    fun removeProduct(product: Product) {
        cart.remove(product)
    }

    fun clearCart() {
        cart.clear()
    }

    fun getTotalCost(): Double {
        val sum:Double=cart.sumOf {product->

            product.price }
        println("Total Cost: $sum")
        return sum
    }


    fun printProducts() {
        cart.forEach {
                product ->
            println("Ürün ID: ${product.productID}")
            println("Ürün Adı: ${product.name}")
            println("Ürün Fiyatı: ${product.price}\n")
        }
    }



}