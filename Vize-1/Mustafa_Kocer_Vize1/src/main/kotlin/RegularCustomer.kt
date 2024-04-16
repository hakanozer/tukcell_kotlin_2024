import org.example.Customer

class RegularCustomer(cName: String, cEmail: String, cPhone: String) : Customer(cName, cEmail, cPhone) {

    var loyaltyPoints = 0
    // her musterinin kendine ait bir sadakat puanı var


    override fun shop(totalPrice : Double) {
        when{
            totalPrice in 0.0..100.0 -> loyaltyPoints += 5
            totalPrice in 101.0..200.0 -> loyaltyPoints += 10
            totalPrice in 200.0..300.0 -> loyaltyPoints += 15
            else -> loyaltyPoints += 20
        }
    }




}