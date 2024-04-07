package Question_1

class VacationMenu : Menu() {

    override fun addFood(menuItem: MenuItem) {
        foodList.add(menuItem)
    }

    override fun filterMenuItemsByPrice(startingPrice: Int, endingPrice: Int) {
        filteredFoodList.addAll(foodList.filter {
            it.menuFoodPrice in startingPrice..endingPrice
        })
    }
}