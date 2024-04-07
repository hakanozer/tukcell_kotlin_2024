package org.example.Task5

open class OnlineShop {

    val userBasket= mutableListOf<Product>() // Kullanıcının ürünlerini tutan liste

    fun addProduct(product:Product) { // Sepete ürün eklemek
        userBasket.add(product)
    }

    fun removeProduct(productName: String) { // Sepetten ürün kaldırmak
        var product=""
        userBasket.forEach {// Önce o ürünün olup olmadığına bakıyoruz, varsa yukarıda tanımlanan product değişkenine atıyoruz
            if(it.name==productName){
                product=it.name
                userBasket.remove(it)
            }
        }
    if(product==productName){ // Kaldırılmasını istenen ürün sepettekiyle eşleşirse kaldırılır
        println("Ürün başarıyla kaldırıldı")
    }
    else{
        println("Böyle bir ürün bulunamadı")
    }
    }

    fun clear() { // Tüm sepeti temizler
        userBasket.clear()
    }

    fun countPrice(){ // Sepetteki ürünlerin fiyatını gösterir
        var price=0
        userBasket.forEach {
            price+=it.price
        }
        println("Toplam tutar : $price")
    }

}