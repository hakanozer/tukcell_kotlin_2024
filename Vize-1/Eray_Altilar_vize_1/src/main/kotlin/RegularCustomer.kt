class RegularCustomer(
    customerId: String, name: String, email: String, phoneNumber: Long

) : Customer(customerId, name, email, phoneNumber, isVIP = false) {

    /// Sadakat puanını burada saklıyoruz
     var loyaltyPoints : Int = 0

    fun showLoyaltyPoints() {
        println("$name Abonesinin Sadakat Puanı : $loyaltyPoints")
    }



}

