package org.example

// 1. Soru
open class Menu {
    protected val items = mutableMapOf<String, Double>()

    fun addItem(item: String, price: Double) {
        items[item] = price
    }

    fun listItemsInRange(minPrice: Double, maxPrice: Double) {
        items.filter { it.value in minPrice..maxPrice }.forEach { println("${it.key}: ${it.value}") }
    }
}