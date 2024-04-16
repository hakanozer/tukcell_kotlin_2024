interface CustomerManager {
    fun addCustomer(customer: Customer)
    fun updateCustomer(customerId: String, newCustomer: Customer)
    fun deleteCustomer(customerId: String)
    fun listCustomers()
    fun getCustomerId(customer: Customer): String?
    fun getCustomerById(customerId: String): Customer?
}