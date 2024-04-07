fun main() {
    val onlineShop = OnlineShop()

    // create baskets
    val user1Basket = Basket()
    val user2Basket = Basket()

    onlineShop.createUserBasket("Ahmet", user1Basket)
    onlineShop.createUserBasket("Ayşe", user2Basket)

    // user1 basket
    user1Basket.addToBasket(Product("kalem",12.99))
    user1Basket.addToBasket(Product("anahtarlık",22.99))
    user1Basket.addToBasket(Product("klavye",32.99))

    // user2 basket
    user2Basket.addToBasket(Product("mont",512.99))
    user2Basket.addToBasket(Product("gömlek",122.99))
    user2Basket.addToBasket(Product("ayakkabı",232.99))

    println("-----------user1 baskets----------")
    user1Basket.listBasket()

    // remove product from basket
    println("-----------remove kalem from user1 basket----------")
    user1Basket.removeFromBasket("kalem")
    println("-----------user1 baskets----------")
    user1Basket.listBasket()
    println("-----------user1 clear basket----------")
    user1Basket.clearBasket()
    println("-----------user1 baskets----------")
    user1Basket.listBasket()

    println("total price of basket:"+ user1Basket.calculateTotalPrice())

    println("-----------user2 baskets----------")
    user2Basket.listBasket()
    println("-----------user2 add product to basket----------")
    user2Basket.addToBasket(Product("eldiven",55.99))
    println("-----------user2 baskets----------")
    user2Basket.listBasket()
    println("-----------user2 total price----------")
    println("total price of basket:"+ user2Basket.calculateTotalPrice())

}