class RegularCustomer(
    var loyaltyPoints: Int,
    name: String,
    email: String,
    phoneNumber: String,
    customerId: Int
) :
    Customer(
        name, email, phoneNumber,
        customerId
    ) {
    init {
        if (loyaltyPoints < 0) {
            println("Uyarı: Müşteri sadakat puanı 0'dan küçük olamaz min loyaltyPoints olan 0 kullanıcıya atandı.")
            loyaltyPoints = 0
        } else if (loyaltyPoints > 100) {
            println("Uyarı: Müşteri sadakat puanı 100'den büyük olamaz max loyaltyPoints olan 100 kullanıcıya atandı.")
            loyaltyPoints = 100
        }
    }

    override fun toString(): String {
        return "${super.toString()}, Müşteri Sadakat Puanı: $loyaltyPoints"

    }
}