class VIPCustomer(
    name: String,
    phoneNumber: String,
    email: String
) : Customer(name, phoneNumber, email) {

    var vipLevel = 0

    override fun toString(): String {
        val info = "Customer Info:\n" +
                "id: $id\n" +
                "name: $name\n" +
                "phone number: $phoneNumber\n" +
                "email: $email\n" +
                "vip level: $vipLevel\n"
        return info
    }
}