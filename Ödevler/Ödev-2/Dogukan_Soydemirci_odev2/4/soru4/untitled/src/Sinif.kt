
open class Product(val name: String, val price: Double)


class OnlineShop {
    private val users = mutableListOf<User>()

    fun kullaniciEkle(user: User) {
        users.add(user)
    }




}


open class User(val name: String) {
    protected val sepet = mutableListOf<Product>()

    fun sepeteEkle(product: Product) {
        sepet.add(product)
    }

    fun sepettenCikart(product: Product) {
        sepet.remove(product)
    }

    fun sepetiTemizle() {
        sepet.clear()
    }

    open fun toplamHarcamaHesapla(): Double {
        var toplamHarcama = 0.0
        for (product in sepet) {
            toplamHarcama += product.price
        }
        return toplamHarcama
    }
}


fun main() {
    val shop = OnlineShop()

    val user1 = User("Ali")
    user1.sepeteEkle(Product("Bilgisayar", 1500.0))
    user1.sepeteEkle(Product("Şarj aleti", 50.0))

    val user2 = User("Veli")
    user2.sepeteEkle(Product("Televizyon", 3000.0))
    user2.sepeteEkle(Product("Kulaklık", 20.0))

    shop.kullaniciEkle(user1)
    shop.kullaniciEkle(user2)

    println("Veli Toplam harcama: ${user2.toplamHarcamaHesapla()} lira")
}
