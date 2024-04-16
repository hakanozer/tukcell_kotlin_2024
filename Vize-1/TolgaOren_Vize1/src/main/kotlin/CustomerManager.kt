class CustomerManager {

    private var customerList = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) : Customer {
        customerList.add(customer)
        return customer
    }

    fun updateCustomer(oldCustomer: Customer, customer: Customer): Customer  {
        val customerIndex = customerList.indexOfFirst {
            it.id == oldCustomer.id
        }
        customerList[customerIndex] = customer
        customerList[customerIndex].id = oldCustomer.id
        return customerList[customerIndex]
    }

    fun removeCustomer(customer: Customer) : Customer {
        customerList.remove(customer)
        return customer
    }

    fun getCustomers() : List<Customer> {
        return customerList
    }

}