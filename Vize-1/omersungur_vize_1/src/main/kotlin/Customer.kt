package org.example

import org.example.Statics.Companion.customerIdCounter

abstract class Customer(
    var customerName: String,
    var customerEmail: String,
    var customerTelNo: String
) {

    // Her müşteriye ait bir adet unique id değeri. Buradaki setter fonksiyonunu private yapıyorum ki bu kapsam dışından değiştirilmesin.
    var customerId: Int = 0
        private set

    init {
        customerId = customerIdCounter
        customerIdCounter++
    }

    override fun toString(): String {
        return "Customer Id: $customerId\n" +
                "Customer Name: $customerName\n" +
                "Customer Email: $customerEmail\n" +
                "Customer Tel No: $customerTelNo"
    }
}