abstract class Customer(
    val customerId: String,
    val name: String,
    val email: String,
    val phoneNumber: String,

) {
    override fun toString(): String {
        return "Müşteri ID : $customerId\nİsim - Soyisim: $name\nE-mail: $email\nTelefon Numarası: $phoneNumber"
    }
}
