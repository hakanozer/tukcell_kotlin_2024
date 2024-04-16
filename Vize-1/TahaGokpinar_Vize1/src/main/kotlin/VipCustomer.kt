class VipCustomer(
    name: String,
    email: String,
    phoneNumber: Number,
    customerId: String,
    val vipLevel : Int

) : Customer(name, email, phoneNumber,  customerId) {

    init {
        displayName()
    }

    override fun toString(): String {
        return super.toString() + "\n Customer VIP Level: $vipLevel"
    }

    override fun displayName() {
        name = this.name.uppercase()
    }

}