class RegularCustomer(customerId: String ,fullName:String, email:String, phoneNumber:String, address: String, gender:String, val loyaltyPoints:Int)
    :Customer(customerId, fullName, email, phoneNumber, address, gender) {

    // loyaltyPoints property aldım ve toString() içinde bilgileri listeleyeceğim
    override fun toString(): String {
        return super.toString() + " - Loyalty Points: $loyaltyPoints"
    }
}