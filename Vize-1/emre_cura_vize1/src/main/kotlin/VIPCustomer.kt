class VIPCustomer( customerId: Int, name: String, email: String, phoneNumber: String) :
    Customer(customerId, name, email, phoneNumber) {

    val levels = mutableListOf("Iron", "Bronze", "Silver", "Gold")
    var customerLevel = 0


    fun increaseCustomerLevel(){
        if (customerLevel == 3){
            println("Customer level cannot be increased")
        }else{
            customerLevel++
        }
    }
    fun decreaseCustomerLevel(){
            customerLevel--

    }









    override fun toString(): String {
        return super.toString() + ", VIP Level: ${levels[customerLevel]}"
    }
}