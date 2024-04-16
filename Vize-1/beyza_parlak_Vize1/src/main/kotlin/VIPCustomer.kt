class VIPCustomer(customerId: String ,fullName:String, email:String, phoneNumber:String, address: String, gender:String, val vipLevel:Int)
    :Customer(customerId, fullName, email, phoneNumber, address, gender) {

    // vipLevel property aldım ve toString() içinde bilgileri listeleyeceğim
    override fun toString(): String {
        return super.toString() + " - VIP Level: $vipLevel"
    }
}