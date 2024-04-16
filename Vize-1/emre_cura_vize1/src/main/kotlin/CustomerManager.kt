class CustomerManager {
    private val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        val newCustomer = customers.find { it.customerId == customer.customerId }

        if (newCustomer != customer) {
                customers.add(customer)
        }


    }
    fun removeCustomer(customerId: Int){
        val customer = customers.find { it.customerId == customerId }
        customer.let {
            customers.remove(customer)
        }

    }

    fun updateCustomer(customerId: Int, newName: String, newEmail: String, newPhoneNumber: String) {
        val customer = customers.find { it.customerId == customerId }
        customer?.let {
                it.name = newName
                it.email = newEmail
                it.phoneNumber = newPhoneNumber
        }
    }
    fun increaseSpecialFuture(customer: Customer){
        if (customer is RegularCustomer){
            customer.increaseLoyaltyPoints()
            if (customer.loyaltyPoints==50){
                regularToVIP(customer)
            }
        }
        else if (customer is VIPCustomer){
            customer.increaseCustomerLevel()
        }
    }

    private fun regularToVIP(customer: RegularCustomer){
        val newCustomer = VIPCustomer(customer.customerId, customer.name,customer.email,customer.phoneNumber)
        removeCustomer(customer.customerId)
        addCustomer(newCustomer)

        println("Customer with ${customer.customerId} IDs became VIP")
    }

    fun decreaseSpecialFuture(customer: Customer){
        if (customer is RegularCustomer){
            customer.decreaseLoyaltyPoints()
        }
        else if (customer is VIPCustomer){
            if (customer.customerLevel == 0){
                VIPToRegular(customer)
            }else{
                customer.decreaseCustomerLevel()

            }
        }
    }
    private fun VIPToRegular(customer: VIPCustomer){
        val newCustomer = RegularCustomer(customer.customerId, customer.name,customer.email,customer.phoneNumber)
        removeCustomer(customer.customerId)
        addCustomer(newCustomer)
        println("Customer with ${customer.customerId} IDs became Regular")
    }

    fun listCustomers(): String {
        return customers.joinToString(separator = "\n")
    }
}