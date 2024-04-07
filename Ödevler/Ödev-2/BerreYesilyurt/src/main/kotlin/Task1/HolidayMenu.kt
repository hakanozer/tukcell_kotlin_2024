package org.example.Task1

class HolidayMenu:Menu() {

    var specialHolidayMenu= menu.toMutableMap() // Menüdeki elemanlarlar birlikte başlatmak için yapılır


    override fun addMeals(meal: String, price: Int) { //  Yeni bir yemek ekleme
        specialHolidayMenu.put(meal,price)
    }

    fun updateSpecialHolidayMenu(){ // Menü sınıfında bir değişiklik olursa burada da güncellenmesi için
        specialHolidayMenu=menu.toMutableMap()
    }




}