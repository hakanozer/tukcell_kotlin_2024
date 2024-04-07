package org.example

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("Ad:")
    val name = scanner.nextLine()

    println("Soyad:")
    val surname = scanner.nextLine()

    println("Vadeli hesabı açmak ister misiniz? (yes/no)")
    val openSavingsAccount = scanner.nextLine().equals("yes", ignoreCase = true)

    if (openSavingsAccount) {
        var savingsAccount: SavingsAccount? = null
        println("Hesap bakiyenizi giriniz:")
        val savingsInitialBalance = scanner.nextDouble()
        savingsAccount = SavingsAccount(UUID.randomUUID().toString(), savingsInitialBalance)

        val checkingAccountList = mutableListOf<CheckingAccount>()
        println("Kaç tane vadesiz hesap açmak istersiniz?")
        val numberOfCheckingAccounts = scanner.nextInt()
        if (numberOfCheckingAccounts != 0) {

            for (i in 1..numberOfCheckingAccounts) {
                println("${i}. hesabınızın başlangıç bakiyesini giriniz:")
                val initialBalance = scanner.nextDouble()

                checkingAccountList.add(CheckingAccount(UUID.randomUUID().toString(), initialBalance))
            }
        }

        val customer = Customer(
            id = UUID.randomUUID().toString(),
            name = name,
            surname = surname,
            savingsAccount = savingsAccount,
            checkingAccountList = checkingAccountList
        )

        // Vadeli hesabı bakiyesi gösterme
        println(customer.savingsAccount?.balance)

        // Vadesiz hesabı bakiyesi gösterme
        customer.checkingAccountList?.get(0)?.checkCheckingAccountBalance(customer)
    }
}

private fun getSavingAccountBalance(customer: Customer) {
    println("Saving Account bakiyesi: ${customer.savingsAccount?.balance}")
}

private fun getCheckingAccountBalance(customer: Customer) {
    customer.checkingAccountList?.get(0)?.checkCheckingAccountBalance(customer)
}