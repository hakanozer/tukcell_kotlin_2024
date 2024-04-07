package question_1

// HolidayMenu extends Menu
class HolidayMenu(
    holidayFoodList: List<Food>,
    holidayMenuString: String = "***** HOLIDAY MENU *****"
) : Menu(holidayFoodList, holidayMenuString) {

    // Dynamic polymorphism
    override fun selectFood(food: List<Food>) {
        super.selectFood(food)

        // If total price more than 50 then discount %20 for total price.
        if (calculateTotalPrice(food) > 50) {
            println("New Price: ${discountMealPrice(calculateTotalPrice(food))}")
        }
    }

    private fun discountMealPrice(totalPrice: Double): Double {
        val discount = totalPrice * 0.2
        return totalPrice - discount
    }
}