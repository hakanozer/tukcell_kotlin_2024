class CustomerManagerImp : CustomerManager{

    // Hem Regular hem de VIP Customer, Customer Abstract sınıfının subclass'ı (child) olduğu için her iki sınıfın nesnesi bu listeye eklenebilir.

    private val customers = mutableListOf<Customer>()

    override fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    override fun updateCustomer(customerId: String, newCustomer: Customer) {
        val index = customers.indexOfFirst { it.customerId == customerId }

        // indexOfFirst metodu listede istenen eleman yoksa -1 döndürür
        if (index != -1) {

            // Indexine göre listeden customer getirilir.
            // Customer Loyal Point ya da VIP Level güncelleme işlemi verilen customer'in hangi sınıfa ait olduğuna göre yapılır.

            val existingCustomer = customers[index]
            if (existingCustomer is RegularCustomer && newCustomer is RegularCustomer) {
                existingCustomer.name = newCustomer.name
                existingCustomer.email = newCustomer.email
                existingCustomer.phone = newCustomer.phone
                existingCustomer.loyaltyPoints = newCustomer.loyaltyPoints

                println("Customer Updated")
            }
            else if (existingCustomer is VIPCustomer && newCustomer is VIPCustomer) {
                existingCustomer.name = newCustomer.name
                existingCustomer.email = newCustomer.email
                existingCustomer.phone = newCustomer.phone
                existingCustomer.vipLevel = newCustomer.vipLevel

                println("Customer Updated")
            }
            else {
                // Eğer verilen customer Regular ya da VIP customer değilse bu kod bloğu çalışır.

                println("Customer type mismatch for ID $customerId.")
                return
            }
            // Güncel customer listeye eskisinin yerine eklenir.

            customers[index] = existingCustomer
        }
        else {
            println("Customer with ID $customerId not found.")
        }
    }


    override fun deleteCustomer(customerId: String) {
        val index = customers.indexOfFirst { it.customerId == customerId }
        if (index != -1) {
            customers.removeAt(index)
            println("Customer with ID $customerId deleted.")
        } else {
            println("Customer with ID $customerId not found.")
        }
    }

    override fun listCustomers() {
        customers.forEach {
            println(it)
            println("-------------")
        }
    }

    override fun getCustomerId(customer: Customer): String? {
        val customerFound = customers.find { it.customerId == customer.customerId }
        return customerFound?.customerId
    }


    override fun getCustomerById(customerId: String): Customer? {
        return customers.find { it.customerId == customerId }
    }

    fun getCustomerRank(customer:Customer) {

        // Customer Loyal Point ya da VIP Level görüntüleme işlemi verilen customer'in hangi sınıfa ait olduğuna göre yapılır.

        if (customer is RegularCustomer) {
             println("${customer.name}'s Loyality Point: ${customer.loyaltyPoints}")
        } else if (customer is VIPCustomer) {
            println("${customer.name}'s VIP Level: ${customer.vipLevel}")
        }
        else {
           println("Customer is not Regular Customer or VIP Customer")
        }
    }
}