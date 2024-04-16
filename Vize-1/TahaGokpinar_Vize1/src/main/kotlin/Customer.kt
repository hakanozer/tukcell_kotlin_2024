abstract class Customer (
    var name: String,
    var email : String,
    var phoneNumber : Number,
    val customerId : String
){
    override fun toString(): String {
        return  " Customer ID: $customerId" +
                "\n Customer name: $name" +
                "\n Customer phone number: $phoneNumber" +
                "\n Customer e-mail: $email"
    }

    abstract fun displayName()
}