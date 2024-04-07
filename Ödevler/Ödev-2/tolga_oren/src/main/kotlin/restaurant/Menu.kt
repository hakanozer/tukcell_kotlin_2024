package restaurant

open class Menu {

    protected val foods = mutableListOf<Food>()

    init {
        val menuList = mutableListOf<Food>(
        Food(0, "Hamburger", 15),
        Food(1, "Pizza", 20),
        Food(2, "Kebab", 25),
        Food(3, "Milkshake", 10),
        Food(4, "French Fries", 12)
    )
        this.addMenuItems(menuList)
    }

    open fun addMenuItems(list: List<Food>) {
        foods.addAll(list)
    }

    open fun filterItems(min: Int, max: Int): List<Food> {
        return foods.filter { it.price in (min + 1) until max }
    }

    open fun getRecipes() : List<Food> {
        return foods.toList()
    }


}