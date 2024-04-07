package Soru5

class OnlineShop {

    val cards = mutableListOf<Product>()

    // Ürün ekleme

    fun addProduct(product : Product)
    {
        cards.add(product)

        when(product)
        {
            is TechnologyProduct -> println("${product.name} (Garanti : ${product.guarantee} yıl) sepete eklendi.")
            is HouseholdAppliancesProduct -> println("${product.name} (Enerji Sınıfı : ${product.energyClass}) sepete eklendi. ")
            else -> println("Sepete eklendi")
        }
    }

    // Toplam fiyat

    fun totalPrice(): Double = cards.sumOf { it.price }

    // Sepeti görüntüleme

    fun showCards()
    {
        if(cards.isEmpty())
        {
            println("Sepetinizde ürün bulunamadı...")
        }
        println("======== Sepetinizdeki ürünler ======")

        cards.forEach {
            println("${it.name} : ${it.price} TL")

        }
        println("Toplam Tutar : ${totalPrice()} TL")
    }
}