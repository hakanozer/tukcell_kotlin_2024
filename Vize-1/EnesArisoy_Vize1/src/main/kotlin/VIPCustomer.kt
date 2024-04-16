package org.example

class VIPCustomer(
    override val customerId: String,
    override val name: String,
    override val email: String,
    override val phoneNumber: String,
    private val vipLevel: Int
) : Customer() {

    override fun toString(): String {
        return super.toString() + "\nVIP Level: $vipLevel"
    }

}