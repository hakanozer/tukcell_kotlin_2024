class Customer(val name: String, val surname: String) {

    private var id: Int = 0
    private val accounts = mutableListOf<Account>()

    //Id property'sine atama yapılır ve counter arttırılır.
    init {
        id = counter
        counter++
    }

    //Counter değişkeni farklı id'ler oluşturmak için kullanılmıştır.
    companion object {
        var counter = 1
    }


    //Hesap Oluşturma
    fun createAccount(account: Account) {
        accounts.add(account)
    }

    //Hesap Bakiyeleri Kontrol
    fun checkBalance() {
        accounts.forEach {
            println("$it \n${it.balance}")
        }
    }

    //Faiz Oranı Uygulama
    fun applyInterestRate() {
        accounts.forEach {
            if (it is SavingsAccount) {
                it.applyInterestRate()
            }
        }
    }

    fun getAllAccount() = accounts

}