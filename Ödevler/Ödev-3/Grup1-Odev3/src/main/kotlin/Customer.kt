class Customer(
    private val firstName: String,
    private val lastName: String
) : ICustomer {
    private val accountList = mutableListOf<Account>()
    private val processList = mutableListOf<String>()

    override fun addAccount(account: Account) {
        if (accountList.isEmpty()) {
            accountList.add(account)
        } else {
            var isExist = false
            for (i in accountList) {
                if (i.accountId == account.accountId) {
                    println("Bu Hesap Kullanılmaktadır!")
                    isExist = true
                    break
                }
            }
            if (!isExist) {
                accountList.add(account)
            }
        }
    }

    override fun deposit(accountId: String, amount: Double) {
        val account = accountList.find { it.accountId == accountId }
        account?.deposit(amount)
        checkBalance(accountId)
        lastFiveProcess(amount, "Deposit")
    }

    override fun withdraw(accountId: String, amount: Double) {
        val account = accountList.find { it.accountId == accountId }
        account?.withdraw(amount)
        checkBalance(accountId)
        lastFiveProcess(amount, "Withdraw")
    }

    override fun checkBalance(accountId: String) {
        val account = accountList.find { it.accountId == accountId }
        println("$firstName ${lastName} İsimli Kullanıcıya Ait Hesap Bilgileri")
        println("Güncel Bakiye: ${account?.balance}")
    }

    private fun lastFiveProcess(amount: Double, processParam: String) {
        val process = "$processParam - $amount "
        processList.add(process)
        if (processList.size > 5) {
            processList.removeFirst()
        }
    }

    fun printLastFiveProcess() {
        println("Son 5 İşlem:")
        processList.forEach {
            println(it)
        }
    }
}