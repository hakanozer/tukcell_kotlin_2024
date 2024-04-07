abstract class Account(var accountId: String, var balance: Double) {
    abstract fun withdraw(amount: Double): Boolean
    abstract fun deposit(amount: Double)
}