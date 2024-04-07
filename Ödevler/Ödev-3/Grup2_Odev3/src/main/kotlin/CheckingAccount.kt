package org.example

class CheckingAccount(
    id: String,
    balance: Double,
    val transactionFee: Double = 0.02,
) : Account(id, balance) {

    fun getTransactionFee(amount: Double) {
        balance -= amount * transactionFee
    }

    override fun withdraw(customer: Customer, amount: Double) {
        if (balance >= amount) {
            balance -= amount
            getTransactionFee(amount)
        }
    }

    override fun deposit(customer: Customer, amount: Double) {
        balance += amount
        getTransactionFee(amount)
    }

}