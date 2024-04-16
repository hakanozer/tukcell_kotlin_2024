package soru_5

fun main() {
    val user = OnlineShop("ahmet")
    user.addToCart("Telefon")
    user.addToCart("Klavye")
    user.addToCart("Mouse")

    println("Sepet: ${user.shoppingCart}")
    println("Toplam Harcama: ${user.calculateTotalCost()} TL")

    user.removeFromCart("Klavye")

    println("Klavye çıkarıldıktan sonraki sepet: ${user.shoppingCart}")
    println("Toplam Harcama: ${user.calculateTotalCost()} TL")

    user.clearCart()
    println("Sepet temizlendi: ${user.shoppingCart}")
}

