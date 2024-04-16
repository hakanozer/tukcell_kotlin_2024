class RegularCustomer( name: String, email: String, phoneNumber: String,var loyaltyPoints:Int) :
    Customer( name, email, phoneNumber
) {


    override fun toString(): String {
        return super.toString()+"\nLoyalty Points: $loyaltyPoints"
    }

    fun inceraseLoyaltyPoints(){
        loyaltyPoints++
    }
    fun decreaseLoyaltyPoints(){
        loyaltyPoints--
    }
}