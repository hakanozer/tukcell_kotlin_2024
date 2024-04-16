class VIPCustomer(
    var vipLevel: Int,
    name: String, email: String, phoneNumber: String,
    customerId: Int
) : Customer(name, email, phoneNumber, customerId) {
    init {
        if (vipLevel < 1) {
            println("Uyarı: Müşteri VIP derecesi 1'den küçük olamaz min viplevel olan 1 kullanıcıya atandı.")
            vipLevel = 1
        } else if (vipLevel > 5) {
            println("Uyarı: Müşteri VIP derecesi 5'ten büyük olamaz max viplevel olan 5 kullanıcıya atandı.")
            vipLevel = 5
        }
    }

    override fun toString(): String {
        return "${super.toString()}, Müşteri VIP Derecesi: $vipLevel"
    }
}