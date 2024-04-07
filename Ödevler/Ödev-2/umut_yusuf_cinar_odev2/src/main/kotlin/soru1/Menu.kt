///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
1. Bir restoranın menüsünü temsil eden bir Kotlin sınıfı olan Menu oluşturun. Bu sınıf,
menüde bulunan yemekleri ve fiyatlarını içermelidir. Ayrıca, menüdeki yemekleri
eklemek için bir metod ve belirli bir fiyat aralığındaki yemekleri listelemek için bir başka
metod ekleyin. Ardından, Menu sınıfını miras alarak özel bir tatil menüsü oluşturun ve
ekstra tatil yemeklerini ve fiyatlarını ekleyin.
 */

//Bu Menu adındaki sınıf restoran menüsünü temsil ediyor

package org.example.soru1

//Miras verebilmesi için belirttiğiniz gibi open class olarak niteliyorum hocam
open class Menu {
    //menü öğelerini ve fiyatlarını anahtar değer çifti olarak tutabilmek için
    //mutableMap oluşturuyorum
    private val menuItems = mutableMapOf<String, Double>()

    //menüye yeni bir öğe eklemek için bir metod oluşturuyorum
    open fun addItemToMenu(itemName: String, price: Double, isFresh: Boolean) {
        menuItems[itemName] = price // öğeyi ve fiyatını map'e ekliyoruz
    }

    //belirli bir fiyat aralığındaki öğeleri listelemek için bir metod oluşturuyorum
    fun listItemsByPriceRange(minPrice: Double, maxPrice: Double): List<String> {
        //map'teki öğeleri filtreleyip belirli bir fiyat aralığını alıyorum
        //bunun için filtreleme yapacağım
        return menuItems.filter { it.value in minPrice..maxPrice }.keys.toList()
    }
}