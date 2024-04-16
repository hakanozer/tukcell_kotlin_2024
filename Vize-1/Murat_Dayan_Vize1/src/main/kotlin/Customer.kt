abstract class Customer(
    var customerId:String,
    var customerName:String,
    var customerEMail:String,
    var customerPhone:String,
    var customerLoyaltyPoints:Int?=0,
    var customerVipLevel:Int?=0
) {


    override fun toString(): String {
        return "Müşteri Bilgileri:\n" +
                "Ad: $customerName\n" +
                "Email: $customerEMail\n" +
                "Telefon: $customerPhone\n"
    }

}