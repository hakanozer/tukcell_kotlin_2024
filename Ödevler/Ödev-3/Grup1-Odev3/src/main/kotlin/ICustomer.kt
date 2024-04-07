interface ICustomer {
    fun checkBalance(accountId: String)
    fun deposit(accountId: String, amount: Double)
    fun withdraw(accountId: String, amount: Double)
    fun addAccount(account: Account)
}