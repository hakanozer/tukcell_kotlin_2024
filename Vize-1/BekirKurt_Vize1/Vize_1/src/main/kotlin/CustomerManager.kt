class CustomerManager {
    private val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        val existingCustomer = customers.find { it.customerId == customer.customerId }
        if (existingCustomer == null) {
            customers.add(customer)
            println("${customer.customerId} ID'li customer başarıyla eklendi")
        } else {
            println("Customer eklenemedi ${customer.customerId} ID'li customer zaten mevcuttur.")
        }
    }

    fun removeCustomerById(customerId: String) {
        val customerToRemove = customers.find { it.customerId == customerId }
        if (customerToRemove != null) {
            customers.remove(customerToRemove)
            println("$customerId ID'li customer başarıyla silindi")
        } else {
            println("Customer silinemedi $customerId ID'li customer mevcut değildir.")
        }
    }

    fun updateCustomer(customerId: String, updatedCustomer: Customer) {
        val foundCustomer = customers.find { it.customerId == customerId }
        if (foundCustomer != null) {
            val index = customers.indexOf(foundCustomer)
            customers[index] = updatedCustomer
            println("$customerId ID'li customer başarıyla güncellendi. Yeni bilgileri:")
            showCustomerById(customerId)
        } else {
            println("Customer güncellenemedi $customerId ID'li customer mevcut değildir.")
        }
    }

    fun showCustomerById(customerId: String) {
        val customer = customers.find { it.customerId == customerId }
        if (customer != null) {
            println(customer)
        } else {
            println("$customerId ID'li customer mevcut değildir.")
        }
    }

    fun listCustomers() = customers.forEach { println(it) }

}