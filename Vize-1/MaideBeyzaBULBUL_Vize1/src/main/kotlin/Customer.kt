import java.util.*

abstract class Customer(var name: String, var email: String, var phoneNumber: String) {
    val customerId: UUID = UUID.randomUUID() // Her müşteriye özgü customerId oluşturuluyor

    // toString() metodu override edilerek müşteri bilgileri düzgün bir şekilde yazdırılıyor
    override fun toString(): String {
        return "Customer ID: $customerId\nName: $name\nEmail: $email\nPhone Number: $phoneNumber"
    }
}