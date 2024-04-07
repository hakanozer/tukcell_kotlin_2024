package assignment_five

fun main() {

    val Ali = User("Ali")
    val Zehra = User("Zehra")


    Ali.addBasket(Product(1,"Laptop",20000))
    Ali.addBasket(Product(2,"Phone",9255))
    Ali.addBasket(Product(3,"Mp3 Player",412))
    Ali.addBasket(Product(4,"Book",130))

    //user.getOutOfBasket(3)
    Zehra.addBasket(Product(1,"Laptop",22544))

    Ali.baskets.forEach {
        println(it.productName)
    }

    //user.cleanBasket()

    println(Zehra.calculateTotalAmount())
}