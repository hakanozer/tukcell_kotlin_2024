class VIPCustomer(
    customerId: String,
    customerName: String,
    customerEMail: String,
    customerPhone: String,
    customerVipLevel: Int? = 0,
    customerLoyaltyPoints:Int?=0,
) : Customer(customerId, customerName, customerEMail, customerPhone, customerVipLevel,customerLoyaltyPoints) {

    override fun toString(): String {
        return "Müşteri Bilgileri:\n" +
                "Ad: $customerName\n" +
                "Email: $customerEMail\n" +
                "Telefon: $customerPhone\n" +
                "VIP Seviyesi: $customerVipLevel\n"+
                "Sadakat Seviyesi: $customerLoyaltyPoints "
    }
}