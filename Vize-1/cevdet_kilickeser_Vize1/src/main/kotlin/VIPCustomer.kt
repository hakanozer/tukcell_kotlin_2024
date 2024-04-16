class VIPCustomer(
    override val customerId: Int,
    override var customerName: String,
    override var customerEmail: String,
    override var customerPhone: String,
    var vipLevel:Int
) : Customer() {

    val customerType:String = "VIP Customer"
}