class VIPCustomer(
    name: String,
    email: String,
    phoneNumber: String,
    override var customerId: String,
    private val vipLevel : Int
) : Customer(name,email,phoneNumber) {





    override fun toString(): String {
        return "\nMüşteri: $name" +
                "\nEposta: $email" +
                "\nTelefon Numarası: $phoneNumber" +
                "\nMüşteri ID: $customerId" +
                "\nVIP Seviyesi: $vipLevel\n"
    }
}