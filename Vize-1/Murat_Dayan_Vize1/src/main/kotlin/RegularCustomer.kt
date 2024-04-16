class RegularCustomer(
    customerId:String,
    customerName:String,
    customerEMail:String,
    customerPhone:String,
    customerLoyaltyPoints:Int?=0,
) : Customer(customerId, customerName,customerEMail,customerPhone,customerLoyaltyPoints) {


    override fun toString(): String {
        return "Müşteri Bilgileri:\n" +
                "Ad: $customerName\n" +
                "Email: $customerEMail\n" +
                "Telefon: $customerPhone\n" +
                "Sadakat Seviyesi: $customerLoyaltyPoints"
    }





}