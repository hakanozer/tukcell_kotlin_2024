package question_1

class HolidayMenu : Menu {

    constructor() {
        addFood("Tacos", 139.99)
        addFood("Sandwich", 99.99)
        addFood("Sushi", 179.99)
        addFood("Spaghetti", 119.99)

    }

    override fun addFood(foodName: String, price: Double) {
        super.addFood("Holiday $foodName", price)
    }
}