abstract class Customer(val customerId: Int, var name: String, var email: String, var phoneNumber: String) {
    override fun toString(): String {
        return "Customer ID: $customerId, Name: $name, Email: $email, Phone: $phoneNumber"
    }
}