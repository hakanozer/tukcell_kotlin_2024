package org.example

class RegularCustomer(name: String, email: String, phoneNumber: String, var loyaltyPoints: Int) : Customer(name, email, phoneNumber) {
    //loyaltyPoint i var olarak tuttum çünkü daha sonradan güncellenebilir olması için
    override val customerId: String = generateCustomerID()

    private fun generateCustomerID(): String {
        val random = (10000..99999).random()
        return "ID-${random}-${loyaltyPoints}"
    }

    fun increaseLoyaltyPoints(points: Int) {
        loyaltyPoints += points

        if(loyaltyPoints >= 1000){
            println("${name} isimli müşterinin puanları VIP'ye yükseltilmek için yeterli.\n")
        }
    }
}