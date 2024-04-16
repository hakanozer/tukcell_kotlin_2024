//Bu kotlin dosyası Geleceği Yazanlar Kotlin 2024 Vize1 İçin Umut Yusuf Çınar tarafından oluşturuldu.
package org.example

//sınıfı Customer sınıfından türetiyorum
class CustomerManager {

    private val customers = mutableListOf<Customer>()

    //metotları tanımlıyorum
    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun updateCustomer(customerId: String, updatedCustomer: Customer) {
        val index = findCustomerIndexById(customerId)
        if (index != -1) {
            customers[index] = updatedCustomer
        } else {
            println("Verilen ID için müşteri bulunamadı.")
        }
    }

    fun listCustomers() {
        println("Müşteriler: ")
        customers.forEachIndexed { index, customer ->
            println("${index + 1}. $customer")
        }
    }

    private fun findCustomerIndexById(customerId: String): Int {
        for ((index, customer) in customers.withIndex()) {
            if (customer.customerId == customerId) {
                return index
            }
        }
        return -1
    }
}
