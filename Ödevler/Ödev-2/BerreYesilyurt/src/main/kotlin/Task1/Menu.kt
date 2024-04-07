package org.example.Task1

open class Menu {
    var menu= mutableMapOf<String,Int>("Makarna" to 200,"Pizza" to 275) // Baştaki menü

    open fun addMeals(meal:String,price:Int){ // Yemeğin ismini ve fiyatını alarak baştaki menüye ekler
        menu.put(meal,price)
    }

    fun listPriceRange(range1:Int,range2:Int):Map<String,Int>{ // Belirli aralıktaki fiyatları listeleyerek döndürür
        val listPriceRange=menu.filter { it.value in range1..range2 }
        return listPriceRange
    }

}