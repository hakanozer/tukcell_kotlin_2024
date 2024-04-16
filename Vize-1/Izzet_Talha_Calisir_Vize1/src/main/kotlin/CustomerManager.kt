package org.example

import kotlin.random.Random

//CustomerManager sınıfı
class CustomerManager {
    private val customers = mutableListOf<Customer>()

    fun addCustomer(customer: Customer) {
        customers.add(customer)
    }

    //guncelleme icin
    fun updateCustomer(customerId: String, newEmail: String, newPhoneNumber: String) {
        val customer = customers.find { it.customerId == customerId }
        customer?.let {
            it.email = newEmail
            it.phoneNumber = newPhoneNumber
        }
    }

    //musterileri listele
    fun listCustomers() {
        println("Musteri Listesi:")
        customers.forEachIndexed { index, customer ->
            println("Musteri ${index + 1}:\n$customer\n")
        }
    }
    //onerilen urunler
    fun recommendProducts(customerId: String) {
        val customer = customers.find { it.customerId == customerId }
        customer?.let {
            val recommendedProducts =
                listOf("Kitap", "Muzik Albumu", "Gezi Paketi", "Yemek defteri", "Telefon", "CD", "Defter")
            val randomIndex = Random.nextInt(recommendedProducts.size)
            val recommendedProduct = recommendedProducts[randomIndex]
            println("${it.name} icin onerilen urun: $recommendedProduct")
        } ?: println("Bu ID ile musteri bulunamadi: $customerId")
    }
}
