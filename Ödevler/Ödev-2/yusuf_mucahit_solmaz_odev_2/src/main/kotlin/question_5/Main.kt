package question_5

fun main() {

    val laptop = Product(productId = 1, productName = "Laptop", productPrice = 2000)
    val phone = Product(productId = 2, productName = "Phone", productPrice = 1000)
    val tablet = Product(productId = 3, productName = "Tablet", productPrice = 500)


    val john = User(userId = 1, userName = "John")
    val emily = User(userId = 2, userName = "Emily")


    val cartTransaction = OnlineShop()


    cartTransaction.addToCart(john, laptop)
    cartTransaction.addToCart(john, phone)

    println(cartTransaction.userCart)
    /*
    Output:

    [UserCart(user=User(userId=1, userName=John), userProduct=[Product(productId=1, productName=Laptop, productPrice=2000), Product(productId=2, productName=Phone, productPrice=1000)])]*/

    cartTransaction.removeFromCart(john.userId, laptop.productId)

    println(cartTransaction.userCart)
    /*
    Output:

    [UserCart(user=User(userId=1, userName=John), userProduct=[Product(productId=2, productName=Phone, productPrice=1000)])]*/


    cartTransaction.addToCart(emily, phone)
    cartTransaction.addToCart(emily, tablet)

    println(cartTransaction.userCart)

    println("John's total spend: ${cartTransaction.calculateUserSpend(john.userId)}")

    /*
    Output:

    John's total spend: 1000 */


    println("Emily's total spend: ${cartTransaction.calculateUserSpend(emily.userId)}")

    /*
    Output:

    Emily's total spend: 1500 */



    cartTransaction.clearUserCart(john.userId)


    println("John's total spend after clearing the cart: ${cartTransaction.calculateUserSpend(john.userId)}")


    /*
    Output:

    John's total spend: 0 */

}
