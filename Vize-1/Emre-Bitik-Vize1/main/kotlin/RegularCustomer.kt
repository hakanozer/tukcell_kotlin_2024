class RegularCustomer(
    customerId : String,
    name: String,
    email: String,
    phoneNumber: String,

    val loyaltyPoints: Int
) : Customer(customerId,name, email, phoneNumber) {
    override fun toString(): String {
        return super.toString() + "\nSadakat Puanı: $loyaltyPoints"
    }
}