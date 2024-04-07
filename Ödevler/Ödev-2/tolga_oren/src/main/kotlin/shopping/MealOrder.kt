package shopping

class MealOrder: OnlineShop() {

    override fun totalPrice(): Double {
        var price = 0.0
        basket.forEach {
            price += it.price
        }
        val tip = price * 0.2
        return price + tip
    }
}