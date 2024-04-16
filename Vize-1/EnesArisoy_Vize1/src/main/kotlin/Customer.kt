package org.example

abstract class Customer {
    abstract val customerId: String
    abstract val name: String
    abstract val email: String
    abstract val phoneNumber: String

    override fun toString(): String {
        return "Customer ID: $customerId\n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "Phone Number: $phoneNumber"
    }
}