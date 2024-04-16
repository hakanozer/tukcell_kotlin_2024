package org.example

// 1. Customer sınıfı
abstract class Customer(var name: String, var email: String, var phoneNumber: String) {
    abstract val customerId: String

    override fun toString(): String {
        return "Müşteri ID: $customerId\nİsim: $name\nEmail: $email\nTelefon Numarası: $phoneNumber"
    }
}