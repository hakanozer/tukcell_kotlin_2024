class CustomerManager {

    private val customerList = mutableListOf<Customer>()
    private var customerId = 0

    fun listCustomers(){
        customerList.forEach{customer ->
            println(customer.toString())
            if (customer is RegularCustomer){
                println("Customer Type  :${customer.customerType}\nLoyalty Point  :${customer.loyaltyPoints}")
                println("*********************************************************************")
            }else if(customer is VIPCustomer){
                println("Customer Type  :${customer.customerType}\nVIP Level      :${customer.vipLevel}")
                println("*********************************************************************")
            }
        }
    }

    fun createCustomer(customerType:Int, customerName:String, customerEmail:String, customerPhone:String) : Customer {
        customerId++
        return if (customerType == 0) {
            RegularCustomer(customerId, customerName, customerEmail, customerPhone,0)
        } else {
            VIPCustomer(customerId, customerName, customerEmail, customerPhone,0)
        }
    }

    fun addCustomer(customer: Customer){
        customerList.add(customer)
    }

    fun removeCustomer(customer: Customer){
        customerList.remove(customer)
    }

    fun updateCustomer(customer: Customer, newName:String, newEmail:String,newPhone:String){
        val index = customerList.indexOf(customer)
        if (newName.isNotEmpty()){ customerList[index].customerName = newName }
        if (newEmail.isNotEmpty()){ customerList[index].customerEmail = newEmail }
        if (newPhone.isNotEmpty()){ customerList[index].customerPhone = newPhone }
    }

    fun increaseVipOrLoyaltyPoint(customer: Customer, increasePoint:Int){
        if (customer is RegularCustomer){
            customer.loyaltyPoints += increasePoint
        }else if (customer is VIPCustomer){
            customer.vipLevel += increasePoint
        }
    }

    fun decreaseVipOrLoyaltyPoint(customer: Customer, decreasePoint:Int){
        if (customer is RegularCustomer){
            customer.loyaltyPoints -= decreasePoint
        }else if (customer is VIPCustomer){
            customer.vipLevel -= decreasePoint
        }
    }
}



