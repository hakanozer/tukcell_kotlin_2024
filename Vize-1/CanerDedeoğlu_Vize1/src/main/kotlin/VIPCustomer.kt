class VIPCustomer (customerId : Int, customerName : String, customerMail: String, customerPhoneNumber : String, customerCity : String, var vipLevel : String )
    : Customer (customerId, customerName , customerMail , customerPhoneNumber , customerCity) {

    override fun toString(): String {

        return super.toString() + "Vip Level : $vipLevel"
    }
}