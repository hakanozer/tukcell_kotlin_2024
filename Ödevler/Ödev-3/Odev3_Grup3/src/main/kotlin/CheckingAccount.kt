class CheckingAccount(balance: Double, private val transactionFee: Double) : Account(balance) {

    // Para Çekme
    override fun withdraw(amount: Double) {

        if (amount + transactionFee <= balance) {
            balance -= (amount + transactionFee)
            println("Hesabınızdan $amount TL para çekilmiştir. İşlem ücreti : $transactionFee")
            println("Kalan bakiyeniz : $balance ")
        } else {
            println("Yetersiz bakiye")
        }
    }

    // Para Yatırma
    override fun deposit(amount: Double) {
        balance += amount - transactionFee
        println("$amount Tl yatırıldı. İşlem ücreti : $transactionFee ")
        println("Yeni bakiye: $balance TL")
    }

    override fun toString(): String {
        return "Checking Account id:${getId()}"
    }

}