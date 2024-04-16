package org.example

class VIPCustomer(name: String, email: String, phoneNumber: String, var vipLevel: Double) : Customer(name, email, phoneNumber) {
    override val customerId: String = generateCustomerID()

    private fun generateCustomerID(): String {
        val random = (10000..99999).random()
        return "ID-${random}-${vipLevel}"
    }

    fun increaseVipLevel(level: Int) {
        vipLevel += level
    }
}