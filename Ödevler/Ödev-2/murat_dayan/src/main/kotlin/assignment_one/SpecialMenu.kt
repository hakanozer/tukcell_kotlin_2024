package assignment_one

class SpecialMenu : Menu {

    constructor(){

    }
    constructor(specialMenu:MutableMap<String,Int>){
        menu = specialMenu
    }

    fun addFoodMenu(foodName: String, foodPrice: Int) {
        menu.put(foodName,foodPrice)
    }

    override fun addExtraFoodMenu(foodName: String, foodPrice: Int) {
        super.addExtraFoodMenu(foodName, foodPrice)
    }


}