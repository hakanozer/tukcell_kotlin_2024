// miras alınan class olduğu için open kavramı eklendi
open class Menu {
    // yemek ve ücretlerini eklemek için MutableMap oluşturuyorum
    val menus: MutableMap<String, Double> = mutableMapOf()

    constructor(){
        println("--------------------------------------------------------------------------------------------------------------------")
        println("Otelimize Hoşgeldiniz. Şimdiden Afiyet Olsun <3 ")
        println("--------------------------------------------------------------------------------------------------------------------")
    }

    // menuye yemek ve ücretlerini eklemek için bir fonksiyon oluşturuyorum
    fun addFoodToMenu(food: String, price: Double){
        // key -> food, values -> price. yemeklerin ve ücretleri
        menus[food] = price
    }

    // belirli fiyat aralığındaki yemekleri listelemek için fonksiyon oluşturuyorum
    fun listFoodsByPriceRange(minPrice: Double, maxPrice: Double):List<String>{
        // dönüş olarak menus.filter ile menunun içindeki priceları istenilen aralığa göre listeliyorum
        return menus.filter { it.value in minPrice..maxPrice }.keys.toList()
    }

}