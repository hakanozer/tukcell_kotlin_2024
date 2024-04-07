package assignment_one

open class Menu {

    var menu = mutableMapOf<String,Int>()

    // sabit menü her menu nesnesı oluşturulugunda oluşacak
    constructor(){
        menu.put("Hamburger",90)
        menu.put("Pizza",180)
        menu.put("Kebap",120)
        menu.put("Döner",70)
        menu.put("Makarna",30)
    }


    // özel menulere izin vermek için open fun eklendi
    open fun addExtraFoodMenu(foodName:String,foodPrice:Int){
    }

    // belirli aralıktaki yemekleri listeler
    open fun getFoodsInPriceRange(minPrice:Int,maxPrice:Int):List<String>{

        val resultFoodList = menu.filter {food->
            food.value in minPrice..maxPrice
        }

        return resultFoodList.keys.toList()
    }


}