import java.util.*

class CustomerManager {
    private val customers = mutableListOf<Customer>()

    fun customerEkle(customer: Customer) {
        customers.add(customer)
        println("Customer eklendi: \n$customer")
    }

    fun customerSilme(customerID: UUID){
        val customer = customers.find { it.customerId == customerID }
        if(customer!=null){
            customers.remove(customer)
            println("Customer silindi:$customer")
        }else{
            println("CUstomer bulunamadı")
        }
    }

    fun updateCustomer(customerId: UUID, updatedCustomer: Customer) {
        val musteriIndex = customers.indexOfFirst { it.customerId == customerId }
        if (musteriIndex != -1) {
            customers[musteriIndex] = updatedCustomer
            if (updatedCustomer is RegularCustomer) {
                println("Sadakat Puanı: ${updatedCustomer.loyaltyPoints}")
            } else if (updatedCustomer is VIPCustomer) {
                println("VIP Seviyesi: ${updatedCustomer.vipLevel}")
            }
            println("Customer güncellendi:\n$updatedCustomer")
        } else {
            println("ID'si $customerId olan müşteri bulunamaadı")
        }
    }

    fun customerListele() {
        println("Customer Listesi:")
        customers.forEach { println(it) }
    }
}