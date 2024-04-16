package org.example

class RegularCustomer(
    private var loyaltyPoints: Int,
    customerName: String,
    customerEmail: String,
    customerTelNo: String
) : Customer(
    customerName,
    customerEmail,
    customerTelNo
) {
    // Eğer müşteri ürün alırsa fiyatına göre bir sadakat puanı kazanacaktır.
    fun buyProduct(productPrice: Int) {
        when (productPrice) {
            in 0..100 -> {
                loyaltyPoints += 100
            }

            in 100..500 -> {
                loyaltyPoints += 350
            }

            in 500..10000 -> {
                loyaltyPoints += 900
            }
        }
        println("Loyalty Points: $loyaltyPoints")
    }

    // Abstract içindeki toString fonksiyonuna ek olarak sadakat puanını da ekledim.
    override fun toString(): String {
        return super.toString() + "\nLoyalty Points: $loyaltyPoints"
    }
}