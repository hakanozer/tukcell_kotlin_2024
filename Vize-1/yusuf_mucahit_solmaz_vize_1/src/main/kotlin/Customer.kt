
abstract class Customer(
    var name: String,
    var email: String,
    var phone: String,
    var customerId: String
) {
    override fun toString(): String {
        return "Customer ID: $customerId\nName: $name\nEmail: $email\nPhone: $phone"
    }
}