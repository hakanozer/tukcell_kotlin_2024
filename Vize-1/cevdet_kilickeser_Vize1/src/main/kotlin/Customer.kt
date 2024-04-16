abstract class Customer {
    abstract val customerId: Int
    abstract var customerName: String
    abstract var customerEmail: String
    abstract var customerPhone: String

    override fun toString(): String {
        return  "Customer ID    :$customerId\n" +
                "Name           :$customerName\n" +
                "Email          :$customerEmail\n" +
                "Phone Number   :$customerPhone"
    }
}