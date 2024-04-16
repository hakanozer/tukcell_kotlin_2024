class RegularCustomer(
    override val customerId: Int,
    override var customerName: String,
    override var customerEmail: String,
    override var customerPhone: String,
    var loyaltyPoints:Int
) : Customer(){

    val customerType:String = "Regular Customer"
}