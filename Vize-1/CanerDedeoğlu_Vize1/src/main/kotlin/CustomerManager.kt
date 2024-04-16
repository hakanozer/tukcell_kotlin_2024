class CustomerManager  {

    private val customers = mutableListOf<Customer>()

    // Müşteri ekleme fonksiyonu

    fun addCustomer(customer : Customer)
    {
        customers.add(customer)
    }

    // Müşteri listeleme fonksiyonu

    fun listCustomer ()
    {
        customers.forEach{customer ->
            println(customer)
        }
    }
    // Müşteri bilgilerini güncelleme fonksiyonu

    fun updateCustomer(customerId : Int, newName : String?, newMail : String?, newPhoneNumber : String?, newNewCity : String?)
    {
        val customer = customers.find { it.customerId == customerId }
        if(customer != null)
        {
            customer.customerName = newName ?: customer.customerName
            customer.customerMail = newMail ?: customer.customerMail
            customer.customerPhoneNumber = newPhoneNumber ?: customer.customerPhoneNumber
            customer.customerCity = newNewCity ?: customer.customerCity

        }
        else
        {
            println("$customerId adlı müşteri bulunamadı.")
        }
    }

    // Müşteri silme fonksiyonu

    fun removeCustomer(customerId: Int)
    {
        val customer = customers.find { it.customerId == customerId }
        if(customer != null)
        {
            customers.removeAt(customerId - 1)
        }
        else
        {
            println("$customerId adlı müşteri bulunamadı.")
        }
    }
}