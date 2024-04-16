class CustomerManager {

    private val customerList = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) = customerList.add(customer)

    fun removeCustomer(id: Int) = customerList.removeIf { id == it.getCustomerId() }

    fun updateCustomer(id: Int, name: String = "", email: String = "", phoneNumber: String = "", pointLevel: Int = -1) {
        val selectedCustomer = customerList.find { id == it.getCustomerId() }
        val index = customerList.indexOf(selectedCustomer)

        if (pointLevel != -1) {
            if (selectedCustomer is RegularCustomer) {
                selectedCustomer.loyaltyPoints = pointLevel
            } else if (selectedCustomer is VIPCustomer) {
                selectedCustomer.vipLevel = pointLevel
            }
        }

        if (!name.isNullOrBlank()) {
            customerList[index].name = name
        }

        if (!email.isNullOrBlank()) {
            customerList[index].email = email
        }

        if (!phoneNumber.isNullOrBlank()) {
            customerList[index].phoneNumber = phoneNumber
        }

    }

    fun listCustomers() = customerList.onEach {
        println(it)
    }

}