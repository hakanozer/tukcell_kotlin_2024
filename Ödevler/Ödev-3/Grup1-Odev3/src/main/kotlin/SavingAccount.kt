class SavingsAccount(
    accountId: String,
    balance: Double,
    private val monthlyInterestRate: Double
) : Account(accountId, balance) {

    override fun withdraw(amount: Double): Boolean {
        if (balance >= amount) {
            balance -= amount
            return true
        }
        return false
    }

    override fun deposit(amount: Double) {
        balance += amount
    }

    fun addMonthlyInterestRate() {
        balance += balance * monthlyInterestRate
        println("Ay sonu bakiye: $balance")
    }
}