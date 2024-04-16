import java.util.*

class RegularCustomer(musteriAdi: String, musteriEmail: String, musteriPhone: String, customerId: UUID,var loyaltyPoints: Int):Customer(musteriAdi, musteriEmail,
    musteriPhone, customerId) {

    //sadakat puanı hesaplama
    fun setLoyaltyLevel() {
        val level = when (loyaltyPoints) {
            in 0..90 -> "Bronze"
            in 100..250 -> "Silver"
            else -> "Gold"
        }
        println("$musteriAdi'nin sadakat seviyesi: $level")
    }

}

