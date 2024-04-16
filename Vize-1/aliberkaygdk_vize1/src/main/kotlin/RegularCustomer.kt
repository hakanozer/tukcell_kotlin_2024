class RegularCustomer(
    name: String,
    email: String,
    phoneNumber: String,
    override var customerId: String,
    private val loyaltyPoints : Int,
) : Customer(name,email,phoneNumber) {




    override fun toString(): String {
        return "\nMüşteri: $name" +
                "\nEposta: $email" +
                "\nTelefon Numarası: $phoneNumber" +
                "\nMüşteri ID: $customerId" +
                "\nSadakat Puanı: $loyaltyPoints\n"
    }

}