package org.example.Task5

fun main() {

    // User1 için fonksiyonların çalışıp çalışmadığının testi. Her bir User kullanıcısının kendisine ait bir sepeti olabilir
    val product1=Product("Kazak",300)
    val product2=Product("Atkı",700)
    val product3=Product("Mont",3000)

    val user1=OnlineShop()

    user1.addProduct(product1)
    user1.addProduct(product2)
    user1.addProduct(product3)
    user1.removeProduct("Atkı")
    //user1.clear()

    user1.userBasket.forEach {
        println(it.name)
    }

    user1.countPrice()


}