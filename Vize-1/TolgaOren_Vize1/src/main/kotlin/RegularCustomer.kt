class RegularCustomer(
    name: String,
    phoneNumber: String,
    email: String
) : Customer(name, phoneNumber, email) {

    var loyaltyPoints = 0

    override fun toString(): String {
        val info = "Customer Info:\n" +
                "id: $id\n" +
                "name: $name\n" +
                "phone number: $phoneNumber\n" +
                "email: $email\n" +
                "loyalty points: $loyaltyPoints\n"
        return info
    }
}