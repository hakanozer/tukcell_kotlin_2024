package question_1

open class Menu {

    val menuMap = mutableMapOf<String,Double>()
    constructor() {
        menuMap["Pizza"] = 140.0
        menuMap["Burger"] = 160.0
        menuMap["Tea"] = 10.0
        menuMap["Salad"] = 49.99
        menuMap["Lahmacun"] = 119.99
    }

    open fun addFood (foodName: String, price: Double){
        menuMap[foodName] = price
    }

    fun filterPrice(from: Double, to: Double) : Map<String, Double>{
        val filteredMenu = menuMap.filterValues {
            it in from..to
        }
        return filteredMenu
    }

}