package org.example

import java.time.LocalDate

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun main() {
    // CustomerManager sınıfını kullanma
    val manager = CustomerManager()

    // Musteri ornekleri
    val regularCustomer1 = RegularCustomer(
        "Talha Calisir",
        "talha@example.com",
        "123456789",
        "123 Caddesi",
        "12345",
        LocalDate.of(1985, 5, 10),
        Gender.ERKEK,
        Language.INGILIZCE,
        Hobby.SPOR,
        100
    )
    val regularCustomer2 = RegularCustomer(
        "Ibrahim Calisir",
        "ibrahim@example.com",
        "987654321",
        "456 Orman Caddesi",
        "54321",
        LocalDate.of(1990, 8, 15),
        Gender.ERKEK,
        Language.FRANSIZCA,
        Hobby.MUZIK,
        150
    )
    val vipCustomer1 = VIPCustomer(
        "Sevgi Calisir",
        "sevgi@example.com",
        "555555555",
        "789 Elma Caddesi",
        "98765",
        LocalDate.of(1978, 12, 25),
        Gender.KADIN,
        Language.ALMANCA,
        Hobby.GEZI,
        200,
        3
    )
    val vipCustomer2 = VIPCustomer(
        "Ayse Siyah",
        "ayse@example.com",
        "999888777",
        "321 Kozalak Caddesi",
        "56789",
        LocalDate.of(1988, 3, 5),
        Gender.DIGER,
        Language.TURKCE,
        Hobby.OKUMA,
        250,
        5
    )
    //Musteri ekleme
    manager.addCustomer(regularCustomer1)
    manager.addCustomer(regularCustomer2)
    manager.addCustomer(vipCustomer1)
    manager.addCustomer(vipCustomer2)

    // Musterileri sirala
    manager.listCustomers()
    //Musteriler için urun onerisi
    println("\nRecommendations:")
    manager.recommendProducts(regularCustomer1.customerId)
    manager.recommendProducts(vipCustomer1.customerId)
}