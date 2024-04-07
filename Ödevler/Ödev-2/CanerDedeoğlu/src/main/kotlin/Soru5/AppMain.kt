package Soru5

fun main() {

    val online = OnlineShop()

    val technology = online.addProduct(TechnologyProduct("Monster Tulpar",30000.0,3 ))

    val whiteThings = online.addProduct(HouseholdAppliancesProduct("Buzdolabı", 18000.0 , "A++"))

   val total = online.totalPrice()
    println(total)

    online.showCards()

}