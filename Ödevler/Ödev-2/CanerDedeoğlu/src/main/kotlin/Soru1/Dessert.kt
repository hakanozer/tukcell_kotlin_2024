package Soru1

class Dessert : Menu() {

    // Tatlı ekleme

   fun addDesert(name:String, price : Double)
   {
       addFood(name,price)
   }
}