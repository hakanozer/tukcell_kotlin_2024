package soru5

fun main() {

    //Product Class
    val product1 = Product(1, "Sneaker", 65.5)
    val product2 = Product(2, "Jacket", 74.9)

    //OnlineShop Class
    val onlineShop = OnlineShop()

    onlineShop.addBasket(product1)
    onlineShop.addBasket(product2)

    println(onlineShop.totalPrice()) //Çıktı 140.4

    onlineShop.removeBasket(1)
    println(onlineShop.getBasket()) //Çıktı [Product(id=2, name=Jacket, price=74.9)]

    onlineShop.clearBasket()
    println(onlineShop.getBasket()) //Çıktı []

}