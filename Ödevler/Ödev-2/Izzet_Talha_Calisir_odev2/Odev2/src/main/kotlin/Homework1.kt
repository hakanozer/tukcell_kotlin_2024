package org.example
//bu aslında example olmamalı diğer sefere değiştir

// Ana menü sınıfı
open class Menu {
    private val menuItems: MutableMap<String, Double> = mutableMapOf()

    // Yemek ekleme metodu
    fun addMenuItem(itemName: String, price: Double) {
        menuItems[itemName] = price
    }

    // Belirli bir fiyat aralığındaki yemekleri listeleme metodu
    fun listItemsInRange(minPrice: Double, maxPrice: Double): List<String> {
        return menuItems.filter { it.value in minPrice..maxPrice }.keys.toList()
    }
}

// Özel tatil menüsü sınıfı, ana menüyü miras alır
class HolidayMenu : Menu() {
    // Ekstra tatil yemeklerini ve fiyatlarını eklemek için kullanılır
    fun addHolidayItem(itemName: String, price: Double) {
        addMenuItem(itemName, price)
    }
}
