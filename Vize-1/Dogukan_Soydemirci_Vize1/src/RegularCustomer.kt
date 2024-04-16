class RegularCustomer(name: String, email: String, phoneNumber: String, val loyaltyPoints: Int) : Customer(name, email, phoneNumber) {
    override val customerId: String = generateCustomerId()

    private fun generateCustomerId(): String {

        return "REGULAR : ${(100..1000).random()}"
    }
}