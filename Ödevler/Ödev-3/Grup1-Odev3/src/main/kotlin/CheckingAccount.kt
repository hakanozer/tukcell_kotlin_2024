class CheckingAccount(accountId: String, balance: Double) : Account(accountId, balance) {

    override fun withdraw(amount: Double): Boolean {
        val commission = calculateCommission(amount)

        val totalWithdraw = amount + commission
        if (balance >= totalWithdraw) {
            this.balance -= totalWithdraw
            return true
        }
        return false
    }

    override fun deposit(amount: Double) {
        val commission = calculateCommission(amount)
        this.balance += (amount - commission)
    }

    // Yapılan işlem miktarına göre komisyon hesaplama
    private fun calculateCommission(amount: Double): Double {
        return when (amount) {
            in 0.0..500.0 -> 5.0
            in 501.0..1000.0 -> 10.0
            else -> 50.0
        }
    }
}