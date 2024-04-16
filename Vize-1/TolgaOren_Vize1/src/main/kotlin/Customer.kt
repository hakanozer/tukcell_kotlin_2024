abstract class Customer(
    var name: String,
    var phoneNumber: String,
    var email: String
) {

    companion object {
        var idCounter = 0
    }

    var id = ++idCounter

    override fun toString(): String {
        val info = "Customer Info:\n" +
                "id: $id\n" +
                "name: $name\n" +
                "phone number: $phoneNumber\n" +
                "email: $email"
        return info
    }
}