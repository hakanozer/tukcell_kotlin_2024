class RegularCustomer(customerId : Int, customerName : String, customerMail : String, customerPhoneNumber: String, customerCity:String, var loyaltyPoint : Int)
    : Customer(customerId , customerName , customerMail , customerPhoneNumber , customerCity)
{

    override fun toString(): String {
        return super.toString() + "Loyalty Point : $loyaltyPoint"
    }
}