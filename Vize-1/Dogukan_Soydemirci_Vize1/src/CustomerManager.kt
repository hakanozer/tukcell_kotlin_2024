class CustomerManager {
    private val customers = mutableListOf<Customer>()


    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun listAllCustomers() {
        println("All Customers:")
        customers.forEachIndexed { index, customer ->
            println("\n$customer\n")
        }
    }
    fun updateCustomer(customerId: String, newCustomer: Customer) {
        val index = customers.indexOfFirst { it.customerId == customerId }
        if (index != -1) {
            customers[index] = newCustomer
        } else {
            println("Customer $customerId cannot found.")
        }
    }



}