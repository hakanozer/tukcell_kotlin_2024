class CustomerManager {
    private val customers = mutableListOf<Customer>()

    // Sadakat müşterisi ekleme
    fun addRegularCustomer(customerId: String,name: String, email: String, phoneNumber: String, loyaltyPoints: Int) {
        val customer = RegularCustomer(customerId,name, email, phoneNumber, loyaltyPoints)
        customers.add(customer)
    }

    // Vip müşterisi ekleme
    fun addVIPCustomer( customerId : String,name: String, email: String, phoneNumber: String, vipLevel: Int) {
        val customer = VIPCustomer(customerId,name, email, phoneNumber, vipLevel)
        customers.add(customer)
    }

    // Bilgi Güncelleme
    fun updateCustomer(customerId: String, updatedCustomer: Customer) {
        val index = customers.indexOfFirst { it.customerId == customerId }
        if (index != -1) {
            customers[index] = updatedCustomer
        } else {
            println("müşteri bulunamadı")
        }
    }

    // Müşteri listeleme
    fun listCustomers() {
        println("Müşteri Listesi:")
        customers.forEachIndexed { index, customer ->
            println("Müşteri ${index + 1}:\n$customer\n")
        }
    }
}