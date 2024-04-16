package org.example

class VipCustomer(
    private val vipLevel: Int,
    customerName: String,
    customerEmail: String,
    customerTelNo: String
) : Customer(
    customerName,
    customerEmail,
    customerTelNo
) {
    // Müşterinin vip seviyesine göre indirim uygula (vip level 1-5 arasında bir değer alır)
    fun discountBasedOnVIPLevel() {
        when (vipLevel) {
            1 -> {
                println("10% discount applied to cart")
            }

            2 -> {
                println("20% discount applied to cart")
            }

            3 -> {
                println("30% discount applied to cart")
            }

            4 -> {
                println("40% discount applied to cart")
            }

            5 -> {
                println("50% discount applied to cart")
            }
        }
    }

    // Abstract içindeki toString fonksiyonuna ek olarak vip seviyesini de ekledim.
    override fun toString(): String {
        return super.toString() + "\nVip Level: $vipLevel"
    }
}