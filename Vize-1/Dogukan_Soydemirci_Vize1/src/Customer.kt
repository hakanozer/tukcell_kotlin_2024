abstract class Customer(val name: String, val email: String, val phoneNumber: String) {

    abstract val customerId: String

    override fun toString(): String {
        return "Customer ID: $customerId\nName: $name\nPhone Number: ${phoneNumber}\nEmail: $email"
    }
}
