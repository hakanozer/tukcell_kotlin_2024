abstract class Customer() {

    private var customerId: Int = counter
    abstract var name: String
    abstract var email: String
    abstract var phoneNumber: String

    init {
        counter++
    }

    companion object {
        private var counter = 1
    }

    fun getCustomerId() = customerId

    override fun toString(): String {
        return "$customerId ID, $name, $email, $phoneNumber"
    }
}

