///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
1. Bir restoranın menüsünü temsil eden bir Kotlin sınıfı olan Menu oluşturun. Bu sınıf,
menüde bulunan yemekleri ve fiyatlarını içermelidir. Ayrıca, menüdeki yemekleri
eklemek için bir metod ve belirli bir fiyat aralığındaki yemekleri listelemek için bir başka
metod ekleyin. Ardından, Menu sınıfını miras alarak özel bir tatil menüsü oluşturun ve
ekstra tatil yemeklerini ve fiyatlarını ekleyin.
 */

//Bu HolidayMenu sınıfı, Menu adındaki sınıftan referans alarak oluşturulan tatil menüsünü temsil ediyor.

package org.example.soru1

//Menu sınıfını miras alarak özel bir tatil menüsü oluşturuyorum
//Eğer ürün taze değilse Menu sınıfının metodunu miras ile polimorfizm yöntemini kullanarak
//HolidayMenu içerisinde fiyat inidirimi yapacak şekilde addItemToMenu metodunu override edeceğim.
class HolidayMenu : Menu() {
    override fun addItemToMenu(itemName: String, price: Double, isFresh: Boolean) {
        if (isFresh) {
            super.addItemToMenu(itemName, price, isFresh)
        } else {
            super.addItemToMenu(itemName, price =(price / 2.0), isFresh)
        }
    }
}
