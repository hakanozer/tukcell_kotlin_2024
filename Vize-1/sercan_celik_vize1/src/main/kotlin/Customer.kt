abstract class Customer(
    var name: String,
    var email: String,
    var phoneNumber: String,
    var customerId: Int
) {
    override fun toString(): String {
        return "Müşteri Adı: $name, Müşteri Mail Adresi: $email, Müşteri ID: $customerId, Müşteri Telefon Numarası: $phoneNumber"
    }
}