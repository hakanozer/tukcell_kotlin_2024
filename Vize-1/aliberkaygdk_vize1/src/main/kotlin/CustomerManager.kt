class CustomerManager {
    private val customers = mutableListOf<Customer>()


    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun listCustomers(): List<Customer> {
        return customers.toList()
    }

    fun updateCustomer(customerId: String, newName: String, newEmail: String, newPhoneNumber: String) {
        val customerToUpdate = customers.find { it.customerId == customerId }
        customerToUpdate?.let {
            it.name = newName
            it.email = newEmail
            it.phoneNumber = newPhoneNumber
        }
    }
}