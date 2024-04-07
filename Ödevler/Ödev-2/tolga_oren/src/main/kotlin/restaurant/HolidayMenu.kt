package restaurant

class HolidayMenu : Menu() {

    init {
        val holidayMenuList = mutableListOf<Food>(
            Food(5, "Taco", 15),
            Food(6, "Lasagna", 20),
            Food(7, "Sushi", 25),
            Food(8, "Cola", 10)
        )
        this.addMenuItems(holidayMenuList)
    }

    override fun addMenuItems(list: List<Food>) {
        foods.addAll(list)
    }

    override fun filterItems(min: Int, max: Int): List<Food> {
        return super.filterItems(min, max)
    }

    override fun getRecipes(): List<Food> {
        return super.getRecipes()
    }
}