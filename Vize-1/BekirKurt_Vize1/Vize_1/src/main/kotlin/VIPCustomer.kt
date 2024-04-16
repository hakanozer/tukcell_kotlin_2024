class VIPCustomer(customerId: String, name: String, email: String, phoneNumber: String,location: String, val vipLevel: Int) :
    Customer(customerId, name, email, phoneNumber, location) {
    override fun toString(): String {
        return super.toString() + "\nVIP Level: $vipLevel"
    }
}