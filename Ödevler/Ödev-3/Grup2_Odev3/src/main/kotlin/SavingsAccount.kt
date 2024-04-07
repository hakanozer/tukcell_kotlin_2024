package org.example

class SavingsAccount(
    id: String,
    balance: Double,
    val transactionFee: Double = 4.0,
    val interestRate: Double = 10.0
) : Account(id, balance) {

    override fun withdraw(customer: Customer, amount: Double) {

        customer.savingsAccount?.let {
            if (it.balance > transactionFee) {
                it.balance -= amount + transactionFee
            }
        }
    }

    override fun deposit(customer: Customer, amount: Double) {

        customer.savingsAccount?.interestRate?.let { interestRate ->

            val currentInterest = balance * (interestRate / 100)
            customer.savingsAccount.balance += amount + (currentInterest - transactionFee)
        }
    }

}