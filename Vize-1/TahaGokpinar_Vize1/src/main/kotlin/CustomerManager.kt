class CustomerManager {

    val customerList = mutableListOf<Customer>()

    fun addCustomer(customer: Customer){
        var sameId = false
        for (existingCustomer in customerList) {
            if (existingCustomer.customerId == customer.customerId) {
                sameId = true
                break
            }
        }
        if (sameId == true) {
            println("Customer with ${customer.customerId} ID already exists.")
        } else {
            customerList.add(customer)
        }
    }

    fun removeCustomer(customerID : String){
        var customerFound = false
        for (i in customerList.indices) {
            if (customerList[i].customerId == customerID) {
                customerList.removeAt(i)
                customerFound = true
                break
            }
        }
        if (customerFound == false) {
            println("No customer found with $customerID ID.")
        }
    }

    fun updateCustomer(customerID: String, newCustomer: Customer){
        var customerFound = false
        if(customerID == newCustomer.customerId){
            for (i in customerList.indices){
                if (customerList[i].customerId == customerID){
                    customerList[i] = newCustomer
                    customerFound = true
                    break
                }
            }
            if (customerFound == false) {
                println("No customer found with $customerID ID.")
            }
        }
        else{
            println("The customer ID to be updated and the customer ID entered are different.")
        }

    }

    fun listCustomers(){
        for(i in customerList.indices){
            println("${i+1}. customer: \n${customerList[i].toString()}")
        }
    }
}