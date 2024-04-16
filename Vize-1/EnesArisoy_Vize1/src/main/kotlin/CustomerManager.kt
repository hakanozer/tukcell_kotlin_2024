package org.example

class CustomerManager {
    private val customerList = mutableListOf<Customer>()

    // Bu fonksiyon ile müşteri ekleyebiliyoruz
    fun addCustomer(customer: Customer) {
        customerList.add(customer)
    }

    // Bu fonksiyon ile müşteri güncelleyebiliyoruz
    fun updateCustomer(customerId: String, updatedCustomer: Customer) {
        val customerToBeUpdated = customerList.find { it.customerId == customerId }

        customerToBeUpdated?.let {
            val index = customerList.indexOf(it)
            customerList[index] = updatedCustomer
            println("$customerId id'sine sahip kullanıcı güncellendi.")
        } ?: run {
            println("$customerId id'sine sahip kullanıcı yok.")
        }

    }

    // Bu fonksiyon ile müşteri silebiliyoruz
    fun removeCustomer(customerId: String) {
        val customerToRemove = customerList.find { it.customerId == customerId }

        customerToRemove?.let {
            customerList.remove(it)
            println("$customerId id'sine sahip kullanıcı silindi.")
        } ?: run {
            println("$customerId id'sine sahip kullanıcı yok.")
        }
    }

    // Bu fonksiyon ile müşterilerin hepsini çekiyoruz
    fun listCustomers() {

        if (customerList.isNotEmpty()) {

            customerList.forEachIndexed { index, customer ->
                println("${index + 1}. Customer: ")
                println(customer)
                println()
            }
        } else {
            println("Customer listesi boş")
        }
    }
}