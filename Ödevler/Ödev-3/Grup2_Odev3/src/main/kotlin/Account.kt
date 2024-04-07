package org.example

abstract class Account {

    abstract val id: String
    abstract val balance: Double

    abstract fun withdraw(id: String, balance: Double)
    abstract fun deposit(id: String, balance: Double)

}
