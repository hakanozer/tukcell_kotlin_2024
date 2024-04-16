import java.util.*

class VIPCustomer(musteriAdi: String, musteriEmail: String, musteriPhone: String, customerId: UUID, var vipLevel: Int) :Customer(musteriAdi, musteriEmail,
    musteriPhone,customerId) {


    fun setVIPLevel(level: Int) {
        vipLevel = level
        val levelName = when (vipLevel) {
            1 -> "1. seviye"
            2 -> "2.seviye"
            3 -> "3.seviye"
            else -> "Immortal"
        }
        println("$musteriAdi'nin VIP seviyesi: $levelName") }

}