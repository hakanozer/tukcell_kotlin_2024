class RegularCustomer(
    override var name: String,
    override var email: String,
    override var phoneNumber: String,
    var loyaltyPoints: Int
) : Customer() {

    override fun toString(): String {
        return "${getCustomerId()} ID, $name, $email, $phoneNumber, Loyalty points: $loyaltyPoints"
    }
}