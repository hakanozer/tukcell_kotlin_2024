package org.example.soru_5

open class Product(val name: String, val price: Double) {
    open fun displayDetails() {
        println("Ürün Adı: $name, Fiyatı: $price")
    }
}