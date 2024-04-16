package org.example


fun main() {
    val customers = CustomerManager()

    val regularCustomer = RegularCustomer("Yunus Ceylan", "yec2442@gmail.com", "05437899877", 100)
    val regularCustomer2 = RegularCustomer("Emre", "emre@hotmail.com", "05437809863", 150)
    val vipCustomer = VIPCustomer("Ceylan Yec", "ceylo@example.com", "0543712345", 2.0)

    customers.addCustomer(regularCustomer)
    customers.addCustomer(vipCustomer)
    customers.addCustomer(regularCustomer2)

    println("Müşteri Listesi:")
    customers.listCustomers()

    println("\nMüşteri Bilgilerinin Güncellenmesi:")
    val updatedEmail = "yunus.emre.ceylan@gmail.com"
    var updatedPhoneNumber = "05543"
    customers.updateCustomer(regularCustomer,regularCustomer.name, updatedEmail, updatedPhoneNumber)
    regularCustomer.increaseLoyaltyPoints(900)//50 sadakat puanı ekle
    vipCustomer.increaseVipLevel(1) // VIP seviyesini 1 artır

    println("\nGüncellenmiş Müşteri Bilgileri:")
    customers.listCustomers()

    customers.convertToVIP(regularCustomer)
    updatedPhoneNumber = "0"
    customers.updateCustomer(regularCustomer,regularCustomer.name, updatedEmail, updatedPhoneNumber)

    //müşteri aramada dönen listenin kontrolünü yapıyorum
    val matchingCustomers = customers.searchInCustomers("Ceylan")
    if (matchingCustomers.isNotEmpty()) {
        println("\nArama Sonucu:")
        for (customer in matchingCustomers) {
            println(customer)
        }
    } else {
        println("\nAranan müşteri bulunamadı.")
    }

    println("\nMüşteri Çıkarılması:")
    customers.removeCustomer(vipCustomer)

    println("\nMüşteri Listesi (Müşteri Çıkarıldıktan Sonra):")
    customers.listCustomers()
}
