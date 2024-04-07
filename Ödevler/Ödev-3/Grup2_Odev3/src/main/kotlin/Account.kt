package org.example

abstract class Account(
    var id: String,
    var balance: Double
) {

    abstract fun withdraw(customer: Customer, amount: Double)
    abstract fun deposit(customer: Customer, amount: Double)

    fun checkCheckingAccountBalance(customer: Customer): Unit {
        customer.checkingAccountList?.forEachIndexed { index, checkingAccount ->

            println("${index+1}. hesabın bakiyesi : ${checkingAccount.balance}")
        }
    }

    fun checkSavingAccountBalance(customer: Customer): Double {
        return customer.savingsAccount?.balance!!
    }

}
