package soru_1

open class Menu {

    open var priceList = mutableMapOf<String, Double>()

    fun addMenuItem(itemName:String, itemPrice:Double){
        priceList[itemName] = itemPrice
    }

    fun showMenuItemsInPriceRange(minPrice:Double,maxPrice:Double){
        val rangeList = priceList.filterValues { it in minPrice..maxPrice }
    }

}