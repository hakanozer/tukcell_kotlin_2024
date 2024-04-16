class VIPCustomer(
    override var name: String,
    override var email: String,
    override var phoneNumber: String,
    var vipLevel:Int
) : Customer() {

    override fun toString(): String {
        return "${getCustomerId()} ID, $name, $email, $phoneNumber, Vip Level: $vipLevel"
    }
}