abstract class Customer(val customerId: String, val name: String, val email: String, val phoneNumber: String, val location: String,) {
    override fun toString(): String {
        return "-------customer infos-------\nCustomer ID: $customerId\nName: $name\nEmail: $email\nPhone Number: $phoneNumber\nLocation: $location"
    }
}

