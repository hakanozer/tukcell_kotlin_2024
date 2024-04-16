class RegularCustomer(customerId: String, name: String, email: String, phoneNumber: String, location: String, val loyaltyPoints: Int) :
    Customer(customerId, name, email, phoneNumber, location) {
    override fun toString(): String {
        return super.toString() + "\nLoyalty Points: $loyaltyPoints"
    }

    fun getLoyaltyPoints():Unit{
        if (loyaltyPoints > 5){
            println("${this.customerId} ID'li customere sadakat puanı eklendi")
        }else{
            println("${this.customerId} ID'li customerin sadakat puanı düşük")
        }
    }

}