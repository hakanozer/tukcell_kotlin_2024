class CustomerManager {
    private  val customers= mutableListOf<Customer>()


    fun addCustomer(customer:Customer){
        customers.add(customer)
    }

    fun removeCustomer(customer: Customer){
        customers.remove(customer)
    }


    //Verilen kullanıcı listede varsa ,istenilen parametreler doldurulup istenilenler boş bırakılarak güncelleme yapılır
    fun updateCustomer(customer: Customer, newName: String? = null, newEmail: String? = null, newPhoneNumber: String? = null) {
        val customerIndex = customers.indexOfFirst { it.customerID == customer.customerID }
        if (customerIndex != -1) {
            newName?.let { customer.name = it }
            newEmail?.let { customer.email = it }
            newPhoneNumber?.let { customer.phoneNumber = it }
        } else {
            println("Customer Not Found.")
        }
    }



    fun listCustomers(){
        customers.forEach {
            println(it)
        }
    }

    fun increaseVipLevel(vipCustomer: VipCustomer){
        vipCustomer.increaseVipLevel()
    }
    fun decreaseVipLevel(vipCustomer: VipCustomer){
        vipCustomer.decreaseVipLevel()
    }

    fun increaseLoyaltyPoints(regularCustomer: RegularCustomer){
        regularCustomer.inceraseLoyaltyPoints()
    }
    fun decreaseLoyaltyPoints(regularCustomer: RegularCustomer){
        regularCustomer.decreaseLoyaltyPoints()
    }

  //Regular Customer Vipye terfi etti ve yeni türde bir VipCustomer olduğu için de Id si değiştirildi
    fun regularToVip(regularCustomer: RegularCustomer){

        val customerIndex=customers.indexOf(regularCustomer)
        customers[customerIndex]=VipCustomer(regularCustomer.name,regularCustomer.email,regularCustomer.phoneNumber,1)
    }
}