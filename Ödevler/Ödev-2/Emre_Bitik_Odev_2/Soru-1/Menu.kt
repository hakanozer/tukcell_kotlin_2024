  open class Menu {
    val menu: MutableMap<String, Int> = mutableMapOf() //
    fun addMeal(meal: String, price: Int) {
        // verilerin eklenmesi için fonksiyon
        menu[meal] = price
    }

    fun priceRange(minPrice: Int, maxPrice: Int): List<Pair<String, Int>> {
        // Menu filtreleme işlemi
        return menu.filterValues { it in minPrice..maxPrice }.toList()
    }


}
class TatilMenu : Menu() // Miras Alma
{
    init {
        // Tatil Menüsüne veri ekleme
        addMeal("Karides", 450)
        addMeal("Kalamar", 450)
        addMeal("Bulgur Pilavı", 200)
        addMeal("Pirinç Pilavı", 200)
        addMeal("Spagetti", 250)
        addMeal("Fırınlanmış Tavuk", 350)
        addMeal("Börek çeşitleri", 150)
    }
}