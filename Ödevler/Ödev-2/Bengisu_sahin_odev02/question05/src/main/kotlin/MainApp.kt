fun main() {
    val user1 = User("bengisu")
    val user2 = User("bora")

    val product = Product("T-shirt", 150.99)
    val product2 = Product("Skirt", 259.99)
    val product3 = Product("Pant", 999.99)
    val product4 = Product("T-shirt", 199.99)

    val shop = OnlineShop()
    shop.addUser(user1)
    shop.addUser(user2)

    shop.addProductToBasket(user1, product)
    shop.addProductToBasket(user1, product2)
    shop.calculateBasket(user1)
    shop.resetBasket(user1)

    shop.addProductToBasket(user2,product3)
    shop.calculateBasket(user2)
    shop.removeProductFromBasket(user2, product3)
    shop.addProductToBasket(user2, product4)
    shop.calculateBasket(user2)
}