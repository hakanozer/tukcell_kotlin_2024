class RegularCustomer(customerId: Int, name: String, email: String, phoneNumber: String)
    : Customer(customerId, name, email, phoneNumber) {

    var loyaltyPoints = 0


    fun increaseLoyaltyPoints(){
        loyaltyPoints += 10
    }

    fun decreaseLoyaltyPoints(){
        if (loyaltyPoints > 10){
            loyaltyPoints -= 10
        }else{
            println("Loyalty points cannot be decreased")
        }

    }

    override fun toString(): String {
        return super.toString() + ", Loyalty Points: $loyaltyPoints"
    }


}