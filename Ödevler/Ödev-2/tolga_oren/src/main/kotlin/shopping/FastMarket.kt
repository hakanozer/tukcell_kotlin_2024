package shopping

class FastMarket: OnlineShop() {

    override fun totalPrice(): Double {
        var price = 0.0
        val shippingFee = 2.50
        basket.forEach {
            price += it.price
        }
        val tip = price * 0.10
        return price + shippingFee + tip
    }
}