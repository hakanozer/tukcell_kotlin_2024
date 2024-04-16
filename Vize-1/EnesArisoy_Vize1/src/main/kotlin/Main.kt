package org.example

fun main() {

    val regularCustomer1 = RegularCustomer(
        customerId = "REG-1",
        name = "Enes Regular",
        email = "enes@enes.com",
        phoneNumber = "555 555 55 55",
        loyaltyPoints = 8
    )

    val vipCustomer1 = VIPCustomer(
        customerId = "VIP-1",
        name = "Enes Arısoy",
        email = "enes@gmail.com",
        phoneNumber = "555 555 55 55",
        vipLevel = 3
    )

    val customerManager = CustomerManager()

    customerManager.addCustomer(regularCustomer1)
    customerManager.addCustomer(vipCustomer1)

    println("Customer ekleme işlemi")
    customerManager.listCustomers()
    println("------------------------------")

    // Vip güncelleme
    val updatedVipCustomer1 = VIPCustomer(
        customerId = "VIP-1",
        name = "Enes Arısoy",
        email = "enes@gmail.com",
        phoneNumber = "555 555 55 55",
        vipLevel = 5    // Sadece vipLevel güncelledim
    )
    customerManager.updateCustomer("VIP-1", updatedVipCustomer1)

    println("Customer güncelledikten sonra")
    customerManager.listCustomers()
    println("------------------------------")

    // Müşteri silme
    customerManager.removeCustomer("REG-1")

    println("Customer sildikten sonra")
    customerManager.listCustomers()
    println("------------------------------")

}
