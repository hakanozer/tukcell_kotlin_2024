interface ICustomer {

    fun addCustomer(
        customerId:String,
        customerName:String,
        customerEMail:String,
        customerPhone:String,
    ) : Customer?


    fun updateCustomer(
        customerId:String,
        customerName:String,
        customerEMail:String,
        customerPhone:String,
    ) :Customer?


    fun becomeVipCostumer(
        customerId:String,
    ) : VIPCustomer?

    fun increaseLoyaltyPoint(customerId:String, pointsToAdd: Int)

    fun removeCustomer(customerId: String)

    fun increaseVipLevel(customerId:String,targetLevel:Int)

}