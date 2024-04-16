package org.example

class CustomerManager {
    private val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    fun updateCustomer(customer: Customer,newName:String, newEmail: String, newPhoneNumber: String) {
        customer.name = newName
        customer.email = newEmail
        customer.phoneNumber = newPhoneNumber
    }

    fun removeCustomer(customer: Customer) {
        customers.remove(customer)
    }

    fun listCustomers() {
        for (customer in customers) {
            println(customer)
        }
    }
    //regular bir customeri VIP bir customer a çevirmek için yazdığım fonksiyon
    //bunu yazmak çok mantıklı gelmedi çünkü mainde oluşturduğum nesne
    // listeden siliyorum ama aklıma başka bir özellik de gelmedi
    fun convertToVIP(regularCustomer: RegularCustomer) {
        if(regularCustomer.loyaltyPoints >=1000){
            val vipCustomer = VIPCustomer(
                regularCustomer.name,
                regularCustomer.email,
                regularCustomer.phoneNumber,
                regularCustomer.loyaltyPoints.toDouble() / 1000
                //vip level ve loyalty points arasında basit bi geçiş işlemi yaptım
            )

            // yeni oluşturduğumuz müşteriyi ekleyip eskisini siliyoruz
            customers.add(vipCustomer)
            customers.remove(regularCustomer)
        }else{
            println("Müşterinin sadakat puanları Vip olmak için yeterli değil")
        }
    }

    //Müşteriler arasında arama yapmak için bir fonksiyon
    fun searchInCustomers(search: String): List<Customer> {
        val matchingCustomers = mutableListOf<Customer>()

        for (customer in customers) {
            if (customer.name.contains(search, ignoreCase = true) ||
                customer.email.contains(search, ignoreCase = true) ||
                customer.phoneNumber.contains(search)
            ) {
                matchingCustomers.add(customer)
            }
        }
        return matchingCustomers
    }
}