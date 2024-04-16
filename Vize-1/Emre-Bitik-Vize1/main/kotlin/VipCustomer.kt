class VIPCustomer(
    customerId : String,
    name: String,
    email: String,
    phoneNumber: String,

    val vipLevel: Int
) : Customer(customerId,name, email, phoneNumber) {
    override fun toString(): String {
        return super.toString() + "\nVip Seviyesi: $vipLevel"
    }
}