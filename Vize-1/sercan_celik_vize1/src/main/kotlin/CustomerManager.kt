class CustomerManager {
    private val customers = mutableListOf<Customer>()
    fun addCustomer(customer: Customer) {
        val existingCustomerId = customers.find {
            it.customerId == customer.customerId
        }
        val existingCustomerPhone = customers.find {
            it.phoneNumber == customer.phoneNumber
        }
        if (existingCustomerId == null) {
            if (existingCustomerPhone == null) {
                customers.add(customer)
                println("${customer.name} adlı müşteri başarıyla eklendi.")
            } else {
                println("${customer.phoneNumber} numaralı telefon zaten bir müşteriye ait.")
            }
        } else {
            println("${customer.customerId} numaralı ID'ye daha önceden müşteri atanmış.")
        }
    }

    fun updateCustomer(updatedCustomer: Customer, customerId: Int) {
        val existingCustomer = customers.find {
            it.customerId == customerId
        }
        if (existingCustomer != null) {
            existingCustomer.apply {
                name = updatedCustomer.name
                email = updatedCustomer.email
                phoneNumber = updatedCustomer.phoneNumber

                if (updatedCustomer is VIPCustomer && this is VIPCustomer) {
                    vipLevel = updatedCustomer.vipLevel
                }
                if (updatedCustomer is RegularCustomer && this is RegularCustomer) {
                    loyaltyPoints = updatedCustomer.loyaltyPoints
                }

                println("$customerId numaralı müşteri başarıyla güncellendi.")
            }

        } else {
            println("$customerId numaralı müşteri bulunamadı.")
        }

    }

    fun removeCustomer(customerId: Int) {
        val customerToRemove = customers.find {
            it.customerId == customerId
        }
        if (customerToRemove != null) {
            customers.remove(customerToRemove)
            println("$customerId numaralı müşteri başarıyla silindi.")
        } else {
            println("$customerId numaralı müşteri bulunamadı.")
        }
    }

    fun listCustomers() {
        println("Müşteri Listesi:")
        if (customers.isNotEmpty()) {
            customers.forEach {
                println(it)
            }
        } else {
            println("Listelenecek Müşteri Bulunamadı!")
        }
    }
}

