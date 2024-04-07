package question_5

fun main() {
    // User Instance
    val user1 = User(1, "Omer")
    val user2 = User(2, "Ahmet")

    // Product Instance
    val computer = Product("Computer", 5000.99)
    val iPhone = Product("Iphone", 2300.99)
    val pencil = Product("Pencil", 21.80)
    val bicycle = Product("Bicycle", 355.85)

    // Online Shop Instance
    val onlineShop = OnlineShop(user1)

    // Add to basket
    onlineShop.addToBasket(listOf(computer, iPhone, bicycle))
    onlineShop.printBasketInfo()
    onlineShop.calculateTotalPrice()
    println()

    // Remove from basket
    onlineShop.removeFromBasket(listOf(computer))
    onlineShop.printBasketInfo()
    onlineShop.calculateTotalPrice()
    println()

    // Clear basket
    onlineShop.clearBasket()
    onlineShop.printBasketInfo()
    onlineShop.calculateTotalPrice()
    println()

    // // Online Shop Instance for another user
    val onlineShop2 = OnlineShop(user2)

    // Add to basket
    onlineShop2.addToBasket(listOf(computer, bicycle))
    onlineShop2.printBasketInfo()
    onlineShop2.calculateTotalPrice()
}