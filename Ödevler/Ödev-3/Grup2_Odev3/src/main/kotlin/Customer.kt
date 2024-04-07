package org.example

data class Customer(
    val id: String,
    val name: String,
    val surname: String,
    val savingsAccount: SavingsAccount?,
    val checkingAccountList: MutableList<CheckingAccount>?,
)
