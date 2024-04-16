import java.util.*

class CustomerManager {
    private val customers: MutableList<Customer> = mutableListOf()

    // Müşteri ekleme işlemi
    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    // Müşteri bilgilerini güncelleme işlemi
    fun updateCustomer(customerId: UUID, name: String, email: String, phoneNumber: String) {
        val customer = customers.find { it.customerId == customerId }
        if (customer != null) {
            customer.name = name
            customer.email = email
            customer.phoneNumber = phoneNumber
        }
    }

    // VIP müşterilerin puanlarını hesapla
    fun calculateVipPointsForAll() {
        customers.filterIsInstance<VIPCustomer>().forEach {
            println("${it.name} - VIP Points: ${it.vipLevel * 100}")
        }
    }

    // Sadakat puanlarını hesapla
    fun calculateLoyaltyPointsForAll() {
        customers.filterIsInstance<RegularCustomer>().forEach {
            println("${it.name} - Loyalty Points: ${it.loyaltyPoints}")
        }
    }

    // Müşterileri listeleme işlemi
    fun listCustomers() {
        customers.forEach {
            println(it)
            println("-------------")
        }
    }
}