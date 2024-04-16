class VIPCustomer(name: String, email: String, phoneNumber: String, val vipLevel: Int) : Customer(name, email, phoneNumber) {
    override val customerId: String = generateCustomerId()

    private fun generateCustomerId(): String {

        return "VIP : ${(10..100).random()}"
    }
}
