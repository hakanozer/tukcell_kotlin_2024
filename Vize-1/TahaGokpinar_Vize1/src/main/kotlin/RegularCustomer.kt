class RegularCustomer(
    name: String,
    email: String,
    phoneNumber: Number,
    customerId: String,
    val loyaltyPoints : Int

) :Customer(name, email, phoneNumber, customerId) {

    init {
        displayName()
    }

    override fun toString(): String {
        return super.toString() + "\n Customer Loyalty Point: $loyaltyPoints"
    }

    override fun displayName() {
        name = this.name.lowercase()
    }
}