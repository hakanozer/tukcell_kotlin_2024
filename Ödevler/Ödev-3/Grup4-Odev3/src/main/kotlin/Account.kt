interface Account {

    val accountId: String
    val customer: Customer
    var balance: Double

    fun deposit(amount: Double)
    fun withdraw(amount: Double)

}