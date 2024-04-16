class CheckingAccount(override val accountId: String, override val customer: Customer, override var balance: Double) :
    Account {
    //Vadesiz
    private val transactionFee = 0.08
    override fun withdraw(amount: Double) {
        if (amount + transactionFee > balance) {
            println("Yetersiz bakiye")
        } else {
            balance -= (amount + (amount * transactionFee))
            println("$amount çekim başarılı. Yeni bakiye: $balance")
            println("Uygulanan işlem ücreti: $transactionFee")
        }
    }

    override fun deposit(amount: Double) {
        balance += (amount - (amount * transactionFee))
        println("$amount başarıyla yatırıldı. Yeni Bakiye: $balance")
    }
}


