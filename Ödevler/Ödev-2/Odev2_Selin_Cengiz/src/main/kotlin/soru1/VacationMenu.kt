package soru1

class VacationMenu : Menu {

    private val menuVacation = mutableMapOf<String, Double>()

    constructor() {
        menuVacation.put("Grilled Cheese", 67.0)
        menuVacation.put("Arrabbiata", 67.0)
        menuVacation.put("Cheese Burger", 67.0)

    }

    //Hem genel menüye hemde vacation menüye ekleme yapılmaktadır.
    override fun addFood(food: String, price: Double) {
        menuVacation.put(food, price)
        return super.addFood(food, price)
    }

    //Vacation menu listelenmektedir.
    fun listVacationFood(bottomPrice: Double, topPrice: Double): Map<String, Double> = menuVacation.filter {
        it.value in bottomPrice..topPrice
    }


}