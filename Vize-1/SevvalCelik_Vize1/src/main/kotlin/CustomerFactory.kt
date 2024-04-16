import java.util.*

object CustomerFactory {
    fun regularCustomerOlustur(musteriAdi: String, musteriEmail: String, musteriPhone: String, customerId: UUID, loyaltyPoints: Int):RegularCustomer{
        val customerId=UUID.randomUUID()
        return RegularCustomer(musteriAdi,musteriEmail,musteriPhone,customerId,loyaltyPoints)
    }

    fun VIPCustomerOlustur(musteriAdi: String, musteriEmail: String, musteriPhone: String, customerId: UUID,  vipLevel: Int):VIPCustomer{
        val customerId=UUID.randomUUID()
        return VIPCustomer(musteriAdi,musteriEmail,musteriPhone,customerId,vipLevel)
    }
}