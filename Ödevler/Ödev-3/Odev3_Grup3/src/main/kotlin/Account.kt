abstract class Account(var balance: Double) {

    private var id: Int = 0

    //Id property'sine atama yapılır ve counter arttırılır.
    init {
        id = counter
        counter++
    }

    //Counter değişkeni farklı id'ler oluşturmak için kullanılmıştır.
    companion object {
        var counter = 1
    }

    fun getId() = id

    abstract fun withdraw(amount: Double)

    abstract fun deposit(amount: Double)


}