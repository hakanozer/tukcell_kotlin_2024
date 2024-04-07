class Customer(val id : String, val firstName: String, val lastName: String)  {
    private val accounts: MutableList<Account> = mutableListOf()

    fun addAccount(account: Account) {
        accounts.add(account)
    }

    fun removeAccount(account: Account) {
        accounts.remove(account)
    }

    fun getAccounts(): List<Account> {
        return accounts.toList()
    }

}