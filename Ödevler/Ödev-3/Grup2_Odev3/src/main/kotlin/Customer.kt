package org.example

data class Customer(
    val id: String,
    val name: String,
    val surname: String,
    val account: List<UserAccount>
)

data class UserAccount(
    val id: String,
    val savingAccount: UserSavingAccount?,
    val vadesizHesap: UserCheckingAccount?
)

data class UserSavingAccount(
    val id: String,
    val balance: Double,
    val interestRate: Double = 8.0
)

data class UserCheckingAccount(
    val id: String,
    val balance: Double
)