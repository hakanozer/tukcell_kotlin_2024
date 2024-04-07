import java.time.LocalDate

class SavingsAccount(override val accountId : String, override val customer: Customer, override var balance: Double, val time : LocalDate) : Account {

    private val interest = 0.04 // faiz oranı

    //Vadeli
    override fun deposit(amount: Double) {
        balance+=amount
        println("Başarılı bir şekilde para eklediniz. Yeni Bakiye: $balance TL")
    }

    override fun withdraw(amount: Double)  {
        if(balance>amount){balance-=amount}
        else{println("Bakiye yetersiz. Bakiye: $balance TL")}

    }

    fun applyMonthlyInterest() {
        val today = LocalDate.now()
        val nextMonth = time.plusMonths(1)
        if (today.isAfter(nextMonth)) {
            balance *= (1 + interest)
            println("Faiz hesaba işlendi. Yeni Bakiye: $balance")
        }
    }

}