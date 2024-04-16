import org.example.Customer

class VIPCustomer(cName: String, cEmail: String, cPhone: String) : Customer(cName, cEmail, cPhone) {

    var vipLevel = 0

    override fun shop(totalPrice: Double) {
        when{
            totalPrice in 0.0..100.0 -> vipLevel += 1
            totalPrice in 101.0..200.0 -> vipLevel += 2
            totalPrice in 200.0..300.0 -> vipLevel += 3
            else -> vipLevel += 4
        }    }
    // her musterinin kendine ait bir vip leveli var


}