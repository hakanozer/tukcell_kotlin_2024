// This abstract class was created to customer infos.
abstract class Customer(var name: String, var email: String, var phoneNumber: Long) {

    // To unique customer id, it was created
    private var customerId: Int = 0


    init {
        customerId = counter
        counter++
    }

    // Counter variable is used to create unique ids.
    companion object{
        private var counter = 1
    }

    fun generateCustomerId() = customerId

    // By overriding the toString() method the information of the customer was printed correctly.
    override fun toString(): String {
        return "Customer's id is $customerId, name is $name, email is $email, phone number is $phoneNumber"
    }

}