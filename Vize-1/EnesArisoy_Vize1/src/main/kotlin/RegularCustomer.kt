package org.example

class RegularCustomer(
    override val customerId: String,
    override val name: String,
    override val email: String,
    override val phoneNumber: String,
    private val loyaltyPoints: Int
) : Customer() {

    override fun toString(): String {
        return super.toString() + "\nLoyalty Points: $loyaltyPoints"
    }
}