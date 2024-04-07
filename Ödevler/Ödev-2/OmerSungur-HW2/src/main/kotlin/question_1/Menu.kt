package question_1

open class Menu(
    private val foodList: List<Food>,
    private val menuString: String = "***** MENU *****"
) {

    fun printAllFoodInMenu() {
        println(menuString)
        foodList.forEach { food ->
            println("${food.foodName} = $${food.foodPrice}")
        }
    }

    fun filterMenuByPrice(price: Double) {
        val filteredFoodByPrice = foodList.filter { foodElement ->
            foodElement.foodPrice < price
        }
        println("***** FOOD UNDER $$price *****")
        for (food in filteredFoodByPrice) {
            println("${food.foodName} = $${food.foodPrice}")
        }
    }

    open fun selectFood(food: List<Food>) {
        val selectedFoodList = mutableListOf<Food>()
        food.forEach { foodElement ->
            selectedFoodList.add(foodElement)
        }
        println("***** SELECTED FOOD *****")
        for (foodElement in selectedFoodList) {
            println("${foodElement.foodName} = $${foodElement.foodPrice}")
        }

        println("Total Price: ${calculateTotalPrice(food)}")
    }

    protected fun calculateTotalPrice(food: List<Food>): Double {
        var totalPrice = 0.0
        food.forEach { foodElement ->
            totalPrice += foodElement.foodPrice
        }
        return totalPrice
    }
}