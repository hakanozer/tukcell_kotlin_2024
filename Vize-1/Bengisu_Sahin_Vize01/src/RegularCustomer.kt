// This class is a type of customer
class RegularCustomer(name: String, email: String, phoneNumber: Long, var loyaltyPoints: Int) : Customer(
    name, email, phoneNumber
) {

    //To show customer infos, it was overrided
    override fun toString(): String {
        return "${generateCustomerId()} ID, $name, $email, $phoneNumber, Loyalty points: $loyaltyPoints"
    }

}